import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class BombermanPanel extends JPanel{
	// Properties
	SuperSocketMaster ssm;
	int intX = 0;
	int intY = 0;
	int intX_red = 300;
	int intY_red = 0;
	int intX_yellow = 0;
	int intY_yellow = 300;
	int intX_white = 300;
	int intY_white = 300;
	int intBombX = 0;
	int intBombY = 0;
	boolean blnUp = false;
	boolean blnDown = false;
	boolean blnLeft = false;
	boolean blnRight = false;
	boolean blnPlaceBomb = false;
	BufferedImage up1;
	BufferedImage up2;
	BufferedImage right1;
	BufferedImage right2;
	BufferedImage down1;
	BufferedImage down2;
	BufferedImage left1;
	BufferedImage left2;
	
	BufferedImage up1_red;
	BufferedImage up2_red;
	BufferedImage right1_red;
	BufferedImage right2_red;
	BufferedImage down1_red;
	BufferedImage down2_red;
	BufferedImage left1_red;
	BufferedImage left2_red;
	
	BufferedImage up1_yellow;
	BufferedImage up2_yellow;
	BufferedImage right1_yellow;
	BufferedImage right2_yellow;
	BufferedImage down1_yellow;
	BufferedImage down2_yellow;
	BufferedImage left1_yellow;
	BufferedImage left2_yellow;
	
	BufferedImage up1_white;
	BufferedImage up2_white;
	BufferedImage right1_white;
	BufferedImage right2_white;
	BufferedImage down1_white;
	BufferedImage down2_white;
	BufferedImage left1_white;
	BufferedImage left2_white;
	
	
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
	BufferedImage mainmenu;
	BufferedImage guestmenu;
	BufferedImage hostmenu;
	BufferedImage multiplayermenu;
	BufferedImage playstylemenu;
	BufferedImage usernamemenu;
	BufferedImage helpmenu;
	BufferedImage highscoresmenu;
	BufferedImage characterselectionmenu;

	///JButton test;
	///GamePanel thepanel;
	
	// Methods
	public void paintComponent(Graphics g){
		// Start Main Menu
			// Main Menu
			if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 1){ 
				g.drawImage(mainmenu, 0, 0, null); 
			}
			// HighscoresMenu 
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 2){ 
				g.drawImage(highscoresmenu, 0, 0, null);
			}
			// HelpMenu
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 3){ 
				g.drawImage(helpmenu, 0, 0, null);
			}
			// UsernameMenu
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 4){
				g.drawImage(usernamemenu, 0, 0, null);
			}
			// PlayStyleMenu
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 5){ 
				g.drawImage(playstylemenu, 0, 0, null);
			}
			// MultiplayerMenu
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 6){ 
				g.drawImage(multiplayermenu, 0, 0, null);
			}
			// HostMenu
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 7){ 
				g.drawImage(hostmenu, 0, 0, null);
				g.setFont(new Font("Arial", Font.PLAIN, 20)); 
				g.drawString(Bomberman.strIP, 580, 480); // Draw IP Adress on screen
				
			}
			// GuestMenu
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 8){ 
				g.drawImage(guestmenu, 0, 0, null);
			}
			// CharacterSelectionMenu
			else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 9){
				g.drawImage(characterselectionmenu, 0, 0, null);
			}
		
		
		// Start Bomberman Game
		if(Bomberman.blnMainMenu == false){
			// Set Background
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1280, 720); 
		
			// Bomberman Animation
			g.drawImage(down1, intX, intY, null);// Default stance
			g.drawImage(down1_red, intX_red, intY_red, null);// Default stance
			g.drawImage(down1_yellow, intX_yellow, intY_yellow, null);// Default stance
			g.drawImage(down1_white, intX_white, intY_white, null);// Default stance
			if(blnPlaceBomb == true){
				intBombX = intX;
				intBombY = intY;
				g.drawImage(bomb_item,intBombX,intBombY,null);
			}
			try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
			if(blnUp == true){
				intY = intY - 5;
				g.drawImage(up1, intX, intY, null);
				try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
           g.drawImage(up2, intX, intY, null);
           try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
			}
			else if(blnRight == true){
				intX = intX + 5;
				g.drawImage(right1, intX, intY, null); 
			try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
			g.drawImage(right2, intX, intY, null); 
			try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
			}
			else if(blnDown == true){
				intY = intY + 5;
				g.drawImage(down1, intX, intY, null); 
			try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
				g.drawImage(down2, intX, intY, null); 
			try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
			}
			else if(blnLeft == true){
				intX = intX - 5;
				g.drawImage(left1, intX, intY, null); 
			try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
				g.drawImage(left2, intX, intY, null);
			try{
              Thread.sleep( 1 );
            }
           catch (InterruptedException e) { 
			}
			}
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
			
			up1_red = ImageIO.read(new File("up1_red.png")); 
			up2_red = ImageIO.read(new File("up2_red.png")); 
			right1_red = ImageIO.read(new File("right1_red.png")); 
			right2_red = ImageIO.read(new File("right2_red.png")); 
			down1_red = ImageIO.read(new File("down1_red.png")); 
			down2_red = ImageIO.read(new File("down2_red.png")); 
			left1_red = ImageIO.read(new File("left1_red.png")); 
			left2_red = ImageIO.read(new File("left2_red.png"));
			
			up1_yellow = ImageIO.read(new File("up1_yellow.png")); 
			up2_yellow = ImageIO.read(new File("up2_yellow.png")); 
			right1_yellow = ImageIO.read(new File("right1_yellow.png")); 
			right2_yellow = ImageIO.read(new File("right2_yellow.png")); 
			down1_yellow = ImageIO.read(new File("down1_yellow.png")); 
			down2_yellow = ImageIO.read(new File("down2_yellow.png")); 
			left1_yellow = ImageIO.read(new File("left1_yellow.png")); 
			left2_yellow = ImageIO.read(new File("left2_yellow.png"));
			  
			up1_white = ImageIO.read(new File("up1_white.png")); 
			up2_white = ImageIO.read(new File("up2_white.png")); 
			right1_white = ImageIO.read(new File("right1_white.png")); 
			right2_white = ImageIO.read(new File("right2_white.png")); 
			down1_white = ImageIO.read(new File("down1_white.png")); 
			down2_white = ImageIO.read(new File("down2_white.png")); 
			left1_white = ImageIO.read(new File("left1_white.png")); 
			left2_white = ImageIO.read(new File("left2_white.png"));
			  
			fire_downend = ImageIO.read(new File("fire_downend.png"));
			fire_leftend = ImageIO.read(new File("fire_leftend.png"));
			fire_mid = ImageIO.read(new File("fire_mid.png"));
			fire_rightend = ImageIO.read(new File("fire_rightend.png"));
			fire_upend = ImageIO.read(new File("fire_upend.png"));
			fire_vertical = ImageIO.read(new File("fire_vertical.png"));
			fire_horizontal = ImageIO.read(new File("fire_horizontal.png"));
			bomb_active = ImageIO.read(new File("bomb_active.png"));
			bomb_item = ImageIO.read(new File("bomb_item.png"));
			flameitem = ImageIO.read(new File("flame item.jpg"));
			multiplebombitem = ImageIO.read(new File("multiplebombitem.jpg"));
			ground_stan = ImageIO.read(new File("stan.ground.jpg"));
			wall_stan = ImageIO.read(new File("stan.wall.jpg"));
			breakwall_stan = ImageIO.read(new File("stan.wallbreakable.jpg"));
			ground_win = ImageIO.read(new File("win.ground.jpg"));
			wall_win = ImageIO.read(new File("win.wall.jpg"));
			mainmenu = ImageIO.read(new File("mainmenu.png"));
			usernamemenu = ImageIO.read(new File("usernamemenu.png"));
			playstylemenu = ImageIO.read(new File("playstylemenu.png"));
			multiplayermenu = ImageIO.read(new File("multiplayermenu.png"));
			hostmenu = ImageIO.read(new File("hostmenu.png"));
			guestmenu = ImageIO.read(new File("guestmenu.png"));
			helpmenu = ImageIO.read(new File("helpmenu.png"));
			highscoresmenu = ImageIO.read(new File("highscores.png"));
			characterselectionmenu = ImageIO.read(new File("characterselectionmenu.png"));
			
		}
		catch(IOException e){
			System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
		}
	}
}
