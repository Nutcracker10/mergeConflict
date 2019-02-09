// Class for the checkers
import javax.swing.*;
import java.awt.*;
/*
 * Should draw the checkers and describe how they move??
 */
public class WhiteChecker extends JComponent
{	
	private int xcoordinate, ycoordinate;
	
	public WhiteChecker(int x, int y)
	{
		xcoordinate = x;
		ycoordinate = y;
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(xcoordinate, ycoordinate, 30, 30);
		g.setColor(Color.WHITE);
		g.fillOval(xcoordinate, ycoordinate, 29, 29);
	}
}

