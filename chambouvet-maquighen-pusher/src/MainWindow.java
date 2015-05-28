
import java.awt.*;

import javax.swing.*;


public class MainWindow extends JFrame
{
	Toolkit tk =Toolkit.getDefaultToolkit();
	Dimension dimEcran = tk.getScreenSize();
	
	int width = dimEcran.width;
	int height = dimEcran.height;
	MainPanel pan;

	
	
	public MainWindow(Map p_map, DisplayGUI display)
	{
		setTitle("Affichage Partie");
		setSize(width/2+180,height/2+150);
		pan = new MainPanel(p_map,display);
		getContentPane().add(pan);
		this.setResizable(false);
		pan.updateLayout();
	}
	
	
}
