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
	
	// Methods
	public void paintComponent(Graphics g){
		// Main Menu
		g.drawImage(mainmenu, 0, 0, null);
		
		if(Bomberman.blnUsernameMenu == true){
			g.drawImage(usernamemenu, 0, 0, null);
		}
		
	}
	
	
	// Constructors
	public MainMenuPanel(){
		super();
		// Add Images
		try{
			mainmenu = ImageIO.read(new File("mainmenu.png"));
			usernamemenu = ImageIO.read(new File("usernamemenu.png"));
		}
		catch(IOException e){
			System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
		}
	}
}

