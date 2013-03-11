import java.io.InputStream;
import com.enterprisedt.net.ftp.FileTransferClient;

public class ClientFTP {
	private FileTransferClient ftp;
	private String host = "raspberry-pi";
	private String username = "pi";
	private String password = "pi";
	private String fileRep = "/home/pi/xml/";

	
	public ClientFTP(){
		
	    ftp = null;

	    try {
	        // create client
	        System.out.println("Creating FTP client");
	        ftp = new FileTransferClient();

	        // set remote host
	        ftp.setRemoteHost(host);
	        ftp.setUserName(username);
	        ftp.setPassword(password);

	        // connect to the server
	        System.out.println("Connecting to server " + host);
	        ftp.connect();
	        System.out.println("Connected and logged in to server " + host);
	     
	        // Shut down client
	        //System.out.println("Quitting client");
	        //ftp.disconnect();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public ClientFTP(String host){

		ftp = null;
		this.host = host;

		try {
			// create client
			System.out.println("Creating FTP client");
			ftp = new FileTransferClient();

			// set remote host
			ftp.setRemoteHost(host);
			ftp.setUserName(username);
			ftp.setPassword(password);

			// connect to the server
			System.out.println("Connecting to server " + host);
			ftp.connect();
			System.out.println("Connected and logged in to server " + host);

			// Shut down client
			//System.out.println("Quitting client");
			//ftp.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] browse(){
		String[] files = null;
		try {
			ftp.changeDirectory(fileRep);
			files = ftp.directoryNameList();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return files;
	}
	public void downdload(String rep, String file){
		System.out.println("Downloading file");
		try{
			ftp.downloadFile(rep, fileRep+file);
			System.out.println("File downloaded");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getMessages(String file){
		StringBuffer messages = new StringBuffer(20000000);
		int i =0;
		try{
			InputStream in = ftp.downloadStream(fileRep+file);
			try {
				int ch = 0;
				while ((ch = in.read()) >= 0) {
					messages.append((char)ch);
					i++;
				}
			}
			finally {
				in.close(); // MUST be closed to complete the transfer
			}
			System.out.println("taille fichier" +i);
		}
		catch(Exception e){

		}
		return messages.toString();
	}
	public void disconnect(){
		 	//Shut down client
		 	try{
		 		System.out.println("Quitting client");
			 	ftp.disconnect();
		 	}
			catch(Exception e){
				
			}
	}
	
 }

