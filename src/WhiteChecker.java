// Class for the checkers
import javax.swing.*;
import java.awt.*;
/*
 * Should draw the checkers and describe how they move??
 */
public class WhiteChecker extends JComponent
{	
	private Coordinate whiteCoordinates;
	
	public WhiteChecker(int x, int y)
	{
		whiteCoordinates = new Coordinate(x, y);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paint(g);
		drawChecker(g);
	}
	
	private void drawChecker(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(whiteCoordinates.getX(), whiteCoordinates.getY(), 30, 30);
	}

	public Coordinate move(int dice)
	{
		whiteCoordinates.setX(whiteCoordinates.getX() + 50);
		return whiteCoordinates;
	}





}

