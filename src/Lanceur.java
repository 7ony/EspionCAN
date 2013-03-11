import java.util.ArrayList;

public class Lanceur {
	public ArrayList<Message> filemessages;
	public static Fabrique fabrique;
	
	public MonInterface vue;

	
	
	public boolean tempsreel = true;
    
 
    public Lanceur() {

    	vue = new MonInterface(this);
    	
        vue.setVisible(true);
    }
  
    
    public static void main(String[] args){  
        new Lanceur();
    }

}