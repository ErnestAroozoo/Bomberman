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
	BufferedImage hostmenu;
	BufferedImage guestmenu;
	
	// Methods
	public void paintComponent(Graphics g){
		// Main Menu
		if(Bomberman.blnMainMenu == true){
			g.drawImage(mainmenu, 0, 0, null);
		}
		
		// Username Menu
		else if(Bomberman.blnUsernameMenu == true){
			g.drawImage(usernamemenu, 0, 0, null);
		}
		
		// Play Style Menu
		else if(Bomberman.blnPlayStyleMenu == true){
			g.drawImage(playstylemenu, 0, 0, null);
		}
		
		// Multiplayer Menu
		else if(Bomberman.blnMultiplayerMenu == true){
			g.drawImage(multiplayermenu, 0, 0, null);
		}
		
		// Host Menu
		else if(Bomberman.blnHostMenu == true){
			g.drawImage(hostmenu, 0, 0, null);
		}
		
		// Guest menu
		else if(Bomberman.blnGuestMenu == true){
			g.drawImage(guestmenu, 0, 0, null);
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
			hostmenu = ImageIO.read(new File("hostmenu.png"));
			guestmenu = ImageIO.read(new File("guestmenu.png"));
		}
		catch(IOException e){
			System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
		}
	}
}

