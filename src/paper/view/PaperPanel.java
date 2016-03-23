package paper.view;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scissors.model.ScissorsGame;
import rock.controller.RockController;

public class PaperPanel extends JPanel
{
	private RockController baseController;
	private SpringLayout baseLayout;
	private JLabel P1Score;
	private JLabel P2Score;
	private JLabel whoseTurn;
	private JLabel Result;
	private JButton RockButtonP1;
	private JButton PaperButtonP1;
	private JButton ScissorsButtonP1;
	private JButton RockButtonP2;
	private JButton PaperButtonP2;
	private JButton ScissorsButtonP2;
	private JCheckBox gameMode;
	

	public int P1Wins;
	public int rand;
	public int P2Wins;
	
	public String newP1Choice;
	public String newP2Choice;
	
	public Boolean Multiplayer;
//	public Lair newLair;
	
	
	
	public PaperPanel(RockController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		gameMode = new JCheckBox("2 Player");
		RockButtonP1 = new JButton("Rock");
		PaperButtonP1 = new JButton("Paper");		
		ScissorsButtonP1 = new JButton("Scissors");		
		RockButtonP2 = new JButton("Rock");	
		PaperButtonP2 = new JButton("Paper");		
		ScissorsButtonP2 = new JButton("Scissors");
		P1Score = new JLabel("Player 1: ");
		P2Score = new JLabel("Player 2: ");				
		whoseTurn = new JLabel("Its P1's Turn");				
		Result = new JLabel("P1 chose  , and P2 chose  , P  Won!");				
		P1Wins = 0;
		P2Wins = 0;	
		rand = 0;
		Multiplayer = false;
		
		RockButtonP2.setVisible(false);
		PaperButtonP2.setVisible(false);
		ScissorsButtonP2.setVisible(false);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(RockButtonP1);
		this.add(RockButtonP2);
		this.add(PaperButtonP1);
		this.add(PaperButtonP2);
		this.add(ScissorsButtonP1);
		this.add(ScissorsButtonP2);
		this.add(whoseTurn);
		this.add(Result);
		this.add(gameMode);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, RockButtonP1, 3, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, PaperButtonP1, 3, SpringLayout.SOUTH, RockButtonP1);
		baseLayout.putConstraint(SpringLayout.WEST, PaperButtonP1, 0, SpringLayout.WEST, RockButtonP1);
		baseLayout.putConstraint(SpringLayout.NORTH, ScissorsButtonP1, 1, SpringLayout.SOUTH, PaperButtonP1);
		baseLayout.putConstraint(SpringLayout.WEST, ScissorsButtonP1, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, RockButtonP1, 0, SpringLayout.NORTH, RockButtonP2);
		baseLayout.putConstraint(SpringLayout.NORTH, RockButtonP2, 92, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, RockButtonP2, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, PaperButtonP2, 0, SpringLayout.NORTH, PaperButtonP1);
		baseLayout.putConstraint(SpringLayout.EAST, PaperButtonP2, 0, SpringLayout.EAST, RockButtonP2);
		baseLayout.putConstraint(SpringLayout.NORTH, ScissorsButtonP2, 0, SpringLayout.NORTH, ScissorsButtonP1);
		baseLayout.putConstraint(SpringLayout.EAST, ScissorsButtonP2, 0, SpringLayout.EAST, RockButtonP2);
		baseLayout.putConstraint(SpringLayout.NORTH, whoseTurn, 53, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, whoseTurn, 179, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, Result, -24, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, Result, -112, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		RockButtonP1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
				baseController.setMyP1Choices("rock");
			if(gameMode.isSelected())
				{
					RockButtonP1.setVisible(false);
					PaperButtonP1.setVisible(false);
					ScissorsButtonP1.setVisible(false);
					RockButtonP2.setVisible(true);
					PaperButtonP2.setVisible(true);
					ScissorsButtonP2.setVisible(true);
					whoseTurn.setText("P2's Turn");
				}
			else
				{
					randomResult();
				}
				
			
			}
		});
		
		RockButtonP2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.setMyP2Choices("rock");	
				
				if(gameMode.isSelected())
				{
					RockButtonP2.setVisible(false);
					PaperButtonP2.setVisible(false);
					ScissorsButtonP2.setVisible(false);
					RockButtonP1.setVisible(true);
					PaperButtonP1.setVisible(true);
					ScissorsButtonP1.setVisible(true);
					whoseTurn.setText("P1's Turn");
				}
				
			whoWon();
			}
		});
		
		PaperButtonP1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.setMyP1Choices("paper");

				if(gameMode.isSelected())
				{
					RockButtonP1.setVisible(false);
					PaperButtonP1.setVisible(false);
					ScissorsButtonP1.setVisible(false);
					RockButtonP2.setVisible(true);
					PaperButtonP2.setVisible(true);
					ScissorsButtonP2.setVisible(true);
					whoseTurn.setText("P2's Turn");
				}
				else
				{
					randomResult();
				}
			}
		});
		
		PaperButtonP2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.setMyP2Choices("paper");
				if(gameMode.isSelected())
				{
					RockButtonP2.setVisible(false);
					PaperButtonP2.setVisible(false);
					ScissorsButtonP2.setVisible(false);
					RockButtonP1.setVisible(true);
					PaperButtonP1.setVisible(true);
					ScissorsButtonP1.setVisible(true);
					whoseTurn.setText("P1's Turn");
				}
				whoWon();
			}
		});
		
		ScissorsButtonP1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.setMyP1Choices("scissors");
			
				if(gameMode.isSelected())
				{
					RockButtonP1.setVisible(false);
					PaperButtonP1.setVisible(false);
					ScissorsButtonP1.setVisible(false);
					RockButtonP2.setVisible(true);
					PaperButtonP2.setVisible(true);
					ScissorsButtonP2.setVisible(true);
					whoseTurn.setText("P2's Turn");
				}
				else
				{
					randomResult();
				}
			}
		});
		
		ScissorsButtonP2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.setMyP2Choices("scissors");
				if(gameMode.isSelected())
				{
					RockButtonP2.setVisible(false);
					PaperButtonP2.setVisible(false);
					ScissorsButtonP2.setVisible(false);
					RockButtonP1.setVisible(true);
					PaperButtonP1.setVisible(true);
					ScissorsButtonP1.setVisible(true);
					whoseTurn.setText("P1's Turn");
				}
				whoWon();
				
			}
		});
		
		gameMode.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(gameMode.isSelected())
				{
					Multiplayer = true;
				}
				else
				{
					Multiplayer = false;
				}
			}
		});
	
	}
	
	public void randomResult()
	{
		rand = (int) (Math.random()*2);
		
		if(rand == 0)
		{
			baseController.setMyP2Choices("scissors");
		}
		else if(rand == 1)
		{
			baseController.setMyP2Choices("rock");
		}
		else
		{
			baseController.setMyP2Choices("paper");
		}
		
	}
	
	private void whoWon()
	{
		if (baseController.getResult() == "P1")
		{
			Result.setText("P1 Used " + baseController.getMyP1Choices() + "and P2 used " + baseController.getMyP2Choices() + " and P1 won");
			
		}
		else if(baseController.getResult() == "P2")
		{
			Result.setText("P1 Used " + baseController.getMyP1Choices() + "and P2 used " + baseController.getMyP2Choices() + " and P2 won");
		}
		else
		{
			Result.setText("You tied");
		}
	}
	
	
}
