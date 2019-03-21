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
public class WhiteChecker extends Checker
{	
	private Coordinate whiteCoordinates;
	//holds x coordinates for all possible locations for black checkers
	private int[] xpos = {715, 663, 613, 563, 513, 463, 413, 311, 261, 211, 161, 111, 61, 61, 111, 161, 211, 261, 311, 413, 463, 513, 563, 613, 663, 362};
	//holds y coordinates for all possible locations for black checkers
	private int[] ypos = {535, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 260};
	
	public WhiteChecker(int x, int y)
	{
		whiteCoordinates = new Coordinate(x, y);
		colour = 0;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if(whiteCoordinates.getX() > 663)
			drawInBearOff(g);
		
		else
			drawChecker(g);
	}
	
	private void drawChecker(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(whiteCoordinates.getX(), whiteCoordinates.getY(), 30, 30);
	}
	
	public void setCoordinates(int x, int y)
	{
		whiteCoordinates.setX(x);
		whiteCoordinates.setY(y);
	}
	
	private void drawInBearOff(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(whiteCoordinates.getX(), whiteCoordinates.getY(), 50, 13);
	}

	public Coordinate move(int to, int[] pips)
	{
		whiteCoordinates.setX(xpos[to]);
		
		if(pips[to] == 0)
			whiteCoordinates.setY(ypos[to]);
		
		else
		{
			if((to >= 0) && (to < 13))
				whiteCoordinates.setY((ypos[to]) - (pips[to] * 30)); 
			
			else if(to == 25)
				whiteCoordinates.setY((ypos[to]) - (pips[to] * 15));
			
			else
				whiteCoordinates.setY((ypos[to]) + (pips[to] * 30));
		}
		
		return whiteCoordinates;
	}





}

