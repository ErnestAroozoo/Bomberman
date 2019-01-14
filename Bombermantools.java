import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Bombermantools{
	BufferedImage multiplayermenu;
	BufferedImage usernamemenu;
	BufferedImage mainmenu;
	public static void trycatch(){
		try{
			mainmenu = ImageIO.read(new File("mainmenu.png"));
		}catch(IOException e){
			System.out.println("unable to load Image");
		}
	}
	public void mainmenu(Graphics g){
		Bombermantools.trycatch();
		g.drawImage(mainmenu, 0, 0, null);
	}
	public void usernamemenu(Graphics g){
		try{
			usernamemenu = ImageIO.read(new File("usernamemenu.png"));
		}catch(IOException e){
			System.out.println("Unable to load Image");
		}
		g.drawImage(usernamemenu,0,0,null);
	}
	public static void multiplayermenu(Graphics g){
		g.drawImage(multiplayermenu,0,0,null);
	}
	public void Playstyle(Graphics g){
		
	}
}
