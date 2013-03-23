import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;


public class ReceiveTCP extends Thread {

	private Socket socket;
	private BufferedReader in = null;
	private String message = null;
	private boolean terminer = false;

	public ReceiveTCP(Socket s){
		socket = s;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Le serveur distant s'est déconnecté !");
		}
	}

	@Override
	public void run() {
		while(!terminer){
			try {
				if(in.ready()){
					message = in.readLine();
					MonInterface.fabrique.decoderTrame(message);
					System.out.println("Trame CAN reçu");
				}
			} catch (IOException e) {	
				e.printStackTrace();
			}

		}

		System.out.println("fermeture thread");
		//JOptionPane.showMessageDialog(null, "fermeture thread", "Information", JOptionPane.INFORMATION_MESSAGE);

	}
	

	public void setTerminer(boolean terminer) {
		this.terminer = terminer;
	}

}