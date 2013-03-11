public class Intelligence extends Message{
	public int positionXhigh;
	public int positionXlow;
	public int positionYhigh;
	public int positionYlow;
	public int pos_speciales;
	public int sens_depla;
	public int pos_speciale_att;
	//A mettre à jour
	public int ACK_ramassage;
	public int nb_balles;
	public int vider_balles;
	public int ordre_balai;
	
	
	public Intelligence(int date1, int id1, int taille1) {
		super(date1, id1, taille1);

	}
	
	public String toString() {
		String affiche = "message intelligence";
		return affiche;
	}
	
	public String toCSV() {
		return super.toCSV();
		
	}
	
	public void decoder(int[] octets_data){
		/*
		if(taille == 6){
			positionXhigh = octets_data[0];
			positionXlow = octets_data[1];
			positionYhigh = octets_data[2];
			positionYlow = octets_data[3];
			pos_speciales = (octets_data[4] & 0xF0) >>> 4;
			sens_depla = (octets_data[4] & 0x0C) >>> 2;
			pos_speciale_att = (octets_data[4] & 0x02) >>> 1;
			
			
		}
		*/
	}
	
}