package scissors.model;

import rock.controller.RockController;

public class ScissorsGame 
{
	private String P1Choice;
	private String P2Choice;
	private RockController baseController;
	
	
	public ScissorsGame(RockController baseController)
	{
		P1Choice = "rock";
		P2Choice = "rock";
	}
	
	public void RunResult()
	{
		P1Choice = baseController.getMyP1Choices();
		P2Choice = baseController.getMyP2Choices();
		
		
		if(P1Choice == "rock" && P2Choice == "paper")
		{
			baseController.setResult("P2");
		}
		else if(P1Choice == "rock" && P2Choice == "scissors")
		{
			baseController.setResult("P1");
		}
		else if(P1Choice == "paper" && P2Choice == "rock")
		{
			baseController.setResult("P1");
		}
		else if(P1Choice == "paper" && P2Choice == "scissors")
		{
			baseController.setResult("P2");
		}
		else if(P1Choice == "scissors" && P2Choice == "rock")
		{
			baseController.setResult("P2");
		}
		else if(P1Choice == "scissors" && P2Choice == "paper")
		{
			baseController.setResult("P1");
		}
		else if(P1Choice == P2Choice)
		{
			baseController.setResult("tie");
		}
		
	}
	

	
}
