
import java.awt.*;

import javax.swing.*;


public class MainWindow extends JFrame
{
	Toolkit tk =Toolkit.getDefaultToolkit();
	Dimension dimEcran = tk.getScreenSize();
	
	int width = dimEcran.width;
	int height = dimEcran.height;
	MainPanel pan;

	
	
	public MainWindow()
	{
		setTitle("Affichage Partie");
		setSize(width/2+20,height/2+30);
		pan = new MainPanel();
		getContentPane().add(pan);
		
	}
	
	
}
