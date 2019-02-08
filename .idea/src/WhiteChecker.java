// Class for the checkers
import javax.swing.*;
import java.awt.*;
/*
 * Should draw the checkers and describe how they move??
 */
public class WhiteChecker extends JComponent
{	
	public WhiteChecker()
	{
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(0,0, 30, 30);
		g.setColor(Color.WHITE);
		g.fillOval(0, 0, 29, 29);
	}
}

