import java.awt.*;

import javax.swing.*;


public class MainPanel extends JPanel
{
	private JPanel gamePanel;
	private JPanel infoPanel;
	private JSplitPane splitPane;
	private JButton bouton;	
	Toolkit tk =Toolkit.getDefaultToolkit();
	Dimension dimEcran = tk.getScreenSize();
	
	int width = dimEcran.width;
	int height = dimEcran.height;
	private Map map;
	private JButton[] thebuttons;

	private int NBButtons;

	
	public MainPanel(Map p_map)
	{
		this.map = p_map;
		this.NBButtons = map.getNumberOfColumns()*map.getNumberOfRows();
		this.setLayout(null);
		
		gamePanel = new JPanel(new GridLayout(map.getNumberOfColumns(),map.getNumberOfRows(),15,10));
		gamePanel.setBounds(0, 0, width/4+50,height/2);
		
		thebuttons = new JButton[NBButtons];
		for ( int i=0 ; i<NBButtons; i++)
		{
			thebuttons[i] = new JButton ( "Button" + i);
			gamePanel.add(thebuttons[i]);
		}
		
		infoPanel = new JPanel(new BorderLayout());
		infoPanel.setBounds(gamePanel.getWidth(), 0, width/4-50 ,height/2);
		infoPanel.setLayout(null);
		
		bouton = new JButton("test2");
		bouton.setBounds(10,10,infoPanel.getWidth()-30,infoPanel.getHeight()-30);
		
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,gamePanel,infoPanel);
		splitPane.setDividerLocation(100);
		
		this.add(gamePanel);
		this.add(infoPanel);
		
		infoPanel.add(bouton);

	}
}
