
public class MessUndefined extends Message {
	public MessUndefined(int date, int id, int taille) {
		super(date, id, taille);
	}
	
	public void decoder(int[] octets_data){
		
	}

	@Override
	public String toString() {
		return "ID non reconnu";
	}
}
