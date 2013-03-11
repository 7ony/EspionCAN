public class Deplacement1 extends Message{
	
	public int positionXhigh;
	public int positionXlow;
	public int positionX;
	public int positionYhigh;
	public int positionYlow;
	public int positionY;	
	public int anglehigh;
	public int anglelow;
	public int pos_speciale;
	public int pos_speciale_att;
	public int SOS_int;
	public int alarme;
	
	public Deplacement1(int date1, int id1, int taille1) {
		super(date1, id1, taille1);

	}
	
	public String toString() {
		
		String affiche = "message de deplacement1";
		
		return affiche;
	}
	
	public String toCSV() {
		return super.toCSV();
		
	}
	
	
	
	public void decoder(int[] octets_data){
		if (taille == 7){
			
			//System.out.println("DEplacement1 cr��");
			
			
			positionXhigh = octets_data[0];
			positionXlow = octets_data[1];
			positionX = ((positionXhigh<<8) + positionXlow);
			positionYhigh = octets_data[2];
			positionYlow = octets_data[4];
			positionY = ((positionYhigh<<8) + positionYlow);
//			anglehigh = octets_data[5];
//			anglelow = octets_data[6];
//			pos_speciale = (octets_data[7] & 0xF0) >>> 4;
//			pos_speciale_att = (octets_data[7] & 0x8) >>> 3;
//			SOS_int = (octets_data[7] & 0x4) >>> 2;	
			
		}
		else {
			System.out.println("taille != 7");
		}
	}
}
