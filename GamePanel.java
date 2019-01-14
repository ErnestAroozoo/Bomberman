import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class GamePanel extends JPanel{
	// Properties
	int intX = 0;
	int intY = 0;
	boolean blnUp = false;
	boolean blnRight = false;
	boolean blnDown = false;
	boolean blnLeft = false;
    int intStartGame = 1;
    int intHost = 0;
	boolean blnMouse = false;
	boolean blnKeys = false;
	boolean blnplacebomb = false;
	boolean blnHelp = false;
	boolean blnHighScores = false;
	String strAddress;

	BufferedImage up1;
	BufferedImage up2;
	BufferedImage right1;
	BufferedImage right2;
	BufferedImage down1;
	BufferedImage down2;
	BufferedImage left1;
	BufferedImage left2;
	BufferedImage mainmenu;
	BufferedImage keys;
	BufferedImage mouse;
	BufferedImage ground_stan;
	BufferedImage wall_stan;
	BufferedImage breakwall_stan;
	BufferedImage ground_win;
	BufferedImage wall_win;
	BufferedImage fire_horizontal;
	BufferedImage fire_downend;
	BufferedImage fire_leftend;
	BufferedImage fire_mid;
	BufferedImage fire_rightend;
	BufferedImage fire_upend;
	BufferedImage fire_vertical;
	BufferedImage bomb_item;
	BufferedImage bomb_active;
	BufferedImage multiplebombitem;
	BufferedImage flameitem;
	BufferedImage guestmenu;
	BufferedImage hostmenu;
	BufferedImage multiplayermenu;
	BufferedImage playstylemenu;
	BufferedImage usernamemenu;

	///JButton test;
	///GamePanel thepanel;
	
	// Methods
	public void paintComponent(Graphics g){
		// Main Menu
		if(blnHighScores){
			
		}
		if(intHost == 1){
			g.drawImage(hostmenu,0,0,null);
			g.drawString(strAddress,400,200);
		}else if(intHost == 2){
			g.drawImage(guestmenu,0,0,null);
		}
		if(blnHelp){
			//g.drawImage(,0,0,null);
		}
		
		if(intStartGame == 1){
			g.drawImage(mainmenu, 0, 0, null);
		}
		// Screen 2
		else if(intStartGame == 2){
			System.out.println("Start Game 2");
			g.drawImage(usernamemenu,0,0,null);
		}else if(intStartGame == 3){
			g.drawImage(playstylemenu,0,0,null);
		}else if(intStartGame == 4){
			g.drawImage(multiplayermenu,0,0,null);
		}
		// Start Game
		else if(intStartGame == 5){
				
			// Set Background
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1280, 720); 
			g.drawImage(mouse, 100, 200, null);
			g.drawImage(keys, 600, 200, null);
			//if(blnStartGame == true && blnMouse == true || blnStartGame == true && blnKeys == true){
			g.drawImage(down1, intX, intY, null); // Default stance
			// Bomberman
			if(blnUp == true){
				intY = intY - 5;
				g.drawImage(up1, intX, intY, null);
				g.drawImage(up2, intX, intY, null);
			}else if(blnRight == true){
				intX = intX + 5;
				g.drawImage(right1, intX, intY, null); 
				g.drawImage(right2, intX, intY, null); 
			}else if(blnDown == true){
				intY = intY + 5;
				g.drawImage(down1, intX, intY, null); 
				g.drawImage(down2, intX, intY, null); 
			}else if(blnLeft == true){
				intX = intX - 5;
				g.drawImage(left1, intX, intY, null); 
				g.drawImage(left2, intX, intY, null); 
			}
			if(blnplacebomb == true){
				g.drawImage(bomb_item,intX,intY,null);
			}
	}
}
	
	// Constructors
	public GamePanel(){
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
			mouse = ImageIO.read(new File("mouse.png"));
			keys = ImageIO.read(new File("keys.png"));
			ground_stan = ImageIO.read(new File("stan.groung.jpg"));
			wall_stan = ImageIO.read(new File("stan.wall.jpg"));
			breakwall_stan = ImageIO.read(new File("stan.wallbreakable.jpg"));
			ground_win = ImageIO.read(new File("win.ground.jpg"));
			wall_win = ImageIO.read(new File("win.wall.jpg"));
			fire_horizontal = ImageIO.read(new File("fire_horizontal.png"));
			fire_downend = ImageIO.read(new File("fire_downend.png"));
			fire_leftend = ImageIO.read(new File("fire_leftend.png"));
			fire_mid = ImageIO.read(new File("fire_mid.png"));
			fire_rightend = ImageIO.read(new File("fire_rightend.png"));
			fire_upend = ImageIO.read(new File("fire_upend.png"));
			fire_vertical = ImageIO.read(new File("fire_vertical.png"));
			bomb_active = ImageIO.read(new File("bomb_active.png"));
			bomb_item = ImageIO.read(new File("bomb_item.png"));
			flameitem = ImageIO.read(new File("flame item.jpg"));
			multiplebombitem = ImageIO.read(new File("multiplebombitem.jpg"));
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
