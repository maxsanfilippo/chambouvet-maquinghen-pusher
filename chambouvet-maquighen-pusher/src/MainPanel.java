import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class MainPanel extends JPanel implements KeyListener
{
	private boolean left,right,up,down;
	

	

	private JPanel gamePanel;
	private JPanel infoPanel;
	private JSplitPane splitPane;
	private JButton giveup;	
	Toolkit tk =Toolkit.getDefaultToolkit();
	Dimension dimEcran = tk.getScreenSize();
	
	int width = dimEcran.width;
	int height = dimEcran.height;
	private Map map;
	private JLabel[] theLabels;

	private int labelsMax;

	
	public MainPanel(Map p_map)
	{
		
	
        this.left=false;
        this.right=false;
        this.up=false;
        this.down=false;
        
		this.map = p_map;
		this.labelsMax = map.getNumberOfColumns()*map.getNumberOfRows();
		this.setLayout(null);
		
		gamePanel = new JPanel(new GridLayout(map.getNumberOfRows(),map.getNumberOfColumns(),15,10));
		gamePanel.setBounds(10, 10, width/2-200,height/2+50);
		
		theLabels = new JLabel[labelsMax];
		for ( int mapElement=0 ; mapElement<labelsMax; mapElement++)
		{
			theLabels[mapElement] = new JLabel();
			gamePanel.add(theLabels[mapElement]);
		}
		
		this.addKeyListener(this);
		
		infoPanel = new JPanel(new BorderLayout());
		infoPanel.setBounds(gamePanel.getWidth()+20, 0, width/4-100 ,height/2+100);
		infoPanel.setLayout(null);
		
		
		giveup = new JButton("Give up");
		giveup.setBounds(80,500,100,50);
		
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,gamePanel,infoPanel);
		splitPane.setDividerLocation(100);
		
		this.add(gamePanel);
		this.add(infoPanel);
		
		infoPanel.add(giveup);

	}
	
	public void updateLayout()
	{
		
		
		for (int label = 0; label < labelsMax ; label++ )
		{
			Position theposition = new Position(label/8,label%8);
			if (map.getFixedContentAt(theposition) instanceof Wall)
			{
				ImageIcon wall = new ImageIcon("square-32.png");
				theLabels[label].setIcon(wall);
			}
			if (map.getFixedContentAt(theposition) instanceof Exit)
			{
				Exit currentExit = (Exit)map.getFixedContentAt(theposition);
				int exitNumber = currentExit.getExitNumber();
				ImageIcon exit = new ImageIcon("exit"+exitNumber+".png");
				theLabels[label].setIcon(exit);
			}
			if (map.getMovableContentAt(theposition) instanceof Box)
			{
				Box currentBox = (Box)map.getMovableContentAt(theposition);
				int boxNumber = currentBox.getNumber();
				ImageIcon box = new ImageIcon("box"+boxNumber+".png");
				theLabels[label].setIcon(box);
				if (map.getFixedContentAt(theposition) instanceof Exit)
				{
					Exit currentExit = (Exit)map.getFixedContentAt(theposition);
					int exitNumber = currentExit.getExitNumber();
					if ( boxNumber == exitNumber)
					{
						ImageIcon complete = new ImageIcon("complete"+exitNumber+".png");
						theLabels[label].setIcon(complete);
					}
				}
			}
			
		}
		
		int x_Player = map.getPlayerPosition().getX();
		int y_Player = map.getPlayerPosition().getY();
		ImageIcon player = new ImageIcon("mickey-mouse-37-32.png");
		theLabels[x_Player*8+y_Player].setIcon(player);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		 switch(e.getKeyCode()){
         case 37 : left = true ; break;
         case 39 : right = true ; break;
         case 38 : up = true ; break;
         case 40 : down = true ; break;
		}
		
	}
	
	public boolean isLeft()
	{
		return left;
	}

	public void setLeft(boolean left)
	{
		this.left = left;
	}

	public boolean isRight()
	{
		return right;
	}

	public void setRight(boolean right)
	{
		this.right = right;
	}

	public boolean isUp()
	{
		return up;
	}

	public void setUp(boolean up)
	{
		this.up = up;
	}

	public boolean isDown()
	{
		return down;
	}

	public void setDown(boolean down)
	{
		this.down = down;
	}

			
			
}
