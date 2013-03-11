public class Capteur extends Message{
	public int capt_distri;
	public int sonar_droit;
	public int sonar_gauche;
	public int etat_match;
	public int couleur_table;
	public int type_balle; //A mettre � jour
	public int angle_high;
	public int angle_low;
	
	
	public Capteur(int date1, int id1, int taille1) {
		super(date1, id1, taille1);

	}
	
	public String toString() {
		String affiche = "message capteur";
		
		return affiche;
	}
	
	public String toCSV() {
		return super.toCSV();
		
	}
	
	public void decoder(int[] octets_data){
		/*
		if (taille == 3){
			
			capt_distri = (octets_data[0] & 0xC0) >>> 6;
			sonar_droit = (octets_data[0] & 0x20) >>> 5;
			sonar_gauche = (octets_data[0] & 0x10) >>> 4;
			etat_match = (octets_data[0] & 0x8) >>> 3;
			couleur_table = (octets_data[0] & 0x4) >>> 2;
			type_balle = (octets_data[0] & 0x3);
			
			angle_high = octets_data[1];
			angle_low = octets_data[2];
		}
		*/
	}
	
}
