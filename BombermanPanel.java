import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.sql.Timestamp;

public class BombermanPanel extends JPanel {
    // Properties       
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
    static boolean blnbomb1set = false;
    static boolean blnbomb2set = false;
    static boolean blnbomb3set = false;
    static boolean blnbomb4set = false;
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
    static long bomb1duration_red = 0;
    static long bomb2duration_red = 0;
    static long bomb3duration_red = 0;
    static long bomb4duration_red = 0;
    static boolean blnbomb1set_red = false;
    static boolean blnbomb2set_red = false;
    static boolean blnbomb3set_red = false;
    static boolean blnbomb4set_red = false;
    static int intBombX_red = 0;
    static int intBombY_red = 0;
    static int intBomb2X_red = 0;
    static int intBomb2Y_red = 0;
    static int intBomb3X_red = 0;
    static int intBomb3Y_red = 0;
    static int intBomb4X_red = 0;
    static int intBomb4Y_red = 0;

    static int intbombrange_yellow = 0;
    static int intbombcount_yellow = 0;
    static boolean blninvicible_yellow = false;
    static long bomb1duration_yellow = 0;
    static long bomb2duration_yellow = 0;
    static long bomb3duration_yellow = 0;
    static long bomb4duration_yellow = 0;
    static boolean blnbomb1set_yellow = false;
    static boolean blnbomb2set_yellow = false;
    static boolean blnbomb3set_yellow = false;
    static boolean blnbomb4set_yellow = false;
    static int intBombX_yellow = 0;
    static int intBombY_yellow = 0;
    static int intBomb2X_yellow = 0;
    static int intBomb2Y_yellow = 0;
    static int intBomb3X_yellow = 0;
    static int intBomb3Y_yellow = 0;
    static int intBomb4X_yellow = 0;
    static int intBomb4Y_yellow = 0;

    static int intbombrange_white = 0;
    static int intbombcount_white = 0;
    static boolean blninvicible_white = false;
    static long bomb1duration_white = 0;
    static long bomb2duration_white = 0;
    static long bomb3duration_white = 0;
    static long bomb4duration_white = 0;
    static boolean blnbomb1set_white = false;
    static boolean blnbomb2set_white = false;
    static boolean blnbomb3set_white = false;
    static boolean blnbomb4set_white = false;
    static int intBombX_white = 0;
    static int intBombY_white = 0;
    static int intBomb2X_white = 0;
    static int intBomb2Y_white = 0;
    static int intBomb3X_white = 0;
    static int intBomb3Y_white = 0;
    static int intBomb4X_white = 0;
    static int intBomb4Y_white = 0;

    static String strTime;



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

	static BufferedImage wall_fire;
	static BufferedImage break_fire;
	static BufferedImage ground_fire;
	
	
	static BufferedImage break_win;
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
    static BufferedImage deathscreen;
    static BufferedImage death;
    static boolean blnDeathBlue = false;
    static boolean blnDeathRed = false;
    static boolean blnDeathYellow = false;
    static boolean blnDeathWhite = false;

    ///JButton test;
    ///GamePanel thepanel;

    // Methods
    //Movements for the blue character
    public static void blue_move(int intYfuture, int intXfuture, boolean blnUP, boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT, Graphics g) {
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
        //if blnresult returns true, check for direction of movement for the blue character
        boolean blnresult = true;

        if (blnUP == true) { //up
            intYfuture = intYfuture - 2;
        } else if (blnDOWN == true) { //down
            intYfuture = intYfuture + 2;
        } else if (blnRIGHT == true) { //right
            intXfuture = intXfuture + 2;
        } else if (blnLEFT == true) { //left
            intXfuture = intXfuture - 2;
        }
        intnewtopleftposx = intXfuture;
        intnewtopleftposy = intYfuture;
        intnewbotleftposx = intXfuture;
        intnewbotleftposy = intYfuture + 50;

        intnewtoprightposx = intXfuture + 35;
        intnewtoprightposy = intYfuture;
        intnewbotrightposx = intXfuture + 35;
        intnewbotrightposy = intYfuture + 50;

        intposydiv = intnewtopleftposy / 60;
        intposxdiv = intnewtopleftposx / 60;


        // checks in the map if it is a random block or an outerblock
        if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
            blnresult = false;
        }

        // whenever the person walks over the item 
        // they get the stats and change the picture to ground
        if (blnresult) {
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm1")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombrange_blue += 1;
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm2")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombcount_blue += 1; //bomb
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm3")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                blninvicible_blue = true;
            }
        }



        if (blnresult) {
            // calculate for top right pixel 
            intposydiv = intnewtoprightposy / 60;
            intposxdiv = intnewtoprightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }



        if (blnresult) {
            // calculate for bottom right pixel
            intposydiv = intnewbotrightposy / 60;
            intposxdiv = intnewbotrightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }

        if (blnresult) {
            // calculate for bottom left pixel
            intposydiv = intnewbotleftposy / 60;
            intposxdiv = intnewbotleftposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }


        if (blnresult) {
            // animation for movement up
            //redraws character at the variable coordinates
            if (blnUP == true && Bomberman.blnDeathBlue == false) {
                g.drawImage(up1, intX, intYfuture, null);
                Bombermantools.trysleep(); //pause
                g.drawImage(up2, intX, intYfuture, null);
                Bombermantools.trysleep(); //pause
                // initializes the future to be the current position
                intY = intYfuture;
            } else if (blnRIGHT == true && Bomberman.blnDeathBlue == false) {
                // animation for movement right 
                g.drawImage(right1, intXfuture, intY, null);
                Bombermantools.trysleep(); //pause
                g.drawImage(right2, intXfuture, intY, null);
                Bombermantools.trysleep(); //pause
                // initializes the future to be the current position
                intX = intXfuture;
            } else if (blnDOWN == true && Bomberman.blnDeathBlue == false) {
                // animation for movement down
                g.drawImage(down1, intX, intYfuture, null);
                Bombermantools.trysleep();
                g.drawImage(down2, intX, intYfuture, null);
                Bombermantools.trysleep();
                // initializes the future to be the current position
                intY = intYfuture;
            } else if (blnLEFT == true && Bomberman.blnDeathBlue == false) {
                // animation for movement left
                g.drawImage(left1, intXfuture, intY, null);
                Bombermantools.trysleep();
                g.drawImage(left2, intXfuture, intY, null);
                Bombermantools.trysleep();
                // initizlies the future to be the current position
                intX = intXfuture;
            }
        }

    }






    //Red will have the same logic as the blue character as will the yellow and the white to ensure equality
    public static void red_move(int intYfuture, int intXfuture, boolean blnUP,
        boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT, Graphics g) {

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

        if (blnUP == true) {
            intYfuture = intYfuture - 5;
        } else if (blnDOWN == true) {
            intYfuture = intYfuture + 5;
        } else if (blnRIGHT == true) {
            intXfuture = intXfuture + 5;
        } else if (blnLEFT == true) {
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

        intposydiv = intnewtopleftposy / 60;

        intposxdiv = intnewtopleftposx / 60;




        if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
            blnresult = false;
        }

        if (blnresult) {
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm1")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombrange_red += 1;
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm2")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombcount_red += 1; //bomb
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm3")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                blninvicible_red = true;
            }
        }



        if (blnresult) {

            intposydiv = intnewtoprightposy / 60;
            intposxdiv = intnewtoprightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }



        if (blnresult) {
            intposydiv = intnewbotrightposy / 60;
            intposxdiv = intnewbotrightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }

        if (blnresult) {
            intposydiv = intnewbotleftposy / 60;
            intposxdiv = intnewbotleftposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }




        if (blnresult) {
            if (blnUP == true && Bomberman.blnDeathRed == false) {
                g.drawImage(up1_red, intX_red, intYfuture, null);
                Bombermantools.trysleep();
                g.drawImage(up2_red, intX_red, intYfuture, null);
                Bombermantools.trysleep();
                intY_red = intYfuture;

            } else if (blnRIGHT == true && Bomberman.blnDeathRed == false) {
                g.drawImage(right1_red, intXfuture, intY_red, null);
                Bombermantools.trysleep();
                g.drawImage(right2_red, intXfuture, intY_red, null);
                Bombermantools.trysleep();
                intX_red = intXfuture;
            } else if (blnDOWN == true && Bomberman.blnDeathRed == false) {
                g.drawImage(down1_red, intX_red, intYfuture, null);
                Bombermantools.trysleep();
                g.drawImage(down2_red, intX_red, intYfuture, null);
                Bombermantools.trysleep();
                intY_red = intYfuture;
            } else if (blnLEFT == true && Bomberman.blnDeathRed == false) {
                g.drawImage(left1_red, intXfuture, intY_red, null);
                Bombermantools.trysleep();
                g.drawImage(left2_red, intXfuture, intY_red, null);
                Bombermantools.trysleep();
                intX_red = intXfuture;
            }
        }
    }


    public static void yellow_move(int intYfuture, int intXfuture, boolean blnUP,
        boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT, Graphics g) {
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

        if (blnUP == true) {
            intYfuture = intYfuture - 5;
        } else if (blnDOWN == true) {
            intYfuture = intYfuture + 5;
        } else if (blnRIGHT == true) {
            intXfuture = intXfuture + 5;
        } else if (blnLEFT == true) {
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

        intposydiv = intnewtopleftposy / 60;
        intposxdiv = intnewtopleftposx / 60;


        if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
            blnresult = false;
        }


        if (blnresult) {
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm1")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombrange_yellow += 1;
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm2")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombcount_yellow += 1; //bomb
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm3")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                blninvicible_yellow = true;
            }
        }



        if (blnresult) {

            intposydiv = intnewtoprightposy / 60;
            intposxdiv = intnewtoprightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }

        if (blnresult) {
            intposydiv = intnewbotrightposy / 60;
            intposxdiv = intnewbotrightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }

        if (blnresult) {
            intposydiv = intnewbotleftposy / 60;
            intposxdiv = intnewbotleftposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }
        if (blnresult) {
            if (blnUP == true && Bomberman.blnDeathYellow == false) {
                g.drawImage(up1_yellow, intX_yellow, intYfuture, null);
                Bombermantools.trysleep();
                g.drawImage(up2_yellow, intX_yellow, intYfuture, null);
                Bombermantools.trysleep();
                intY_yellow = intYfuture;
            } else if (blnRIGHT == true && Bomberman.blnDeathYellow == false) {
                g.drawImage(right1_yellow, intXfuture, intY_yellow, null);
                Bombermantools.trysleep();
                g.drawImage(right2_yellow, intXfuture, intY_yellow, null);
                Bombermantools.trysleep();
                intX_yellow = intXfuture;
            } else if (blnDOWN == true && Bomberman.blnDeathYellow == false) {
                g.drawImage(down1_yellow, intX_yellow, intYfuture, null);
                Bombermantools.trysleep();
                g.drawImage(down2_yellow, intX_yellow, intYfuture, null);
                Bombermantools.trysleep();
                intY_yellow = intYfuture;
            } else if (blnLEFT == true && Bomberman.blnDeathYellow == false) {
                g.drawImage(left1_yellow, intXfuture, intY_yellow, null);
                Bombermantools.trysleep();
                g.drawImage(left2_yellow, intXfuture, intY_yellow, null);
                Bombermantools.trysleep();
                intX_yellow = intXfuture;
            }
        }
    }







    public static void white_move(int intYfuture, int intXfuture, boolean blnUP,
        boolean blnDOWN, boolean blnRIGHT, boolean blnLEFT, Graphics g) {
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

        if (blnUP == true) {
            intYfuture = intYfuture - 5;
        } else if (blnDOWN == true) {
            intYfuture = intYfuture + 5;
        } else if (blnRIGHT == true) {
            intXfuture = intXfuture + 5;
        } else if (blnLEFT == true) {
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

        intposydiv = intnewtopleftposy / 60;
        intposxdiv = intnewtopleftposx / 60;


        if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
            blnresult = false;
        }


        if (blnresult) {
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm1")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombrange_white += 1;
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm2")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                intbombcount_white += 1; //bomb
            } else if (Bomberman.strMap[intposydiv][intposxdiv].equals("itm3")) {
                Bomberman.strMap[intposydiv][intposxdiv] = "g";
                blninvicible_white = true;
            }
        }



        if (blnresult) {

            intposydiv = intnewtoprightposy / 60;
            intposxdiv = intnewtoprightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }

        if (blnresult) {
            intposydiv = intnewbotrightposy / 60;
            intposxdiv = intnewbotrightposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }

        if (blnresult) {
            intposydiv = intnewbotleftposy / 60;
            intposxdiv = intnewbotleftposx / 60;
            if (Bomberman.strMap[intposydiv][intposxdiv].equals("r") || Bomberman.strMap[intposydiv][intposxdiv].equals("ob")) {
                blnresult = false;
            }
        }
        if (blnresult) {
            if (blnUP == true && Bomberman.blnDeathWhite == false) {
                g.drawImage(up1_white, intX_white, intYfuture, null);
                Bombermantools.trysleep();
                g.drawImage(up2_white, intX_white, intYfuture, null);
                Bombermantools.trysleep();
                intY_white = intYfuture;
            } else if (blnRIGHT == true && Bomberman.blnDeathWhite == false) {
                g.drawImage(right1_white, intXfuture, intY_white, null);
                Bombermantools.trysleep();
                g.drawImage(right2_white, intXfuture, intY_white, null);
                Bombermantools.trysleep();
                intX_white = intXfuture;
            } else if (blnDOWN == true && Bomberman.blnDeathWhite == false) {
                g.drawImage(down1_white, intX_white, intYfuture, null);
                Bombermantools.trysleep();
                g.drawImage(down2_white, intX_white, intYfuture, null);
                Bombermantools.trysleep();
                intY_white = intYfuture;
            } else if (blnLEFT == true && Bomberman.blnDeathWhite == false) {
                g.drawImage(left1_white, intXfuture, intY_white, null);
                Bombermantools.trysleep();
                g.drawImage(left2_white, intXfuture, intY_white, null);
                Bombermantools.trysleep();
                intX_white = intXfuture;
            }
        }
    }


    //bomb positioning for each of the characters
    public static void bombposition(int intBombX, int intBombY, int intrange, Graphics g) {
        //variables
        int intposydiv;
        int intposymod;
        int intposxdiv;
        int intposxmod;
        int intcountrange;
        boolean blnobfound = false;


        //calculate the positionings of the bombs
        intposydiv = intBombY / 60;
        intposymod = intBombY % 60;
        intposxdiv = intBombX / 60;
        intposxmod = intBombX % 60;
        if (intposymod > 30 && intposydiv > 0) {
            intposydiv += 1;
        }
        if (intposxmod > 30 && intposxdiv > 0) {
            intposxdiv += 1;
        }

        if (intposxdiv == 1 && intposydiv == 9) {
            g.drawImage(fire_mid, intBombX, intBombY, null);
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY - (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX + (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_rightend, intBombX + (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_rightend, intBombX + (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
        } else if (intposxdiv == 13 && intposydiv == 9) {
            g.drawImage(fire_mid, intBombX, intBombY, null);
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY - (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX - (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_leftend, intBombX - (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_leftend, intBombX - (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
        } else if (intposxdiv == 1 && intposydiv == 1) {
            g.drawImage(fire_mid, intBombX, intBombY, null);

            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY + (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX + (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_rightend, intBombX + (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_rightend, intBombX + (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
        } else if (intposxdiv == 13 && intposydiv == 1) {
            g.drawImage(fire_mid, intBombX, intBombY, null);
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY + (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX - (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_leftend, intBombX - (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_leftend, intBombX - (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
        } else if (intposxdiv == 1) {
            g.drawImage(fire_mid, intBombX, intBombY, null);
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY - (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY + (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX + (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_rightend, intBombX + (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_rightend, intBombX + (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
        } else if (intposxdiv == 13) {
            g.drawImage(fire_mid, intBombX, intBombY, null);
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY - (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY + (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX - (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_leftend, intBombX - (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_leftend, intBombX - (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
        } else if (intposydiv == 1) {
            g.drawImage(fire_mid, intBombX, intBombY, null);

            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY + (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX - (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_leftend, intBombX - (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_leftend, intBombX - (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX + (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_rightend, intBombX + (60 * intcountrange), intBombY, null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_rightend, intBombX + (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }

        } else if (intposydiv == 9) {
            g.drawImage(fire_mid, intBombX, intBombY, null);
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY - (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX - (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_leftend, intBombX - (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_leftend, intBombX - (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX + (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_rightend, intBombX + (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_rightend, intBombX + (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
        } else {
            g.drawImage(fire_mid, intBombX, intBombY, null);
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY + (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_downend, intBombX, intBombY + (60 * (intcountrange - 1)), null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX - (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_leftend, intBombX - (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_leftend, intBombX - (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_horizontal, intBombX + (60 * intcountrange), intBombY, null);
                    } else {
                        g.drawImage(fire_rightend, intBombX + (60 * intcountrange), intBombY, null);
                    }

                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_rightend, intBombX + (60 * (intcountrange - 1)), intBombY, null);
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && blnobfound == false) {
                intcountrange += 1;
                if (!Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    if (intcountrange <= intrange) {
                        g.drawImage(fire_vertical, intBombX, intBombY - (60 * intcountrange), null);
                    } else {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * intcountrange), null);
                    }
                } else {
                    blnobfound = true;
                    if (intcountrange > 1) {
                        g.drawImage(fire_upend, intBombX, intBombY - (60 * (intcountrange - 1)), null);
                    }
                }
            }
        }


    }



    //
    //
    //
    //    Display any items after bombing
    //
    //
    //
    public static void bombitem(int intBombX, int intBombY, int intrange, Graphics g) {
        int intposydiv;
        int intposymod;
        int intposxdiv;
        int intposxmod;
        int intcountrange;
        boolean blnobfound = false;

        //setting the positions of the bomb items
        intposydiv = intBombY / 60;
        intposymod = intBombY % 60;
        intposxdiv = intBombX / 60;
        intposxmod = intBombX % 60;
        if (intposymod > 30 && intposydiv > 0) {
            intposydiv += 1;
        }
        if (intposxmod > 30 && intposxdiv > 0) {
            intposxdiv += 1;
        }

        if (intposxdiv == 1 && intposydiv == 9) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv + intcountrange) < 13) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    }
                }
            }
        } else if (intposxdiv == 13 && intposydiv == 9) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    }
                }
            }
        } else if (intposxdiv == 1 && intposydiv == 1) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv + intcountrange) < 9) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv + intcountrange) < 13) && blnobfound == false) {
                intcountrange += 1;

                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    }
                }
            }
        } else if (intposxdiv == 13 && intposydiv == 1) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv + intcountrange) < 9) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    }
                }
            }
        } else if (intposxdiv == 1) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv + intcountrange) < 9) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv + intcountrange) < 13) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    }
                }
            }
        } else if (intposxdiv == 13) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv + intcountrange) < 9) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    }
                }
            }
        } else if (intposydiv == 1) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv + intcountrange) < 9) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv + intcountrange) < 13) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    }
                }
            }
        } else if (intposydiv == 9) {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv + intcountrange) < 13) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    }
                }
            }
        } else {
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv + intcountrange) < 9) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv + intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv + intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv + intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv + intcountrange][intposxdiv] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv - intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv - intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv - intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv - intcountrange] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposxdiv + intcountrange) < 13) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv][intposxdiv + intcountrange].equals("r")) {
                    Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "g";
                    if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm1")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm1";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm2")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm2";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    } else if (Bomberman.stritem[intposydiv][intposxdiv + intcountrange].equals("itm3")) {
                        Bomberman.strMap[intposydiv][intposxdiv + intcountrange] = "itm3";
                        Bomberman.stritem[intposydiv][intposxdiv + intcountrange] = "na";
                    }
                }
            }
            intcountrange = 0;
            blnobfound = false;
            while (intcountrange <= intrange && ((intposydiv - intcountrange) > 1) && blnobfound == false) {
                intcountrange += 1;
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("ob")) {
                    blnobfound = true;
                }
                if (Bomberman.strMap[intposydiv - intcountrange][intposxdiv].equals("r")) {
                    Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "g";
                    if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm1")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm1";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm2")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm2";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    } else if (Bomberman.stritem[intposydiv - intcountrange][intposxdiv].equals("itm3")) {
                        Bomberman.strMap[intposydiv - intcountrange][intposxdiv] = "itm3";
                        Bomberman.stritem[intposydiv - intcountrange][intposxdiv] = "na";
                    }
                }
            }
        }


    }

    public static void bombdisplay(Graphics g) {
        if (blnPlaceBomb && blnbomb1set == false) {
            intBombX_blue = intX;
            intBombY_blue = intY;
            g.drawImage(bomb_item, intBombX_blue, intBombY_blue, null);
            Bombermantools.trysleep();
            bomb1duration_blue = System.currentTimeMillis() / 1000;
            blnbomb1set = true;
            blnPlaceBomb = false;
        } else if (blnPlaceBomb == false && blnbomb1set) {
            g.drawImage(bomb_item, intBombX_blue, intBombY_blue, null);
            Bombermantools.trysleep();
        }


        if (blnPlaceBomb && blnbomb2set == false && intbombcount_blue == 1) {
            intBomb2X_blue = intX;
            intBomb2Y_blue = intY;
            g.drawImage(bomb_item, intBomb2X_blue, intBomb2Y_blue, null);
            Bombermantools.trysleep();
            bomb2duration_blue = System.currentTimeMillis() / 1000;
            blnbomb2set = true;
            blnPlaceBomb = false;
        } else if (blnPlaceBomb == false && blnbomb2set) {
            g.drawImage(bomb_item, intBomb2X_blue, intBomb2Y_blue, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb && blnbomb3set == false && intbombcount_blue == 2) {
            intBomb3X_blue = intX;
            intBomb3Y_blue = intY;
            g.drawImage(bomb_item, intBomb3X_blue, intBomb3Y_blue, null);
            Bombermantools.trysleep();
            bomb3duration_blue = System.currentTimeMillis() / 1000;
            blnbomb3set = true;
            blnPlaceBomb = false;
        } else if (blnPlaceBomb == false && blnbomb3set) {
            g.drawImage(bomb_item, intBomb3X_blue, intBomb3Y_blue, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb && blnbomb4set == false && intbombcount_blue == 3) {
            intBomb4X_blue = intX;
            intBomb4Y_blue = intY;
            g.drawImage(bomb_item, intBomb4X_blue, intBomb4Y_blue, null);
            Bombermantools.trysleep();
            bomb4duration_blue = System.currentTimeMillis() / 1000;
            blnbomb4set = true;
            blnPlaceBomb = false;
        } else if (blnPlaceBomb == false && blnbomb4set) {
            g.drawImage(bomb_item, intBomb4X_blue, intBomb4Y_blue, null);
            Bombermantools.trysleep();
        }
    }
    public static void bombdisplay_red(Graphics g) {
        if (blnPlaceBomb_red && blnbomb1set_red == false) {
            intBombX_red = intX_red;
            intBombY_red = intY_red;
            g.drawImage(bomb_item, intBombX_red, intBombY_red, null);
            Bombermantools.trysleep();
            bomb1duration_red = System.currentTimeMillis() / 1000;
            blnbomb1set_red = true;
            blnPlaceBomb_red = false;
        } else if (blnPlaceBomb_red == false && blnbomb1set_red) {
            g.drawImage(bomb_item, intBombX_red, intBombY_red, null);
            Bombermantools.trysleep();
        }


        if (blnPlaceBomb_red && blnbomb2set_red == false && intbombcount_red == 1) {
            intBomb2X_red = intX_red;
            intBomb2Y_red = intY_red;
            g.drawImage(bomb_item, intBomb2X_red, intBomb2Y_red, null);
            Bombermantools.trysleep();
            bomb2duration_red = System.currentTimeMillis() / 1000;
            blnbomb2set_red = true;
            blnPlaceBomb_red = false;
        } else if (blnPlaceBomb_red == false && blnbomb2set_red) {
            g.drawImage(bomb_item, intBomb2X_red, intBomb2Y_red, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb_red && blnbomb3set_red == false && intbombcount_red == 2) {
            intBomb3X_red = intX_red;
            intBomb3Y_red = intY_red;
            g.drawImage(bomb_item, intBomb3X_red, intBomb3Y_red, null);
            Bombermantools.trysleep();
            bomb3duration_red = System.currentTimeMillis() / 1000;
            blnbomb3set_red = true;
            blnPlaceBomb_red = false;
        } else if (blnPlaceBomb_red == false && blnbomb3set_red) {
            g.drawImage(bomb_item, intBomb3X_red, intBomb3Y_red, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb_red && blnbomb4set_red == false && intbombcount_red == 3) {
            intBomb4X_red = intX_red;
            intBomb4Y_red = intY_red;
            g.drawImage(bomb_item, intBomb4X_red, intBomb4Y_red, null);
            Bombermantools.trysleep();
            bomb4duration_red = System.currentTimeMillis() / 1000;
            blnbomb4set_red = true;
            blnPlaceBomb_red = false;
        } else if (blnPlaceBomb_red == false && blnbomb4set_red) {
            g.drawImage(bomb_item, intBomb4X_red, intBomb4Y_red, null);
            Bombermantools.trysleep();
        }
    }
    public static void bombdisplay_yellow(Graphics g) {
        if (blnPlaceBomb_yellow && blnbomb1set_yellow == false) {
            intBombX_yellow = intX_yellow;
            intBombY_yellow = intY_yellow;
            g.drawImage(bomb_item, intBombX_yellow, intBombY_yellow, null);
            Bombermantools.trysleep();
            bomb1duration_yellow = System.currentTimeMillis() / 1000;
            blnbomb1set_yellow = true;
            blnPlaceBomb_yellow = false;
        } else if (blnPlaceBomb_yellow == false && blnbomb1set_yellow) {
            g.drawImage(bomb_item, intBombX_yellow, intBombY_yellow, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb_yellow && blnbomb2set_yellow == false && intbombcount_yellow == 1) {
            intBomb2X_yellow = intX_yellow;
            intBomb2Y_yellow = intY_yellow;
            g.drawImage(bomb_item, intBomb2X_yellow, intBomb2Y_yellow, null);
            Bombermantools.trysleep();
            bomb2duration_yellow = System.currentTimeMillis() / 1000;
            blnbomb2set_yellow = true;
            blnPlaceBomb_yellow = false;
        } else if (blnPlaceBomb_yellow == false && blnbomb2set_yellow) {
            g.drawImage(bomb_item, intBomb2X_yellow, intBomb2Y_yellow, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb_yellow && blnbomb3set_yellow == false && intbombcount_yellow == 2) {
            intBomb3X_yellow = intX_yellow;
            intBomb3Y_yellow = intY_yellow;
            g.drawImage(bomb_item, intBomb3X_yellow, intBomb3Y_yellow, null);
            Bombermantools.trysleep();
            bomb3duration_yellow = System.currentTimeMillis() / 1000;
            blnbomb3set_yellow = true;
            blnPlaceBomb_yellow = false;
        } else if (blnPlaceBomb_yellow == false && blnbomb3set_yellow) {
            g.drawImage(bomb_item, intBomb3X_yellow, intBomb3Y_yellow, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb && blnbomb4set_yellow == false && intbombcount_yellow == 3) {
            intBomb4X_yellow = intX_yellow;
            intBomb4Y_yellow = intY_yellow;
            g.drawImage(bomb_item, intBomb4X_yellow, intBomb4Y_yellow, null);
            Bombermantools.trysleep();
            bomb4duration_yellow = System.currentTimeMillis() / 1000;
            blnbomb4set_yellow = true;
            blnPlaceBomb_yellow = false;
        } else if (blnPlaceBomb_yellow == false && blnbomb4set_yellow) {
            g.drawImage(bomb_item, intBomb4X_yellow, intBomb4Y_yellow, null);
            Bombermantools.trysleep();
        }
    }

    //
    //
    //
    //
    // White Bomberman bomb display
    //
    //
    //
    public static void bombdisplay_white(Graphics g) {
        if (blnPlaceBomb_white && blnbomb1set_white == false) {
            intBombX_white = intX_white;
            intBombY_white = intY_white;
            g.drawImage(bomb_item, intBombX_white, intBombY_white, null);
            Bombermantools.trysleep();
            bomb1duration_white = System.currentTimeMillis() / 1000;
            blnbomb1set_white = true;
            blnPlaceBomb_white = false;
        } else if (blnPlaceBomb_white == false && blnbomb1set_white) {
            g.drawImage(bomb_item, intBombX_white, intBombY_white, null);
            Bombermantools.trysleep();
        }


        if (blnPlaceBomb_white && blnbomb2set_white == false && intbombcount_white == 1) {
            intBomb2X_white = intX_white;
            intBomb2Y_white = intY_white;
            g.drawImage(bomb_item, intBomb2X_white, intBomb2Y_white, null);
            Bombermantools.trysleep();
            bomb2duration_white = System.currentTimeMillis() / 1000;
            blnbomb2set_white = true;
            blnPlaceBomb_white = false;
        } else if (blnPlaceBomb_white == false && blnbomb2set_white) {
            g.drawImage(bomb_item, intBomb2X_white, intBomb2Y_white, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb_white && blnbomb3set_white == false && intbombcount_white == 2) {
            intBomb3X_white = intX_white;
            intBomb3Y_white = intY_white;
            g.drawImage(bomb_item, intBomb3X_white, intBomb3Y_white, null);
            Bombermantools.trysleep();
            bomb3duration_white = System.currentTimeMillis() / 1000;
            blnbomb3set_white = true;
            blnPlaceBomb_white = false;
        } else if (blnPlaceBomb_white == false && blnbomb3set_white) {
            g.drawImage(bomb_item, intBomb3X_white, intBomb3Y_white, null);
            Bombermantools.trysleep();
        }
        if (blnPlaceBomb_white && blnbomb4set_white == false && intbombcount_white == 3) {
            intBomb4X_white = intX_white;
            intBomb4Y_white = intY_white;
            g.drawImage(bomb_item, intBomb4X_white, intBomb4Y_white, null);
            Bombermantools.trysleep();
            bomb4duration_white = System.currentTimeMillis() / 1000;
            blnbomb4set_white = true;
            blnPlaceBomb_white = false;
        } else if (blnPlaceBomb_white == false && blnbomb4set_white) {
            g.drawImage(bomb_item, intBomb4X_white, intBomb4Y_white, null);
            Bombermantools.trysleep();
        }
    }
    public static void bombexplosion(Graphics g) {
        int inttime;
        if (blnbomb1set) {
            long duration_blue;
            duration_blue = System.currentTimeMillis() / 1000;
            inttime = (int) duration_blue - (int) bomb1duration_blue;
            if (inttime >= 4) {
                bombposition(intBombX_blue, intBombY_blue, intbombrange_blue, g); // bomb explosion
                if (intX >= intBombX_blue - (120 * intbombrange_blue) && intX <= (intBombX_blue + 120 * intbombrange_blue) && intY >= intBombY_blue - (120 * intbombrange_blue) && intY <= (intBombY_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBombX_blue - (120 * intbombrange_blue) && intX_yellow <= (intBombX_blue + 120 * intbombrange_blue) && intY_yellow >= intBombY_blue - (120 * intbombrange_blue) && intY_yellow <= (intBombY_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBombX_blue - (120 * intbombrange_blue) && intX_red <= (intBombX_blue + 120 * intbombrange_blue) && intY_red >= intBombY_blue - (120 * intbombrange_blue) && intY_red <= (intBombY_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBombX_blue - (120 * intbombrange_blue) && intX_white <= (intBombX_blue + 120 * intbombrange_blue) && intY_white >= intBombY_blue - (120 * intbombrange_blue) && intY_white <= (intBombY_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb1duration_blue = 0;
                    blnbomb1set = false;
                    bombitem(intBombX_blue, intBombY_blue, intbombrange_blue, g); // display items
                }
            }
        }

        if (blnbomb2set) {
            long duration_blue;
            duration_blue = System.currentTimeMillis() / 1000;
            inttime = (int) duration_blue - (int) bomb2duration_blue;

            if (inttime >= 4) {
                bombposition(intBomb2X_blue, intBomb2Y_blue, intbombrange_blue, g); // bomb explosion
                if (intX >= intBomb2X_blue - (120 * intbombrange_blue) && intX <= (intBomb2X_blue + 120 * intbombrange_blue) && intY >= intBomb2Y_blue - (120 * intbombrange_blue) && intY <= (intBomb2Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb2X_blue - (120 * intbombrange_blue) && intX_yellow <= (intBomb2X_blue + 120 * intbombrange_blue) && intY_yellow >= intBomb2Y_blue - (120 * intbombrange_blue) && intY_yellow <= (intBomb2Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb2X_blue - (120 * intbombrange_blue) && intX_red <= (intBomb2X_blue + 120 * intbombrange_blue) && intY_red >= intBomb2Y_blue - (120 * intbombrange_blue) && intY_red <= (intBomb2Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb2X_blue - (120 * intbombrange_blue) && intX_white <= (intBomb2X_blue + 120 * intbombrange_blue) && intY_white >= intBomb2Y_blue - (120 * intbombrange_blue) && intY_white <= (intBomb2Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb2duration_blue = 0;
                    blnbomb2set = false;
                    bombitem(intBomb2X_blue, intBomb2Y_blue, intbombrange_blue, g); // display items
                }
            }
        }
        if (blnbomb3set) {
            long duration_blue;
            duration_blue = System.currentTimeMillis() / 1000;
            inttime = (int) duration_blue - (int) bomb3duration_blue;
            if (inttime >= 4) {
                bombposition(intBomb3X_blue, intBomb3Y_blue, intbombrange_blue, g); // bomb explosion
                if (intX >= intBomb3X_blue - (120 * intbombrange_blue) && intX <= (intBomb3X_blue + 120 * intbombrange_blue) && intY >= intBomb3Y_blue - (120 * intbombrange_blue) && intY <= (intBomb3Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb3X_blue - (120 * intbombrange_blue) && intX_yellow <= (intBomb3X_blue + 120 * intbombrange_blue) && intY_yellow >= intBomb3Y_blue - (120 * intbombrange_blue) && intY_yellow <= (intBomb3Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb3X_blue - (120 * intbombrange_blue) && intX_red <= (intBomb3X_blue + 120 * intbombrange_blue) && intY_red >= intBomb3Y_blue - (120 * intbombrange_blue) && intY_red <= (intBomb3Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb3X_blue - (120 * intbombrange_blue) && intX_white <= (intBomb3X_blue + 120 * intbombrange_blue) && intY_white >= intBomb3Y_blue - (120 * intbombrange_blue) && intY_white <= (intBomb3Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb3duration_blue = 0;
                    blnbomb3set = false;
                    bombitem(intBomb3X_blue, intBomb3Y_blue, intbombrange_blue, g); // display items
                }
            }
        }

        if (blnbomb4set) {
            long duration_blue;
            duration_blue = System.currentTimeMillis() / 1000;
            inttime = (int) duration_blue - (int) bomb4duration_blue;
            if (inttime >= 4) {
                bombposition(intBomb4X_blue, intBomb4Y_blue, intbombrange_blue, g); // bomb explosion
                if (intX >= intBomb4X_blue - (120 * intbombrange_blue) && intX <= (intBomb4X_blue + 120 * intbombrange_blue) && intY >= intBomb4Y_blue - (120 * intbombrange_blue) && intY <= (intBomb4Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb4X_blue - (120 * intbombrange_blue) && intX_yellow <= (intBomb4X_blue + 120 * intbombrange_blue) && intY_yellow >= intBomb4Y_blue - (120 * intbombrange_blue) && intY_yellow <= (intBomb4Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb4X_blue - (120 * intbombrange_blue) && intX_red <= (intBomb4X_blue + 120 * intbombrange_blue) && intY_red >= intBomb4Y_blue - (120 * intbombrange_blue) && intY_red <= (intBomb4Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb4X_blue - (120 * intbombrange_blue) && intX_white <= (intBomb4X_blue + 120 * intbombrange_blue) && intY_white >= intBomb4Y_blue - (120 * intbombrange_blue) && intY_white <= (intBomb4Y_blue + 120 * intbombrange_blue)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb4duration_blue = 0;
                    blnbomb4set = false;
                    bombitem(intBomb4X_blue, intBomb4Y_blue, intbombrange_blue, g); // display items
                }
            }
        }
    }
    public static void bombexplosion_red(Graphics g) {
        int inttime;
        if (blnbomb1set_red) {
            long duration_red;
            duration_red = System.currentTimeMillis() / 1000;
            inttime = (int) duration_red - (int) bomb1duration_red;
            if (inttime >= 4) {
                bombposition(intBombX_red, intBombY_red, intbombrange_red, g); // bomb explosion
                if (intX >= intBombX_red - (120 * intbombrange_red) && intX <= (intBombX_red + 120 * intbombrange_red) && intY >= intBombY_red - (120 * intbombrange_red) && intY <= (intBombY_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBombX_red - (120 * intbombrange_red) && intX_yellow <= (intBombX_red + 120 * intbombrange_red) && intY_yellow >= intBombY_red - (120 * intbombrange_red) && intY_yellow <= (intBombY_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBombX_red - (120 * intbombrange_red) && intX_red <= (intBombX_red + 120 * intbombrange_red) && intY_red >= intBombY_red - (120 * intbombrange_red) && intY_red <= (intBombY_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBombX_red - (120 * intbombrange_red) && intX_white <= (intBombX_red + 120 * intbombrange_red) && intY_white >= intBombY_red - (120 * intbombrange_red) && intY_white <= (intBombY_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb1duration_red = 0;
                    blnbomb1set_red = false;
                    bombitem(intBombX_red, intBombY_red, intbombrange_red, g); // display items
                }
            }
        }

        if (blnbomb2set_red) {
            long duration_red;
            duration_red = System.currentTimeMillis() / 1000;
            inttime = (int) duration_red - (int) bomb2duration_red;

            if (inttime >= 4) {
                bombposition(intBomb2X_red, intBomb2Y_red, intbombrange_red, g); // bomb explosion
                if (intX >= intBomb2X_red - (120 * intbombrange_red) && intX <= (intBomb2X_red + 120 * intbombrange_red) && intY >= intBomb2Y_red - (120 * intbombrange_red) && intY <= (intBomb2Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb2X_red - (120 * intbombrange_red) && intX_yellow <= (intBomb2X_red + 120 * intbombrange_red) && intY_yellow >= intBomb2Y_red - (120 * intbombrange_red) && intY_yellow <= (intBomb2Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb2X_red - (120 * intbombrange_red) && intX_red <= (intBomb2X_red + 120 * intbombrange_red) && intY_red >= intBomb2Y_red - (120 * intbombrange_red) && intY_red <= (intBomb2Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb2X_red - (120 * intbombrange_red) && intX_white <= (intBomb2X_red + 120 * intbombrange_red) && intY_white >= intBomb2Y_red - (120 * intbombrange_red) && intY_white <= (intBomb2Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb2duration_red = 0;
                    blnbomb2set_red = false;
                    bombitem(intBomb2X_red, intBomb2Y_red, intbombrange_red, g); // display items
                }
            }
        }
        if (blnbomb3set_red) {
            long duration_red;
            duration_red = System.currentTimeMillis() / 1000;
            inttime = (int) duration_red - (int) bomb3duration_red;
            if (inttime >= 4) {
                bombposition(intBomb3X_red, intBomb3Y_red, intbombrange_red, g); // bomb explosion
                if (intX >= intBomb3X_red - (120 * intbombrange_red) && intX <= (intBomb3X_red + 120 * intbombrange_red) && intY >= intBomb3Y_red - (120 * intbombrange_red) && intY <= (intBomb3Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb3X_red - (120 * intbombrange_red) && intX_yellow <= (intBomb3X_red + 120 * intbombrange_red) && intY_yellow >= intBomb3Y_red - (120 * intbombrange_red) && intY_yellow <= (intBomb3Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb3X_red - (120 * intbombrange_red) && intX_red <= (intBomb3X_red + 120 * intbombrange_red) && intY_red >= intBomb3Y_red - (120 * intbombrange_red) && intY_red <= (intBomb3Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb3X_red - (120 * intbombrange_red) && intX_white <= (intBomb3X_red + 120 * intbombrange_red) && intY_white >= intBomb3Y_red - (120 * intbombrange_red) && intY_white <= (intBomb3Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb3duration_red = 0;
                    blnbomb3set_red = false;
                    bombitem(intBomb3X_red, intBomb3Y_red, intbombrange_red, g); // display items
                }
            }
        }

        if (blnbomb4set_red) {
            long duration_red;
            duration_red = System.currentTimeMillis() / 1000;
            inttime = (int) duration_red - (int) bomb4duration_red;
            if (inttime >= 4) {
                bombposition(intBomb4X_red, intBomb4Y_red, intbombrange_red, g); // bomb explosion
                if (intX >= intBomb4X_red - (120 * intbombrange_red) && intX <= (intBomb4X_red + 120 * intbombrange_red) && intY >= intBomb4Y_red - (120 * intbombrange_red) && intY <= (intBomb4Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb4X_red - (120 * intbombrange_red) && intX_yellow <= (intBomb4X_red + 120 * intbombrange_red) && intY_yellow >= intBomb4Y_red - (120 * intbombrange_red) && intY_yellow <= (intBomb4Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb4X_red - (120 * intbombrange_red) && intX_red <= (intBomb4X_red + 120 * intbombrange_red) && intY_red >= intBomb4Y_red - (120 * intbombrange_red) && intY_red <= (intBomb4Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb4X_red - (120 * intbombrange_red) && intX_white <= (intBomb4X_red + 120 * intbombrange_red) && intY_white >= intBomb4Y_red - (120 * intbombrange_red) && intY_white <= (intBomb4Y_red + 120 * intbombrange_red)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb4duration_red = 0;
                    blnbomb4set_red = false;
                    bombitem(intBomb4X_red, intBomb4Y_red, intbombrange_red, g); // display items
                }
            }
        }
    }
    public static void bombexplosion_yellow(Graphics g) {
        int inttime;
        if (blnbomb1set_yellow) {
            long duration_yellow;
            duration_yellow = System.currentTimeMillis() / 1000;
            inttime = (int) duration_yellow - (int) bomb1duration_yellow;
            if (inttime >= 4) {
                bombposition(intBombX_yellow, intBombY_yellow, intbombrange_yellow, g); // bomb explosion
                if (intX >= intBombX_yellow - (120 * intbombrange_yellow) && intX <= (intBombX_yellow + 120 * intbombrange_yellow) && intY >= intBombY_yellow - (120 * intbombrange_yellow) && intY <= (intBombY_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBombX_yellow - (120 * intbombrange_yellow) && intX_yellow <= (intBombX_yellow + 120 * intbombrange_yellow) && intY_yellow >= intBombY_yellow - (120 * intbombrange_yellow) && intY_yellow <= (intBombY_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBombX_yellow - (120 * intbombrange_yellow) && intX_red <= (intBombX_yellow + 120 * intbombrange_yellow) && intY_red >= intBombY_yellow - (120 * intbombrange_yellow) && intY_red <= (intBombY_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBombX_yellow - (120 * intbombrange_yellow) && intX_white <= (intBombX_yellow + 120 * intbombrange_yellow) && intY_white >= intBombY_yellow - (120 * intbombrange_yellow) && intY_white <= (intBombY_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb1duration_yellow = 0;
                    blnbomb1set_yellow = false;
                    bombitem(intBombX_yellow, intBombY_yellow, intbombrange_yellow, g); // display items
                }
            }
        }

        if (blnbomb2set_yellow) {
            long duration_yellow;
            duration_yellow = System.currentTimeMillis() / 1000;
            inttime = (int) duration_yellow - (int) bomb2duration_yellow;
            if (inttime >= 4) {
                bombposition(intBomb2X_yellow, intBomb2Y_yellow, intbombrange_yellow, g); // bomb explosion
                if (intX >= intBomb2X_yellow - (120 * intbombrange_yellow) && intX <= (intBomb2X_yellow + 120 * intbombrange_yellow) && intY >= intBomb2Y_yellow - (120 * intbombrange_yellow) && intY <= (intBomb2Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb2X_yellow - (120 * intbombrange_yellow) && intX_yellow <= (intBomb2X_yellow + 120 * intbombrange_yellow) && intY_yellow >= intBomb2Y_yellow - (120 * intbombrange_yellow) && intY_yellow <= (intBomb2Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb2X_yellow - (120 * intbombrange_yellow) && intX_red <= (intBomb2X_yellow + 120 * intbombrange_yellow) && intY_red >= intBomb2Y_yellow - (120 * intbombrange_yellow) && intY_red <= (intBomb2Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb2X_yellow - (120 * intbombrange_yellow) && intX_white <= (intBomb2X_yellow + 120 * intbombrange_yellow) && intY_white >= intBomb2Y_yellow - (120 * intbombrange_yellow) && intY_white <= (intBomb2Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb2duration_yellow = 0;
                    blnbomb2set_yellow = false;
                    bombitem(intBomb2X_yellow, intBomb2Y_yellow, intbombrange_yellow, g); // display items
                }
            }
        }
        if (blnbomb3set_yellow) {
            long duration_yellow;
            duration_yellow = System.currentTimeMillis() / 1000;
            inttime = (int) duration_yellow - (int) bomb3duration_yellow;
            if (inttime >= 4) {
                bombposition(intBomb3X_yellow, intBomb3Y_yellow, intbombrange_yellow, g); // bomb explosion
                if (intX >= intBomb3X_yellow - (120 * intbombrange_yellow) && intX <= (intBomb3X_yellow + 120 * intbombrange_yellow) && intY >= intBomb3Y_yellow - (120 * intbombrange_yellow) && intY <= (intBomb3Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb3X_yellow - (120 * intbombrange_yellow) && intX_yellow <= (intBomb3X_yellow + 120 * intbombrange_yellow) && intY_yellow >= intBomb3Y_yellow - (120 * intbombrange_yellow) && intY_yellow <= (intBomb3Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb3X_yellow - (120 * intbombrange_yellow) && intX_red <= (intBomb3X_yellow + 120 * intbombrange_yellow) && intY_red >= intBomb3Y_yellow - (120 * intbombrange_yellow) && intY_red <= (intBomb3Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb3X_yellow - (120 * intbombrange_yellow) && intX_white <= (intBomb3X_yellow + 120 * intbombrange_yellow) && intY_white >= intBomb3Y_yellow - (120 * intbombrange_yellow) && intY_white <= (intBomb3Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb3duration_yellow = 0;
                    blnbomb3set_yellow = false;
                    bombitem(intBomb3X_yellow, intBomb3Y_yellow, intbombrange_yellow, g); // display items
                }
            }
        }

        if (blnbomb4set_yellow) {
            long duration_yellow;
            duration_yellow = System.currentTimeMillis() / 1000;
            inttime = (int) duration_yellow - (int) bomb4duration_yellow;
            if (inttime >= 4) {
                bombposition(intBomb4X_yellow, intBomb4Y_yellow, intbombrange_yellow, g); // bomb explosion
                if (intX >= intBomb4X_yellow - (120 * intbombrange_yellow) && intX <= (intBomb4X_yellow + 120 * intbombrange_yellow) && intY >= intBomb4Y_yellow - (120 * intbombrange_yellow) && intY <= (intBomb4Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb4X_yellow - (120 * intbombrange_yellow) && intX_yellow <= (intBomb4X_yellow + 120 * intbombrange_yellow) && intY_yellow >= intBomb4Y_yellow - (120 * intbombrange_yellow) && intY_yellow <= (intBomb4Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb4X_yellow - (120 * intbombrange_yellow) && intX_red <= (intBomb4X_yellow + 120 * intbombrange_yellow) && intY_red >= intBomb4Y_yellow - (120 * intbombrange_yellow) && intY_red <= (intBomb4Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb4X_yellow - (120 * intbombrange_yellow) && intX_white <= (intBomb4X_yellow + 120 * intbombrange_yellow) && intY_white >= intBomb4Y_yellow - (120 * intbombrange_yellow) && intY_white <= (intBomb4Y_yellow + 120 * intbombrange_yellow)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb4duration_yellow = 0;
                    blnbomb4set_yellow = false;
                    bombitem(intBomb4X_yellow, intBomb4Y_yellow, intbombrange_yellow, g); // display items
                }
            }
        }
    }
    public static void bombexplosion_white(Graphics g) {
        int inttime;
        if (blnbomb1set_white) {
            long duration_white;
            duration_white = System.currentTimeMillis() / 1000;
            inttime = (int) duration_white - (int) bomb1duration_white;
            if (inttime >= 4) {
                bombposition(intBombX_white, intBombY_white, intbombrange_white, g); // bomb explosion
                if (intX >= intBombX_white - (120 * intbombrange_white) && intX <= (intBombX_white + 120 * intbombrange_white) && intY >= intBombY_white - (120 * intbombrange_white) && intY <= (intBombY_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBombX_white - (120 * intbombrange_white) && intX_yellow <= (intBombX_white + 120 * intbombrange_white) && intY_yellow >= intBombY_white - (120 * intbombrange_white) && intY_yellow <= (intBombY_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBombX_white - (120 * intbombrange_white) && intX_red <= (intBombX_white + 120 * intbombrange_white) && intY_red >= intBombY_white - (120 * intbombrange_white) && intY_red <= (intBombY_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBombX_white - (120 * intbombrange_white) && intX_white <= (intBombX_white + 120 * intbombrange_white) && intY_white >= intBombY_white - (120 * intbombrange_white) && intY_white <= (intBombY_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb1duration_white = 0;
                    blnbomb1set_white = false;
                    bombitem(intBombX_white, intBombY_white, intbombrange_white, g); // display items
                }
            }
        }

        if (blnbomb2set_white) {
            long duration_white;
            duration_white = System.currentTimeMillis() / 1000;
            inttime = (int) duration_white - (int) bomb2duration_white;

            if (inttime >= 4) {
                bombposition(intBomb2X_white, intBomb2Y_white, intbombrange_white, g); // bomb explosion
                if (intX >= intBomb2X_white - (120 * intbombrange_white) && intX <= (intBomb2X_white + 120 * intbombrange_white) && intY >= intBomb2Y_white - (120 * intbombrange_white) && intY <= (intBomb2Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb2X_white - (120 * intbombrange_white) && intX_yellow <= (intBomb2X_white + 120 * intbombrange_white) && intY_yellow >= intBomb2Y_white - (120 * intbombrange_white) && intY_yellow <= (intBomb2Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb2X_white - (120 * intbombrange_white) && intX_red <= (intBomb2X_white + 120 * intbombrange_white) && intY_red >= intBomb2Y_white - (120 * intbombrange_white) && intY_red <= (intBomb2Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb2X_white - (120 * intbombrange_white) && intX_white <= (intBomb2X_white + 120 * intbombrange_white) && intY_white >= intBomb2Y_white - (120 * intbombrange_white) && intY_white <= (intBomb2Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb2duration_white = 0;
                    blnbomb2set_white = false;
                    bombitem(intBomb2X_white, intBomb2Y_white, intbombrange_white, g); // display items
                }
            }
        }
        if (blnbomb3set_white) {
            long duration_white;
            duration_white = System.currentTimeMillis() / 1000;
            inttime = (int) duration_white - (int) bomb3duration_white;
            if (inttime >= 4) {
                bombposition(intBomb3X_white, intBomb3Y_white, intbombrange_white, g); // bomb explosion
                if (intX >= intBomb3X_white - (120 * intbombrange_white) && intX <= (intBomb3X_white + 120 * intbombrange_white) && intY >= intBomb3Y_white - (120 * intbombrange_white) && intY <= (intBomb3Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb3X_white - (120 * intbombrange_white) && intX_yellow <= (intBomb3X_white + 120 * intbombrange_white) && intY_yellow >= intBomb3Y_white - (120 * intbombrange_white) && intY_yellow <= (intBomb3Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb3X_white - (120 * intbombrange_white) && intX_red <= (intBomb3X_white + 120 * intbombrange_white) && intY_red >= intBomb3Y_white - (120 * intbombrange_white) && intY_red <= (intBomb3Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb3X_white - (120 * intbombrange_white) && intX_white <= (intBomb3X_white + 120 * intbombrange_white) && intY_white >= intBomb3Y_white - (120 * intbombrange_white) && intY_white <= (intBomb3Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb3duration_white = 0;
                    blnbomb3set_white = false;
                    bombitem(intBomb3X_white, intBomb3Y_white, intbombrange_white, g); // display items
                }
            }
        }

        if (blnbomb4set_white) {
            long duration_white;
            duration_white = System.currentTimeMillis() / 1000;
            inttime = (int) duration_white - (int) bomb4duration_white;

            if (inttime >= 4) {
                bombposition(intBomb4X_white, intBomb4Y_white, intbombrange_white, g); // bomb explosion
                if (intX >= intBomb4X_white - (120 * intbombrange_white) && intX <= (intBomb4X_white + 120 * intbombrange_white) && intY >= intBomb4Y_white - (120 * intbombrange_white) && intY <= (intBomb4Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathBlue = true;
                }
                if (intX_yellow >= intBomb4X_white - (120 * intbombrange_white) && intX_yellow <= (intBomb4X_white + 120 * intbombrange_white) && intY_yellow >= intBomb4Y_white - (120 * intbombrange_white) && intY_yellow <= (intBomb4Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathYellow = true;
                }
                if (intX_red >= intBomb4X_white - (120 * intbombrange_white) && intX_red <= (intBomb4X_white + 120 * intbombrange_white) && intY_red >= intBomb4Y_white - (120 * intbombrange_white) && intY_red <= (intBomb4Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathRed = true;
                }
                if (intX_white >= intBomb4X_white - (120 * intbombrange_white) && intX_white <= (intBomb4X_white + 120 * intbombrange_white) && intY_white >= intBomb4Y_white - (120 * intbombrange_white) && intY_white <= (intBomb4Y_white + 120 * intbombrange_white)) {
                    Bomberman.blnDeathWhite = true;
                }
                if (inttime > 6) {
                    bomb4duration_white = 0;
                    blnbomb4set_white = false;
                    bombitem(intBomb4X_white, intBomb4Y_white, intbombrange_white, g); // display items
                }
            }
        }
    }


    // intX greater X pixel of the bomb but less than the range of the x bomb pixel
    /* if(intX >= intBombX_blue && intX <= (intBomb4X_blue +(60* intbombrange_blue)) 
        																		&& intY >= intBombY_blue && (intY <= (intBombY_blue +(60* intbombrange_blue)))){
           Bomberman.blnDeathYellow = true;
           } */

    /**********************************************************************
     * 
     * 
     * 
     * 
     *  Paint Component
     * 
     * 
     * 
     * 
     * *******************************************************************/



    public void paintComponent(Graphics g) {
        // Start Main Menu
        // Main Menu
        int intCount2 = 0;
        if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 1) {
            g.drawImage(mainmenu, 0, 0, null);
        }
        // HighscoresMenu 
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 2) {
            g.drawImage(highscoresmenu, 0, 0, null);
            g.drawString("Name", 450, 250);
            g.drawString("Score", 750, 250);
            for (intCount2 = 0; intCount2 < Bomberman.intPlayers || intCount2 < 10; intCount2++) {
                g.drawString(Bomberman.strArray[intCount2][0], 450, 270 + (intCount2 * 15));
                g.drawString(Bomberman.strArray[intCount2][1], 750, 270 + (intCount2 * 15));
            }
        }
        // HelpMenu
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 3) {
            g.drawImage(helpmenu, 0, 0, null);
        }
        // UsernameMenu
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 4) {
            g.drawImage(usernamemenu, 0, 0, null);
        }
        // PlayStyleMenu
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 5) {
            g.drawImage(playstylemenu, 0, 0, null);
        }
        // MultiplayerMenu
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 6) {
            g.drawImage(multiplayermenu, 0, 0, null);
        }
        // HostMenu
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 7) {
            g.drawImage(hostmenu, 0, 0, null);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString(Bomberman.strIP, 580, 480); // Draw IP Adress on screen

        }
        // GuestMenu
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 8) {
            g.drawImage(guestmenu, 0, 0, null);
        }
        // CharacterSelectionMenu
        else if (Bomberman.blnMainMenu == true && Bomberman.intMenu == 9) {
            g.drawImage(characterselectionmenu, 0, 0, null);
        }


        // Start Bomberman Game
        if (Bomberman.blnMainMenu == false) {
            // Set Background
            if (Bomberman.blnIsKeyboard == true) {
                g.drawImage(gui_keyboard, 0, 0, null);
            } else if (Bomberman.blnIsMouse == true) {
                g.drawImage(gui_mouse, 0, 0, null);
            }
            // Draw Game Round Timer
            strTime = String.format("%02d:%02d", Bomberman.intMinute, Bomberman.intSecond);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 60));
            g.drawString(strTime, 1010, 130);
            // Draw Game Round Number
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("" + Bomberman.intRound, 1110, 181);
            // Draw Bomberman Score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("" + Bomberman.intScoreBlue, 158, 700);
            g.drawString("" + Bomberman.intScoreRed, 400, 700);
            g.drawString("" + Bomberman.intScoreYellow, 642, 700);
            g.drawString("" + Bomberman.intScoreWhite, 884, 700);
            // Bomberman Animation
            if (Bomberman.intRand == 1) {
                for (intRow = 0; intRow < 11; intRow++) {
                    for (intCol = 0; intCol < 15; intCol++) {
                        if (Bomberman.strMap[intRow][intCol].equals("ob")) {
                            g.drawImage(wall_stan, intCol * 60, intRow * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("r")) {
                            g.drawImage(breakwall_stan, intCol * 60, intRow * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("g")) {
                            g.drawImage(ground_stan, intCol * 60, intRow * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("c1")) {
                            g.drawImage(down1, intRow * 60, intCol * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("c2")) {
                            g.drawImage(down1_red, intRow * 60, intCol * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("c3")) {
                            g.drawImage(down1_yellow, intRow * 60, intCol * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("c4")) {
                            g.drawImage(down1_white, intRow * 60, intCol * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("itm1")) {
                            g.drawImage(flameitem, intCol * 60, intRow * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("itm2")) {
                            g.drawImage(multiplebombitem, intCol * 60, intRow * 60, null);
                        } else if (Bomberman.strMap[intRow][intCol].equals("itm3")) {
                            g.drawImage(vestitem, intCol * 60, intRow * 60, null);
                        }
                    }
                }









                	}else if(Bomberman.intRand == 2){	
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
                			//	stritem[intRow][intCol] = "na";
                			}
                		}
                	/*	for(intRow = 0; intRow < 4; intRow++){
                			BombermanPanel.generateitem(1);
                		}
                		for(intRow = 0; intRow < 4; intRow++){
                			BombermanPanel.generateitem(2);
                		}
                		for(intRow = 0; intRow < 3; intRow++){
                			BombermanPanel.generateitem(3);
                		} */
                	}else if(Bomberman.intRand == 3){
                		for(intRow = 0; intRow < 11; intRow++){
                			for(intCol = 0; intCol < 15; intCol++){
                				if(Bomberman.strMap[intRow][intCol].equals("ob")){
                					g.drawImage(wall_fire,intCol*60,intRow * 60,null);
                				}else if(Bomberman.strMap[intRow][intCol].equals("r")){
                					g.drawImage(break_fire,intCol*60,intRow*60,null);
                				}else if(Bomberman.strMap[intRow][intCol].equals("g")){
                					g.drawImage(ground_fire,intCol*60,intRow*60,null);
                				/*}else if(Bomberman.strMap[intRow][intCol].equals("c1")){
                					g.drawImage(down1_blue,intRow*60,intCol*60,null);
                				}else if(Bomberman.strMap[intRow][intCol].equals("c2")){
                					g.drawImage(down1_red,intRow*60,intCol*60,null);
                				}else if(Bomberman.strMap[intRow][intCol].equals("c3")){
                					g.drawImage(down1_yellow,intRow*60,intCol*60,null);
                				}else if(Bomberman.strMap[intRow][intCol].equals("c4")){
                					g.drawImage(down1_white,intRow*60,intCol*60,null);
                				}*/
                			}
                		}
					 }
            }
            g.drawImage(down1, intX, intY, null); // Default stance
            g.drawImage(down1_red, intX_red, intY_red, null); // Default stance
            g.drawImage(down1_yellow, intX_yellow, intY_yellow, null); // Default stance
            g.drawImage(down1_white, intX_white, intY_white, null); // Default stance

            BombermanPanel.bombdisplay(g); // display player's bomb
            BombermanPanel.bombdisplay_red(g);
            BombermanPanel.bombdisplay_yellow(g);
            BombermanPanel.bombdisplay_white(g);


            if (blnUp || blnDown || blnRight || blnLeft ) {
                BombermanPanel.blue_move(intY, intX, blnUp, blnDown, blnRight, blnLeft, g);
            }
            if (blnUp_red || blnDown_red || blnRight_red || blnLeft_red) {
                BombermanPanel.red_move(intY_red, intX_red, blnUp_red, blnDown_red, blnRight_red, blnLeft_red, g);
            }
            if (blnUp_yellow || blnDown_yellow || blnRight_yellow || blnLeft_yellow) {
                BombermanPanel.yellow_move(intY_yellow, intX_yellow, blnUp_yellow, blnDown_yellow, blnRight_yellow, blnLeft_yellow, g);
            }
            if (blnUp_white || blnDown_white || blnRight_white || blnLeft_white) {
                BombermanPanel.white_move(intY_white, intX_white, blnUp_white, blnDown_white, blnRight_white, blnLeft_white, g);
            }

            BombermanPanel.bombexplosion(g);
            BombermanPanel.bombexplosion_red(g);
            BombermanPanel.bombexplosion_yellow(g);
            BombermanPanel.bombexplosion_white(g);

            // Death Screen
            if (Bomberman.blnDeathBlue == true && Bomberman.blnBlue == true) {
                g.drawImage(deathscreen, 0, 0, null);
            } else if (Bomberman.blnDeathRed == true && Bomberman.blnRed == true) {
                g.drawImage(deathscreen, 0, 0, null);
            } else if (Bomberman.blnDeathYellow == true && Bomberman.blnYellow == true) {
                g.drawImage(deathscreen, 0, 0, null);
            } else if (Bomberman.blnDeathWhite == true && Bomberman.blnWhite == true) {
                g.drawImage(deathscreen, 0, 0, null);
            }


        }
    }

    // Constructors
    public BombermanPanel() {
        super();
        // Add Images
        try {
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
            break_win = ImageIO.read(new File("win.wallbreakable.jpg"));
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
            deathscreen = ImageIO.read(new File("deathscreen.png"));
            death = ImageIO.read(new File("death.png"));

        } catch (IOException e) {
            System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
        }
    }
}
