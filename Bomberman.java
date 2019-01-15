import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * <h1>Bomberman</h1>
 * Recreation of the game Bomberman in Java<p>
 * @author  Ernest Aroozoo, Bryan Chung, Austin Chay
 * @version 1.0
 */

public class Bomberman implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	// Properties
	JFrame theframe;
	BombermanPanel bombermanpanel;
	SuperSocketMaster ssm;
	Timer thetimer;
	JButton button_startgame;
	JButton button_highscores;
	JButton button_help;
	JButton button_quit;
	JTextField textfield_username;
	JButton button_usernameconfirm;
	JButton button_mouse;
	JButton button_keyboard;
	JButton button_host;
	JButton button_guest;
	JButton button_back;
	JButton button_hostcontinue;
	JButton button_guestcontinue;
	JTextField textfield_ip;
	JButton button_blue;
	JButton button_yellow;
	JButton button_white;
	JButton button_red;
	static String strUsername = "";
	static boolean blnMainMenu = true; // Start actual game when blnMainMenu = false
	static int intMenu = 1; // Default menu card to MainMenu (intMenu = 1)
	static boolean blnIsKeyboard = false;
	static boolean blnIsMouse = false;
	static boolean blnIsHost = false;
	static boolean blnIsGuest = false;
	static String strIP = "";
	static String strConnectionStatus; 
	
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		// JPanel Refresh 60 FPS
		if(evt.getSource() == thetimer){
			bombermanpanel.repaint();
		}
		
		// MainMenu (intMenu == 1)
		if(intMenu == 1){
			System.out.println("MainMenu");
			button_startgame.setVisible(true); // Unhide necessary JComponents
			button_highscores.setVisible(true); 
			button_help.setVisible(true); 
			button_quit.setVisible(true); 
			// [Start Game Button]
			if(evt.getSource() == button_startgame){
				System.out.println("Start Game");
				button_startgame.setVisible(false); // Hide unecessary JComponents
				button_highscores.setVisible(false); 
				button_help.setVisible(false); 
				button_quit.setVisible(false); 
				intMenu = 4; // Change to UsernameMenu 
			}
			// [Highscores Button]
			else if(evt.getSource() == button_highscores){ 
				System.out.println("Highscores");
				button_startgame.setVisible(false); // Hide unecessary JComponents
				button_highscores.setVisible(false);
				button_help.setVisible(false);
				button_quit.setVisible(false);
				intMenu = 2; // Change to HighscoresMenu
			}
			// [Help Button]
			else if(evt.getSource() == button_help){
				System.out.println("Help");
				button_startgame.setVisible(false); // Hide unecessary JComponents
				button_highscores.setVisible(false);
				button_help.setVisible(false);
				button_quit.setVisible(false);
				intMenu = 3; // Change to HelpMenu
			}
			// [Quit Button]
			else if(evt.getSource() == button_quit){ 
				System.out.println("Quit");
				System.exit(0); // Exit program
			}
		}
		
		// HighscoresMenu (intMenu == 2)
		else if(intMenu == 2){
			button_back.setVisible(true); // Unhide necessary JComponents
			// [Back Button]
			if(evt.getSource() == button_back){
				intMenu = 1;
				button_back.setVisible(false); // Hide necessary JComponents
			}
		}
		
		// Help Menu (intMenu == 3)
		else if(intMenu == 3){
			button_back.setVisible(true); // Unhide necessary JComponents
			if(evt.getSource() == button_back){
				intMenu = 1;
				button_back.setVisible(false); // Hide necessary JComponents
			}
		}
		
		// UsernameMenu (intMenu == 4)
		else if(intMenu == 4){
			System.out.println("UsernameMenu");
			textfield_username.setVisible(true); // Unhide necessary JComponents
			button_usernameconfirm.setVisible(true); 
			button_back.setVisible(true);
			textfield_username.grabFocus();
			// [Username Confirm Button]
			if(evt.getSource() == button_usernameconfirm){ 
					strUsername = textfield_username.getText(); 
					System.out.println("Username: " + strUsername);
					textfield_username.setVisible(false); // Hide unecessary JComponents
					button_usernameconfirm.setVisible(false); 
					intMenu = 5; // Change to PlayStyleMenu
				}
			// [Back Button]
			else if(evt.getSource() == button_back){
				intMenu = 1;
				textfield_username.setVisible(false); // Hide unecessary JComponents
				button_usernameconfirm.setVisible(false); 
				button_back.setVisible(false);
			}
		}
		
		// PlayStyleMenu (intMenu == 5)
		else if(intMenu == 5){
			System.out.println("PlayStylemenu");
			button_mouse.setVisible(true); // Unhide necessary JComponents
			button_keyboard.setVisible(true); 
			// [Mouse Button]
			if(evt.getSource() == button_mouse){ 
					System.out.println("Play Style: Mouse");
					blnIsKeyboard = false;
					blnIsMouse = true;
					button_mouse.setVisible(false); // Hide unecessary JComponents
					button_keyboard.setVisible(false);
					intMenu = 6; // Change to MultiplayerMenu
				}
			// [Keyboard Button]
			else if(evt.getSource() == button_keyboard){ 
					System.out.println("Play Style: Keyboard");
					blnIsMouse = false;
					blnIsKeyboard = true;
					button_mouse.setVisible(false); // Hide unecessary JComponents
					button_keyboard.setVisible(false);
					intMenu = 6; // Change to MultiplayerMenu
				}
			// [Back Button]
			else if(evt.getSource() == button_back){
				intMenu = 4;
				button_mouse.setVisible(false); // Hide unecessary JComponents
				button_keyboard.setVisible(false);
			}
		}
		
		// MultiplayerMenu (intMenu == 6)
		else if(intMenu == 6){
			System.out.println("MultiplayerMenu");
			button_host.setVisible(true); // Unhide necessary JComponents
			button_guest.setVisible(true); 
			// [Host Button]
			if(evt.getSource() == button_host){ 
				System.out.println("Multiplayer: Host");
				blnIsGuest = false;
				blnIsHost = true;
				button_host.setVisible(false); // Hide unecessary JComponents
				button_guest.setVisible(false);
				intMenu = 7; // Change to HostMenu
			}
			// [Guest Button]
			else if(evt.getSource() == button_guest){ 
				System.out.println("Multiplayer: Guest");
				blnIsHost = false;
				blnIsGuest = true;
				button_host.setVisible(false); // Hide unecessary JComponents
				button_guest.setVisible(false);
				intMenu = 8; // Change to GuestMenu
			}
			// [Back Button]
			else if(evt.getSource() == button_back){
				intMenu = 5;
				button_host.setVisible(false); // Hide unecessary JComponents
				button_guest.setVisible(false);
			}
		}
		
		// HostMenu (intMenu == 7)
		else if(intMenu == 7){
			System.out.println("HostMenu");
			button_hostcontinue.setVisible(true); // Unhide necessary JComponents
			// [Back Button]
			if(evt.getSource() == button_back){
				intMenu = 6;
				button_hostcontinue.setVisible(false); // Hide unecessary JComponents
			}
			// [Host Continue Button]
			else if(evt.getSource() == button_hostcontinue){
				button_hostcontinue.setVisible(false); // Hide unecessary JComponents
				button_back.setVisible(false); 
				ssm = new SuperSocketMaster(1337, this); // Setup SuperSocketMaster Server
				System.out.println(ssm.getMyAddress());
				strIP = ssm.getMyAddress(); // Convert IP Address into String strIP
				ssm.connect(); 
				ssm.sendText("connected");
				intMenu = 9; // Change to CharacterSelectionMenu
			}
		}
		
		// GuestMenu (intMenu == 8)
		else if(intMenu == 8){
			System.out.println("GuestMenu");
			button_guestcontinue.setVisible(true); // Unhide necessary JComponents
			textfield_ip.setVisible(true);
			textfield_ip.grabFocus();
			// [Back Button]
			if(evt.getSource() == button_back){
				intMenu = 6;
				button_guestcontinue.setVisible(false); // Hide unecessary JComponents
				button_back.setVisible(false); 
				textfield_ip.setVisible(false);
			}
			// [Guest Continue Button]
			else if(evt.getSource() == button_guestcontinue){
				button_guestcontinue.setVisible(false); // Hide unecessary JComponents
				button_back.setVisible(false); 
				textfield_ip.setVisible(false);
				strIP = textfield_ip.getText(); // Grab IP Address from textfield_ip
				System.out.println("Connecting: " + strIP);
				ssm = new SuperSocketMaster(strIP, 1337, this); // Setup SuperSocketMaster Client
				ssm.connect(); 
				strConnectionStatus = ssm.readText();
					if(strConnectionStatus.equals("connected")){
						intMenu = 9; // Change to CharacterSelectionMenu
					}
			} 
		}
			
		// CharacterSelectionMenu (intMenu == 9)
		else if(intMenu == 9){
			System.out.println("CharacterSelectionMenu");
			
			
		}
		
	}

	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() == 37){ // Left Arrow Key
			bombermanpanel.blnLeft = false;
		}
		else if(evt.getKeyCode() == 38){ // Up Arrow Key
			bombermanpanel.blnUp = false;
		}
		else if(evt.getKeyCode() == 39){ // Right Arrow Key
			bombermanpanel.blnRight = false;
		}
		else if(evt.getKeyCode() == 40){ // Down Arrow Key
			bombermanpanel.blnDown = false;
		}
	}

	public void keyPressed(KeyEvent evt){ 
		if(evt.getKeyCode() == 37){ // Left Arrow Key
			bombermanpanel.blnLeft = true;
		}
		else if(evt.getKeyCode() == 38){ // Up Arrow Key
			bombermanpanel.blnUp = true;
			System.out.println("up");
		}
		else if(evt.getKeyCode() == 39){ // Right Arrow Key
			bombermanpanel.blnRight = true;
			System.out.println("right");
		}
		else if(evt.getKeyCode() == 40){ // Down Arrow Key
			bombermanpanel.blnDown = true;
		}
	}

	public void keyTyped(KeyEvent evt){ 

	}

	public void mouseMoved(MouseEvent evt){ 

	}
	
	public void mouseDragged(MouseEvent evt){ 

	}
	
	public void mouseExited(MouseEvent evt){
		
	}
	
	public void mouseEntered(MouseEvent evt){
		
	}
	
	public void mousePressed(MouseEvent evt){
		
	}
	
	public void mouseReleased(MouseEvent evt){
		
	}
	
	public void mouseClicked(MouseEvent evt){

	}

	// Constructors
	public Bomberman(){
		// JPanel
		bombermanpanel = new BombermanPanel(); 
		bombermanpanel.setLayout(null);
		bombermanpanel.setPreferredSize(new Dimension(1280, 720));
		
		// JFrame
		theframe = new JFrame("Bomberman");
		theframe.setContentPane(bombermanpanel);
		theframe.setResizable(false);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);

		// Add MouseMotionListener
		bombermanpanel.addMouseMotionListener(this);
		bombermanpanel.addMouseListener(this);
		
		// Add MouseMotionListener
		theframe.addKeyListener(this);
		theframe.addMouseListener(this);
		
		// Add Timer Object
		thetimer = new Timer(1000/60, this); // Triggering timer object every 1000/60. Basically 60 FPS.
		thetimer.start();
		
		// Add JButtons
		button_startgame = new JButton("Start Game");
		button_startgame.setSize(200, 50);
		button_startgame.setLocation(540, 230);
		button_startgame.addActionListener(this);
		button_startgame.setFocusPainted(false);
		button_startgame.setContentAreaFilled(false);
		button_startgame.setFont(new Font("Arial", Font.PLAIN, 20));
		button_startgame.setForeground(Color.WHITE);
		bombermanpanel.add(button_startgame);
		
		button_highscores = new JButton("Highscores");
		button_highscores.setSize(200, 50);
		button_highscores.setLocation(540, 300);
		button_highscores.addActionListener(this);
		button_highscores.setFocusPainted(false);
		button_highscores.setContentAreaFilled(false);
		button_highscores.setFont(new Font("Arial", Font.PLAIN, 20));
		button_highscores.setForeground(Color.WHITE);
		bombermanpanel.add(button_highscores);
		
		button_help = new JButton("Help");
		button_help.setSize(200, 50);
		button_help.setLocation(540, 370);
		button_help.addActionListener(this);
		button_help.setFocusPainted(false);
		button_help.setContentAreaFilled(false);
		button_help.setFont(new Font("Arial", Font.PLAIN, 20));
		button_help.setForeground(Color.WHITE);
		bombermanpanel.add(button_help);
		
		button_quit = new JButton("Quit");
		button_quit.setSize(200, 50);
		button_quit.setLocation(540, 440);
		button_quit.addActionListener(this);
		button_quit.setFocusPainted(false);
		button_quit.setContentAreaFilled(false);
		button_quit.setFont(new Font("Arial", Font.PLAIN, 20));
		button_quit.setForeground(Color.WHITE);
		bombermanpanel.add(button_quit);
		
		textfield_username = new JTextField();
		textfield_username.setOpaque(false); // Make textfield_username transparent
		textfield_username.setHorizontalAlignment(JTextField.CENTER); // Make textfield_username align center
		textfield_username.setFont(new Font("Arial", Font.PLAIN, 20)); // Change font and text size of textfield_username
		textfield_username.setSize(400, 35);
		textfield_username.setLocation(440,325);
		textfield_username.addActionListener(this);
		bombermanpanel.add(textfield_username);
		textfield_username.setVisible(false); // Hide textfield_username initially
		
		button_usernameconfirm = new JButton("Continue");
		button_usernameconfirm.setSize(200, 50);
		button_usernameconfirm.setLocation(540, 380);
		button_usernameconfirm.addActionListener(this);
		button_usernameconfirm.setFocusPainted(false);
		button_usernameconfirm.setContentAreaFilled(false);
		button_usernameconfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		button_usernameconfirm.setForeground(Color.WHITE);
		bombermanpanel.add(button_usernameconfirm);
		button_usernameconfirm.setVisible(false); // Hide button_usernameconfirm initially
		
		button_mouse = new JButton("Mouse");
		button_mouse.setSize(200, 50);
		button_mouse.setLocation(360, 450);
		button_mouse.addActionListener(this);
		button_mouse.setFocusPainted(false);
		button_mouse.setContentAreaFilled(false);
		button_mouse.setFont(new Font("Arial", Font.PLAIN, 20));
		button_mouse.setForeground(Color.WHITE);
		bombermanpanel.add(button_mouse);
		button_mouse.setVisible(false); // Hide button_mouse initially
		
		button_keyboard = new JButton("Keyboard");
		button_keyboard.setSize(200, 50);
		button_keyboard.setLocation(721, 450);
		button_keyboard.addActionListener(this);
		button_keyboard.setFocusPainted(false);
		button_keyboard.setContentAreaFilled(false);
		button_keyboard.setFont(new Font("Arial", Font.PLAIN, 20));
		button_keyboard.setForeground(Color.WHITE);
		bombermanpanel.add(button_keyboard);
		button_keyboard.setVisible(false); // Hide button_keyboard initially
		
		button_host = new JButton("Host");
		button_host.setSize(200, 50);
		button_host.setLocation(355, 490);
		button_host.addActionListener(this);
		button_host.setFocusPainted(false);
		button_host.setContentAreaFilled(false);
		button_host.setFont(new Font("Arial", Font.PLAIN, 20));
		button_host.setForeground(Color.WHITE);
		bombermanpanel.add(button_host);
		button_host.setVisible(false); // Hide button_host initially
		
		button_guest = new JButton("Guest");
		button_guest.setSize(200, 50);
		button_guest.setLocation(730, 490);
		button_guest.addActionListener(this);
		button_guest.setFocusPainted(false);
		button_guest.setContentAreaFilled(false);
		button_guest.setFont(new Font("Arial", Font.PLAIN, 20));
		button_guest.setForeground(Color.WHITE);
		bombermanpanel.add(button_guest);
		button_guest.setVisible(false); // Hide button_guest initially
		
		button_back = new JButton("Back");
		button_back.setSize(200, 50);
		button_back.setLocation(540, 610);
		button_back.addActionListener(this);
		button_back.setFocusPainted(false);
		button_back.setContentAreaFilled(false);
		button_back.setFont(new Font("Arial", Font.PLAIN, 20));
		button_back.setForeground(Color.WHITE);
		bombermanpanel.add(button_back);
		button_back.setVisible(false); // Hide button_back initially
		
		button_hostcontinue = new JButton("Continue");
		button_hostcontinue.setSize(200, 50);
		button_hostcontinue.setLocation(540, 500);
		button_hostcontinue.addActionListener(this);
		button_hostcontinue.setFocusPainted(false);
		button_hostcontinue.setContentAreaFilled(false);
		button_hostcontinue.setFont(new Font("Arial", Font.PLAIN, 20));
		button_hostcontinue.setForeground(Color.WHITE);
		bombermanpanel.add(button_hostcontinue);
		button_hostcontinue.setVisible(false); // Hide button_hostcontinue initially
		
		button_guestcontinue = new JButton("Continue");
		button_guestcontinue.setSize(200, 50);
		button_guestcontinue.setLocation(540, 500);
		button_guestcontinue.addActionListener(this);
		button_guestcontinue.setFocusPainted(false);
		button_guestcontinue.setContentAreaFilled(false);
		button_guestcontinue.setFont(new Font("Arial", Font.PLAIN, 20));
		button_guestcontinue.setForeground(Color.WHITE);
		bombermanpanel.add(button_guestcontinue);
		button_guestcontinue.setVisible(false); // Hide button_guestcontinue initially
		
		textfield_ip = new JTextField();
		textfield_ip.setOpaque(false); 
		textfield_ip.setHorizontalAlignment(JTextField.CENTER); 
		textfield_ip.setFont(new Font("Arial", Font.PLAIN, 20)); 
		textfield_ip.setSize(400, 35);
		textfield_ip.setLocation(440,450);
		textfield_ip.addActionListener(this);
		bombermanpanel.add(textfield_ip);
		textfield_ip.setVisible(false); // Hide textfield_ip initially
	}

	// Main Methods
	public static void main(String[] args){
		new Bomberman();
	}
}
