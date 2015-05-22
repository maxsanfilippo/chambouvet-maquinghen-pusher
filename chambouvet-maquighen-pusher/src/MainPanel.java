import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class MainPanel extends JPanel
{
	private JPanel gamePanel;
	private JPanel infoPanel;
	private JSplitPane splitPane;
	private JButton bouton1;
	private JButton bouton2;
	Toolkit tk =Toolkit.getDefaultToolkit();
	Dimension dimEcran = tk.getScreenSize();
	
	int width = dimEcran.width;
	int height = dimEcran.height;
	
	public MainPanel()
	{
		
		gamePanel = new JPanel(new BorderLayout());
		gamePanel.setBounds(0, 0, 500,500);
		
		
		bouton1 = new JButton("test");
		bouton1.setBounds(width/2, height/2, 10,10);
		gamePanel.add(bouton1);
		
		infoPanel = new JPanel(new BorderLayout());
		infoPanel.setBounds(500, 0, width/2 ,height/2);
		
		bouton2 = new JButton("test2");
	//	bouton2.setBounds(width/2, height/2, 0, 0);
		infoPanel.add(bouton2);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,gamePanel,infoPanel);
		splitPane.setDividerLocation(300);
		splitPane.setOneTouchExpandable(true);
		this.add(splitPane);
	
		

	}
}
