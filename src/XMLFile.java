import java.io.*;
import org.jdom2.*;
import org.jdom2.input.*;
import java.util.List;
import java.util.Iterator;

public class XMLFile
{
	org.jdom2.Document document;
	Element racine;
	
	private int id;
	private int dlc;

	public XMLFile()
	{
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			//On crée un nouveau document JDOM avec en argument le fichier XML
			//Le parsing est terminé ;)
			document = sxb.build(new File("/home/tony/Documents/Projet/can.xml"));
			//On initialise un nouvel élément racine avec l'élément racine du document.
			racine = document.getRootElement();
		}
		catch(Exception e){}

		

		//Méthode définie dans la partie 3.2. de cet article
		getTrames();
	}
	
	public XMLFile(String message)
	{
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			System.out.println(message);
			//Le parsing est terminé ;)
			document = sxb.build(new StringReader(message.toString()));
			
			//On initialise un nouvel élément racine avec l'élément racine du document.
			racine = document.getRootElement();
		}
		catch(Exception e){
			System.out.println("Erreur :"+e.toString());
		}
		

		//Méthode définie dans la partie 3.2. de cet article
		//getTrames();
	}


	public void getTrames()
	{
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List listEtudiants = racine.getChildren("trame");

		
	   //On crée un Iterator sur notre liste
	   Iterator i = listEtudiants.iterator();
	   while(i.hasNext())
	   {
	      //On recrée l'Element courant à chaque tour de boucle afin de
	      //pouvoir utiliser les méthodes propres aux Element comme :
	      //selectionner un noeud fils, modifier du texte, etc...
	      Element courant = (Element)i.next();
	      //On affiche le nom de l'element courant
	      id = Integer.parseInt(courant.getChild("id").getText(), 10);
	      dlc = Integer.parseInt(courant.getChild("dlc").getText(), 10);
	      
	      for(int j =0; j<Integer.parseInt(courant.getChild("dlc").getText());j++){
	    	//  System.out.print(courant.getChild("data").getChild("data"+j).getText());
	      }
	   }
	}

	
	public int getId(){
		return id;
	}

	public int getDlc() {
		return dlc;
	}
}