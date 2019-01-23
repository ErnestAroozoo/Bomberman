import javax.swing. * ;
import java.awt. * ;
import java.awt.event. * ;
import java.awt.image. * ;
import javax.imageio. * ;
import java.io. * ;

/**
 * <h1>Bomberman</h1>
 * Recreation of the game Bomberman in Java<p>
 * @author  Ernest Aroozoo, Bryan Chung, Austin Chay
 * @version 1.0
 * 
 * Welcome to our bomberman game!!!  This game was created uniquely to give you a twist on the classic bomberman game that we all know and love!!!
 * In this game each player will initially start off with bombs that do not harm anyone and only destroys the destructable blocks in the game.  However, 
 * standing on the same spot as where you placed the bomb will kill you.  Another twist that we have added to the game is simulating real life situations
 * where explosions go through walls!!!  Once you grab an increased bomb range power-up, the bombs will function as they would in a normal bomberman game 
 * but the explosions will be able to go through walls!!!  Best of luck and happy gaming!!!
 */

public class Bomberman implements ActionListener,
KeyListener,
MouseListener,
MouseMotionListener {
	// Propertiesd
	JFrame theframe;
	static BombermanPanel bombermanpanel;
	static SuperSocketMaster ssm;
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
	JButton button_back;
	JButton button_hostcontinue;
	JButton button_guestcontinue;
	JTextField textfield_ip;
	JButton button_blue;
	JButton button_yellow;
	JButton button_white;
	JButton button_red;
	JButton button_guestconnect;
	JScrollPane scrollpane_chat;
	JTextField textfield_chat;
	JTextArea textarea_chat;
	JButton button_hoststart;
	Timer gametimer;
	int intLoop = 0;
	static String strUsername = ""; // Check their username
	static boolean blnMainMenu = true; // Start actual game when blnMainMenu = false
	static int intMenu = 1; // Default menu card to MainMenu (intMenu = 1)
	static boolean blnIsKeyboard = false; // Check if Keyboard playstyle
	static boolean blnIsMouse = false; // Check if Mouse playstyle
	static boolean blnIsHost = false; // Check if user is Host
	static boolean blnIsGuest = false; // Check if user is Guest
	static String strIP; // IP Address
	static String strConnectionStatus; // Connection status between Host and Client
	static String strChat; // Chat messages between Host and Client
	static int intPlayer = 1; // Keep track of number of players connected to game
	static int intSelection = 0; // Keep track of how many players selected their character so Host can start game once everyone is ready...
	static boolean blnBlue = false; // Check if they selected Blue Bomberman
	static boolean blnYellow = false; // Check if they selected Yellow Bomberman
	static boolean blnRed = false; // Check if they selected Red Bomberman
	static boolean blnWhite = false; // Check if they selected White Bomberman
	static int intTimer = 140; // Timer (seconds)
	static int intMinute = 3; // Minute from timer
	static int intSecond = 0; // Second from timer
	static int intRound = 1; // Game round
	static String strMovement; // Send movement info SSM
	static boolean blnDeathBlue = false; // Set Bombermans to default alive
	static boolean blnDeathRed = false; // Set Bombermans to default alive
	static boolean blnDeathYellow = false; // Set Bombermans to default alive
	static boolean blnDeathWhite = false; // Set Bombermans to default alive
	static int intScoreBlue = 0; // Set default score for Bombermans
	static int intScoreYellow = 0; // Set default score for Bombermans
	static int intScoreWhite = 0; // Set default score for Bombermans
	static int intScoreRed = 0; // Set default score for Bombermans
	static int intLine = 0;
	static int intRand = 0;
	static String strRand = "";
	int intindex = 0;
	//static int intLine;
	static String strMap[][] = new String[11][15];
	static String stritem[][] = new String[11][15];
	static FileReader thefile;
	static BufferedReader thefiledata;
	String strSplit[];
	static int intCount2;
	static String strName;
	static String strArray[][];
	static int intPlayers = 0;

	// Methods

	public static void generateitem(int intitemnum) {
		boolean blnfound = false;
		int introwitem;
		int intcolitem;
		double dblrow;
		double dblcol;
		String stritem = "";

		if (intitemnum == 1) {
			stritem = "itm1";
		} else if (intitemnum == 2) {
			stritem = "itm2";
		} else if (intitemnum == 3) {
			stritem = "itm3";
		}
		while (blnfound == false) {
			dblrow = Math.random() * 9 + 1;
			dblcol = Math.random() * 13 + 1;
			introwitem = (int) dblrow;
			intcolitem = (int) dblcol;
			if (Bomberman.strMap[introwitem][intcolitem].equals("r")) {
				if (Bomberman.stritem[introwitem][intcolitem] == "na") {
					Bomberman.stritem[introwitem][intcolitem] = stritem;
					blnfound = true;
				}
			}
		}
	}

	public void actionPerformed(ActionEvent evt) {
		FileReader highscoresfile = null;
		BufferedReader highscoresreaddata;
		// JPanel Refresh 60 FPS
		if (evt.getSource() == thetimer) {
			bombermanpanel.repaint();
		}

		// MainMenu (intMenu == 1)
		if (intMenu == 1) {
			System.out.println("MainMenu");
			button_startgame.setVisible(true); // Unhide necessary JComponents
			button_highscores.setVisible(true);
			button_help.setVisible(true);
			button_quit.setVisible(true);
			// [Start Game Button]
			if (evt.getSource() == button_startgame) {
				System.out.println("Start Game");
				button_startgame.setVisible(false); // Hide unecessary JComponents
				button_highscores.setVisible(false);
				button_help.setVisible(false);
				button_quit.setVisible(false);
				intMenu = 4; // Change to UsernameMenu 
			}
			// [Highscores Button]
			else if (evt.getSource() == button_highscores) {
				System.out.println("Highscores");
				button_startgame.setVisible(false); // Hide unecessary JComponents
				button_highscores.setVisible(false);
				button_help.setVisible(false);
				button_quit.setVisible(false);
				try {
					highscoresfile = new FileReader("highscores.txt");
				} catch(FileNotFoundException e) {
					System.out.println("unable to read the file");
				}
				highscoresreaddata = new BufferedReader(highscoresfile);

				String strLine = "";
				String strScore = "";
				intPlayers = 0;
				try {
					strLine = highscoresreaddata.readLine();
					strScore = highscoresreaddata.readLine();
				} catch(IOException e) {
					System.out.println("Unable to read line");
				}

				while (strScore != null) { // read the score file line by line
					intPlayers = intPlayers + 1;

					try {
						strLine = highscoresreaddata.readLine();
						strScore = highscoresreaddata.readLine();
					} catch(IOException e) {
						System.out.println("Unable to read line");
					}
				}
				try {
					highscoresfile.close();
				} catch(IOException e) {
					System.out.println("unable to close the file");
				}
				strArray = new String[intPlayers][2];
				try {
					highscoresfile = new FileReader("highscores.txt");
				} catch(FileNotFoundException e) {
					System.out.println("unable to read the file");
				}
				highscoresreaddata = new BufferedReader(highscoresfile);
				for (intCount2 = 0; intCount2 < intPlayers; intCount2++) {
					try {
						strName = highscoresreaddata.readLine();
						strScore = highscoresreaddata.readLine();
					} catch(IOException e) {
						System.out.println("unable to read line");
					}
					strArray[intCount2][0] = strName;
					strArray[intCount2][1] = strScore;
				}
				try {
					highscoresfile.close();
				} catch(IOException e) {
					System.out.println("unable to close the file");
				}

				//3 - sort the array
				String strLeft;
				String strRight;
				String strTemp;
				// Bubble sort - compare the left to the right, if the left is greater, swap using temp
				int intCounta;
				int intCountb;
				for (intCountb = 0; intCountb < intPlayers - 1; intCountb++) {
					for (intCounta = 0; intCounta < intPlayers - 1; intCounta++) {
						strLeft = strArray[intCounta][1];
						strRight = strArray[intCounta + 1][1];
						if (Integer.parseInt(strRight) > Integer.parseInt(strLeft)) {
							strTemp = strArray[intCounta][1];
							strArray[intCounta][1] = strArray[intCounta + 1][1];
							strArray[intCounta + 1][1] = strTemp;
							strTemp = strArray[intCounta][0];
							strArray[intCounta][0] = strArray[intCounta + 1][0];
							strArray[intCounta + 1][0] = strTemp;
						}
					}
				}

				intMenu = 2; // Change to HighscoresMenu
			}
			// [Help Button]
			else if (evt.getSource() == button_help) {
				System.out.println("Help");
				button_startgame.setVisible(false); // Hide unecessary JComponents
				button_highscores.setVisible(false);
				button_help.setVisible(false);
				button_quit.setVisible(false);
				intMenu = 3; // Change to HelpMenu
			}
			// [Quit Button]
			else if (evt.getSource() == button_quit) {
				System.out.println("Quit");
				System.exit(0); // Exit program
			}
		}

		// HighscoresMenu (intMenu == 2)
		else if (intMenu == 2) {
			button_back.setVisible(true); // Unhide necessary JComponents
			// [Back Button]
			if (evt.getSource() == button_back) {
				intMenu = 1;
				button_back.setVisible(false); // Hide necessary JComponents
			}
		}

		// Help Menu (intMenu == 3)
		else if (intMenu == 3) {
			button_back.setVisible(true); // Unhide necessary JComponents
			if (evt.getSource() == button_back) {
				intMenu = 1;
				button_back.setVisible(false); // Hide necessary JComponents
			}
		}

		// UsernameMenu (intMenu == 4)
		else if (intMenu == 4) {
			System.out.println("UsernameMenu");
			textfield_username.setVisible(true); // Unhide necessary JComponents
			button_usernameconfirm.setVisible(true);
			button_back.setVisible(true);
			textfield_username.grabFocus();
			// [Username Confirm Button]
			if (evt.getSource() == button_usernameconfirm) {
				strUsername = textfield_username.getText();
				System.out.println("Username: " + strUsername);
				textfield_username.setVisible(false); // Hide unecessary JComponents
				button_usernameconfirm.setVisible(false);
				intMenu = 5; // Change to PlayStyleMenu
			}
			// [Back Button]
			else if (evt.getSource() == button_back) {
				intMenu = 1;
				textfield_username.setVisible(false); // Hide unecessary JComponents
				button_usernameconfirm.setVisible(false);
				button_back.setVisible(false);
			}
		}

		// PlayStyleMenu (intMenu == 5)
		else if (intMenu == 5) {
			System.out.println("PlayStylemenu");
			button_mouse.setVisible(true); // Unhide necessary JComponents
			button_keyboard.setVisible(true);
			// [Mouse Button]
			if (evt.getSource() == button_mouse) {
				System.out.println("Play Style: Mouse");
				blnIsKeyboard = false;
				blnIsMouse = true;
				button_mouse.setVisible(false); // Hide unecessary JComponents
				button_keyboard.setVisible(false);
				intMenu = 6; // Change to MultiplayerMenu
			}
			// [Keyboard Button]
			else if (evt.getSource() == button_keyboard) {
				System.out.println("Play Style: Keyboard");
				blnIsMouse = false;
				blnIsKeyboard = true;
				button_mouse.setVisible(false); // Hide unecessary JComponents
				button_keyboard.setVisible(false);
				intMenu = 6; // Change to MultiplayerMenu
			}
			// [Back Button]
			else if (evt.getSource() == button_back) {
				intMenu = 4;
				button_mouse.setVisible(false); // Hide unecessary JComponents
				button_keyboard.setVisible(false);
			}
		}

		// MultiplayerMenu (intMenu == 6)
		else if (intMenu == 6) {
			System.out.println("MultiplayerMenu");
			button_host.setVisible(true); // Unhide necessary JComponents
			button_guest.setVisible(true);
			// [Host Button]
			if (evt.getSource() == button_host) {
				System.out.println("Multiplayer: Host");
				blnIsHost = true;
				button_host.setVisible(false); // Hide unecessary JComponents
				button_guest.setVisible(false);
				button_back.setVisible(false);
				ssm = new SuperSocketMaster(1337, this); // Setup SuperSocketMaster Server
				System.out.println(ssm.getMyAddress());
				strIP = ssm.getMyAddress(); // Convert IP Address into String strIP
				ssm.connect();
				intMenu = 7; // Change to HostMenu
			}
			// [Guest Button]
			else if (evt.getSource() == button_guest) {
				System.out.println("Multiplayer: Guest");
				blnIsGuest = true;
				button_host.setVisible(false); // Hide unecessary JComponents
				button_guest.setVisible(false);
				button_back.setVisible(false);
				intMenu = 8; // Change to GuestMenu
			}
			// [Back Button]
			else if (evt.getSource() == button_back) {
				intMenu = 5;
				button_host.setVisible(false); // Hide unecessary JComponents
				button_guest.setVisible(false);
			}
		}

		// HostMenu (intMenu == 7)
		else if (intMenu == 7) {
			System.out.println("HostMenu");
			button_hostcontinue.setVisible(true); // Unhide necessary JComponents 
			// [Host Continue Button]
			if (evt.getSource() == button_hostcontinue) {
				button_hostcontinue.setVisible(false); // Hide unecessary JComponents
				intMenu = 9; // Change to CharacterSelectionMenu
				ssm.sendText("characterselectionmenu"); // Tell all clients to go to CharacterSelectionMenu
			}
			// Connection Check (Only allow Host to continue if it's connected with Client)
			else if (evt.getSource() == ssm) {
				strConnectionStatus = ssm.readText();
				if (strConnectionStatus.equals("connect")) {
					ssm.sendText("connected");
					intPlayer = intPlayer + 1; // Count total number of players connected to the game
					textarea_chat.setVisible(true); // Show chat only when there are people connected
					scrollpane_chat.setVisible(true);
					textfield_chat.setVisible(true);
					ssm.sendText("You have joined " + strUsername + "'s game. \n"); // Send message that you've joined their game
					button_hostcontinue.setEnabled(true);
				}
			}
		}

		// GuestMenu (intMenu == 8)
		else if (intMenu == 8) {
			System.out.println("GuestMenu");
			button_guestconnect.setVisible(true); // Unhide necessary JComponents
			textfield_ip.setVisible(true);
			// [Guest Connect Button]
			if (evt.getSource() == button_guestconnect) {
				strIP = textfield_ip.getText();
				ssm = new SuperSocketMaster(strIP, 1337, this); // Connect to IP user typed
				ssm.connect();
				ssm.sendText("connect");
				ssm.sendText(strUsername + " has joined the game. \n"); // Send message that you've joined their game
				button_guestconnect.setVisible(false); // Unhide necessary JComponents
				textfield_ip.setVisible(false);
			}
			// Connection Check (Only allow Client to continue if it's connected with Host)
			else if (evt.getSource() == ssm) {
				strConnectionStatus = ssm.readText();
				if (strConnectionStatus.equals("connected")) {
					textarea_chat.setVisible(true); // Show chat only when there are people connected
					scrollpane_chat.setVisible(true);
					textfield_chat.setVisible(true);
					button_guestcontinue.setEnabled(true);
					button_guestconnect.setEnabled(false);
					textfield_ip.setEnabled(false);

				}
				// Go to CharacterSelectionMenu only if the host allows
				else if (strConnectionStatus.equals("characterselectionmenu")) {
					button_guestcontinue.setVisible(false); // Hide unecessary JComponents
					button_guestconnect.setVisible(false);
					textfield_ip.setVisible(false);
					button_guestcontinue.setEnabled(false);
					button_guestconnect.setEnabled(false);
					textfield_ip.setEnabled(false);
					intMenu = 9; // Change to CharacterSelectionMenu
				}
			}
		}

		// CharacterSelectionMenu (intMenu == 9)
		else if (intMenu == 9) {
			System.out.println("CharacterSelectionMenu");
			button_blue.setVisible(true); // Unhide necessary JComponents
			button_white.setVisible(true);
			button_yellow.setVisible(true);
			button_red.setVisible(true);
			// [Blue Button]
			if (evt.getSource() == button_blue) {
				ssm.sendText("blue"); // Let other players know Blue Bomberman is taken
				intSelection = intSelection + 1;
				blnBlue = true;
				button_blue.setEnabled(false); // Don't let user choose anything once they've selected their character
				button_white.setEnabled(false);
				button_yellow.setEnabled(false);
				button_red.setEnabled(false);
			}
			// [White Button]
			else if (evt.getSource() == button_white) {
				ssm.sendText("white"); // Let other players know White Bomberman is taken
				intSelection = intSelection + 1;
				blnWhite = true;
				button_blue.setEnabled(false); // Don't let user choose anything once they've selected their character
				button_white.setEnabled(false);
				button_yellow.setEnabled(false);
				button_red.setEnabled(false);
			}
			// [Yellow Button]
			else if (evt.getSource() == button_yellow) {
				ssm.sendText("yellow"); // Let other players know Yellow Bomberman is taken
				intSelection = intSelection + 1;
				blnYellow = true;
				button_blue.setEnabled(false); // Don't let user choose anything once they've selected their character
				button_white.setEnabled(false);
				button_yellow.setEnabled(false);
				button_red.setEnabled(false);
			}
			// [Red Button]
			else if (evt.getSource() == button_red) {
				ssm.sendText("red"); // Let other players know Red Bomberman is taken
				intSelection = intSelection + 1;
				blnRed = true;
				button_blue.setEnabled(false); // Don't let user choose anything once they've selected their character
				button_white.setEnabled(false);
				button_yellow.setEnabled(false);
				button_red.setEnabled(false);
			}
			// Check if character has been selected by others via SSM
			if (evt.getSource() == ssm) {
				strConnectionStatus = ssm.readText();
				if (strConnectionStatus.equals("blue")) {
					button_blue.setEnabled(false);
					intSelection = intSelection + 1;
				}
				if (strConnectionStatus.equals("yellow")) {
					button_yellow.setEnabled(false);
					intSelection = intSelection + 1;
				}
				if (strConnectionStatus.equals("white")) {
					button_white.setEnabled(false);
					intSelection = intSelection + 1;
				}
				if (strConnectionStatus.equals("red")) {
					button_red.setEnabled(false);
					intSelection = intSelection + 1;
				}
			}
			// [Host] Check if everyone connected has selected their character
			if (blnIsHost == true && intSelection == intPlayer) {
				button_hoststart.setVisible(true); // Display start game button only if everyone has selected their character
			}
			// [Client] Check if Host clicked Start Game
			else if (blnIsGuest == true) {
				strConnectionStatus = ssm.readText();
				if (strConnectionStatus.equals("startgame1")) { // [Client] Load Map 1
					intRand = 1;
					button_yellow.setVisible(false); // Hide unecessary JComponents
					button_red.setVisible(false);
					button_white.setVisible(false);
					button_blue.setVisible(false);
					intMenu = 10;
					blnMainMenu = false; // Start the actual Bomberman Game and get out of the menu once Host approves
					gametimer.start();
					theframe.requestFocus(); // Focus to the game instead of chat
					button_guestcontinue.setEnabled(false);
					button_guestconnect.setEnabled(false);
					textfield_ip.setEnabled(false);
					ssm.sendText("startgame1"); // Tell everyone connected to load Map 1
					try {
						thefile = new FileReader("standard.csv");
					} catch(FileNotFoundException e) {
						System.out.println("Unable to read from the file");
					}

					thefiledata = new BufferedReader(thefile);

					String strLine = "";
					try {
						strLine = thefiledata.readLine();
					} catch(IOException e) {
						System.out.println("Unable to read Map");
					}

					while (strLine != null) {
						strSplit = strLine.split(",");
						for (intindex = 0; intindex < 15; intindex++) {
							strMap[intLine][intindex] = strSplit[intindex];
							System.out.println(strMap[intLine][intindex]);
						}
						intLine++;
						try {
							strLine = thefiledata.readLine();
						} catch(IOException e) {
							System.out.println("Unable to read Map");
						}
					}
					int intRow2;
					int intCol2;
					for (intRow2 = 0; intRow2 < 11; intRow2++) {
						for (intCol2 = 0; intCol2 < 15; intCol2++) {
							stritem[intRow2][intCol2] = "na";
						}
					}
					stritem[1][3] = "itm1";
					stritem[3][1] = "itm2";
					stritem[1][4] = "itm3";
				} 
				if (strConnectionStatus.equals("startgame2")) { // [Client] Load Map 2
					intRand = 2;
					button_yellow.setVisible(false); // Hide unecessary JComponents
					button_red.setVisible(false);
					button_white.setVisible(false);
					button_blue.setVisible(false);
					intMenu = 10;
					blnMainMenu = false; // Start the actual Bomberman Game and get out of the menu once Host approves
					gametimer.start();
					theframe.requestFocus(); // Focus to the game instead of chat
					button_guestcontinue.setEnabled(false);
					button_guestconnect.setEnabled(false);
					textfield_ip.setEnabled(false);
					try {
						thefile = new FileReader("wintermap.csv");
					} catch(FileNotFoundException e) {
						System.out.println("Unable to read from the file");
					}

					thefiledata = new BufferedReader(thefile);

					String strLine2 = "";
					try {
						strLine2 = thefiledata.readLine();
					} catch(IOException e) {
						System.out.println("Unable to read Map");
					}

					while (strLine2 != null) {
						strSplit = strLine2.split(",");
						for (intindex = 0; intindex < 15; intindex++) {
							strMap[intLine][intindex] = strSplit[intindex];
							System.out.println(strMap[intLine][intindex]);
						}
						intLine++;
						try {
							strLine2 = thefiledata.readLine();
						} catch(IOException e) {
							System.out.println("Unable to read Map");
						}
					}
					int intRow2;
					int intCol2;
					for (intRow2 = 0; intRow2 < 11; intRow2++) {
					for (intCol2 = 0; intCol2 < 15; intCol2++) {
						stritem[intRow2][intCol2] = "na";
					}
				}
				stritem[1][3] = "itm1";
				stritem[3][1] = "itm2";
				stritem[1][4] = "itm3";
				} 
				if (strConnectionStatus.equals("startgame3")) { // [Client] Load map 3
					intRand = 3;
					button_yellow.setVisible(false); // Hide unecessary JComponents
					button_red.setVisible(false);
					button_white.setVisible(false);
					button_blue.setVisible(false);
					intMenu = 10;
					blnMainMenu = false; // Start the actual Bomberman Game and get out of the menu once Host approves
					gametimer.start();
					theframe.requestFocus(); // Focus to the game instead of chat
					button_guestcontinue.setEnabled(false);
					button_guestconnect.setEnabled(false);
					textfield_ip.setEnabled(false);
					try {
						thefile = new FileReader("firemap.csv");
					} catch(FileNotFoundException e) {
						System.out.println("Unable to read from the file");
					}

					thefiledata = new BufferedReader(thefile);

					String strLine = "";
					try {
						strLine = thefiledata.readLine();
					} catch(IOException e) {
						System.out.println("Unable to read Map");
					}

					while (strLine != null) {
						strSplit = strLine.split(",");
						for (intindex = 0; intindex < 15; intindex++) {
							strMap[intLine][intindex] = strSplit[intindex];
							System.out.println(strMap[intLine][intindex]);
						}
						intLine++;
						try {
							strLine = thefiledata.readLine();
						} catch(IOException e) {
							System.out.println("Unable to read Map");
						}
					}
					int intRow2;
					int intCol2;
					for (intRow2 = 0; intRow2 < 11; intRow2++) {
					for (intCol2 = 0; intCol2 < 15; intCol2++) {
						stritem[intRow2][intCol2] = "na";
					}
				}
				stritem[1][3] = "itm1";
				stritem[3][1] = "itm2";
				stritem[1][4] = "itm3";
					
				} 
			} 

			// [Host Start Button]
			if (evt.getSource() == button_hoststart) {
				intRand = (int)(Math.random() * 3) + 1;
				button_yellow.setVisible(false); // Hide unecessary JComponents
				button_red.setVisible(false);
				button_white.setVisible(false);
				button_blue.setVisible(false);
				button_hoststart.setVisible(false);
				intMenu = 10; // Exit menu and go into actual game
				blnMainMenu = false; // Start game
				gametimer.start();
				theframe.requestFocus(); // Focus to the game instead of chat
				if (intRand == 1) {
					ssm.sendText("startgame1"); // Tell everyone connected to load Map 1
					try {
						thefile = new FileReader("standard.csv");
					} catch(FileNotFoundException e) {
						System.out.println("Unable to read from the file");
					}

					thefiledata = new BufferedReader(thefile);

					String strLine = "";
					try {
						strLine = thefiledata.readLine();
					} catch(IOException e) {
						System.out.println("Unable to read Map");
					}

					while (strLine != null) {
						strSplit = strLine.split(",");
						for (intindex = 0; intindex < 15; intindex++) {
							strMap[intLine][intindex] = strSplit[intindex];
							System.out.println(strMap[intLine][intindex]);
						}
						intLine++;
						try {
							strLine = thefiledata.readLine();
						} catch(IOException e) {
							System.out.println("Unable to read Map");
						}
					}
				}  
				int intRow2;
				int intCol2;
				for (intRow2 = 0; intRow2 < 11; intRow2++) {
					for (intCol2 = 0; intCol2 < 15; intCol2++) {
						stritem[intRow2][intCol2] = "na";
					}
				}
	
				stritem[1][3] = "itm1";
				stritem[3][1] = "itm2";
				stritem[1][4] = "itm3";
			
				if (intRand == 2) {
					ssm.sendText("startgame2"); // Tell everyone connected to load Map 2
					try {
						thefile = new FileReader("wintermap.csv");
					} catch(FileNotFoundException e) {
						System.out.println("Unable to read from the file");
					}

					thefiledata = new BufferedReader(thefile);

					String strLine2 = "";
					try {
						strLine2 = thefiledata.readLine();
					} catch(IOException e) {
						System.out.println("Unable to read Map");
					}

					while (strLine2 != null) {
						strSplit = strLine2.split(",");
						for (intindex = 0; intindex < 15; intindex++) {
							strMap[intLine][intindex] = strSplit[intindex];
							System.out.println(strMap[intLine][intindex]);
						}
						intLine++;
						try {
							strLine2 = thefiledata.readLine();
						} catch(IOException e) {
							System.out.println("Unable to read Map");
						}
					} 
				}
				for (intRow2 = 0; intRow2 < 11; intRow2++) {
					for (intCol2 = 0; intCol2 < 15; intCol2++) {
						stritem[intRow2][intCol2] = "na";
					}
				}
		
				stritem[1][3] = "itm1";
				stritem[3][1] = "itm2";
				stritem[1][4] = "itm3";
				if (intRand == 3) {
					ssm.sendText("startgame3"); // Tell everyone connected to load Map 3
					try {
						thefile = new FileReader("firemap.csv");
					} catch(FileNotFoundException e) {
						System.out.println("Unable to read from the file");
					}

					thefiledata = new BufferedReader(thefile);

					String strLine = "";
					try {
						strLine = thefiledata.readLine();
					} catch(IOException e) {
						System.out.println("Unable to read Map");
					}

					while (strLine != null) {
						strSplit = strLine.split(",");
						for (intindex = 0; intindex < 15; intindex++) {
							strMap[intLine][intindex] = strSplit[intindex];
							System.out.println(strMap[intLine][intindex]);
						}
						intLine++;
						try {
							strLine = thefiledata.readLine();
						} catch(IOException e) {
							System.out.println("Unable to read Map");
						}
					}
				} 

				for (intRow2 = 0; intRow2 < 11; intRow2++) {
					for (intCol2 = 0; intCol2 < 15; intCol2++) {
						stritem[intRow2][intCol2] = "na";
					}
				}
				stritem[1][3] = "itm1";
				stritem[3][1] = "itm2";
				stritem[1][4] = "itm3";

			}
		}

		// In-Game Chat (Receive)
		if (evt.getSource() == ssm) {
			strChat = ssm.readText();
			// Block SSM data so they it doesn't show in chat
			if (!strChat.equals("connect") && !strChat.equals("startgame3")&& !strChat.equals("startgame2")&& !strChat.equals("startgame1") && !strChat.equals("wb_r") && !strChat.equals("!wb_p") && !strChat.equals("!wd_r") && !strChat.equals("!wd_p") && !strChat.equals("!wr_r") && !strChat.equals("!wr_p") && !strChat.equals("!wu_r") && !strChat.equals("!wu_p") && !strChat.equals("!wl_r") && !strChat.equals("!wl_p") && !strChat.equals("!rb_r") && !strChat.equals("!rb_p") && !strChat.equals("!rd_r") && !strChat.equals("!rd_p") && !strChat.equals("!rr_r") && !strChat.equals("!rr_p") && !strChat.equals("!ru_r") && !strChat.equals("!ru_p") && !strChat.equals("!rl_r") && !strChat.equals("!rl_p") && !strChat.equals("!yb_r") && !strChat.equals("!yb_p") && !strChat.equals("!yd_r") && !strChat.equals("!yd_p") && !strChat.equals("!yr_r") && !strChat.equals("!yr_p") && !strChat.equals("!yu_r") && !strChat.equals("!yu_p") && !strChat.equals("!yl_r") && !strChat.equals("!yl_p") && !strChat.equals("!bb_r") && !strChat.equals("!bb_p") && !strChat.equals("!bd_r") && !strChat.equals("!bd_p") && !strChat.equals("!br_r") && !strChat.equals("!br_p") && !strChat.equals("!bu_r") && !strChat.equals("!bu_p") && !strChat.equals("!bl_r") && !strChat.equals("!bl_p") && !strChat.equals("connected") && !strChat.equals("blue") && !strChat.equals("red") && !strChat.equals("yellow") && !strChat.equals("white") && !strChat.equals("characterselectionmenu")) { // Blacklist I/O data so they don't show in chat area
				textarea_chat.append(strChat + "\n");
				theframe.requestFocus();
				textarea_chat.setCaretPosition(textarea_chat.getDocument().getLength()); // Auto scroll down as new message pops up
			}
		}

		// In-Game Chat (Send) 
		if (evt.getSource() == textfield_chat) {
			System.out.println(strUsername + ": " + textfield_chat.getText());
			ssm.sendText(strUsername + ": " + textfield_chat.getText());
			textarea_chat.append(strUsername + ": " + textfield_chat.getText() + "\n");
			textfield_chat.setText("");
			theframe.requestFocus();
			textarea_chat.setCaretPosition(textarea_chat.getDocument().getLength()); // Auto scroll down as new message pops up
		}

		// Game Round Timer
		if (evt.getSource() == gametimer) {
			intTimer = intTimer - 1; // intTimer goes down by 1 every 1000 milisecond from gametimer
			intSecond = intSecond - 1;
			if (intSecond < 0) {
				intMinute = intMinute - 1;
				intSecond = 59;
			}
			if (intTimer < 0) { // Reset timer and restart game when timer hits 0
				System.out.println("Ending round...");
				intRound = intRound + 1; // Increase game round number
				intMinute = 3;
				intSecond = 0;
				// [Send]
				if (blnDeathBlue == false) {
					intScoreBlue = intScoreBlue + 1;
				}
				if (blnDeathRed == false) {
					intScoreRed = intScoreRed + 1;
				}
				if (blnDeathYellow == false) {
					intScoreYellow = intScoreYellow + 1;
				}
				if (blnDeathWhite == false) {
					intScoreWhite = intScoreWhite + 1;
				}
				blnDeathBlue = false;
				blnDeathYellow = false;
				blnDeathWhite = false;
				blnDeathRed = false;
				bombermanpanel.intX = 60;
				bombermanpanel.intY = 60;
				bombermanpanel.intX_red = 780;
				bombermanpanel.intY_red = 60;
				bombermanpanel.intX_yellow = 60;
				bombermanpanel.intY_yellow = 540;
				bombermanpanel.intX_white = 780;
				bombermanpanel.intY_white = 540;

				intTimer = 140;
				ssm.sendText("Time's Up! Starting Round " + intRound + "!");
				gametimer.restart();
			}
		}

		// Multiplayer Movement Receive

		if (evt.getSource() == ssm) {
			strMovement = ssm.readText();
			if (strMovement.equals("!bl_p")) {
				bombermanpanel.blnLeft = true;
			}
			if (strMovement.equals("!bl_r")) {
				bombermanpanel.blnLeft = false;
			}
			if (strMovement.equals("!bu_p")) {
				bombermanpanel.blnUp = true;
			}
			if (strMovement.equals("!bu_r")) {
				bombermanpanel.blnUp = false;
			}
			if (strMovement.equals("!br_p")) {
				bombermanpanel.blnRight = true;
			}
			if (strMovement.equals("!br_r")) {
				bombermanpanel.blnRight = false;
			}
			if (strMovement.equals("!bd_p")) {
				bombermanpanel.blnDown = true;
			}
			if (strMovement.equals("!bd_r")) {
				bombermanpanel.blnDown = false;
			}
			if (strMovement.equals("!bb_p")) {
				bombermanpanel.blnPlaceBomb = true;
			}
			if (strMovement.equals("!bb_r")) {
				bombermanpanel.blnPlaceBomb = false;
			}
			if (strMovement.equals("!yl_p")) {
				bombermanpanel.blnLeft_yellow = true;
			}
			if (strMovement.equals("!yl_r")) {
				bombermanpanel.blnLeft_yellow = false;
			}
			if (strMovement.equals("!yu_p")) {
				bombermanpanel.blnUp_yellow = true;
			}
			if (strMovement.equals("!yu_r")) {
				bombermanpanel.blnUp_yellow = false;
			}
			if (strMovement.equals("!yr_p")) {
				bombermanpanel.blnRight_yellow = true;
			}
			if (strMovement.equals("!yr_r")) {
				bombermanpanel.blnRight_yellow = false;
			}
			if (strMovement.equals("!yd_p")) {
				bombermanpanel.blnDown_yellow = true;
			}
			if (strMovement.equals("!yd_r")) {
				bombermanpanel.blnDown_yellow = false;
			}
			if (strMovement.equals("!yb_p")) {
				bombermanpanel.blnPlaceBomb_yellow = true;
			}
			if (strMovement.equals("!yb_r")) {
				bombermanpanel.blnPlaceBomb_yellow = false;
			}
			if (strMovement.equals("!rl_p")) {
				bombermanpanel.blnLeft_red = true;
			}
			if (strMovement.equals("!rl_r")) {
				bombermanpanel.blnLeft_red = false;
			}
			if (strMovement.equals("!ru_p")) {
				bombermanpanel.blnUp_red = true;
			}
			if (strMovement.equals("!ru_r")) {
				bombermanpanel.blnUp_red = false;
			}
			if (strMovement.equals("!rr_p")) {
				bombermanpanel.blnRight_red = true;
			}
			if (strMovement.equals("!rr_r")) {
				bombermanpanel.blnRight_red = false;
			}
			if (strMovement.equals("!rd_p")) {
				bombermanpanel.blnDown_red = true;
			}
			if (strMovement.equals("!rd_r")) {
				bombermanpanel.blnDown_red = false;
			}
			if (strMovement.equals("!rb_p")) {
				bombermanpanel.blnPlaceBomb_red = true;
			}
			if (strMovement.equals("!rb_r")) {
				bombermanpanel.blnPlaceBomb_red = false;
			}
			if (strMovement.equals("!wl_p")) {
				bombermanpanel.blnLeft_white = true;
			}
			if (strMovement.equals("!wl_r")) {
				bombermanpanel.blnLeft_white = false;
			}
			if (strMovement.equals("!wu_p")) {
				bombermanpanel.blnUp_white = true;
			}
			if (strMovement.equals("!wu_r")) {
				bombermanpanel.blnUp_white = false;
			}
			if (strMovement.equals("!wr_p")) {
				bombermanpanel.blnRight_white = true;
			}
			if (strMovement.equals("!wr_r")) {
				bombermanpanel.blnRight_white = false;
			}
			if (strMovement.equals("!wd_p")) {
				bombermanpanel.blnDown_white = true;
			}
			if (strMovement.equals("!wd_r")) {
				bombermanpanel.blnDown_white = false;
			}
			if (strMovement.equals("!wb_p")) {
				bombermanpanel.blnPlaceBomb_white = true;
			}
			if (strMovement.equals("!wb_r")) {
				bombermanpanel.blnPlaceBomb_white = false;
			}
		}
	}

	public void keyReleased(KeyEvent evt) {
		if (evt.getKeyCode() == 37 && blnBlue == true && blnIsKeyboard) { // Left Arrow Key
			ssm.sendText("!bl_r");
			bombermanpanel.blnLeft = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 38 && blnBlue == true && blnIsKeyboard) { // Up Arrow Key
			ssm.sendText("!bu_r");
			bombermanpanel.blnUp = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 39 && blnBlue == true && blnIsKeyboard) { // Right Arrow Key
			ssm.sendText("!br_r");
			bombermanpanel.blnRight = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 40 && blnBlue == true && blnIsKeyboard) { // Down Arrow Key
			bombermanpanel.blnDown = false;
			ssm.sendText("!bd_r");
			intLoop = 0;
		} else if (evt.getKeyCode() == 37 && blnYellow == true && blnIsKeyboard) { // Left Arrow Key
			ssm.sendText("!yl_r");
			bombermanpanel.blnLeft_yellow = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 38 && blnYellow == true && blnIsKeyboard) { // Up Arrow Key
			ssm.sendText("!yu_r");
			bombermanpanel.blnUp_yellow = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 39 && blnYellow == true && blnIsKeyboard) { // Right Arrow Key
			ssm.sendText("!yr_r");
			bombermanpanel.blnRight_yellow = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 40 && blnYellow == true && blnIsKeyboard) { // Down Arrow Key
			ssm.sendText("!yd_r");
			bombermanpanel.blnDown_yellow = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 37 && blnRed == true && blnIsKeyboard) { // Left Arrow Key
			ssm.sendText("!rl_r");
			bombermanpanel.blnLeft_red = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 38 && blnRed == true && blnIsKeyboard) { // Up Arrow Key
			ssm.sendText("!ru_r");
			bombermanpanel.blnUp_red = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 39 && blnRed == true && blnIsKeyboard) { // Right Arrow Key
			ssm.sendText("!rr_r");
			bombermanpanel.blnRight_red = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 40 && blnRed == true && blnIsKeyboard) { // Down Arrow Key
			ssm.sendText("!rd_r");
			bombermanpanel.blnDown_red = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 37 && blnWhite == true && blnIsKeyboard) { // Left Arrow Key
			ssm.sendText("!wl_r");
			bombermanpanel.blnLeft_white = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 38 && blnWhite == true && blnIsKeyboard) { // Up Arrow Key
			ssm.sendText("!wl_r");
			bombermanpanel.blnUp_white = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 39 && blnWhite == true && blnIsKeyboard) { // Right Arrow Key
			ssm.sendText("!wr_r");
			bombermanpanel.blnRight_white = false;
			intLoop = 0;
		} else if (evt.getKeyCode() == 40 && blnWhite == true && blnIsKeyboard) { // Down Arrow Key
			ssm.sendText("!wd_r");
			bombermanpanel.blnDown_white = false;
			intLoop = 0;
		}
	}

	public void keyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 37 && blnBlue == true && blnIsKeyboard) { // Left Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!bl_p");
				bombermanpanel.blnLeft = true;
			}
		} else if (evt.getKeyCode() == 38 && blnBlue == true && blnIsKeyboard) { // Up Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!bu_p");
				bombermanpanel.blnUp = true;
			}
		} else if (evt.getKeyCode() == 39 && blnBlue == true && blnIsKeyboard) { // Right Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!br_p");
				bombermanpanel.blnRight = true;
			}
		} else if (evt.getKeyCode() == 40 && blnBlue == true && blnIsKeyboard) { // Down Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!bd_p");
				bombermanpanel.blnDown = true;
			}
		} else if (evt.getKeyCode() == 32 && blnBlue == true && blnIsKeyboard && blnDeathBlue == false) { // Bomb Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!bb_p");
				bombermanpanel.blnPlaceBomb = true;
			}
		} else if (evt.getKeyCode() == 37 && blnYellow == true && blnIsKeyboard) { // Left Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!yl_p");
				bombermanpanel.blnLeft_yellow = true;
			}
		} else if (evt.getKeyCode() == 38 && blnYellow == true && blnIsKeyboard) { // Up Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!yu_p");
				bombermanpanel.blnUp_yellow = true;
			}
		} else if (evt.getKeyCode() == 39 && blnYellow == true && blnIsKeyboard) { // Right Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!yr_p");
				bombermanpanel.blnRight_yellow = true;
			}
		} else if (evt.getKeyCode() == 40 && blnYellow == true && blnIsKeyboard) { // Down Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!yd_p");
				bombermanpanel.blnDown_yellow = true;
			}
		} else if (evt.getKeyCode() == 32 && blnYellow == true && blnIsKeyboard && blnDeathYellow == false) { // Bomb Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!yb_p");
				bombermanpanel.blnPlaceBomb_yellow = true;
			}
		} else if (evt.getKeyCode() == 37 && blnRed == true && blnIsKeyboard) { // Left Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!rl_p");
				bombermanpanel.blnLeft_red = true;
			}
		} else if (evt.getKeyCode() == 38 && blnRed == true && blnIsKeyboard) { // Up Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!ru_p");
				bombermanpanel.blnUp_red = true;
			}
		} else if (evt.getKeyCode() == 39 && blnRed == true && blnIsKeyboard) { // Right Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!rr_p");
				bombermanpanel.blnRight_red = true;
			}
		} else if (evt.getKeyCode() == 40 && blnRed == true && blnIsKeyboard) { // Down Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!rd_p");
				bombermanpanel.blnDown_red = true;
			}
		} else if (evt.getKeyCode() == 32 && blnRed == true && blnIsKeyboard && blnDeathRed == false) { // Bomb Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!rb_p");
				bombermanpanel.blnPlaceBomb_red = true;
			}
		} else if (evt.getKeyCode() == 37 && blnWhite == true && blnIsKeyboard) { // Left Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!wl_p");
				bombermanpanel.blnLeft_white = true;
			}
		} else if (evt.getKeyCode() == 38 && blnWhite == true && blnIsKeyboard) { // Up Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!wu_p");
				bombermanpanel.blnUp_white = true;
			}
		} else if (evt.getKeyCode() == 39 && blnWhite == true && blnIsKeyboard) { // Right Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!wr_p");
				bombermanpanel.blnRight_white = true;
			}
		} else if (evt.getKeyCode() == 40 && blnWhite == true && blnIsKeyboard) { // Down Arrow Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!wd_p");
				bombermanpanel.blnDown_white = true;
			}
		} else if (evt.getKeyCode() == 32 && blnWhite == true && blnIsKeyboard && blnDeathWhite == false) { // Bomb Key
			intLoop = intLoop + 1;
			if (intLoop == 1) {
				ssm.sendText("!wb_p");
				bombermanpanel.blnPlaceBomb_white = true;
			}
		}
	}

	public void keyTyped(KeyEvent evt) {}

	public void mouseMoved(MouseEvent evt) {

}

	public void mouseDragged(MouseEvent evt) {

}

	public void mouseExited(MouseEvent evt) {

}

	public void mouseEntered(MouseEvent evt) {

}

	public void mousePressed(MouseEvent evt) {
		if (evt.getX() > 966 && evt.getX() < 1043 && evt.getY() > 337 && evt.getY() < 414 && blnIsMouse) { // On-Screen Left Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!bl_p");
					bombermanpanel.blnLeft = true;
				}
			} else if (blnYellow == true) { // Yellow
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!yl_p");
					bombermanpanel.blnLeft_yellow = true;
				}
			} else if (blnRed == true) { // Red
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!rl_p");
					bombermanpanel.blnLeft_red = true;
				}
			} else if (blnWhite == true) { // White
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!wl_p");
					bombermanpanel.blnLeft_white = true;
				}
			}
		} else if (evt.getX() > 1137 && evt.getX() < 1212 && evt.getY() > 337 && evt.getY() < 414 && blnIsMouse) { // On-Screen Right Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!br_p");
					bombermanpanel.blnRight = true;
				}
			} else if (blnYellow == true) { // Yellow
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!yr_p");
					bombermanpanel.blnRight_yellow = true;
				}
			} else if (blnRed == true) { // Red
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!rr_p");
					bombermanpanel.blnRight_red = true;
				}
			} else if (blnWhite == true) { // White
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!wr_p");
					bombermanpanel.blnRight_white = true;
				}
			}
		} else if (evt.getX() > 1051 && evt.getX() < 1127 && evt.getY() > 252 && evt.getY() < 327 && blnIsMouse) { // On-Screen Up Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!bu_p");
					bombermanpanel.blnUp = true;
				}
			} else if (blnYellow == true) { // Yellow
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!yu_p");
					bombermanpanel.blnUp_yellow = true;
				}
			} else if (blnRed == true) { // Red
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!ru_p");
					bombermanpanel.blnUp_red = true;
				}
			} else if (blnWhite == true) { // White
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!wu_p");
					bombermanpanel.blnUp_white = true;
				}
			}
		} else if (evt.getX() > 1051 && evt.getX() < 1127 && evt.getY() > 337 && evt.getY() < 414 && blnIsMouse) { // On-Screen Down Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!bd_p");
					bombermanpanel.blnDown = true;
				}
			} else if (blnYellow == true) { // Yellow
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!yd_p");
					bombermanpanel.blnDown_yellow = true;
				}
			} else if (blnRed == true) { // Red
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!rd_p");
					bombermanpanel.blnDown_red = true;
				}
			} else if (blnWhite == true) { // White
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!wd_p");
					bombermanpanel.blnDown_white = true;
				}
			}
		} else if (evt.getX() > 971 && evt.getX() < 1215 && evt.getY() > 428 && evt.getY() < 477 && blnIsMouse) { // On-Screen Place Bomb Button
			if (blnBlue == true && blnDeathBlue == false) { // Blue
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!bb_p");
					bombermanpanel.blnPlaceBomb = true;
				}
			} else if (blnYellow == true && blnDeathYellow == false) { // Yellow
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!yb_p");
					bombermanpanel.blnPlaceBomb_yellow = true;
				}
			} else if (blnRed == true && blnDeathRed == false) { // Red
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!rb_p");
					bombermanpanel.blnPlaceBomb_red = true;
				}
			} else if (blnWhite == true && blnDeathWhite == false) { // White
				intLoop = intLoop + 1;
				if (intLoop == 1) {
					ssm.sendText("!wb_p");
					bombermanpanel.blnPlaceBomb_white = true;
				}
			}
		}

	}
	public void mouseReleased(MouseEvent evt) {
		if (evt.getX() > 966 && evt.getX() < 1043 && evt.getY() > 337 && evt.getY() < 414 && blnIsMouse) { // On-Screen Left Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = 0;
				ssm.sendText("!bl_r");
				bombermanpanel.blnLeft = false;
			} else if (blnYellow == true) { // Yellow
				intLoop = 0;
				ssm.sendText("!yl_r");
				bombermanpanel.blnLeft_yellow = false;
			} else if (blnRed == true) { // Red
				intLoop = 0;
				ssm.sendText("!rl_r");
				bombermanpanel.blnLeft_red = false;
			} else if (blnWhite == true) { // White
				intLoop = 0;
				ssm.sendText("!wl_r");
				bombermanpanel.blnLeft_white = false;
			}
		} else if (evt.getX() > 1137 && evt.getX() < 1212 && evt.getY() > 337 && evt.getY() < 414 && blnIsMouse) { // On-Screen Right Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = 0;
				ssm.sendText("!br_r");
				bombermanpanel.blnRight = false;
			} else if (blnYellow == true) { // Yellow
				intLoop = 0;
				ssm.sendText("!yr_r");
				bombermanpanel.blnRight_yellow = false;
			} else if (blnRed == true) { // Red
				intLoop = 0;
				ssm.sendText("!rr_r");
				bombermanpanel.blnRight_red = false;
			} else if (blnWhite == true) { // White
				intLoop = 0;
				ssm.sendText("!wr_r");
				bombermanpanel.blnRight_white = false;
			}
		} else if (evt.getX() > 1051 && evt.getX() < 1127 && evt.getY() > 252 && evt.getY() < 327 && blnIsMouse) { // On-Screen Up Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = 0;
				ssm.sendText("!bu_r");
				bombermanpanel.blnUp = false;
			} else if (blnYellow == true) { // Yellow
				intLoop = 0;
				ssm.sendText("!yu_r");
				bombermanpanel.blnUp_yellow = false;
			} else if (blnRed == true) { // Red
				intLoop = 0;
				ssm.sendText("!ru_r");
				bombermanpanel.blnUp_red = false;
			} else if (blnWhite == true) { // White
				intLoop = 0;
				ssm.sendText("!wu_r");
				bombermanpanel.blnUp_white = false;
			}
		} else if (evt.getX() > 1051 && evt.getX() < 1127 && evt.getY() > 337 && evt.getY() < 414 && blnIsMouse) { // On-Screen Down Arrow Key
			if (blnBlue == true) { // Blue
				intLoop = 0;
				ssm.sendText("!bd_r");
				bombermanpanel.blnDown = false;
			} else if (blnYellow == true) { // Yellow
				intLoop = 0;
				ssm.sendText("!yd_r");
				bombermanpanel.blnDown_yellow = false;
			} else if (blnRed == true) { // Red
				intLoop = 0;
				ssm.sendText("!rd_r");
				bombermanpanel.blnDown_red = false;
			} else if (blnWhite == true) { // White
				intLoop = 0;
				ssm.sendText("!wd_r");
				bombermanpanel.blnDown_white = false;
			}
		} else if (evt.getX() > 971 && evt.getX() < 1215 && evt.getY() > 428 && evt.getY() < 477 && blnIsMouse) { // On-Screen Place Bomb Button
			if (blnBlue == true && blnDeathBlue == false) { // Blue
				intLoop = 0;
				ssm.sendText("!bb_r");
				bombermanpanel.blnPlaceBomb = false;
			} else if (blnYellow == true && blnDeathYellow == false) { // Yellow
				intLoop = 0;
				ssm.sendText("!yb_r");
				bombermanpanel.blnPlaceBomb_yellow = false;
			} else if (blnRed == true && blnDeathRed == false) { // Red
				intLoop = 0;
				ssm.sendText("!rb_r");
				bombermanpanel.blnPlaceBomb_red = false;
			} else if (blnWhite == true && blnDeathWhite == false) { // White
				intLoop = 0;
				ssm.sendText("!wb_r");
				bombermanpanel.blnPlaceBomb_white = false;
			}
		}

	}

	public void mouseClicked(MouseEvent evt) {

}

	// Constructors
	public Bomberman() {
		// JPanel
		bombermanpanel = new BombermanPanel();
		bombermanpanel.setLayout(null);
		bombermanpanel.setPreferredSize(new Dimension(1280, 720));

		// JFrame
		theframe = new JFrame("Bomberman");
		theframe.setContentPane(bombermanpanel);
		theframe.setResizable(false);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);

		// Add MouseMotionListener
		bombermanpanel.addMouseMotionListener(this);
		bombermanpanel.addMouseListener(this);

		// Add MouseMotionListener
		theframe.addKeyListener(this);
		theframe.addMouseListener(this);

		// Add Timer Object
		thetimer = new Timer(1000 / 60, this); // Triggering timer object every 1000/60. Basically 60 FPS.
		thetimer.start();

		gametimer = new Timer(1000, this);

		// Menu JComponents
		button_startgame = new JButton("Start Game");
		button_startgame.setSize(200, 50);
		button_startgame.setLocation(540, 230);
		button_startgame.addActionListener(this);
		button_startgame.setFocusPainted(false);
		button_startgame.setContentAreaFilled(false);
		button_startgame.setFont(new Font("Arial", Font.PLAIN, 20));
		button_startgame.setForeground(Color.WHITE);
		bombermanpanel.add(button_startgame);

		button_highscores = new JButton("Highscores");
		button_highscores.setSize(200, 50);
		button_highscores.setLocation(540, 300);
		button_highscores.addActionListener(this);
		button_highscores.setFocusPainted(false);
		button_highscores.setContentAreaFilled(false);
		button_highscores.setFont(new Font("Arial", Font.PLAIN, 20));
		button_highscores.setForeground(Color.WHITE);
		bombermanpanel.add(button_highscores);

		button_help = new JButton("Help");
		button_help.setSize(200, 50);
		button_help.setLocation(540, 370);
		button_help.addActionListener(this);
		button_help.setFocusPainted(false);
		button_help.setContentAreaFilled(false);
		button_help.setFont(new Font("Arial", Font.PLAIN, 20));
		button_help.setForeground(Color.WHITE);
		bombermanpanel.add(button_help);

		button_quit = new JButton("Quit");
		button_quit.setSize(200, 50);
		button_quit.setLocation(540, 440);
		button_quit.addActionListener(this);
		button_quit.setFocusPainted(false);
		button_quit.setContentAreaFilled(false);
		button_quit.setFont(new Font("Arial", Font.PLAIN, 20));
		button_quit.setForeground(Color.WHITE);
		bombermanpanel.add(button_quit);

		textfield_username = new JTextField();
		textfield_username.setOpaque(false); // Make textfield_username transparent
		textfield_username.setHorizontalAlignment(JTextField.CENTER); // Make textfield_username align center
		textfield_username.setFont(new Font("Arial", Font.PLAIN, 20)); // Change font and text size of textfield_username
		textfield_username.setSize(400, 35);
		textfield_username.setLocation(440, 325);
		textfield_username.addActionListener(this);
		bombermanpanel.add(textfield_username);
		textfield_username.setVisible(false); // Hide textfield_username initially

		button_usernameconfirm = new JButton("Continue");
		button_usernameconfirm.setSize(200, 50);
		button_usernameconfirm.setLocation(540, 380);
		button_usernameconfirm.addActionListener(this);
		button_usernameconfirm.setFocusPainted(false);
		button_usernameconfirm.setContentAreaFilled(false);
		button_usernameconfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		button_usernameconfirm.setForeground(Color.WHITE);
		bombermanpanel.add(button_usernameconfirm);
		button_usernameconfirm.setVisible(false); // Hide button_usernameconfirm initially

		button_mouse = new JButton("Mouse");
		button_mouse.setSize(200, 50);
		button_mouse.setLocation(360, 450);
		button_mouse.addActionListener(this);
		button_mouse.setFocusPainted(false);
		button_mouse.setContentAreaFilled(false);
		button_mouse.setFont(new Font("Arial", Font.PLAIN, 20));
		button_mouse.setForeground(Color.WHITE);
		bombermanpanel.add(button_mouse);
		button_mouse.setVisible(false); // Hide button_mouse initially

		button_keyboard = new JButton("Keyboard");
		button_keyboard.setSize(200, 50);
		button_keyboard.setLocation(721, 450);
		button_keyboard.addActionListener(this);
		button_keyboard.setFocusPainted(false);
		button_keyboard.setContentAreaFilled(false);
		button_keyboard.setFont(new Font("Arial", Font.PLAIN, 20));
		button_keyboard.setForeground(Color.WHITE);
		bombermanpanel.add(button_keyboard);
		button_keyboard.setVisible(false); // Hide button_keyboard initially

		button_host = new JButton("Host");
		button_host.setSize(200, 50);
		button_host.setLocation(355, 490);
		button_host.addActionListener(this);
		button_host.setFocusPainted(false);
		button_host.setContentAreaFilled(false);
		button_host.setFont(new Font("Arial", Font.PLAIN, 20));
		button_host.setForeground(Color.WHITE);
		bombermanpanel.add(button_host);
		button_host.setVisible(false); // Hide button_host initially

		button_guest = new JButton("Guest");
		button_guest.setSize(200, 50);
		button_guest.setLocation(730, 490);
		button_guest.addActionListener(this);
		button_guest.setFocusPainted(false);
		button_guest.setContentAreaFilled(false);
		button_guest.setFont(new Font("Arial", Font.PLAIN, 20));
		button_guest.setForeground(Color.WHITE);
		bombermanpanel.add(button_guest);
		button_guest.setVisible(false); // Hide button_guest initially

		button_back = new JButton("Back");
		button_back.setSize(200, 50);
		button_back.setLocation(540, 610);
		button_back.addActionListener(this);
		button_back.setFocusPainted(false);
		button_back.setContentAreaFilled(false);
		button_back.setFont(new Font("Arial", Font.PLAIN, 20));
		button_back.setForeground(Color.WHITE);
		bombermanpanel.add(button_back);
		button_back.setVisible(false); // Hide button_back initially

		button_hostcontinue = new JButton("Continue");
		button_hostcontinue.setSize(200, 50);
		button_hostcontinue.setLocation(540, 500);
		button_hostcontinue.addActionListener(this);
		button_hostcontinue.setFocusPainted(false);
		button_hostcontinue.setContentAreaFilled(false);
		button_hostcontinue.setFont(new Font("Arial", Font.PLAIN, 20));
		button_hostcontinue.setForeground(Color.WHITE);
		bombermanpanel.add(button_hostcontinue);
		button_hostcontinue.setVisible(false); // Hide button_hostcontinue initially
		button_hostcontinue.setEnabled(false); // Disable button_hostname initially

		button_guestcontinue = new JButton("Continue");
		button_guestcontinue.setSize(200, 50);
		button_guestcontinue.setLocation(540, 610);
		button_guestcontinue.addActionListener(this);
		button_guestcontinue.setFocusPainted(false);
		button_guestcontinue.setContentAreaFilled(false);
		button_guestcontinue.setFont(new Font("Arial", Font.PLAIN, 20));
		button_guestcontinue.setForeground(Color.WHITE);
		bombermanpanel.add(button_guestcontinue);
		button_guestcontinue.setVisible(false); // Hide button_guestcontinue initially
		button_guestcontinue.setEnabled(false); // Disable button_hostname initially

		button_guestconnect = new JButton("Connect");
		button_guestconnect.setSize(200, 50);
		button_guestconnect.setLocation(540, 500);
		button_guestconnect.addActionListener(this);
		button_guestconnect.setFocusPainted(false);
		button_guestconnect.setContentAreaFilled(false);
		button_guestconnect.setFont(new Font("Arial", Font.PLAIN, 20));
		button_guestconnect.setForeground(Color.WHITE);
		bombermanpanel.add(button_guestconnect);
		button_guestconnect.setVisible(false); // Hide button_guestconnect initially

		textfield_ip = new JTextField();
		textfield_ip.setOpaque(false);
		textfield_ip.setHorizontalAlignment(JTextField.CENTER);
		textfield_ip.setFont(new Font("Arial", Font.PLAIN, 20));
		textfield_ip.setSize(400, 35);
		textfield_ip.setLocation(440, 450);
		textfield_ip.addActionListener(this);
		bombermanpanel.add(textfield_ip);
		textfield_ip.setVisible(false); // Hide textfield_ip initially

		button_blue = new JButton("Blue");
		button_blue.setSize(100, 30);
		button_blue.setLocation(462, 375);
		button_blue.addActionListener(this);
		button_blue.setFocusPainted(false);
		button_blue.setContentAreaFilled(false);
		button_blue.setFont(new Font("Arial", Font.PLAIN, 20));
		button_blue.setForeground(Color.WHITE);
		bombermanpanel.add(button_blue);
		button_blue.setVisible(false); // Hide button_blue initially

		button_white = new JButton("White");
		button_white.setSize(100, 30);
		button_white.setLocation(718, 375);
		button_white.addActionListener(this);
		button_white.setFocusPainted(false);
		button_white.setContentAreaFilled(false);
		button_white.setFont(new Font("Arial", Font.PLAIN, 20));
		button_white.setForeground(Color.WHITE);
		bombermanpanel.add(button_white);
		button_white.setVisible(false); // Hide button_white initially

		button_red = new JButton("Red");
		button_red.setSize(100, 30);
		button_red.setLocation(462, 605);
		button_red.addActionListener(this);
		button_red.setFocusPainted(false);
		button_red.setContentAreaFilled(false);
		button_red.setFont(new Font("Arial", Font.PLAIN, 20));
		button_red.setForeground(Color.WHITE);
		bombermanpanel.add(button_red);
		button_red.setVisible(false); // Hide button_red initially

		button_yellow = new JButton("Yellow");
		button_yellow.setSize(100, 30);
		button_yellow.setLocation(718, 605);
		button_yellow.addActionListener(this);
		button_yellow.setFocusPainted(false);
		button_yellow.setContentAreaFilled(false);
		button_yellow.setFont(new Font("Arial", Font.PLAIN, 20));
		button_yellow.setForeground(Color.WHITE);
		bombermanpanel.add(button_yellow);
		button_yellow.setVisible(false); // Hide button_yellow initially

		button_hoststart = new JButton("Start Game");
		button_hoststart.setSize(140, 40);
		button_hoststart.setLocation(570, 470);
		button_hoststart.addActionListener(this);
		button_hoststart.setFocusPainted(false);
		button_hoststart.setContentAreaFilled(false);
		button_hoststart.setFont(new Font("Arial", Font.PLAIN, 20));
		button_hoststart.setForeground(Color.WHITE);
		bombermanpanel.add(button_hoststart);
		button_hoststart.setVisible(false); // Hide button_hoststart initially

		// In-Game Chat JComponents
		textarea_chat = new JTextArea();
		textarea_chat.setOpaque(false);
		textarea_chat.setForeground(Color.WHITE); // Set text colour 
		textarea_chat.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font and size
		textarea_chat.setVisible(false);
		textarea_chat.setEnabled(false);

		scrollpane_chat = new JScrollPane(textarea_chat);
		scrollpane_chat.getViewport().setOpaque(false);
		scrollpane_chat.setOpaque(false);
		scrollpane_chat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Remove ugly vertical scroll bars
		scrollpane_chat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Remove ugly horizontal scroll bars
		scrollpane_chat.setSize(350, 200);
		scrollpane_chat.setLocation(930, 485);
		bombermanpanel.add(scrollpane_chat);
		scrollpane_chat.setVisible(false);

		textfield_chat = new JTextField();
		textfield_chat.setOpaque(false);
		textfield_chat.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font and size
		textfield_chat.setForeground(Color.WHITE); // Set text colour 
		textfield_chat.setSize(350, 35);
		textfield_chat.setLocation(930, 685);
		textfield_chat.addActionListener(this);
		bombermanpanel.add(textfield_chat);
		textfield_chat.setVisible(false);

	}

	// Main Methods
	public static void main(String[] args) {
		new Bomberman();
		// Blue Bomberman Blueprint (Slow but strong)
		bombermanblueprint blue = new bombermanblueprint("Blue", 2, 1); // [Colour] [Speed] [Number of Bombs]
		blue.speed();
		blue.bombrange();
		// Red Bomberman Blueprint (Fast but weak)
		bombermanblueprint red = new bombermanblueprint("Red", 4, 0); // [Colour] [Speed] [Number of Extra Bombs]
		red.speed();
		red.bombrange();
		// Yellow Bomberman Blueprint (Slow but strong)
		bombermanblueprint yellow = new bombermanblueprint("Yellow", 2, 1); // [Colour] [Speed] [Number of Extra Bombs]
		yellow.speed();
		yellow.bombrange();
		// White Bomberman Blueprint (Fast but weak)
		bombermanblueprint white = new bombermanblueprint("White", 4, 0); // [Colour] [Speed] [Number of Extra Bombs]
		white.speed();
		white.bombrange();
	}
}
/**/
/**/
