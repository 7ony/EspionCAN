import java.util.ArrayList;

public class Fabrique {

	//créer variable "fixe" permettant de se souvenir du message en cours de construction
	static public Message mess_en_cours;
	private long debut;
	private ArrayList<Message> filemessages;
	
	public Fabrique(ArrayList<Message> filemessages){
		this.filemessages = filemessages;
	}
	

	public void creer_messages(CSVFile monFichier) { 
		int i =1;
		while(!monFichier.getData(i, 0).isEmpty()){
			int id = Integer.decode(monFichier.getData(i, 0));
			int date = Integer.decode(monFichier.getData(i, 1));
			int taille = Integer.decode(monFichier.getData(i, 2));
			
			mess_en_cours = message_en_cours(id, date, taille);
			i++;
			filemessages.add(mess_en_cours);
		}
		System.out.println(filemessages.size());

	}
	public void creer_message(ParseXML monFichier) { 

		for(int i = 0; i< monFichier.getTrame().length;i++){
			int id = monFichier.getTrame()[i].getId();
			int taille = monFichier.getTrame()[i].getDlc();
			int date = 0;
			
			if(filemessages.isEmpty()){
				debut = monFichier.getTrame()[i].getDate();
			}
			else{
				date = (int)(monFichier.getTrame()[i].getDate()-debut);
			}
			
			mess_en_cours = message_en_cours(id, date, taille);
			
			filemessages.add(mess_en_cours);
			mess_en_cours.decoder(monFichier.getTrame()[i].getData());
		}
		
		System.out.println(monFichier.getTrame().length);
		System.out.println(filemessages.size());

	}
	public void decoderTrame(String xml) { 
		ParseXML monFichier = new ParseXML(xml);
		for(int i = 0; i< monFichier.getTrame().length;i++){
			int id = monFichier.getTrame()[i].getId();
			int taille = monFichier.getTrame()[i].getDlc();
			
			int date = 0;
			
			if(filemessages.isEmpty()){
				debut = monFichier.getTrame()[i].getDate();
			}
			else{
				date = (int)(monFichier.getTrame()[i].getDate()-debut);
			}
			
			mess_en_cours = message_en_cours(id, date, taille);
			
			filemessages.add(mess_en_cours);
			//System.out.println(mess_en_cours.getClass().getName());
			if(mess_en_cours != null){
				mess_en_cours.decoder(monFichier.getTrame()[i].getData());
			}
		}
		//System.out.println(filemessages.size());
	}
	
	
	public long getDebut() {
		return debut;
	}


	public ArrayList<Message> getFilemessages() {
		return filemessages;
	}


	private Message message_en_cours(int id, int date, int taille){
		Message mess = null;
		switch (id) {
			//deplacement1
			case(0x100):
				mess = new Deplacement1(date, id, taille);
				System.out.println("deplacement1 reconnu");
			break;
			case(0x111):
				mess = new Deplacement2(date, id, taille);
				System.out.println("deplacement2 reconnu");
			break;	
			case(0x200):
				mess = new Capteur(date, id, taille);
				System.out.println("capteur reconnu");
			break;				
			case(0x140):
				mess = new Intelligence(date, id, taille);
				System.out.println("intelligence reconnu");
			break;	
			case(0x500):
				mess = new Actionneur(date, id, taille);
				System.out.println("actionneur reconnu");
			break;
			case(0x7FF):
				mess = new Carte_espion(date, id, taille);
			break;
			default:
				mess = new MessUndefined(date, id, taille);
				System.out.println(mess);
			break;
			
		}
		return mess;
	}
	
}
