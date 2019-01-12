import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class MainMenuPanel extends JPanel{ 
	// Properties
	BufferedImage mainmenu;
	BufferedImage usernamemenu;
	BufferedImage playstylemenu;
	BufferedImage multiplayermenu;
	
	// Methods
	public void paintComponent(Graphics g){
		// Main Menu
		g.drawImage(mainmenu, 0, 0, null);
		
		// Username Menu
		if(Bomberman.blnUsernameMenu == true){
			g.drawImage(usernamemenu, 0, 0, null);
		}
		
		// Play Style Menu
		if(Bomberman.blnPlayStyleMenu == true){
			g.drawImage(playstylemenu, 0, 0, null);
		}
		
		// Multiplayer Menu
		if(Bomberman.blnMultiplayerMenu == true){
			g.drawImage(multiplayermenu, 0, 0, null);
		}
		
		
	}
	
	
	// Constructors
	public MainMenuPanel(){
		super();
		// Add Images
		try{
			mainmenu = ImageIO.read(new File("mainmenu.png"));
			usernamemenu = ImageIO.read(new File("usernamemenu.png"));
			playstylemenu = ImageIO.read(new File("playstylemenu.png"));
			multiplayermenu = ImageIO.read(new File("multiplayermenu.png"));
		}
		catch(IOException e){
			System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
		}
	}
}

