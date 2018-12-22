import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class BombermanPanel extends JPanel{
	// Properties

	
	// Methods
	public void paintComponent(Graphics g){
		// Set Background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1280, 720); 
	}
	
	// Constructors
	public BombermanPanel(){
		super();
	}
}

