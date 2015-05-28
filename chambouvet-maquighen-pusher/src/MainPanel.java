import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class MainPanel extends JPanel implements ActionListener
{


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
	


	

	private JLabel info;
	private DisplayGUI display;

	
	public MainPanel(Map p_map, DisplayGUI display)
	{
		
		this.display = display;
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
		
		
		
		infoPanel = new JPanel(new BorderLayout());
		infoPanel.setBounds(gamePanel.getWidth()+20, 0, 500 ,height/2+100);
		infoPanel.setLayout(null);
			
		info = new JLabel("SOKOBAN");
		info.setBounds(30, 50, 100, 300);
		Font font = new Font("Arial",Font.BOLD,20);
		info.setFont(font);
		
		
		
		giveup = new JButton("Give up");
		giveup.setFocusable(false);
		giveup.setBounds(80,500,100,50);
		
		giveup.addActionListener(this);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,gamePanel,infoPanel);
		splitPane.setDividerLocation(100);
		
		this.add(gamePanel);
		this.add(infoPanel);
		
		infoPanel.add(info);
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
	public void actionPerformed(ActionEvent arg0)
	{
		if (arg0.getSource()==giveup)
		{
			display.setDirection(null);
		}
		
	}

			
}
