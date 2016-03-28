package paper.view;

import javax.swing.JFrame;
import rock.controller.RockController;

public class PaperFrame extends JFrame
{
	private RockController baseController;
	private PaperPanel basePanel;
	
	public PaperFrame(RockController baseController)
	{
		this.baseController = baseController;
		basePanel = new PaperPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);  //installs the panel in the frame
		this.setSize(500,500);
		this.setTitle("Rock, paper, scissors!"); // find a good size for app
		this.setResizable(false); //can't change size of window
		this.setVisible(true);  //must be last line of setupFrame
	}
	
	public RockController getBaseController()
	{
		return baseController;
	}
}
