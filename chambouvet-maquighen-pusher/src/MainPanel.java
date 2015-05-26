import java.awt.*;

import javax.swing.*;


public class MainPanel extends JPanel
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

	
	public MainPanel(Map p_map)
	{
		this.map = p_map;
		this.labelsMax = map.getNumberOfColumns()*map.getNumberOfRows();
		this.setLayout(null);
		
		gamePanel = new JPanel(new GridLayout(map.getNumberOfRows(),map.getNumberOfColumns(),15,10));
		gamePanel.setBounds(10, 10, width/2-80,height/2+100);
		
		theLabels = new JLabel[labelsMax];
		for ( int mapElement=0 ; mapElement<labelsMax; mapElement++)
		{
			theLabels[mapElement] = new JLabel();
			gamePanel.add(theLabels[mapElement]);
		}
		
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
				ImageIcon wall = new ImageIcon("square-24.png");
				theLabels[label].setIcon(wall);
			}
			if (map.getFixedContentAt(theposition) instanceof Exit)
			{
				ImageIcon exit = new ImageIcon("circle-outline-16.png");
				theLabels[label].setIcon(exit);
			}
			if (map.getMovableContentAt(theposition) instanceof Box)
			{
				ImageIcon box = new ImageIcon("square-16.png");
				theLabels[label].setIcon(box);
			}
		}
		
		int x_Player = map.getPlayerPosition().getX();
		int y_Player = map.getPlayerPosition().getY();
		ImageIcon player = new ImageIcon("arrow-24-24.png");
		theLabels[x_Player*8+y_Player].setIcon(player);
	}
}
