public class Carte_espion extends Message{
	public Carte_espion(int date1, int id1, int taille1) {
		super(date1, id1, taille1);

	}
	
	public String toString() {
		String affiche = "";
		
		return affiche;
	}
	
	public String toCSV() {
		return super.toCSV();
		
	}
	
	public void decoder(int[] octets_data){
		
	}
}