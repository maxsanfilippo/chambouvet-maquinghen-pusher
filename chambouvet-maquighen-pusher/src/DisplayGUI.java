


public class DisplayGUI implements PlayerDisplay, PlayerEntry
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


	public Direction getDirectionToGo()
	{
	
			if (board.pan.isRight())
				return Direction.RIGHT;
			else if (board.pan.isLeft())
				 return Direction.LEFT;
			else if (board.pan.isUp())
				return Direction.UP;
			else if (board.pan.isDown())
				return Direction.DOWN;
		//	else if ("give up"))
			//	return null;
			
			return Direction.NOWHERE;
	
	}

}
