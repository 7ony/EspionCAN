public class Actionneur extends Message{
	//A mettre � jour plus tard
	
	public Actionneur(int date1, int id1, int taille1) {
		super(date1, id1, taille1);

	}
	
	public String toString() {
		String affiche = "message actionneur";
		
		return affiche;
	}
	
	public String toCSV() {
		return super.toCSV();
		
	}
	
	public void decoder(int[] octets_data){
		
	}
}
