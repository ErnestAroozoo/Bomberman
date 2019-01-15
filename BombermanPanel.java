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
	int intRow = 0;
	int intCol = 0;
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
		if(Bomberman.blnMainMenu == true){
			// Main Menu
			if(Bomberman.intMenu == 1){ 
				g.drawImage(mainmenu, 0, 0, null); 
			}
			// HighscoresMenu 
			else if(Bomberman.intMenu == 2){ 
				g.drawImage(highscoresmenu, 0, 0, null);
			}
			// HelpMenu
			else if(Bomberman.intMenu == 3){ 
				g.drawImage(helpmenu, 0, 0, null);
			}
			// UsernameMenu
			else if(Bomberman.intMenu == 4){
				g.drawImage(usernamemenu, 0, 0, null);
			}
			// PlayStyleMenu
			else if(Bomberman.intMenu == 5){ 
				g.drawImage(playstylemenu, 0, 0, null);
			}
			// MultiplayerMenu
			else if(Bomberman.intMenu == 6){ 
				g.drawImage(multiplayermenu, 0, 0, null);
			}
			// HostMenu
			else if(Bomberman.intMenu == 7){ 
				g.drawImage(hostmenu, 0, 0, null);
				g.setFont(new Font("Arial", Font.PLAIN, 20)); 
				g.drawString(Bomberman.strIP, 580, 480); // Draw IP Adress on screen
				
			}
			// GuestMenu
			else if(Bomberman.intMenu == 8){ 
				g.drawImage(guestmenu, 0, 0, null);
			}
			// CharacterSelectionMenu
			else if(Bomberman.intMenu == 9){
				g.drawImage(characterselectionmenu, 0, 0, null);
			}
		}
		
		// Start Bomberman Game
		else if(Bomberman.blnMainMenu == false){
			if(blnUp == true){
				intY = intY - 5;
				g.drawImage(up1_blue, intX, intY, null);
				g.drawImage(up2_blue, intX, intY, null);
			}
			else if(blnRight == true){
				intX = intX + 5;
				g.drawImage(right1_blue, intX, intY, null); 
				g.drawImage(right2_blue, intX, intY, null); 
			}
			else if(blnDown == true){
				intY = intY + 5;
				g.drawImage(down1_blue, intX, intY, null); 
				g.drawImage(down2_blue, intX, intY, null); 
			}
			else if(blnLeft == true){
				intX = intX - 5;
				g.drawImage(left1_blue, intX, intY, null); 
				g.drawImage(left2_blue, intX, intY, null); 
			}
			if(blnPlaceBomb == true){
				g.drawImage(bomb_item,intX,intY,null);
			}
			for(intRow = 0; intRow < 11; intRow++){
				for(intCol = 0; intCol < 15; intCol++){
					if(Bomberman.strMap1[intRow][intCol].equals("ob")){
						g.drawImage(wall_stan,intCol*60,intRow * 60,null);
					}else if(Bomberman.strMap1[intRow][intCol].equals("r")){
						g.drawImage(breakwall_stan,intCol*60,intRow*60,null);
					}else if(Bomberman.strMap1[intRow][intCol].equals("g")){
						g.drawImage(ground_stan,intCol*60,intRow*60,null);
					}else if(Bomberman.strMap1[intRow][intCol.equals("c1")){
						g.drawImage(default_blue,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap1[intRow][intCol].equals("c2")){
						g.drawImage(default_red,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap1[intRow][intCol].equals("c3")){
						g.drawImage(default_yellow,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap1[intRow][intCol].equals("c4")){
						g.drawImage(default_white,intRow*60,intCol*60,null);
					}
				}
			}
			for(intRow = 0; intRow < 11; intRow++){
				for(intCol = 0; intCol < 15; intCol++){
					if(Bomberman.strMap2[intRow][intCol].equals("ob")){
						g.drawImage(wall_stan,intCol*60,intRow * 60,null);
					}else if(Bomberman.strMap2[intRow][intCol].equals("r")){
						g.drawImage(breakwall_stan,intCol*60,intRow*60,null);
					}else if(Bomberman.strMap2[intRow][intCol].equals("g")){
						g.drawImage(ground_stan,intCol*60,intRow*60,null);
					}else if(Bomberman.strMap2[intRow][intCol.equals("c1")){
						g.drawImage(default_blue,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap2[intRow][intCol].equals("c2")){
						g.drawImage(default_red,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap2[intRow][intCol].equals("c3")){
						g.drawImage(default_yellow,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap2[intRow][intCol].equals("c4")){
						g.drawImage(default_white,intRow*60,intCol*60,null);
					}
				}
			}
			for(intRow = 0; intRow < 11; intRow++){
				for(intCol = 0; intCol < 15; intCol++){
					if(Bomberman.strMap1[intRow][intCol].equals("ob")){
						g.drawImage(wall_stan,intCol*60,intRow * 60,null);
					}else if(Bomberman.strMap3[intRow][intCol].equals("r")){
						g.drawImage(breakwall_stan,intCol*60,intRow*60,null);
					}else if(Bomberman.strMap3[intRow][intCol].equals("g")){
						g.drawImage(ground_stan,intCol*60,intRow*60,null);
					}else if(Bomberman.strMap3[intRow][intCol.equals("c1")){
						g.drawImage(default_blue,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap3[intRow][intCol].equals("c2")){
						g.drawImage(default_red,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap3[intRow][intCol].equals("c3")){
						g.drawImage(default_yellow,intRow*60,intCol*60,null);
					}else if(Bomberman.strMap3[intRow][intCol].equals("c4")){
						g.drawImage(default_white,intRow*60,intCol*60,null);
					}
				}
			}
		}
	}
}
	
	// Constructors
	public BombermanPanel(){
		super();
		// Add Images
		try{
			default_blue = ImageIO.read(new File("default.png"));
			up1_blue = ImageIO.read(new File("up1.png")); 
			up2_blue = ImageIO.read(new File("up2.png")); 
			right1_blue = ImageIO.read(new File("right1.png")); 
			right2_blue = ImageIO.read(new File("right2.png")); 
			down1_blue = ImageIO.read(new File("down1.png")); 
			down2_blue = ImageIO.read(new File("down2.png")); 
			left1_blue = ImageIO.read(new File("left1.png")); 
			left2_blue = ImageIO.read(new File("left2.png"));
			default_red = ImageIO.read(new File("default_red.png"));
			up1_red = ImageIO.read(new File("up1_red.png")); 
			up2_red = ImageIO.read(new File("up2_red.png")); 
			right1_red = ImageIO.read(new File("right1_red.png")); 
			right2_red = ImageIO.read(new File("right2_red.png")); 
			down1_red = ImageIO.read(new File("down1_red.png")); 
			down2_red = ImageIO.read(new File("down2_red.png")); 
			left1_red = ImageIO.read(new File("left1_red.png")); 
			left2_red = ImageIO.read(new File("left2_red.png"));
			default_yellow = ImageIO.read(new File("default_yellow.png"));
			up1_yellow = ImageIO.read(new File("up1_yellow.png")); 
			up2_yellow = ImageIO.read(new File("up2_yellow.png")); 
			right1_yellow = ImageIO.read(new File("right1_yellow.png")); 
			right2_yellow = ImageIO.read(new File("right2_yellow.png")); 
			down1_yellow = ImageIO.read(new File("down1_yellow.png")); 
			down2_yellow = ImageIO.read(new File("down2_yellow.png")); 
			left1_yellow = ImageIO.read(new File("left1_yellow.png")); 
			left2_yellow = ImageIO.read(new File("left2_yellow.png"));
			default_white = ImageIO.read(new File("default_yellow.png"));
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
