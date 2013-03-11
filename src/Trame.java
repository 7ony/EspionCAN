
public class Trame {
	private int id;
	private int dlc;
	private long date;
	private int[] data;
	public Trame(int id, int dlc, long date, int[] data) {
		this.id = id;
		this.dlc = dlc;
		this.date = date;
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public int getDlc() {
		return dlc;
	}
	public long getDate() {
		
		return date;
	}
	public int[] getData() {
		return data;
	}
	
	
	
}
