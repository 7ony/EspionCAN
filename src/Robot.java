import java.awt.*;


public class Robot {
	private int largeur = 80;
	private int hauteur = 80;
	
	//X, Y et teta sont les coordonnées entrée par l'utilisateur
	//X et Y correspondent au coordonnées du centre de gravité du robot
	//teta est l'angle du robot en degrés
	public int X;
	public int Y;
	public double teta;
	
	//X1 et Y1 sont les coordonnées du coin haut gauche et sont calculées avec X et Y
	//car le dessin du rectangle se fait à partir des coordonnées du coin supérieur gauche
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
		
		//couleur du petit carré face avant du robot
		g2.setColor(Color.decode("#990000"));
		g2.fill(new Rectangle(X_coin+largeur*3/8, Y_coin, largeur/4, hauteur/4));
		
		g2.setColor(c);
		
	}


}
