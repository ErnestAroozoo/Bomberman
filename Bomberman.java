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
	
	// Methods
	public void actionPerformed(ActionEvent evt){  // actionPerformed is triggered when JComponents are triggered.
		
	}
	
	public void keyReleased(KeyEvent evt){ // keyReleased is triggered when you release the key.
		
	}
	public void keyPressed(KeyEvent evt){ // keyPressed is triggered when you press the key.
		
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
	}
	
	// Main Methods
	public static void main(String[] args){
		new Bomberman();
	}
}

