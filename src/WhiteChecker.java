/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
// Class for the checkers
import javax.swing.*;
import java.awt.*;
/*
 * Should draw the checkers and describe how they move??
 */
public class WhiteChecker extends JComponent
{	
	private Coordinate whiteCoordinates;
	private int[] xpos = {362, 663, 613, 563, 513, 463, 413, 311, 261, 211, 161, 111, 61, 61, 111, 161, 211, 261, 311, 413, 463, 513, 563, 613, 663, 715};
	private int[] ypos = {260,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 535};
	
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
		g.fillRect(715, 535, 50, 13);
	}

	public Coordinate move(int from, int to, int[] pips)
	{
		whiteCoordinates.setX(xpos[to]);
		
		if(pips[to] == 0)
			whiteCoordinates.setY(ypos[to]);
		
		else
		{
			if((to > 0) && (to < 13))
				whiteCoordinates.setY((ypos[to]) + (pips[to] * 30)); 
			
			else
				whiteCoordinates.setY((ypos[to]) - (pips[to] * 30));
		}
		
		return whiteCoordinates;
	}





}

