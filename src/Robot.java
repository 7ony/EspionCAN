import java.awt.*;


public class Robot {
	private int largeur = 80;
	private int hauteur = 80;
	
	//X, Y et teta sont les coordonn�es entr�e par l'utilisateur
	//X et Y correspondent au coordonn�es du centre de gravit� du robot
	//teta est l'angle du robot en degr�s
	public int X;
	public int Y;
	public double teta;
	
	//X1 et Y1 sont les coordonn�es du coin haut gauche et sont calcul�es avec X et Y
	//car le dessin du rectangle se fait � partir des coordonn�es du coin sup�rieur gauche
	private int X_coin;
	private int Y_coin;
	
	public void paint (Graphics g){
		
		Graphics2D g2;
		g2 = (Graphics2D)g;
		
		Color c = g2.getColor();
		
		//couleur du robot
		g2.setColor(Color.decode("#FF6600"));
		g2.rotate(Math.toRadians(teta), X, Y);
		
		X_coin = X - (largeur/2) ;
		Y_coin = Y - (hauteur/2);
		
		g2.fill(new Rectangle(X_coin, Y_coin, largeur, hauteur));
		
		//couleur du petit carr� face avant du robot
		g2.setColor(Color.decode("#990000"));
		g2.fill(new Rectangle(X_coin+largeur*3/8, Y_coin, largeur/4, hauteur/4));
		
		g2.setColor(c);
		
	}


}
