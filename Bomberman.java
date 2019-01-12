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
	MainMenuPanel mainmenupanel;
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
	static boolean blnStartGame = false; // blnStartGame = true when we want to switch over to BombermanPanel (actual game)
	static boolean blnMainMenu = true;
	static boolean blnUsernameMenu = false;
	static String strUsername;
	static boolean blnPlayStyleMenu = false;
	static boolean blnIsKeyboard = false;
	static boolean blnIsMouse = false;
	static boolean blnMultiplayerMenu = false;
	static boolean blnIsHost = false;
	static boolean blnIsGuest = false;
	static boolean blnHostMenu = false;
	static boolean blnGuestMenu = false;
	

	// Methods
	public void actionPerformed(ActionEvent evt){
		// JPanel Refresh 60 FPS
		if(evt.getSource() == thetimer){
			mainmenupanel.repaint();
			bombermanpanel.repaint();
		}
		// [Start Game Button]
		if(evt.getSource() == button_startgame){ // Start Game Button
			blnMainMenu = false;
			System.out.println("Start Game");
			button_startgame.setVisible(false); // Hide button_startgame
			button_highscores.setVisible(false); // Hide button_highscores
			button_help.setVisible(false); // Hide button_help
			button_quit.setVisible(false); // Hide button_quit
			blnUsernameMenu = true; // Change to UsernameMenu image
		}

		// [Username Menu]
		if(blnUsernameMenu == true){
			textfield_username.setVisible(true); // Unhide textfield_username
			button_usernameconfirm.setVisible(true); // Unhide button_usernameconfirm
			textfield_username.grabFocus(); // Grab text focus onto textfield_username
				if(evt.getSource() == button_usernameconfirm){ // Username Confirm Button
					strUsername = textfield_username.getText(); // Grab username when button_usernameconfirm is clicked
					System.out.println("Username: " + strUsername);
					textfield_username.setVisible(false); // Hide textfield_username
					button_usernameconfirm.setVisible(false); // Hide button_usernameconfirm 
					blnUsernameMenu = false; 
					blnPlayStyleMenu = true; // Change to PlayStyleMenu
				}
			}
			
		// [Play Style Menu]
		if(blnPlayStyleMenu == true){
			button_mouse.setVisible(true); // Unhide button_mouse
			button_keyboard.setVisible(true); // Unhide button_keyboard
				if(evt.getSource() == button_mouse){ // Mouse Selection
					blnIsMouse = true;
					System.out.println("Play Style: Mouse");
					button_mouse.setVisible(false);
					button_keyboard.setVisible(false);
					blnPlayStyleMenu = false;
					blnMultiplayerMenu = true; // Change to MultiplayerMenu
				}
				else if(evt.getSource() == button_keyboard){ // Keyboard Selection
					blnIsKeyboard = true;
					System.out.println("Play Style: Keyboard");
					button_mouse.setVisible(false);
					button_keyboard.setVisible(false);
					blnPlayStyleMenu = false; 
					blnMultiplayerMenu = true; // Change to MultiplayerMenu
				}
		}
		
		// [Multiplayer Menu]
		if(blnMultiplayerMenu == true){
			button_host.setVisible(true); // Unhide button_host
			button_guest.setVisible(true); // Unhide button_guest
			if(evt.getSource() == button_host){ // Host Selection
				blnIsHost = true;
				System.out.println("Multiplayer: Host");
				button_host.setVisible(false);
				button_guest.setVisible(false);
				blnMultiplayerMenu = false;
				blnHostMenu = true; // Change to HostMenu
			}
			else if(evt.getSource() == button_guest){ // Guest Selection
				blnIsGuest = true;
				System.out.println("Multiplayer: Guest");
				button_host.setVisible(false);
				button_guest.setVisible(false);
				blnMultiplayerMenu = false;
				blnGuestMenu = true; // Change to GuestMenu
			}
		}
		
		// [Host Menu]
		if(blnHostMenu == true){
			// Display Host's IP address
		}
		
		
		// [Highscores Button]
		else if(evt.getSource() == button_highscores){ 
			System.out.println("Highscores");
			// Remove Buttons
			button_startgame.setVisible(false);
			button_highscores.setVisible(false);
			button_help.setVisible(false);
			button_quit.setVisible(false);
		}
		
		// [Help Button]
		else if(evt.getSource() == button_help){
			System.out.println("Help");
			// Remove Buttons
			button_startgame.setVisible(false);
			button_highscores.setVisible(false);
			button_help.setVisible(false);
			button_quit.setVisible(false);
		}
		
		// [Quit Button]
		else if(evt.getSource() == button_quit){ 
			System.out.println("Quit");
			// Exit Program
			System.exit(0);
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
		mainmenupanel = new MainMenuPanel(); // First Panel
		mainmenupanel.setLayout(null);
		mainmenupanel.setPreferredSize(new Dimension(1280, 720));
		
		bombermanpanel = new BombermanPanel(); // Second Panel
		bombermanpanel.setLayout(null);
		bombermanpanel.setPreferredSize(new Dimension(1280, 720));
		
		// JFrame
		theframe = new JFrame("Bomberman");
		theframe.setContentPane(mainmenupanel);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);

		// Add MouseMotionListener
		if(blnStartGame == true){
			bombermanpanel.addMouseMotionListener(this);
			bombermanpanel.addMouseListener(this);
		}

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
		mainmenupanel.add(button_startgame);
		
		button_highscores = new JButton("Highscores");
		button_highscores.setSize(200, 50);
		button_highscores.setLocation(540, 300);
		button_highscores.addActionListener(this);
		button_highscores.setFocusPainted(false);
		button_highscores.setContentAreaFilled(false);
		button_highscores.setFont(new Font("Arial", Font.PLAIN, 20));
		button_highscores.setForeground(Color.WHITE);
		mainmenupanel.add(button_highscores);
		
		button_help = new JButton("Help");
		button_help.setSize(200, 50);
		button_help.setLocation(540, 370);
		button_help.addActionListener(this);
		button_help.setFocusPainted(false);
		button_help.setContentAreaFilled(false);
		button_help.setFont(new Font("Arial", Font.PLAIN, 20));
		button_help.setForeground(Color.WHITE);
		mainmenupanel.add(button_help);
		
		button_quit = new JButton("Quit");
		button_quit.setSize(200, 50);
		button_quit.setLocation(540, 440);
		button_quit.addActionListener(this);
		button_quit.setFocusPainted(false);
		button_quit.setContentAreaFilled(false);
		button_quit.setFont(new Font("Arial", Font.PLAIN, 20));
		button_quit.setForeground(Color.WHITE);
		mainmenupanel.add(button_quit);
		
		textfield_username = new JTextField();
		textfield_username.setOpaque(false);
		textfield_username.setFont(new Font("Arial", Font.PLAIN, 20));
		textfield_username.setSize(400, 35);
		textfield_username.setLocation(440,325);
		textfield_username.addActionListener(this);
		mainmenupanel.add(textfield_username);
		textfield_username.setVisible(false); // Hide textfield_username initially
		
		button_usernameconfirm = new JButton("Continue");
		button_usernameconfirm.setSize(200, 50);
		button_usernameconfirm.setLocation(540, 440);
		button_usernameconfirm.addActionListener(this);
		button_usernameconfirm.setFocusPainted(false);
		button_usernameconfirm.setContentAreaFilled(false);
		button_usernameconfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		button_usernameconfirm.setForeground(Color.WHITE);
		mainmenupanel.add(button_usernameconfirm);
		button_usernameconfirm.setVisible(false); // Hide button_usernameconfirm initially
		
		button_mouse = new JButton("Mouse");
		button_mouse.setSize(200, 50);
		button_mouse.setLocation(360, 450);
		button_mouse.addActionListener(this);
		button_mouse.setFocusPainted(false);
		button_mouse.setContentAreaFilled(false);
		button_mouse.setFont(new Font("Arial", Font.PLAIN, 20));
		button_mouse.setForeground(Color.WHITE);
		mainmenupanel.add(button_mouse);
		button_mouse.setVisible(false); // Hide button_mouse initially
		
		button_keyboard = new JButton("Keyboard");
		button_keyboard.setSize(200, 50);
		button_keyboard.setLocation(721, 450);
		button_keyboard.addActionListener(this);
		button_keyboard.setFocusPainted(false);
		button_keyboard.setContentAreaFilled(false);
		button_keyboard.setFont(new Font("Arial", Font.PLAIN, 20));
		button_keyboard.setForeground(Color.WHITE);
		mainmenupanel.add(button_keyboard);
		button_keyboard.setVisible(false); // Hide button_keyboard initially
		
		button_host = new JButton("Host");
		button_host.setSize(200, 50);
		button_host.setLocation(355, 490);
		button_host.addActionListener(this);
		button_host.setFocusPainted(false);
		button_host.setContentAreaFilled(false);
		button_host.setFont(new Font("Arial", Font.PLAIN, 20));
		button_host.setForeground(Color.WHITE);
		mainmenupanel.add(button_host);
		button_host.setVisible(false); // Hide button_host initially
		
		button_guest = new JButton("Guest");
		button_guest.setSize(200, 50);
		button_guest.setLocation(730, 490);
		button_guest.addActionListener(this);
		button_guest.setFocusPainted(false);
		button_guest.setContentAreaFilled(false);
		button_guest.setFont(new Font("Arial", Font.PLAIN, 20));
		button_guest.setForeground(Color.WHITE);
		mainmenupanel.add(button_guest);
		button_guest.setVisible(false); // Hide button_guest initially
		
	}

	// Main Methods
	public static void main(String[] args){
		new Bomberman();
	}
}
