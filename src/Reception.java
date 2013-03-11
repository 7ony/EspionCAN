import java.io.BufferedReader;
import java.io.IOException;


public class Reception implements Runnable {

	private BufferedReader in;
	private String message = null;
	private boolean terminer = false; 
	
	public Reception(BufferedReader in){
		this.in = in;
	}
	
	public void run() {
		while(!terminer){
	        try {
		        	
				message = in.readLine();
				System.out.println("Le serveur vous dit :" +message);
				MonInterface.fabrique.decoderTrame(message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	public void close(){
		terminer = true;
	}

}
