import java.io.*;
import java.net.*;


public class ClientServeur implements Runnable {

	private Socket socket;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private Thread t2, t3;
	private Reception reception;
	private Emission emission;
	
	public ClientServeur(Socket s){
		socket = s;
	}
	
	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			reception = new Reception(in);
			t2 = new Thread(reception);
			t2.start();
			emission = new Emission(out);
			t3 = new Thread(emission);
			t3.start();
		
		   
		    
		} catch (IOException e) {
			System.err.println("Le serveur distant s'est déconnecté !");
		}
	}
	public void close(){
		reception.close();
		emission.close();
		
	}

}