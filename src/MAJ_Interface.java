import java.util.ArrayList;

public class MAJ_Interface {

	private int dernier_nb_messages;
	private MonInterface vue;
	private ArrayList<Message> filemessages;
	private boolean terminer;
	
	//reglage de la frequence de MAJ de l'affichage
	//temps de latence en ms :
	private int periode_temps_reel = 1000;
	private int periode_hors_ligne = 500;
	
	MAJ_Interface(MonInterface vue1, ArrayList<Message> filemessages, boolean temps_reel) {
		vue = vue1;
		this.filemessages = filemessages;
		dernier_nb_messages = 0;
		terminer = false;
		if(temps_reel == true) {
			go_temps_reel();
		}
		else {
			go_hors_ligne();
		}
	}
	
	public void go_temps_reel(){
		new Thread(){
			public void run(){			
				while(!terminer){
					//si il y a de nouveaux messages dans la file depuis la derni�re mise � jour :
					if (dernier_nb_messages != filemessages.size()) {
						vue.maj();
					}
					dernier_nb_messages = filemessages.size();
					
					try {
						sleep(periode_temps_reel);
					} catch (InterruptedException e) {}
				}
			}
		}.start();
	}
	
	public void go_hors_ligne(){
		new Thread(){
			public void run(){			
				while(!terminer){
					
					vue.afficher_horsligne(true, periode_hors_ligne);
					
					try {
						sleep(periode_hors_ligne);
					} catch (InterruptedException e) {}
				}
			}
		}.start();
	}
	
	public void close() {
		terminer = true;
	}
}
