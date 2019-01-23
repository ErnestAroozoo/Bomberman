public class bombermanblueprint{
	// Properties
	
	public String strName;
	public int intSpeed;
	public String strColour;
	public int intbrange;
	public int intbcount;
	
	// Methods
	public void speed(){
		if(this.strColour.equals("Blue")){
			BombermanPanel.intSpeedBlue = this.intSpeed;
		}
		else if(this.strColour.equals("Red")){
			BombermanPanel.intSpeedRed = this.intSpeed;
		}
		else if(this.strColour.equals("Yellow")){
			BombermanPanel.intSpeedYellow = this.intSpeed;
		}
		else if(this.strColour.equals("White")){
			BombermanPanel.intSpeedWhite = this.intSpeed;
		}
	}
	
	public void bombrange(){
		if(this.strColour.equals("Blue")){
			BombermanPanel.intbombcount_blue = this.intbcount;
		}
		else if(this.strColour.equals("Red")){
			BombermanPanel.intbombcount_red = this.intbcount;
		}
		else if(this.strColour.equals("Yellow")){
			BombermanPanel.intbombcount_yellow= this.intbcount;
		}
		else if(this.strColour.equals("White")){
			BombermanPanel.intbombcount_white = this.intbcount;
		}
	}





	
	// Constructor
	public bombermanblueprint(String strColour,int intSpeed,int intbcount){
		this.intSpeed = intSpeed;
		this.strColour = strColour;
		this.intbrange = intbrange;
		this.intbcount = intbcount;
	}
}
