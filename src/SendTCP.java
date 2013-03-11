import java.io.PrintWriter;
import java.net.Socket;

public class SendTCP {
	private PrintWriter out;
	
	public SendTCP(Socket socket, String message) {
		try{
			out = new PrintWriter(socket.getOutputStream());
			out.print(message);
			out.flush();
		}
		catch(Exception e){
			
		}
	}
	
}
