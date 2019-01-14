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

/// Things we need to consider
/// a back button so that if they make a mistake they can go back
/// a recap screen so that they can see what they have and also for us to see what they have


public class Bomberman implements ActionListener, KeyListener, MouseMotionListener{
	// Properties
	JFrame theframe;
	GamePanel thepanel;
	Timer thetimer;
	JButton button_startgame;
	JButton button_highscores;
	JButton button_help;
	JButton button_quit;
	JButton button_next;
	JButton button_host;
	JButton button_guest;
	JButton button_usernameconfirm;
	JButton button_IPconfirm;
	JButton button_mouse;
	JButton button_keyboard;
	JButton button_goback;
	JTextField textfield_username;
	JTextField textfield_guestIP;
	SuperSocketMaster ssm;
	static String strUsername;
	static boolean blnIsMouse;
	static boolean blnIsKeyboard;
	static boolean blnIsHost;
	static boolean blnIsGuest;
	static String strAddress;
	// Methods
	public void actionPerformed(ActionEvent evt){  // actionPerformed is triggered when JComponents are triggered.
		
		if(evt.getSource() == thetimer){ // If timer is going off, 60 FPS in this case, panel will repaint itself.
			thepanel.repaint();
		}else if(evt.getSource() == button_highscores){
			System.out.println("highscores");
			thepanel.blnHighScores = true;
			button_help.setVisible(false);
			button_highscores.setVisible(false);
			button_quit.setVisible(false);
			button_startgame.setVisible(false);
		}else if(evt.getSource() == button_help){
			System.out.println("help");
			thepanel.blnHelp = true;
			button_help.setVisible(false);
			button_highscores.setVisible(false);
			button_quit.setVisible(false);
			button_startgame.setVisible(false);
		}else if(evt.getSource() == button_quit){
			System.exit(0);
		}else if(evt.getSource() == button_startgame){
			thepanel.intStartGame = 2;
			button_help.setVisible(false);
			button_highscores.setVisible(false);
			button_quit.setVisible(false);
			button_startgame.setVisible(false);
			textfield_username.setVisible(true); // Unhide textfield_username
			button_usernameconfirm.setVisible(true); // Unhide button_usernameconfirm
			textfield_username.grabFocus(); // Grab text focus onto textfield_username
				if(evt.getSource() == button_usernameconfirm){ // Username Confirm Button
					strUsername = textfield_username.getText(); // Grab username when button_usernameconfirm is clicked
					System.out.println("Username: " + strUsername);
					textfield_username.setVisible(false); // Hide textfield_username
					button_usernameconfirm.setVisible(false); // Hide button_usernameconfirm
					thepanel.intStartGame = 3; 
				}else if(evt.getSource() == button_goback){
					thepanel.intStartGame = 1;
					button_help.setVisible(true);
					button_highscores.setVisible(true);
					button_quit.setVisible(true);
					button_startgame.setVisible(true);
					textfield_username.setVisible(false); // Hide textfield_username
					button_usernameconfirm.setVisible(false); // Hide button_usernameconfirm
				}
			if(thepanel.intStartGame == 3){
				button_mouse.setVisible(true); // Unhide button_mouse
				button_keyboard.setVisible(true); // Unhide button_keyboard
				if(evt.getSource() == button_mouse){ // Mouse Selection
					blnIsMouse = true;
					System.out.println("Play Style: Mouse");
					button_mouse.setVisible(false);
					button_keyboard.setVisible(false);
					thepanel.intStartGame = 4;
				}
				else if(evt.getSource() == button_keyboard){ // Keyboard Selection
					blnIsKeyboard = true;
					System.out.println("Play Style: Keyboard");
					button_mouse.setVisible(false);
					button_keyboard.setVisible(false);
					thepanel.intStartGame = 4;
				}else if(evt.getSource() == button_goback){
					thepanel.intStartGame = 2;
					textfield_username.setVisible(true); // Unhide textfield_username
					button_usernameconfirm.setVisible(true); // Unhide button_usernameconfirm
					button_mouse.setVisible(false); // Unhide button_mouse
					button_keyboard.setVisible(false); // Unhide button_keyboard
				}
			}
			if(thepanel.intStartGame == 4){
				button_host.setVisible(true); // Unhide button_host
				button_guest.setVisible(true); // Unhide button_guest
				if(evt.getSource() == button_host){ // Host Selection
					blnIsHost = true;
					System.out.println("Multiplayer: Host");
					button_host.setVisible(false);
					button_guest.setVisible(false);
					ssm = new SuperSocketMaster(1337, this); // Setup Host SuperSocketMaster
					System.out.println(ssm.getMyAddress());
					thepanel.strAddress = ssm.getMyAddress();
					ssm.connect(); 
					thepanel.intHost = 1;
				}else if(evt.getSource() == button_guest){ // Guest Selection
					blnIsGuest = true;
					System.out.println("Multiplayer: Guest");
					button_host.setVisible(false);
					button_guest.setVisible(false);
					thepanel.intHost = 2;
				}else if(evt.getSource() == button_goback){
					thepanel.intStartGame = 3;
					button_mouse.setVisible(true);
					button_keyboard.setVisible(true);
					button_host.setVisible(false); // Unhide button_host
					button_guest.setVisible(false); // Unhide button_guest
				}
			}
			if(thepanel.intHost == 2){
				textfield_guestIP.setVisible(true);
				button_IPconfirm.setVisible(true);
				if(evt.getSource() == button_IPconfirm){
					thepanel.intStartGame = 5;
					textfield_guestIP.setVisible(false);
					button_IPconfirm.setVisible(false);
				}else if(evt.getSource() == button_goback){
					thepanel.intStartGame = 4;
					button_host.setVisible(true); // Unhide button_host
					button_guest.setVisible(true); // Unhide button_guest
					textfield_guestIP.setVisible(false);
					button_IPconfirm.setVisible(false);
				}
			}
		}
	}

	public void keyReleased(KeyEvent evt){ // keyReleased is triggered when you release the key.
		System.out.println(evt.getKeyCode());
		if(evt.getKeyCode() == 37){ // Left Arrow Key
			thepanel.blnLeft = false;
		}
		else if(evt.getKeyCode() == 38){ // Up Arrow Key
			thepanel.blnUp = false;
		}
		else if(evt.getKeyCode() == 39){ // Right Arrow Key
			thepanel.blnRight = false;
		}
		else if(evt.getKeyCode() == 40){ // Down Arrow Key
			thepanel.blnDown = false;
		}
	}

	public void keyPressed(KeyEvent evt){ // keyPressed is triggered when you press the key.
		if(evt.getKeyCode() == 37){ // Left Arrow Key
			thepanel.blnLeft = true;
		}
		else if(evt.getKeyCode() == 38){ // Up Arrow Key
			thepanel.blnUp = true;
			System.out.println("up");
		}
		else if(evt.getKeyCode() == 39){ // Right Arrow Key
			thepanel.blnRight = true;
			System.out.println("right");
		}
		else if(evt.getKeyCode() == 40){ // Down Arrow Key
			thepanel.blnDown = true;
		}
	}

	public void keyTyped(KeyEvent evt){ // keyTyped is triggered when you press and release the key.
		if(evt.getKeyCode() == 32){
			thepanel.blnplacebomb = true;
		}
	}

	public void mouseMoved(MouseEvent evt){ // mouseMoved is triggered when mouse is moved.

	}
	public void mouseDragged(MouseEvent evt){ // mouseDragged is triggered when mouse is dragged.

	}

	public JButton StartGame(){
		button_startgame = new JButton("Start Game");
		button_startgame.setSize(200,50);
		button_startgame.setLocation(540, 230);
		button_startgame.addActionListener(this);
		button_startgame.setFocusPainted(false);
		button_startgame.setContentAreaFilled(false);
		button_startgame.setFont(new Font("Arial", Font.PLAIN, 20));
		button_startgame.setForeground(Color.WHITE);
		return(button_startgame);
	}
	public JButton HighScores(){
		button_highscores = new JButton("Highscores");
		button_highscores.setSize(200, 50);
		button_highscores.setLocation(540, 300);
		button_highscores.addActionListener(this);
		button_highscores.setFocusPainted(false);
		button_highscores.setContentAreaFilled(false);
		button_highscores.setFont(new Font("Arial", Font.PLAIN, 20));
		button_highscores.setForeground(Color.WHITE);
		return(button_highscores);
	}
	public JButton Help(){
		button_help = new JButton("Help");
		button_help.setSize(200, 50);
		button_help.setLocation(540, 370);
		button_help.addActionListener(this);
		button_help.setFocusPainted(false);
		button_help.setContentAreaFilled(false);
		button_help.setFont(new Font("Arial", Font.PLAIN, 20));
		button_help.setForeground(Color.WHITE);
		return(button_help);
	}
	public JButton Quit(){
		button_quit = new JButton("Quit");
		button_quit.setSize(200, 50);
		button_quit.setLocation(540, 440);
		button_quit.addActionListener(this);
		button_quit.setFocusPainted(false);
		button_quit.setContentAreaFilled(false);
		button_quit.setFont(new Font("Arial", Font.PLAIN, 20));
		button_quit.setForeground(Color.WHITE);
		return(button_quit);
	}
	public JButton Host(){
		button_host = new JButton("Host");
		button_host.setSize(200, 50);
		button_host.setLocation(355, 490);
		button_host.addActionListener(this);
		button_host.setFocusPainted(false);
		button_host.setContentAreaFilled(false);
		button_host.setFont(new Font("Arial", Font.PLAIN, 20));
		button_host.setForeground(Color.WHITE);
		button_host.setVisible(false);
		return(button_host);
	}
	public JButton Guest(){
		button_guest = new JButton("Guest");
		button_guest.setSize(200, 50);
		button_guest.setLocation(730, 490);
		button_guest.addActionListener(this);
		button_guest.setFocusPainted(false);
		button_guest.setContentAreaFilled(false);
		button_guest.setFont(new Font("Arial", Font.PLAIN, 20));
		button_guest.setForeground(Color.WHITE);
		button_guest.setVisible(false);
		return(button_guest);
	}
	public JTextField Username(){
		textfield_username = new JTextField();
		textfield_username.setOpaque(false); // Make textfield_username transparent
		textfield_username.setHorizontalAlignment(JTextField.CENTER); // Make textfield_username align center
		textfield_username.setFont(new Font("Arial", Font.PLAIN, 20)); // Change font and text size of textfield_username
		textfield_username.setSize(400, 35);
		textfield_username.setLocation(440,325);
		textfield_username.addActionListener(this);
		textfield_username.setVisible(false);
		return(textfield_username);
	}
	public JButton Usernameconfirm(){
		button_usernameconfirm = new JButton("Continue");
		button_usernameconfirm.setSize(200, 50);
		button_usernameconfirm.setLocation(540, 440);
		button_usernameconfirm.addActionListener(this);
		button_usernameconfirm.setFocusPainted(false);
		button_usernameconfirm.setContentAreaFilled(false);
		button_usernameconfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		button_usernameconfirm.setForeground(Color.WHITE);
		button_usernameconfirm.setVisible(false);
		return (button_usernameconfirm);
	}
	public JButton Mousebutton(){
		button_mouse = new JButton("Mouse");
		button_mouse.setSize(200, 50);
		button_mouse.setLocation(360, 450);
		button_mouse.addActionListener(this);
		button_mouse.setFocusPainted(false);
		button_mouse.setContentAreaFilled(false);
		button_mouse.setFont(new Font("Arial", Font.PLAIN, 20));
		button_mouse.setForeground(Color.WHITE);
		button_mouse.setVisible(false); // Hide button_mouse initially
		return(button_mouse);
	}
	public JButton Keyboardbutton(){
		button_keyboard = new JButton("Keyboard");
		button_keyboard.setSize(200, 50);
		button_keyboard.setLocation(721, 450);
		button_keyboard.addActionListener(this);
		button_keyboard.setFocusPainted(false);
		button_keyboard.setContentAreaFilled(false);
		button_keyboard.setFont(new Font("Arial", Font.PLAIN, 20));
		button_keyboard.setForeground(Color.WHITE);
		button_keyboard.setVisible(false); // Hide button_keyboard initially
		return(button_keyboard);
	}
	public JTextField GuestIP(){
		textfield_guestIP = new JTextField();
		textfield_guestIP.setOpaque(false); // Make textfield_username transparent
		textfield_guestIP.setHorizontalAlignment(JTextField.CENTER); // Make textfield_username align center
		textfield_guestIP.setFont(new Font("Arial", Font.PLAIN, 20)); // Change font and text size of textfield_username
		textfield_guestIP.setSize(400, 35);
		textfield_guestIP.setLocation(440,325);
		textfield_guestIP.addActionListener(this);
		textfield_guestIP.setVisible(false);
		return(textfield_guestIP);
	}
	public JButton IPconfirm(){
		button_IPconfirm = new JButton("Continue");
		button_IPconfirm.setSize(200, 50);
		button_IPconfirm.setLocation(540, 440);
		button_IPconfirm.addActionListener(this);
		button_IPconfirm.setFocusPainted(false);
		button_IPconfirm.setContentAreaFilled(false);
		button_IPconfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		button_IPconfirm.setForeground(Color.WHITE);
		button_IPconfirm.setVisible(false);
		return (button_IPconfirm);
	}
	public JButton GoBack(){
		button_goback = new JButton("Back");
		button_goback.setSize(200,50);
		button_goback.setLocation(0,0);
		button_goback.addActionListener(this);
		button_goback.setFocusPainted(false);
		button_goback.setContentAreaFilled(false);
		button_goback.setFont(new Font("Arial", Font.PLAIN, 20));
		button_goback.setForeground(Color.WHITE);
		return(button_goback);
	}
	// Constructors
	public Bomberman(){
		// Create GUI Window
		theframe = new JFrame("Bomberman");
		thepanel = new GamePanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		theframe.setContentPane(thepanel);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);
		thepanel.add(StartGame());
		thepanel.add(HighScores());
		thepanel.add(Help());
		thepanel.add(Quit());
		thepanel.add(Host());
		thepanel.add(Guest());
		thepanel.add(Username());
		thepanel.add(Usernameconfirm());
		thepanel.add(button_mouse);
		thepanel.add(button_keyboard);
		thepanel.add(GuestIP());
		thepanel.add(IPconfirm());

		// Add Timer Object
		thetimer = new Timer(1000/60, this); // Triggering timer object every 1000/60. Basically 60 FPS.
		thetimer.start();
	}
	// Main Method
		public static void main(String[] args){
		new Bomberman();
	}
}
