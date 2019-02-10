import javax.swing.*;
import java.awt.*;

public class BlackChecker extends JComponent
{
	private Coordinate blackCoordinates; //coordinates for the checker
	
	public BlackChecker(int x, int y)
	{
		blackCoordinates = new Coordinate(x, y); //giving the co ordinates to object

	}
	
	public void paintComponent(Graphics g)
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
		g.fillRect(715, 252, 50, 13);
	}


	public Coordinate move(int dice)
    {
        blackCoordinates.setX(blackCoordinates.getX() - 50); //moves checker to the left

        return blackCoordinates;
    }



}
