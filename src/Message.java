public abstract class Message {
	
	protected int date;
	protected int id;
	protected int taille;

	public Message(int date1, int id1, int taille1){
		date = date1;
		id = id1;
		taille = taille1;
	}
	
	public abstract String toString();
	
	public String toCSV(){
		
		return id+";"+date+";"+taille;
	}
	
	public abstract void decoder(int[] octets_data);
	
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	
}
