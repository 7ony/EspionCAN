import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class ClientTCP {

	private Socket socket = null;
	private Thread t1;
	private ReceiveTCP recieveTCP;
	
	public ClientTCP(){
		try {

			System.out.println("Demande de connexion");
			socket = new Socket("192.168.1.129",1234);
			System.out.println("Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connecté
			recieveTCP = new ReceiveTCP(socket);
			t1 = new Thread(recieveTCP);
			t1.start();



		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}

	}
	public ClientTCP(String ip){
		try {

			System.out.println("Demande de connexion");
			socket = new Socket(ip,1234);
			System.out.println("Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connecté
			
			recieveTCP = new ReceiveTCP(socket);
			t1 = new Thread(recieveTCP);
			t1.start();



		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}

	}
	public void closeSocket() throws InterruptedException {
		try{
			recieveTCP.setTerminer(true);
			t1.join();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur de deconnection", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	public Socket getSocket(){
		return socket;
	}
	

}