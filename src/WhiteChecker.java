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
	
	public void paintComponent(Graphics g)
	{

		super.paint(g);
		drawChecker(g);
	}
	
	private void drawChecker(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(xcoordinate, ycoordinate, 30, 30);
	}






}

