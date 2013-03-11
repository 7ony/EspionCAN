import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Reader_FIFO implements Runnable {

	private Semaphore semaphore;
	public ArrayDeque<Byte> FIFO;	


	//Constantes concernant l'�tat de l'envoi des deux parties du messages � la fabrique : [id date taille] , et , [message brut]
	private final static char etat_intermediaire = 5;
	private final static char debut_trouve = 1;
	private final static char fin_trouve = 2;
	private final static char id_date_taille_envoyes = 3;
	private final static char data_envoyee = 4;

	private char etat_envoi;
	private int taille_message;

	Reader_FIFO (Semaphore sem,  ArrayDeque<Byte> fifo) {
		semaphore = sem;
		FIFO = fifo;
		new Thread(this).start();
	}
 
	//cr�er variable static "�tat de l'envoi" :  pouvant prendre les valeurs "id_date_taille envoy�s" , et "data_envoy�e"
	//if taille FIFO >= 4  & etat = data_envoy� : envoi_id_date();
	//-> on r�cup�re "taille_message"
	//if taille FIFO >= "taille_message" & etat = id_date_taille_envoy� : envoi_data();



	public void run() {
		int bytedebut = 0x00;
		int bytefin = 0xFF;
		char nb_trouve;

		while(true) {	
			try {
				int nblu = 0;// compte le nombre de octets r�ellement lu pour mettre � jour les jetons
				semaphore.acquire(1);// attends au moins un jeton
				switch(etat_envoi) {


				case (fin_trouve):
					//on cherche maintenant le debut du message suivant
					nb_trouve = 0;
				int test;
				
				//while (nb_trouve != 1 && serie.nb_octets_restants >0){
				while (nb_trouve != 1 && (FIFO.size() > 0)){
					nblu++;
					if((((int)FIFO.pollFirst()) & 0xFF) == (bytedebut)){
						nb_trouve++;
						//System.out.println("debut trouve : "+ nb_trouve);
					}
					else {
						nb_trouve = 0;
						//System.out.println("pas de debut, taille FIFO : " + FIFO.size());
					}
					//serie.maj_octets_restants(-1);
				}
				if (nb_trouve != 0) {
					//System.out.println("debut_trouve");
					etat_envoi = debut_trouve;
				}
				break;


				case (debut_trouve):
					//on a trouv� le d�but : on envoit l'id, la date, et la taille � la fabrique
					if ((FIFO.size() >= 4)) {
						//System.out.println(" envoi id date : serie.nb_octets_restants " + FIFO.size());
				
						etat_envoi = etat_intermediaire;
						//lancement du traitement
						//System.out.println("envoi id date");
						envoi_ID_Date();
						nblu+=4;
						//System.out.println("envoi id date termin�");

						//le changement d'�tat se fait dans la fonction envoi_id_date()
					}
				break;


				case (id_date_taille_envoyes):
					//on envoi maintenant les donn�es du message � la fabrique
					if ((FIFO.size() >= (taille_message))) {

						//System.out.println(" envoi data : serie.nb_octets_restants " + FIFO.size());
						etat_envoi = etat_intermediaire;

						//System.out.println("envoi data");
						//lancement du traitement
						envoi_data();
						nblu+=taille_message;
						//System.out.println("data_envoyee");

					}
				//le changement d'etat se fait dans la fonction envoi_data()
				break;


				case (data_envoyee):
					nb_trouve = 0;
				//tout a �t� envoy� � la fabrique, on cherche maintenant la fin du message
				while ((nb_trouve != 1) && (FIFO.size() > 0)){
					test = ((int)FIFO.pollFirst()) & 0xFF;
					nblu++;
					if((test) == (bytefin)){
						nb_trouve++;
					}
					else {
						nb_trouve = 0;
					}
				}
				if (nb_trouve != 0) {
					//System.out.println("fin trouvee");
					etat_envoi = fin_trouve;
				}
				break;

				case (etat_intermediaire):
					break;

				default:
					etat_envoi = fin_trouve;
					semaphore.release(1);// remet le jeton inutilis�
					
				break;


				}
				//System.out.println("nblu : " + nblu);
				if(nblu != 0){
					semaphore.acquire(nblu-1);// mange les jetons utilis�s r�ellement
				}
			} catch (InterruptedException e) {

			}
		}		
	}

	private void envoi_ID_Date() {	

		int i; //pour les boucles
		//tableau contenant l'ID et la DATE et TAILLE qui sera envoy� � la fabrique
		byte[] tabl_buffer = new byte[4];		


		//on lit les premiers octets
		for (i = 0; i<4; i++) {
			tabl_buffer[i] = FIFO.pollFirst();
		}
	//	taille_message = Lanceur.fabrique.creer_message(tabl_buffer);
		//System.out.println("cree_message fait");
		etat_envoi = id_date_taille_envoyes;

	}

	private void envoi_data() {	

		int i; //pour les boucles

		//tableau contenant les donn�es 
		byte[] tabl_buffer = new byte[taille_message];		

		//lecture du message en fonction de la taille message
		//System.out.println("taille_message = " + taille_message);

		if(taille_message != 0) {
			for (i = 0; i<taille_message; i++) {
				tabl_buffer[i] = FIFO.pollFirst();
				//System.out.println("tablbuffer " + i + " rempli");
			}
			//envoi � la fabrique
	//		Lanceur.fabrique.enregistrer_data(tabl_buffer);
		}
		etat_envoi = data_envoyee;
	}

}
