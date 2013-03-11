public class Deplacement2 extends Message{
	public int vitesseXhigh;
	public int vitesseXlow;
	public int vitesseYhigh;
	public int vitesseYlow;
	public int arret_obst;
	public int etat_capt_av_ar;
	public int sens_deplacement;
	
	public Deplacement2(int date1, int id1, int taille1) {
		super(date1, id1, taille1);

	}
	
	public String toString() {
		String affiche = "message deplacement 2";
		
		return affiche;
	}
	
	public String toCSV() {
		return super.toCSV();
		
	}
	
	public void decoder(int[] octets_data){
		if (taille ==5) {
			vitesseXhigh = octets_data[0];
			vitesseYhigh = octets_data[1];
			vitesseXlow = octets_data[2];
			vitesseYlow = octets_data[4];
			arret_obst = (octets_data[5] & 0x10) >>> 4;
			etat_capt_av_ar = (octets_data[5] & 0x6) >>> 2;
			sens_deplacement = (octets_data[5] & 0x3);	
		}
	}
}
