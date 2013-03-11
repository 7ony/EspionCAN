import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ParseXML
{
	org.jdom2.Document document;
	Element racine;
	private Trame[] trame;
	
	private int id;
	private int dlc;
	private long date;
	private int[] data;

	public ParseXML(String path, boolean fichier) throws FileNotFoundException
	{
		
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			//On crée un nouveau document JDOM avec en argument le fichier XML
			//Le parsing est terminé ;)
			document = sxb.build(new File(path));
			//On initialise un nouvel élément racine avec l'élément racine du document.
			racine = document.getRootElement();
		}
		catch(Exception e){}

		

		//Méthode définie dans la partie 3.2. de cet article
		getTrames();
	}
	
	public ParseXML(String message)
	{
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			//Le parsing est terminé ;)
			document = sxb.build(new StringReader(message.toString()));
			
			//On initialise un nouvel élément racine avec l'élément racine du document.
			racine = document.getRootElement();
		}
		catch(Exception e){
			System.out.println("Erreur :"+e.toString());
		}
		
		getTrames();
	}


	public void getTrames()
	{
		
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List trames = racine.getChildren("trame");
		
		
	   //On crée un Iterator sur notre liste
	   Iterator i = trames.iterator();
	   int nbtrames =0;
	   while(i.hasNext()){
		   i.next();
		   nbtrames++;
	   }
	   trame = new Trame[nbtrames];
	   i = trames.iterator();
	   int k = 0;
	   while(i.hasNext()){
		   //On recrée l'Element courant à chaque tour de boucle afin de
	      //pouvoir utiliser les méthodes propres aux Element comme :
	      //selectionner un noeud fils, modifier du texte, etc...
	      Element courant = (Element)i.next();
	      //On affiche le nom de l'element courant
	      id = Integer.decode(courant.getChild("id").getText());
	      System.out.println(id);
	      dlc = Integer.decode(courant.getChild("dlc").getText());
	      date = Long.decode(courant.getChild("timestamp").getText());
	      data = new int[Integer.decode(courant.getChild("dlc").getText())];
	      for(int j =0; j<Integer.decode(courant.getChild("dlc").getText());j++){
	    	//  System.out.print(courant.getChild("data").getChild("data"+j).getText());
	    	  data[j] = Integer.decode(courant.getChild("data").getChild("data"+j).getText());
	      }
	      trame[k] = new Trame(id, dlc, date, data);
	      k++;
	   }
	}

	
	public int getId(){
		return id;
	}

	public int getDlc() {
		return dlc;
	}

	public Trame[] getTrame() {
		return trame;
	}

}