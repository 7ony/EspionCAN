import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Table extends JPanel{
	private static final long serialVersionUID = 1L;
	private String filePath;
	public Robot robot;

	public Table (String filePath){
		super();
		this.filePath = filePath;
		
		robot = new Robot();
		robot.X = 200;
		robot.Y = 150;
		robot.teta = 0;
	}
		
	public void paint(Graphics g){
		try{
		BufferedImage image = ImageIO.read(new File(filePath));
		g.drawImage(image, 0, 0, null);
			
		robot.paint(g);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

