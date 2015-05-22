import java.awt.*;

import javax.swing.*;


public class MainPanel extends JPanel
{
	private JPanel gamePanel;
	private JPanel infoPanel;
	private JSplitPane splitPane;
	private JButton bouton;
	private JButton bouton2;
	Toolkit tk =Toolkit.getDefaultToolkit();
	Dimension dimEcran = tk.getScreenSize();
	
	int width = dimEcran.width;
	int height = dimEcran.height;
	
	public MainPanel()
	{
		this.setLayout(null);
		
		gamePanel = new JPanel(new BorderLayout());
		gamePanel.setBounds(0, 0, width/4+50,height/2);
		gamePanel.setLayout(null);
	
		bouton = new JButton("test");
		bouton.setBounds(10,10,gamePanel.getWidth()-30,gamePanel.getHeight()-30);
		
		
		infoPanel = new JPanel(new BorderLayout());
		infoPanel.setBounds(gamePanel.getWidth(), 0, width/4-50 ,height/2);
		infoPanel.setLayout(null);
		
		bouton2 = new JButton("test2");
		bouton2.setBounds(10,10,infoPanel.getWidth()-30,infoPanel.getHeight()-30);
		
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,gamePanel,infoPanel);
		splitPane.setDividerLocation(100);
		splitPane.setOneTouchExpandable(true);
		this.add(gamePanel);
		this.add(infoPanel);
		gamePanel.add(bouton);
		infoPanel.add(bouton2);

	}
}
