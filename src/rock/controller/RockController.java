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
	public ScissorsGame ScissorsGame;
	public  String result;
	
	public RockController(PaperPanel basePanel)
	{
		baseFrame = new PaperFrame(this);
		myP1Choices = new String();
		myP2Choices = new String();
		ScissorsGame = new ScissorsGame(this);
		result = new String();
	}
	
	public void start()
	{
		
	}
	
	public void runGame()
	{
		ScissorsGame.RunResult();
	}
	public String getResult() 
	{
		return result;
	}

	public void setResult(String result) 
	{
		this.result = result;
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

	public PaperFrame getBaseFrame() 
	{
		return baseFrame;
	}

	public void setBaseFrame(PaperFrame baseFrame) 
	{
		this.baseFrame = baseFrame;
	}

	public PaperPanel getBasePanel() 
	{
		return basePanel;
	}

	public void setBasePanel(PaperPanel basePanel) 
	{
		this.basePanel = basePanel;
	}

	public ScissorsGame getScissorsGame() 
	{
		return ScissorsGame;
	}

	public void setScissorsGame(ScissorsGame scissorsGame) 
	{
		ScissorsGame = scissorsGame;
	}
	
	
}


