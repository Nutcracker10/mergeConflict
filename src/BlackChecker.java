/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;

public class BlackChecker extends Checker
{
	private Coordinate blackCoordinates; //coordinates for the checker
	//holds the x coordinate for all possible black checker locations
	private int[] xpos = {715, 663, 613, 563, 513, 463, 413, 311, 261, 211, 161, 111, 61, 61, 111, 161, 211, 261, 311, 413, 463, 513, 563, 613, 663, 362};
	//holds the y coordinate for all possible black checker locations
	private int[] ypos = {252, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 310};
	
	public BlackChecker(int x, int y)
	{
		blackCoordinates = new Coordinate(x, y); //giving the coordinates to object
        colour = 1;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if(blackCoordinates.getX() > 663)
			drawInBearOff(g);
		
		else
			drawChecker(g);
	}

	private void drawChecker(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(blackCoordinates.getX(), blackCoordinates.getY(), 30, 30);
	}
	
	private void drawInBearOff(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(blackCoordinates.getX(), blackCoordinates.getY(), 50, 13);
	}

	public void setCoordinates(int x, int y)
	{
		blackCoordinates.setX(x);
		blackCoordinates.setY(y);
	}
	
	public Coordinate move(int to, int[] pips)
    {
		blackCoordinates.setX(xpos[to]);
		
		if(pips[to] == 0)
			blackCoordinates.setY(ypos[to]);
		
		else
		{
			if((to > 0) && (to < 13))
				blackCoordinates.setY((ypos[to]) - (pips[to] * 30)); 
			
			else if(to == 0)
				blackCoordinates.setY((ypos[to]) - (pips[to] * 15));
			
			else
				blackCoordinates.setY((ypos[to]) + (pips[to] * 30));
		}
		
		return blackCoordinates;
    }



}
