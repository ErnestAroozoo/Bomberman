import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.sql.Timestamp;

public class BombermanPanel extends JPanel{
  // Properties
  SuperSocketMaster ssm;               
  static int intX = 60;
  static int intXfuture;
  static int intY = 60;
  static int intYfuture;
  static int intX_red = 780;
  static int intY_red = 60;
  static int intX_yellow = 60;
  static int intY_yellow = 540;
  static int intX_white = 780;
  static int intY_white = 540;
  static int intRow = 0;
  static int intCol = 0;
  String strTime;
  
  static boolean blnUp = false;
  static boolean blnDown = false;
  static boolean blnLeft = false;
  static boolean blnRight = false;
  static boolean blnPlaceBomb = false;
  static boolean blnUp_red = false;
  static boolean blnDown_red = false;
  static boolean blnLeft_red = false;
  static boolean blnRight_red = false;
  static boolean blnPlaceBomb_red = false;
  static boolean blnUp_yellow = false;
  static boolean blnDown_yellow = false;
  static boolean blnLeft_yellow = false;
  static boolean blnRight_yellow = false;
  static boolean blnPlaceBomb_yellow = false;
  static boolean blnUp_white = false;
  static boolean blnDown_white = false;
  static boolean blnLeft_white = false;
  static boolean blnRight_white = false;
  static boolean blnPlaceBomb_white = false;
  
  
  
  static int intbombrange_blue = 0;
  static int intbombcount_blue = 0;
  static boolean blninvicible_blue = false;
  static Timestamp timestamp_blue;
  static long bomb1duration_blue = 0;
  static long bomb2duration_blue = 0;
  static long bomb3duration_blue = 0;
  static long bomb4duration_blue = 0;
  boolean blnbomb1set = false;
  boolean blnbomb2set = false;
  boolean blnbomb3set = false;
  boolean blnbomb4set = false;
  static int intBombX_blue = 0;
  static int intBombY_blue = 0;
  static int intBomb2X_blue = 0;
  static int intBomb2Y_blue = 0;
  static int intBomb3X_blue = 0;
  static int intBomb3Y_blue = 0;
  static int intBomb4X_blue = 0;
  static int intBomb4Y_blue = 0;
  
  static int intbombrange_red = 0;
  static int intbombcount_red = 0;
  static boolean blninvicible_red = false;
  //static Timestamp timestamp_blue;
  
  static int intbombrange_yellow = 0;
  static int intbombcount_yellow = 0;
  static boolean blninvicible_yellow = false;
  //static Timestamp timestamp_blue;
  
  static int intbombrange_white = 0;
  static int intbombcount_white = 0;
  static boolean blninvicible_white = false;
  //static Timestamp timestamp_blue;
  
  
  
  static BufferedImage up1;
  static BufferedImage up2;
  static BufferedImage right1;
  static BufferedImage right2;
  static BufferedImage down1;
  static BufferedImage down2;
  static BufferedImage left1;
  static BufferedImage left2;
  
  static BufferedImage up1_red;
  static BufferedImage up2_red;
  static BufferedImage right1_red;
  static BufferedImage right2_red;
  static BufferedImage down1_red;
  static BufferedImage down2_red;
  static BufferedImage left1_red;
  static BufferedImage left2_red;
  
  static BufferedImage up1_yellow;
  static BufferedImage up2_yellow;
  static BufferedImage right1_yellow;
  static BufferedImage right2_yellow;
  static BufferedImage down1_yellow;
  static BufferedImage down2_yellow;
  static BufferedImage left1_yellow;
  static BufferedImage left2_yellow;
  
  static BufferedImage up1_white;
  static BufferedImage up2_white;
  static BufferedImage right1_white;
  static BufferedImage right2_white;
  static BufferedImage down1_white;
  static BufferedImage down2_white;
  static BufferedImage left1_white;
  static BufferedImage left2_white;
  
  
  static BufferedImage ground_stan;
  static BufferedImage wall_stan;
  static BufferedImage breakwall_stan;
  static BufferedImage ground_win;
  static BufferedImage wall_win;
  static BufferedImage fire_horizontal;
  static BufferedImage fire_downend;
  static BufferedImage fire_leftend;
  static BufferedImage fire_mid;
  static BufferedImage fire_rightend;
  static BufferedImage fire_upend;
  static BufferedImage fire_vertical;
  static BufferedImage bomb_item;
  static BufferedImage bomb_active;
  static BufferedImage multiplebombitem;
  static BufferedImage flameitem;
  static BufferedImage vestitem;
  static BufferedImage mainmenu;
  static BufferedImage guestmenu;
  static BufferedImage hostmenu;
  static BufferedImage multiplayermenu;
  static BufferedImage playstylemenu;
  static BufferedImage usernamemenu;
  static BufferedImage helpmenu;
  static BufferedImage highscoresmenu;
  static BufferedImage characterselectionmenu;
  static BufferedImage gui_keyboard;
	static BufferedImage gui_mouse;
  
  
  ///JButton test;
  ///GamePanel thepanel;
  
  // Methods
  public static void blue_move(int intYfuture,int intXfuture, boolean blnUP,
                               boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT,Graphics g){
    int intposydiv;
    int intposymod;
    int intposxdiv;
    int intposxmod;
    
    
    int intnewtopleftposx;
    int intnewtopleftposy;
    int intnewtoprightposx;
    int intnewtoprightposy;
    int intnewbotleftposx;
    int intnewbotleftposy;
    int intnewbotrightposx;
    int intnewbotrightposy;
    
    
    
    
    
    
    
    boolean blnresult = true;
    System.out.println("Blue MOve strting   " );
    System.out.println("  " );
    System.out.println("future y: " + intYfuture +" future x: " + intXfuture);
    
    if(blnUP == true){
      intYfuture = intYfuture - 5;
    }else if(blnDOWN == true){
      intYfuture = intYfuture + 5;
    }else if(blnRIGHT == true){
      intXfuture = intXfuture + 5;
    }else if(blnLEFT == true){
      intXfuture = intXfuture - 5;
    } 
    intnewtopleftposx = intXfuture;
    intnewtopleftposy = intYfuture;
    intnewbotleftposx = intXfuture;
    intnewbotleftposy = intYfuture + 59;
    
    intnewtoprightposx = intXfuture + 35;
    intnewtoprightposy = intYfuture;
    intnewbotrightposx = intXfuture + 35;
    intnewbotrightposy = intYfuture + 59;
    
    System.out.println("toplefty: "+intnewtopleftposy + "topleftx: " + intnewtopleftposx);
    System.out.println("toprighty: "+intnewtoprightposy + "toprightx: " + intnewtoprightposx);
    System.out.println("botlefty: "+intnewbotleftposy + "botleftx: " +intnewbotleftposx);
    System.out.println("botrighty: "+intnewbotrightposy + "botrightx: " +intnewbotrightposx);
    
    System.out.println("future posy: " + intYfuture +" future posx: " + intXfuture);
    intposydiv = intnewtopleftposy / 60;
    //intposymod = intnewposy % 60;
    intposxdiv = intnewtopleftposx / 60;
    //intposxmod = intnewposx % 60;
    
    /*if(intposymod > 0 && intposydiv > 0){
     intposydiv += 1;
     }
     if(intposxmod > 0 && intposxdiv > 0){
     intposxdiv += 1;
     }*/
    
    System.out.println("position y: " + intposydiv +" position x: " + intposxdiv);
    System.out.println("array: " +Bomberman.strMap[intposydiv][intposxdiv]);
    
    if(Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")){
      blnresult = false;
      System.out.println("equal to ob");
    }
    
    
    if(blnresult){
      System.out.println("  " );
      System.out.println("array for item : " +Bomberman.strMap[intposydiv][intposxdiv]);
      if(Bomberman.strMap[intposydiv][intposxdiv].equals("itm1")){
        Bomberman.strMap[intposydiv][intposxdiv] = "g";
        intbombrange_blue += 1;
      }else if(Bomberman.strMap[intposydiv][intposxdiv].equals("itm2")){
        Bomberman.strMap[intposydiv][intposxdiv] = "g";
        intbombcount_blue += 1;     //bomb
        System.out.println("bombitem count movement: "+intbombcount_blue);
      }else if(Bomberman.strMap[intposydiv][intposxdiv].equals("itm3")){
        Bomberman.strMap[intposydiv][intposxdiv] = "g";
        blninvicible_blue = true;
      }
    }
    
    
    
    if(blnresult){
      
      intposydiv = intnewtoprightposy / 60;
      intposxdiv = intnewtoprightposx / 60;
      System.out.println("topright y: " + intposydiv +" position x: " + intposxdiv);
      System.out.println("array: " +Bomberman.strMap[intposydiv][intposxdiv]);
      if(Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")){
        blnresult = false;
        System.out.println("equal to ob");
      }
    }
    
    
    
    if(blnresult){
      intposydiv = intnewbotrightposy / 60;
      intposxdiv = intnewbotrightposx / 60;
      System.out.println("botright y: " + intposydiv +" position x: " + intposxdiv);
      System.out.println("array: " +Bomberman.strMap[intposydiv][intposxdiv]);
      if(Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")){
        blnresult = false;
        System.out.println("equal to ob");
      }
    }
    
    if(blnresult){
      intposydiv = intnewbotleftposy / 60;
      intposxdiv = intnewbotleftposx / 60;
      System.out.println("botleft y: " + intposydiv +" position x: " + intposxdiv);
      System.out.println("array: " +Bomberman.strMap[intposydiv][intposxdiv]);
      if(Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")){
        blnresult = false;
        System.out.println("equal to ob");
      }
    }
    
    
    if(blnresult){
      if(blnUP == true){
        g.drawImage(up1, intX, intYfuture, null);
        Bombermantools.trysleep();
        System.out.println("went up");
        g.drawImage(up2, intX, intYfuture, null);
        Bombermantools.trysleep();
        
        intY = intYfuture;
      }
      else if(blnRIGHT == true){
        g.drawImage(right1, intXfuture, intY, null); 
        Bombermantools.trysleep();
        g.drawImage(right2, intXfuture, intY, null); 
        Bombermantools.trysleep();
        intX = intXfuture;
      }
      else if(blnDOWN == true){
        g.drawImage(down1, intX, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(down2, intX, intYfuture, null); 
        Bombermantools.trysleep();
        
        intY = intYfuture;
      }
      else if(blnLEFT == true){
        g.drawImage(left1, intXfuture, intY, null); 
        Bombermantools.trysleep();
        g.drawImage(left2, intXfuture, intY, null);
        Bombermantools.trysleep();
        
        intX = intXfuture;
      }
    }
    
    
    
    
    
    
    
  }
  
  
  
  
  
  
  
  public static void red_move(int intYfuture,int intXfuture, boolean blnUP,
                              boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT,Graphics g){
    int intposydiv;
    int intposymod;
    int intposxdiv;
    int intposxmod;
    int intnewposx;
    int intnewposy;
    boolean blnresult = true;
    System.out.println("future y: " + intYfuture +" future x: " + intXfuture);
    intnewposx = intXfuture;
    intnewposy = intYfuture;
    
    if(blnUP == true){
      intYfuture = intYfuture - 5;
      intnewposy = intYfuture;
    }else if(blnDOWN == true){
      intYfuture = intYfuture + 5;
      intnewposy = intYfuture + 60;
    }else if(blnRIGHT == true){
      intXfuture = intXfuture + 5;
      intnewposx = intXfuture + 30;
    }else if(blnLEFT == true){
      intXfuture = intXfuture - 5;
      intnewposy = intYfuture;
    } 
    System.out.println("future posy: " + intnewposy +" future posx: " + intnewposx);
    intposydiv = intnewposy / 60;
    intposymod = intnewposy % 60;
    intposxdiv = intnewposx / 60;
    intposxmod = intnewposx % 60;
    if(intposymod > 0 && intposydiv > 0){
      intposydiv += 1;
    }
    if(intposxmod > 0 && intposxdiv > 0){
      intposxdiv += 1;
    }
    System.out.println("position y: " + intposymod +" position x: " + intposxdiv);
    System.out.println("array: " +Bomberman.strMap[intposydiv][intposxdiv]);
    if(Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")){
      blnresult = false;
    }else{
      if(blnUP == true){
        g.drawImage(up1_red, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        g.drawImage(up2_red, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        intY_red = intYfuture;
        
      }
      else if(blnRIGHT == true){
        g.drawImage(right1_red, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(right2_red, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        intX_red = intXfuture;
      }
      else if(blnDOWN == true){
        g.drawImage(down1_red, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(down2_red, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        intY_red = intYfuture;
      }
      else if(blnLEFT == true){
        g.drawImage(left1_red, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(left2_red, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        intX_red = intXfuture;
      }
    }
    
    
    
    if(blnresult){
      if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm1")){
        intbombrange_red += 1;
      }else if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm2")){
        intbombcount_red += 1;
      }else if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm3")){
        blninvicible_red = true;
        //timestamp_blue = new Timestamp(System.currentTimeMillis());
      }
    }
    
    
  }
  
  
  
  
  
  
  
  
  public static void yellow_move(int intYfuture,int intXfuture, boolean blnUP,
                                 boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT,Graphics g){
    int intposydiv;
    int intposymod;
    int intposxdiv;
    int intposxmod;
    boolean blnresult = true;
    System.out.println("future y: " + intYfuture +" future x: " + intXfuture);
    if(blnUP == true){
      intYfuture = intYfuture - 5;
    }else if(blnDOWN == true){
      intYfuture = intYfuture + 5;
    }else if(blnRIGHT == true){
      intXfuture = intXfuture + 5;
    }else if(blnLEFT == true){
      intXfuture = intXfuture - 5;
    } 
    
    intposydiv = intYfuture / 60;
    intposymod = intYfuture % 60;
    intposxdiv = intXfuture / 60;
    intposxmod = intXfuture % 60;
    if(intposymod > 0 && intposydiv > 0){
      intposydiv += 1;
    }
    if(intposxmod > 0 && intposxdiv > 0){
      intposxdiv += 1;
    }
    System.out.println("position y: " + intposymod +" position x: " + intposxdiv);
    System.out.println("array: " +Bomberman.strMap[intposydiv][intposxdiv]);
    if(Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")){
      blnresult = false;
    }else{
      if(blnUP == true){
        g.drawImage(up1_yellow, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        g.drawImage(up2_yellow, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        intY_yellow = intYfuture;
      }
      else if(blnRIGHT == true){
        g.drawImage(right1_yellow, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(right2_yellow, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        intX_yellow = intXfuture;
      }
      else if(blnDOWN == true){
        g.drawImage(down1_yellow, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(down2_yellow, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        intY_yellow = intYfuture;
      }
      else if(blnLEFT == true){
        g.drawImage(left1_yellow, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(left2_yellow, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        intX_yellow = intXfuture;
      }
    }
    if(blnresult){
      if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm1")){
        intbombrange_yellow += 1;
      }else if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm2")){
        intbombcount_yellow += 1;
      }else if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm3")){
        blninvicible_yellow = true;
        //timestamp_blue = new Timestamp(System.currentTimeMillis());
      }
    }
  }
  
  
  
  
  
  
  
  public static void white_move(int intYfuture,int intXfuture, boolean blnUP,
                                boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT,Graphics g){
    int intposydiv;
    int intposymod;
    int intposxdiv;
    int intposxmod;
    boolean blnresult = true;
    System.out.println("future y: " + intYfuture +" future x: " + intXfuture);
    if(blnUP == true){
      intYfuture = intYfuture - 5;
    }else if(blnDOWN == true){
      intYfuture = intYfuture + 5;
    }else if(blnRIGHT == true){
      intXfuture = intXfuture + 5;
    }else if(blnLEFT == true){
      intXfuture = intXfuture - 5;
    } 
    
    intposydiv = intYfuture / 60;
    intposymod = intYfuture % 60;
    intposxdiv = intXfuture / 60;
    intposxmod = intXfuture % 60;
    if(intposymod > 0 && intposydiv > 0){
      intposydiv += 1;
    }
    if(intposxmod > 0 && intposxdiv > 0){
      intposxdiv += 1;
    }
    System.out.println("position y: " + intposymod +" position x: " + intposxdiv);
    System.out.println("array: " +Bomberman.strMap[intposydiv][intposxdiv]);
    if(Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")){
      blnresult = false;
    }else{
      if(blnUP == true){
        g.drawImage(up1_white, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        g.drawImage(up2_white, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        intY_white = intYfuture;
      }
      else if(blnRIGHT == true){
        g.drawImage(right1_white, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(right2_white, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        intX_white = intXfuture;
      }
      else if(blnDOWN == true){
        g.drawImage(down1_white, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(down2_white, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        intY_white = intYfuture;
      }
      else if(blnLEFT == true){
        g.drawImage(left1_white, intXfuture, intYfuture, null); 
        Bombermantools.trysleep();
        g.drawImage(left2_white, intXfuture, intYfuture, null);
        Bombermantools.trysleep();
        intX_white = intXfuture;
      }
    }
    
    if(blnresult){
      if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm1")){
        intbombrange_white += 1;
      }else if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm2")){
        intbombcount_white += 1;
      }else if(Bomberman.stritem[intposxdiv][intposydiv].equals("itm3")){
        blninvicible_white = true;
      }
    }
    
  }
  
  /* public static void bombposition_original(int intBombX,int intBombY,Graphics g){
   * 
   int intposydiv;
   int intposymod;
   int intposxdiv;
   int intposxmod;
   
   
   
   intposydiv = intBombY / 60;
   intposymod = intBombY % 60;
   intposxdiv = intBombX / 60;
   intposxmod = intBombX % 60;
   if(intposymod > 30 && intposydiv > 0){
   intposydiv += 1;
   }
   if(intposxmod > 30 && intposxdiv > 0){
   intposxdiv += 1;
   }
   
   System.out.println("posx: "+intposxdiv+"posy: "+intposydiv);
   if(intposxdiv == 1 && intposydiv == 9){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
   g.drawImage(fire_upend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
   g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
   }
   }else if(intposxdiv == 13 && intposydiv == 9){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
   g.drawImage(fire_upend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
   g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
   }
   }else if(intposxdiv == 1 && intposydiv == 1){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
   g.drawImage(fire_downend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
   g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
   }
   }else if(intposxdiv == 13 && intposydiv == 1){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
   g.drawImage(fire_downend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
   g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
   }
   }else if(intposxdiv == 1){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
   g.drawImage(fire_upend,intBombX, intBombY - 60,null);
   }
   if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
   g.drawImage(fire_downend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
   g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
   }
   }else if(intposxdiv == 13){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
   g.drawImage(fire_upend,intBombX, intBombY - 60,null);
   }
   if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
   g.drawImage(fire_downend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
   g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
   }
   }else if(intposydiv == 1){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
   g.drawImage(fire_downend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
   g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
   g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
   }
   }else if(intposydiv == 9){
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
   g.drawImage(fire_upend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
   g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
   g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
   }
   }else{
   g.drawImage(fire_mid,intBombX,intBombY,null);
   if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
   g.drawImage(fire_downend,intBombX, intBombY + 60,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
   g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
   }
   if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
   g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
   }
   if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
   g.drawImage(fire_upend,intBombX,intBombY -60,null);
   }
   }
   
   
   }*/
  
  
  
  
  
  
  
  
  public static void bombposition(int intBombX,int intBombY,int intrange,Graphics g){
    
    int intposydiv;
    int intposymod;
    int intposxdiv;
    int intposxmod;
    int intcountrange;
    boolean blnobfound = false;
    
    
    
    intposydiv = intBombY / 60;
    intposymod = intBombY % 60;
    intposxdiv = intBombX / 60;
    intposxmod = intBombX % 60;
    if(intposymod > 30 && intposydiv > 0){
      intposydiv += 1;
    }
    if(intposxmod > 30 && intposxdiv > 0){
      intposxdiv += 1;
    }
    
    System.out.println("posx: "+intposxdiv+"posy: "+intposydiv);
    if(intposxdiv == 1 && intposydiv == 9){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
        g.drawImage(fire_upend,intBombX, intBombY + 60,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
        g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
      }
    }else if(intposxdiv == 13 && intposydiv == 9){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
        g.drawImage(fire_upend,intBombX, intBombY + 60,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
        g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
      }
    }else if(intposxdiv == 1 && intposydiv == 1){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      
      intcountrange = 0;
      blnobfound = false;
      while(intcountrange <= intrange && blnobfound == false){
        intcountrange += 1;
        if(!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")){
          if(intcountrange < intrange){
            g.drawImage(fire_vertical,intBombX, intBombY + (60 * intcountrange),null);
          }else{
            g.drawImage(fire_downend,intBombX, intBombY + (60 * intcountrange),null);
          }
        }else{ 
          blnobfound = true;
        }
      }
      intcountrange = 0;
      blnobfound = false;
      while(intcountrange <= intrange && blnobfound == false){
        intcountrange += 1;
        if(!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")){
          if(intcountrange < intrange){
            g.drawImage(fire_horizontal,intBombX + (60 * intcountrange), intBombY,null);
          }else{
            g.drawImage(fire_rightend,intBombX + (60* intcountrange),intBombY,null);
          }
          
        }else{ 
          blnobfound = true;
        }
      }
    }else if(intposxdiv == 13 && intposydiv == 1){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
        g.drawImage(fire_downend,intBombX, intBombY + 60,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
        g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
      }
    }else if(intposxdiv == 1){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
        g.drawImage(fire_upend,intBombX, intBombY - 60,null);
      }
      if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
        g.drawImage(fire_downend,intBombX, intBombY + 60,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
        g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
      }
    }else if(intposxdiv == 13){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
        g.drawImage(fire_upend,intBombX, intBombY - 60,null);
      }
      if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
        g.drawImage(fire_downend,intBombX, intBombY + 60,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
        g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
      }
    }else if(intposydiv == 1){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      
      intcountrange = 0;
      blnobfound = false;
      while(intcountrange <= intrange && blnobfound == false){
        intcountrange += 1;
        if(!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")){
          if(intcountrange < intrange){
            g.drawImage(fire_vertical,intBombX, intBombY + (60 * intcountrange),null);
          }else{
            g.drawImage(fire_downend,intBombX, intBombY + (60 * intcountrange),null);
          }
        }else{ 
          blnobfound = true;
        }
      }
      intcountrange = 0;
      blnobfound = false;
      while(intcountrange <= intrange && blnobfound == false){
        intcountrange += 1;
        if(!Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")){
          if(intcountrange < intrange){
            g.drawImage(fire_horizontal,intBombX - (60 * intcountrange), intBombY,null);
          }else{
            g.drawImage(fire_leftend,intBombX - (60 * intcountrange),intBombY,null);
          }
          
        }else{ 
          blnobfound = true;
        }
      }
      intcountrange = 0;
      blnobfound = false;
      while(intcountrange <= intrange && blnobfound == false){
        intcountrange += 1;
        if(!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")){
          g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
        }else{ 
          blnobfound = true;
        }
      }
      
    }else if(intposydiv == 9){
      g.drawImage(fire_mid,intBombX,intBombY,null);
      if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
        g.drawImage(fire_upend,intBombX, intBombY + 60,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
        g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
        g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
      }
    }else{
      g.drawImage(fire_mid,intBombX,intBombY,null);
      if(!Bomberman.strMap[intposydiv + 1][intposxdiv].equals("ob")){
        g.drawImage(fire_downend,intBombX, intBombY + 60,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv - 1].equals("ob")){
        g.drawImage(fire_leftend,intBombX - 60,intBombY,null);
      }
      if(!Bomberman.strMap[intposydiv][intposxdiv + 1].equals("ob")){
        g.drawImage(fire_rightend,intBombX + 60,intBombY,null);
      }
      if(!Bomberman.strMap[intposydiv - 1][intposxdiv].equals("ob")){
        g.drawImage(fire_upend,intBombX,intBombY -60,null);
      }
    }
    
    
  }
  
  
  
  
  public static void bombitem(int intBombX,int intBombY,Graphics g){
    int intposydiv;
    int intposymod;
    int intposxdiv;
    int intposxmod;
    
    
    intposydiv = intBombY / 60;
    intposymod = intBombY % 60;
    intposxdiv = intBombX / 60;
    intposxmod = intBombX % 60;
    if(intposymod > 30 && intposydiv > 0){
      intposydiv += 1;
    }
    if(intposxmod > 30 && intposxdiv > 0){
      intposxdiv += 1;
    }
    
    //System.out.println("bom item posx: "+intposxdiv+"Bom item posy: "+intposydiv);
    if(intposxdiv == 1 && intposydiv == 9){
      
      if(Bomberman.strMap[intposydiv - 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv - 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv + 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv + 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }
      }
    }else if(intposxdiv == 13 && intposydiv == 9){
      if(Bomberman.strMap[intposydiv - 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv - 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv - 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv - 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }
      }
    }else if(intposxdiv == 1 && intposydiv == 1){
      if(Bomberman.strMap[intposydiv + 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv + 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv + 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv + 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }
      }
    }else if(intposxdiv == 13 && intposydiv == 1){
      if(Bomberman.strMap[intposydiv + 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv + 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv - 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv - 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }
      }
    }else if(intposxdiv == 1){
      if(Bomberman.strMap[intposydiv - 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv - 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv + 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv + 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv + 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv + 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }
      }
    }else if(intposxdiv == 13){
      if(Bomberman.strMap[intposydiv - 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv - 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv + 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv + 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv - 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv - 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }
      }
    }else if(intposydiv == 1){
      if(Bomberman.strMap[intposydiv + 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv + 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv - 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv - 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv + 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv + 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }
      }
    }else if(intposydiv == 9){
      if(Bomberman.strMap[intposydiv - 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv - 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv - 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv - 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na"; 
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv + 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv + 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }
      }
    }else{
      if(Bomberman.strMap[intposydiv + 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv + 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv + 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv + 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv + 1][intposxdiv] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv - 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv - 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv - 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv - 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv - 1] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv][intposxdiv + 1].equals("r")){
        Bomberman.strMap[intposydiv][intposxdiv + 1] = "g";
        if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm1")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm1";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm2")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm2";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }else if(Bomberman.stritem[intposydiv][intposxdiv + 1].equals("itm3")){
          Bomberman.strMap[intposydiv][intposxdiv + 1] = "itm3";
          Bomberman.stritem[intposydiv][intposxdiv + 1] = "na";
        }
      }
      if(Bomberman.strMap[intposydiv - 1][intposxdiv].equals("r")){
        Bomberman.strMap[intposydiv - 1][intposxdiv] = "g";
        if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm1")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm1";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm2")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm2";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }else if(Bomberman.stritem[intposydiv - 1][intposxdiv].equals("itm3")){
          Bomberman.strMap[intposydiv - 1][intposxdiv] = "itm3";
          Bomberman.stritem[intposydiv - 1][intposxdiv] = "na";
        }
      }
    }
    
    
  }
  
  
  
  
  
  
  
  public void paintComponent(Graphics g){
    // Start Main Menu
    // Main Menu
    if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 1){ 
      g.drawImage(mainmenu, 0, 0, null); 
    }
    // HighscoresMenu 
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 2){ 
      g.drawImage(highscoresmenu, 0, 0, null);
    }
    // HelpMenu
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 3){ 
      g.drawImage(helpmenu, 0, 0, null);
    }
    // UsernameMenu
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 4){
      g.drawImage(usernamemenu, 0, 0, null);
    }
    // PlayStyleMenu
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 5){ 
      g.drawImage(playstylemenu, 0, 0, null);
    }
    // MultiplayerMenu
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 6){ 
      g.drawImage(multiplayermenu, 0, 0, null);
    }
    // HostMenu
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 7){ 
      g.drawImage(hostmenu, 0, 0, null);
      g.setFont(new Font("Arial", Font.PLAIN, 20)); 
      g.drawString(Bomberman.strIP, 580, 480); // Draw IP Adress on screen
      
    }
    // GuestMenu
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 8){ 
      g.drawImage(guestmenu, 0, 0, null);
    }
    // CharacterSelectionMenu
    else if(Bomberman.blnMainMenu == true && Bomberman.intMenu == 9){
      g.drawImage(characterselectionmenu, 0, 0, null);
    }
    
    
    // Start Bomberman Game
    if(Bomberman.blnMainMenu == false){
		int inttime;
      // Draw GUI Background
      if(Bomberman.blnIsKeyboard == true){
		  g.drawImage(gui_keyboard, 0, 0, null);
	  }
	  else if(Bomberman.blnIsMouse == true){
		  g.drawImage(gui_mouse, 0, 0, null);
	  }
	  // Draw Game Round Timer
	  strTime = String.format("%02d:%02d", Bomberman.intMinute, Bomberman.intSecond);
	  g.setColor(Color.WHITE);
	  g.setFont(new Font("Arial", Font.PLAIN, 60)); 
	  g.drawString(strTime, 1010, 130);
	  // Draw Round #
	  g.setColor(Color.WHITE);
	  g.setFont(new Font("Arial", Font.PLAIN, 24)); 
	  g.drawString(""+Bomberman.intRound, 1110, 181);
	  
      // Bomberman Animation
      if(Bomberman.intRand == 1){
        for(intRow = 0; intRow < 11; intRow++){
          for(intCol = 0; intCol < 15; intCol++){
            if(Bomberman.strMap[intRow][intCol].equals("ob")){
              g.drawImage(wall_stan,intCol*60,intRow * 60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("r")){
              g.drawImage(breakwall_stan,intCol*60,intRow*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("g")){
              g.drawImage(ground_stan,intCol*60,intRow*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("c1")){
              g.drawImage(down1,intRow*60,intCol*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("c2")){
              g.drawImage(down1_red,intRow*60,intCol*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("c3")){
              g.drawImage(down1_yellow,intRow*60,intCol*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("c4")){
              g.drawImage(down1_white,intRow*60,intCol*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("itm1")){
              g.drawImage(flameitem,intCol*60,intRow*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("itm2")){
              g.drawImage(multiplebombitem,intCol*60,intRow*60,null);
            }else if(Bomberman.strMap[intRow][intCol].equals("itm3")){
              g.drawImage(vestitem,intCol*60,intRow*60,null);
            }
          }
        }
        
        
        
        
        
        
        
        
        
        /* }else if(Bomberman.intRand == 2){ 
         for(intRow = 0; intRow < 11; intRow++){
         for(intCol = 0; intCol < 15; intCol++){
         if(Bomberman.strMap[intRow][intCol].equals("ob")){
         g.drawImage(wall_win,intCol*60,intRow * 60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("r")){
         g.drawImage(break_win,intCol*60,intRow*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("g")){
         g.drawImage(ground_win,intCol*60,intRow*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c1")){
         g.drawImage(down1,intRow*60,intCol*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c2")){
         g.drawImage(down1_red,intRow*60,intCol*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c3")){
         g.drawImage(down1_yellow,intRow*60,intCol*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c4")){
         g.drawImage(down1_white,intRow*60,intCol*60,null);
         }
         }
         }
         for(intRow = 0; intRow < 11; intRow++){
         for(intCol = 0; intCol < 15; intCol++){
         stritem[intRow][intCol] = "na";
         }
         }
         for(intRow = 0; intRow < 4; intRow++){
         BombermanPanel.generateitem(1);
         }
         for(intRow = 0; intRow < 4; intRow++){
         BombermanPanel.generateitem(2);
         }
         for(intRow = 0; intRow < 3; intRow++){
         BombermanPanel.generateitem(3);
         }
         }else if(Bomberman.intRand == 3){
         for(intRow = 0; intRow < 11; intRow++){
         for(intCol = 0; intCol < 15; intCol++){
         if(Bomberman.strMap[intRow][intCol].equals("ob")){
         g.drawImage(wall_fire,intCol*60,intRow * 60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("r")){
         g.drawImage(break_fire,intCol*60,intRow*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("g")){
         g.drawImage(ground_fire,intCol*60,intRow*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c1")){
         g.drawImage(default_blue,intRow*60,intCol*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c2")){
         g.drawImage(default_red,intRow*60,intCol*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c3")){
         g.drawImage(default_yellow,intRow*60,intCol*60,null);
         }else if(Bomberman.strMap[intRow][intCol].equals("c4")){
         g.drawImage(default_white,intRow*60,intCol*60,null);
         }
         }
         }
         */
      }
      g.drawImage(down1, intX, intY, null);// Default stance
      g.drawImage(down1_red, intX_red, intY_red, null);// Default stance
      g.drawImage(down1_yellow, intX_yellow, intY_yellow, null);// Default stance
      g.drawImage(down1_white, intX_white, intY_white, null);// Default stance
      //blnPlaceBomb = true;
      //System.out.println(blnPlaceBomb);
      
      if(blnPlaceBomb && blnbomb1set == false){
        intBombX_blue = intX;
        intBombY_blue = intY;
        System.out.println("int bom x : "+intBombX_blue + "int bom y: "+ intBombY_blue);
        g.drawImage(bomb_item,intBombX_blue,intBombY_blue,null);
        Bombermantools.trysleep();
        bomb1duration_blue = System.currentTimeMillis()/1000;
        blnbomb1set = true;
      }else if(blnPlaceBomb && blnbomb1set){
        System.out.println("int bom 2x : "+intBombX_blue + "int bom 2y: "+ intBombY_blue);
        g.drawImage(bomb_item,intBombX_blue,intBombY_blue,null);
        Bombermantools.trysleep();
      } 
      
      if(blnPlaceBomb && blnbomb2set == false && intbombcount_blue == 1){
        intBomb2X_blue = intX;
        intBomb2Y_blue = intY;
        System.out.println("int bom count 1x : --------> ");
        System.out.println("int bom count 1x : "+intBomb2X_blue + "int bom y: "+ intBomb2Y_blue);
        g.drawImage(bomb_item,intBomb2X_blue,intBomb2Y_blue,null);
        Bombermantools.trysleep();
        bomb2duration_blue = System.currentTimeMillis()/1000;
        blnbomb2set = true;
      }else if(blnPlaceBomb && blnbomb2set){
        System.out.println("int bom count 1x : "+intBomb2X_blue + "int bom 2y: "+ intBomb2Y_blue);
        g.drawImage(bomb_item,intBomb2X_blue,intBomb2Y_blue,null);
        Bombermantools.trysleep();
      }
      
      
      
      
      if(blnUp || blnDown || blnRight || blnLeft){
        BombermanPanel.blue_move(intY,intX,blnUp,blnDown,blnRight,blnLeft,g);
        System.out.println("block first player");
        System.out.println("firstplayer y: " + intY +" intx: " + intX);
      }
      if(blnUp_red || blnDown_red || blnRight_red || blnLeft_red){
        BombermanPanel.red_move(intY_red,intX_red,blnUp_red,blnDown_red,blnRight_red,blnLeft_red,g);
        System.out.println("block second player");
        System.out.println("inty: " + intY +" intx: " + intX);
      }
      if(blnUp_yellow || blnDown_yellow || blnRight_yellow || blnLeft_yellow){
        BombermanPanel.yellow_move(intY_yellow,intX_yellow,blnUp_yellow,blnDown_yellow,blnRight_yellow,blnLeft_yellow,g);
        System.out.println("block third player");
        System.out.println("inty: " + intY +" intx: " + intX);
      }
      if(blnUp_white || blnDown_white || blnRight_white || blnLeft_white){
        BombermanPanel.white_move(intY_white,intX_white,blnUp_white,blnDown_white,blnRight_white,blnLeft_white,g);
        System.out.println("block fourth player");
        System.out.println("inty: " + intY +" intx: " + intX);
      }
      
      
      
      
      
      
      
      if(blnPlaceBomb && blnbomb1set){
        long duration_blue;
        duration_blue = System.currentTimeMillis()/1000;
        inttime = (int)duration_blue - (int)bomb1duration_blue;
        if(inttime >= 3){
          bombposition(intBombX_blue,intBombY_blue,0,g); // bomb explosion
          
          if(inttime > 6){
            bomb1duration_blue = 0;
            blnbomb1set = false;
            bombitem(intBombX_blue,intBombY_blue,g); // display items
            if(intbombcount_blue < 1){
              blnPlaceBomb = false;
            }
          }
        }
      }
      
      if(blnPlaceBomb && blnbomb2set){
        long duration_blue;
        duration_blue = System.currentTimeMillis()/1000;
        inttime = (int)duration_blue - (int)bomb2duration_blue;
        
        if(inttime >= 3){
          bombposition(intBomb2X_blue,intBomb2Y_blue,0,g); // bomb explosion
          System.out.println("int bom count 1x  explosion : *************** ");
          System.out.println("intBomb2X: "+intBomb2X_blue + "intBomb2Y: "+intBomb2Y_blue);
          if(inttime > 6){
            bomb2duration_blue = 0;
            blnbomb2set = false;
            bombitem(intBomb2X_blue,intBomb2Y_blue,g); // display items
            intbombcount_blue --;
            System.out.println("bombitem count after display item: "+intbombcount_blue);
            if(intbombcount_blue < 1){
              System.out.println("bombitem count: "+intbombcount_blue);
              blnPlaceBomb = false;
              
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
      up1 = ImageIO.read(new File("up1.png")); 
      up2 = ImageIO.read(new File("up2.png")); 
      right1 = ImageIO.read(new File("right1.png")); 
      right2 = ImageIO.read(new File("right2.png")); 
      down1 = ImageIO.read(new File("down1.png")); 
      down2 = ImageIO.read(new File("down2.png")); 
      left1 = ImageIO.read(new File("left1.png")); 
      left2 = ImageIO.read(new File("left2.png"));
      
      up1_red = ImageIO.read(new File("up1_red.png")); 
      up2_red = ImageIO.read(new File("up2_red.png")); 
      right1_red = ImageIO.read(new File("right1_red.png")); 
      right2_red = ImageIO.read(new File("right2_red.png")); 
      down1_red = ImageIO.read(new File("down1_red.png")); 
      down2_red = ImageIO.read(new File("down2_red.png")); 
      left1_red = ImageIO.read(new File("left1_red.png")); 
      left2_red = ImageIO.read(new File("left2_red.png"));
      
      up1_yellow = ImageIO.read(new File("up1_yellow.png")); 
      up2_yellow = ImageIO.read(new File("up2_yellow.png")); 
      right1_yellow = ImageIO.read(new File("right1_yellow.png")); 
      right2_yellow = ImageIO.read(new File("right2_yellow.png")); 
      down1_yellow = ImageIO.read(new File("down1_yellow.png")); 
      down2_yellow = ImageIO.read(new File("down2_yellow.png")); 
      left1_yellow = ImageIO.read(new File("left1_yellow.png")); 
      left2_yellow = ImageIO.read(new File("left2_yellow.png"));
      
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
      vestitem = ImageIO.read(new File("vest.png"));
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
      gui_keyboard = ImageIO.read(new File("gui_keyboard.png"));
      gui_mouse = ImageIO.read(new File("gui_mouse.png"));
      
      
    }
    catch(IOException e){
      System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
    }
  }
}
