import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Bombermantools{

	
	public static int validmove(int colfuture, int rowfuture,Graphics g){
		int validFlag = 0;
		
		if((colfuture < 1) || (rowfuture < 0) || (colfuture > 15) || (rowfuture > Bomberman.intLine)){
			validFlag = 1;
			
		}
		return validFlag;
	}
	public static void trysleep(){
		try{
			Thread.sleep(1);
		}catch(InterruptedException e) { 
		}
	}
}

