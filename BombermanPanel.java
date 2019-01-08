import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class BombermanPanel extends JPanel{
	// Properties
	int intX = 0;
	int intY = 0;
	boolean blnUp = false;
	boolean blnRight = false;
	boolean blnDown = false;
	boolean blnLeft = false;
	boolean blnStartGame = false;
	BufferedImage up1;
	BufferedImage up2;
	BufferedImage right1;
	BufferedImage right2;
	BufferedImage down1;
	BufferedImage down2;
	BufferedImage left1;
	BufferedImage left2;
	BufferedImage mainmenu;
	
	// Methods
	public void paintComponent(Graphics g){
		// Main Menu
		if(blnStartGame == false){
			g.drawImage(mainmenu, 0, 0, null);
		}
		// Start Game
		else if(blnStartGame == true){
			// Set Background
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1280, 720); 
			
			// Bomberman
			if(blnUp == true){
				intY = intY - 5;
				g.drawImage(up1, intX, intY, null);
				g.drawImage(up2, intX, intY, null);
			}
			else if(blnRight == true){
				intX = intX + 5;
				g.drawImage(right1, intX, intY, null); 
				g.drawImage(right2, intX, intY, null); 
			}
			else if(blnDown == true){
				intY = intY + 5;
				g.drawImage(down1, intX, intY, null); 
				g.drawImage(down2, intX, intY, null); 
			}
		
			else if(blnLeft == true){
				intX = intX - 5;
				g.drawImage(left1, intX, intY, null); 
				g.drawImage(left2, intX, intY, null); 
			}
		
			g.drawImage(down1, intX, intY, null); // Default stance
		}
	}
	
	// Constructors
	public BombermanPanel(){
		super();
		// Add Images
		try{
			up1 = ImageIO.read(new File("up1.png")); 
			up2 = ImageIO.read(new File("up2.png")); 
			right1 = ImageIO.read(new File("right1.png")); 
			right2 = ImageIO.read(new File("right2.png")); 
			down1 = ImageIO.read(new File("down1.png")); 
			down2 = ImageIO.read(new File("down2.png")); 
			left1 = ImageIO.read(new File("left1.png")); 
			left2 = ImageIO.read(new File("left2.png"));  
			mainmenu = ImageIO.read(new File("mainmenu.png"));
		}
		catch(IOException e){
			System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
		}
	}
}

