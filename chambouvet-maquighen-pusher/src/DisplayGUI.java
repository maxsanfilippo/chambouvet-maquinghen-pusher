


public class DisplayGUI implements PlayerDisplay
{
	MainWindow board;
	public DisplayGUI(Map map)
	{

		this.board = new MainWindow(map);
		board.setVisible(true);
		
	}

	
	public void displayDirectionChoice()
	{				

	}

	@Override
	public void displayMap(String formattedMap)
	{
		this.board.pan.updateLayout();
	}

	@Override
	public void displayVictoryMessage()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayInvalidDirectionMessage()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayHowToGiveUpMessage()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayGiveUpMessage()
	{
		// TODO Auto-generated method stub
		
	}

}
