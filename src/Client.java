import java.io.*;
import java.net.*;

public class Client {

	private Socket socket = null;
	private Thread t1;
	private ClientServeur clientServeur;
	
	public Client(){
		try {

			System.out.println("Demande de connexion");
			socket = new Socket("192.168.1.129",1234);
			System.out.println("Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connecté
			clientServeur = new ClientServeur(socket);
			t1 = new Thread(clientServeur);
			t1.start();



		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}

	}
	public Client(String ip){
		try {

			System.out.println("Demande de connexion");
			socket = new Socket(ip,1234);
			System.out.println("Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connecté
			t1 = new Thread(new ClientServeur(socket));
			t1.start();



		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}

	}
	public void closeSocket() {
		try{
			clientServeur.close();
			socket.close();
		}
		catch(Exception e){
			
		}
		

	}
	public Socket getSocket(){
		return socket;
	}
	

}