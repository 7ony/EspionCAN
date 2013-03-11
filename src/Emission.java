import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	private boolean terminer = false; 
	
	public Emission(PrintWriter out) {
		this.out = out;
	}
	
	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(!terminer){
			    System.out.println("Votre message :");
				message = sc.nextLine();
				out.println(message);
			    out.flush();
			  }
	}
	
	public void close(){
		terminer = true;
	}
}