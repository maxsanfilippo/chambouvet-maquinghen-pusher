import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class DisplayGUI implements PlayerDisplay, PlayerEntry, KeyListener
{
	private Direction direction;
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}

	private MainWindow board;
	private volatile boolean keyIsPressed = false;
	
	
	
	public DisplayGUI(Map map)
	{
		this.board = new MainWindow(map,this);
		board.addKeyListener(this);
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
		board.dispose();
		
	}


	public Direction getDirectionToGo()
	{
		while (!keyIsPressed)
		{
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}	
		return direction;
	
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		
		 switch(e.getKeyCode()){
         case 37 : direction = Direction.LEFT; keyIsPressed = true;  break;
         case 39 : direction = Direction.RIGHT; keyIsPressed = true; break;
         case 38 : direction = Direction.UP; keyIsPressed = true; break;
         case 40 : direction = Direction.DOWN; keyIsPressed = true; break;
		 }
	}
		

	@Override
	public void keyReleased(KeyEvent e)
	{

		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	

}
