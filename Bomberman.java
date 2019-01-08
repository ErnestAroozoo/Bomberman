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

public class Bomberman implements ActionListener, KeyListener, MouseMotionListener{
	// Properties
	JFrame theframe;
	BombermanPanel thepanel;
	Timer thetimer;
	JButton button_startgame;
	JButton button_highscores;
	JButton button_help;
	JButton button_quit;

	// Methods
	public void actionPerformed(ActionEvent evt){  // actionPerformed is triggered when JComponents are triggered.
		if(evt.getSource() == thetimer){ // If timer is going off, 60 FPS in this case, panel will repaint itself.
			thepanel.repaint();
		}
		else if(evt.getSource() == button_startgame){ // Start Game Button
			System.out.println("Start Game");
		}
		else if(evt.getSource() == button_highscores){
			System.out.println("Highscores");
		}
		else if(evt.getSource() == button_help){
			System.out.println("Help");
		}
		else if(evt.getSource() == button_quit){
			System.out.println("Quit");
		}
	}

	public void keyReleased(KeyEvent evt){ // keyReleased is triggered when you release the key.
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

	}

	public void mouseMoved(MouseEvent evt){ // mouseMoved is triggered when mouse is moved.

	}
	public void mouseDragged(MouseEvent evt){ // mouseDragged is triggered when mouse is dragged.

	}

	// Constructors
	public Bomberman(){
		// Create GUI Window
		theframe = new JFrame("Bomberman");
		thepanel = new BombermanPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		theframe.setContentPane(thepanel);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);

		// Add MouseMotionListener
		thepanel.addMouseMotionListener(this);

		// Add MouseMotionListener
		theframe.addKeyListener(this);

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
		thepanel.add(button_startgame);
		
		button_highscores = new JButton("Highscores");
		button_highscores.setSize(200, 50);
		button_highscores.setLocation(540, 300);
		button_highscores.addActionListener(this);
		button_highscores.setFocusPainted(false);
		button_highscores.setContentAreaFilled(false);
		button_highscores.setFont(new Font("Arial", Font.PLAIN, 20));
		button_highscores.setForeground(Color.WHITE);
		thepanel.add(button_highscores);
		
		button_help = new JButton("Help");
		button_help.setSize(200, 50);
		button_help.setLocation(540, 370);
		button_help.addActionListener(this);
		button_help.setFocusPainted(false);
		button_help.setContentAreaFilled(false);
		button_help.setFont(new Font("Arial", Font.PLAIN, 20));
		button_help.setForeground(Color.WHITE);
		thepanel.add(button_help);
		
		button_quit = new JButton("Quit");
		button_quit.setSize(200, 50);
		button_quit.setLocation(540, 440);
		button_quit.addActionListener(this);
		button_quit.setFocusPainted(false);
		button_quit.setContentAreaFilled(false);
		button_quit.setFont(new Font("Arial", Font.PLAIN, 20));
		button_quit.setForeground(Color.WHITE);
		thepanel.add(button_quit);
		
		
		
	}

	// Main Methods
	public static void main(String[] args){
		new Bomberman();
	}
}
