package rock.controller;

import rock.controller.RockController;
import paper.view.PaperPanel;

public class RockRunner 
{
	public static void main (String [] args)
	{
		RockController myController = new RockController(null);
		myController.start();
	}
}
