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
		
		if(whiteCoordinates.getX() > 663)
		{
			drawInBearOff(g);
		}
		else
			drawChecker(g);
	}
	
	private void drawChecker(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(whiteCoordinates.getX(), whiteCoordinates.getY(), 30, 30);
	}
	
	private void drawInBearOff(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(715, 252, 50, 13);
	}

	public Coordinate move(int dice)
	{
		if((whiteCoordinates.getX()) == 362 && (whiteCoordinates.getY() == 260))
		{
			whiteCoordinates.setX(663);
			whiteCoordinates.setY(50);
		}
		
		else if((whiteCoordinates.getY() == 50))
		{
			whiteCoordinates.setX(whiteCoordinates.getX() - 50);
			
			if(whiteCoordinates.getX() < 61)
			{
				whiteCoordinates.setX(61);
				whiteCoordinates.setY(550);
			}
		}
		
		return whiteCoordinates;
	}





}

