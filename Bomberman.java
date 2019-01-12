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
	static boolean blnStartGame = false; // blnStartGame = true when we want to switch over to BombermanPanel (actual game)
	static boolean blnUsernameMenu = false;
	static String strUsername;
	

	// Methods
	public void actionPerformed(ActionEvent evt){  
		if(evt.getSource() == thetimer && blnStartGame == true){ // Refresh BombermanPanel (actual game) 60 FPS
			bombermanpanel.repaint();
		}
		
		else if(evt.getSource() == button_startgame){ // Start Game Button
			System.out.println("Start Game");
			button_startgame.setVisible(false);
			button_highscores.setVisible(false);
			button_help.setVisible(false);
			button_quit.setVisible(false);
			mainmenupanel.repaint();
			// Username Menu
			blnUsernameMenu = true; // Change to UsernameMenu image
			textfield_username.setVisible(true); 
			textfield_username.grabFocus(); 
			strUsername = textfield_username.getText(); // Grab username
			System.out.println("Username: " + strUsername);
		}
		
		else if(evt.getSource() == button_highscores){ // Highscores Button
			System.out.println("Highscores");
			// Remove Buttons
			button_startgame.setVisible(false);
			button_highscores.setVisible(false);
			button_help.setVisible(false);
			button_quit.setVisible(false);
		}
		else if(evt.getSource() == button_help){ // Help Button
			System.out.println("Help");
			// Remove Buttons
			button_startgame.setVisible(false);
			button_highscores.setVisible(false);
			button_help.setVisible(false);
			button_quit.setVisible(false);
		}
		else if(evt.getSource() == button_quit){ // Quit Button
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
		mainmenupanel = new MainMenuPanel();
		mainmenupanel.setLayout(null);
		mainmenupanel.setPreferredSize(new Dimension(1280, 720));
		
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
		textfield_username.setSize(400, 35);
		textfield_username.setLocation(440,325);
		textfield_username.addActionListener(this);
		mainmenupanel.add(textfield_username);
		textfield_username.setVisible(false); // Hide textfield_username initially
		
	}

	// Main Methods
	public static void main(String[] args){
		new Bomberman();
	}
}
