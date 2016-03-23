package rock.controller;

import java.util.Scanner;
import scissors.model.ScissorsGame;
import paper.view.PaperFrame;
import paper.view.PaperPanel;

public class RockController 
{
	private PaperFrame baseFrame;
	private PaperPanel basePanel;
	public String myP1Choices;
	public String myP2Choices;
	private ScissorsGame ScissorsGame;
	public  String result;
	
	public RockController(PaperPanel basePanel)
	{
		baseFrame = new PaperFrame(this);
		myP1Choices = new String();
		myP2Choices = new String();
		ScissorsGame = new ScissorsGame(this);
		result = new String();
	}
	
	public String getResult() 
	{
		return result;
	}

	public void setResult(String result) 
	{
		this.result = result;
	}

	public void start()
	{
		
	}

	public String getMyP1Choices() 
	{
		return myP1Choices;
	}

	public void setMyP1Choices(String myP1Choices) 
	{
		this.myP1Choices = myP1Choices;
	}

	public String getMyP2Choices() 
	{
		return myP2Choices;
	}

	public void setMyP2Choices(String myP2Choices) 
	{
		this.myP2Choices = myP2Choices;
	}
}
