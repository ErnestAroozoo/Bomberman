import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class BombermanPanel extends JPanel{
	// Properties
	SuperSocketMaster ssm;               
	static int intX = 0;
	static int intY = 0;
	static int intX_red = 300;
	static int intY_red = 0;
	static int intX_yellow = 0;
	static int intY_yellow = 300;
	static int intX_white = 300;
	static int intY_white = 300;
    static int intRow = 0;
	static int intCol = 0;
	int intBombX = 0;
	int intBombY = 0;
	boolean blnUp = false;
	boolean blnDown = false;
	boolean blnLeft = false;
	boolean blnRight = false;
	boolean blnPlaceBomb = false;
	boolean blnUp_red = false;
	boolean blnDown_red = false;
	boolean blnLeft_red = false;
	boolean blnRight_red = false;
	boolean blnPlaceBomb_red = false;
	boolean blnUp_yellow = false;
	boolean blnDown_yellow = false;
	boolean blnLeft_yellow = false;
	boolean blnRight_yellow = false;
	boolean blnPlaceBomb_yellow = false;
	boolean blnUp_white = false;
	boolean blnDown_white = false;
	boolean blnLeft_white = false;
	boolean blnRight_white = false;
	boolean blnPlaceBomb_white = false;
	static BufferedImage up1;
	static BufferedImage up2;
	static BufferedImage right1;
	static BufferedImage right2;
	static BufferedImage down1;
	static BufferedImage down2;
	static BufferedImage left1;
	static BufferedImage left2;
	
	static BufferedImage up1_red;
	static BufferedImage up2_red;
	static BufferedImage right1_red;
	static BufferedImage right2_red;
	static BufferedImage down1_red;
	static BufferedImage down2_red;
	static BufferedImage left1_red;
	static BufferedImage left2_red;
	
	static BufferedImage up1_yellow;
	static BufferedImage up2_yellow;
	static BufferedImage right1_yellow;
	static BufferedImage right2_yellow;
	static BufferedImage down1_yellow;
	static BufferedImage down2_yellow;
	static BufferedImage left1_yellow;
	static BufferedImage left2_yellow;
	
	static BufferedImage up1_white;
	static BufferedImage up2_white;
	static BufferedImage right1_white;
	static BufferedImage right2_white;
	static BufferedImage down1_white;
	static BufferedImage down2_white;
	static BufferedImage left1_white;
	static BufferedImage left2_white;
	
	
	static BufferedImage ground_stan;
	static BufferedImage wall_stan;
	static BufferedImage breakwall_stan;
	static BufferedImage ground_win;
	static BufferedImage wall_win;
	static BufferedImage fire_horizontal;
	static BufferedImage fire_downend;
	static BufferedImage fire_leftend;
	static BufferedImage fire_mid;
	static BufferedImage fire_rightend;
	static BufferedImage fire_upend;
	static BufferedImage fire_vertical;
	static BufferedImage bomb_item;
	static BufferedImage bomb_active;
	static BufferedImage multiplebombitem;
	static BufferedImage flameitem;
	static BufferedImage mainmenu;
	static BufferedImage guestmenu;
	static BufferedImage hostmenu;
	static BufferedImage multiplayermenu;
	static BufferedImage playstylemenu;
	static BufferedImage usernamemenu;
	static BufferedImage helpmenu;
	static BufferedImage highscoresmenu;
	static BufferedImage characterselectionmenu;

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
      if(Bomberman.intRand == 1){
				for(intRow = 0; intRow < 11; intRow++){
					for(intCol = 0; intCol < 15; intCol++){
						if(Bomberman.strMap[intRow][intCol].equals("ob")){
							g.drawImage(wall_stan,intCol*60,intRow * 60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("r")){
							g.drawImage(breakwall_stan,intCol*60,intRow*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("g")){
							g.drawImage(ground_stan,intCol*60,intRow*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c1")){
							g.drawImage(down1,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c2")){
							g.drawImage(down1_red,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c3")){
							g.drawImage(down1_yellow,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c4")){
							g.drawImage(down1_white,intRow*60,intCol*60,null);
						}
					}
				}
		/*	}else if(Bomberman.intRand == 2){	
				for(intRow = 0; intRow < 11; intRow++){
					for(intCol = 0; intCol < 15; intCol++){
						if(Bomberman.strMap[intRow][intCol].equals("ob")){
							g.drawImage(wall_win,intCol*60,intRow * 60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("r")){
							g.drawImage(break_win,intCol*60,intRow*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("g")){
							g.drawImage(ground_stan,intCol*60,intRow*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c1")){
							g.drawImage(down1,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c2")){
							g.drawImage(down1_red,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c3")){
							g.drawImage(down1_yellow,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c4")){
							g.drawImage(down1_white,intRow*60,intCol*60,null);
						}
					}
				}
			}else if(Bomberman.intRand == 3){
				for(intRow = 0; intRow < 11; intRow++){
					for(intCol = 0; intCol < 15; intCol++){
						if(Bomberman.strMap[intRow][intCol].equals("ob")){
							g.drawImage(wall_win,intCol*60,intRow * 60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("r")){
							g.drawImage(break_win,intCol*60,intRow*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("g")){
							g.drawImage(ground_stan,intCol*60,intRow*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c1")){
							g.drawImage(default_blue,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c2")){
							g.drawImage(default_red,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c3")){
							g.drawImage(default_yellow,intRow*60,intCol*60,null);
						}else if(Bomberman.strMap[intRow][intCol].equals("c4")){
							g.drawImage(default_white,intRow*60,intCol*60,null);
						}
					}
				} */
			}
			g.drawImage(down1, intX, intY, null);// Default stance
			g.drawImage(down1_red, intX_red, intY_red, null);// Default stance
			g.drawImage(down1_yellow, intX_yellow, intY_yellow, null);// Default stance
			g.drawImage(down1_white, intX_white, intY_white, null);// Default stance
			if(blnPlaceBomb){
				intBombX = intX;
				intBombY = intY;
				g.drawImage(bomb_item,intBombX,intBombY,null);
			}
			
			if(blnUp == true){
				intY = intY - 5;
				g.drawImage(up1, intX, intY, null);
				Bombermantools.trysleep();
           g.drawImage(up2, intX, intY, null);
           Bombermantools.trysleep();
			}
			else if(blnRight == true){
				intX = intX + 5;
				g.drawImage(right1, intX, intY, null); 
			Bombermantools.trysleep();
			g.drawImage(right2, intX, intY, null); 
			Bombermantools.trysleep();
			}
			else if(blnDown == true){
				intY = intY + 5;
				g.drawImage(down1, intX, intY, null); 
			Bombermantools.trysleep();
				g.drawImage(down2, intX, intY, null); 
			Bombermantools.trysleep();
			}
			else if(blnLeft == true){
				intX = intX - 5;
				g.drawImage(left1, intX, intY, null); 
			Bombermantools.trysleep();
				g.drawImage(left2, intX, intY, null);
			Bombermantools.trysleep();
			}
			else if(blnUp_red == true){
				intY_red = intY_red - 5;
				g.drawImage(up1_red, intX_red, intY_red, null);
				Bombermantools.trysleep();
           g.drawImage(up2_red, intX_red, intY_red, null);
           Bombermantools.trysleep();
			}
			else if(blnRight_red == true){
				intX_red = intX_red + 5;
				g.drawImage(right1_red, intX_red, intY_red, null); 
			Bombermantools.trysleep();
			g.drawImage(right2_red, intX_red, intY_red, null); 
			Bombermantools.trysleep();
			}
			else if(blnDown_red == true){
				intY_red = intY_red + 5;
				g.drawImage(down1_red, intX_red, intY_red, null); 
			Bombermantools.trysleep();
				g.drawImage(down2_red, intX_red, intY_red, null); 
			Bombermantools.trysleep();
			}
			else if(blnLeft_red == true){
				intX_red = intX_red - 5;
				g.drawImage(left1_red, intX_red, intY_red, null); 
			Bombermantools.trysleep();
				g.drawImage(left2_red, intX_red, intY_red, null);
			Bombermantools.trysleep();
				}
			else if(blnUp_yellow == true){
				intY_yellow = intY_yellow - 5;
				g.drawImage(up1_yellow, intX_yellow, intY_yellow, null);
				Bombermantools.trysleep();
           g.drawImage(up2_yellow, intX_yellow, intY_yellow, null);
           Bombermantools.trysleep();
			}
			else if(blnRight_yellow == true){
				intX_yellow = intX_yellow + 5;
				g.drawImage(right1_yellow, intX_yellow, intY_yellow, null); 
			Bombermantools.trysleep();
			g.drawImage(right2_yellow, intX_yellow, intY_yellow, null); 
			Bombermantools.trysleep();
			}
			else if(blnDown_yellow == true){
				intY_yellow = intY_yellow + 5;
				g.drawImage(down1_yellow, intX_yellow, intY_yellow, null); 
			Bombermantools.trysleep();
				g.drawImage(down2_yellow, intX_yellow, intY_yellow, null); 
			Bombermantools.trysleep();
			}
			else if(blnLeft_yellow == true){
				intX_yellow = intX_yellow - 5;
				g.drawImage(left1_yellow, intX_yellow, intY_yellow, null); 
				Bombermantools.trysleep();
				g.drawImage(left2_yellow, intX_yellow, intY_yellow, null);
				Bombermantools.trysleep();
			}
		else if(blnUp_white == true){
				intY_white = intY_white - 5;
				g.drawImage(up1_white, intX_white, intY_white, null);
				Bombermantools.trysleep();
           g.drawImage(up2_white, intX_white, intY_white, null);
           Bombermantools.trysleep();
			}
			else if(blnRight_white == true){
				intX_white = intX_white + 5;
				g.drawImage(right1_white, intX_white, intY_white, null); 
			Bombermantools.trysleep();
			g.drawImage(right2_white, intX_white, intY_white, null); 
			Bombermantools.trysleep();
			}
			else if(blnDown_white == true){
				intY_white = intY_white + 5;
				g.drawImage(down1_white, intX_white, intY_white, null); 
			Bombermantools.trysleep();
				g.drawImage(down2_white, intX_white, intY_white, null); 
			Bombermantools.trysleep();
			}
			else if(blnLeft_white == true){
				intX_white = intX_white - 5;
				g.drawImage(left1_white, intX_white, intY_white, null); 
			Bombermantools.trysleep();
				g.drawImage(left2_white, intX_white, intY_white, null);
			Bombermantools.trysleep();
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
