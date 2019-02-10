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
		drawChecker(g);
	}



	private void drawChecker(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(blackCoordinates.getX(), blackCoordinates.getY(), 30, 30);
	}


	public Coordinate move(int dice)
    {


       /* if(blackCoordinates.getX() == 311)
			blackCoordinates.setX(blackCoordinates.getX() + 100); //to jump over the bar
		else if(blackCoordinates.getX() == 413)
			blackCoordinates.setX(blackCoordinates.getX() + 100);
		else if(blackCoordinates.getX() == 61)
		{

		}

		else
			blackCoordinates.setX(blackCoordinates.getX() + 50); //moves checker to the left
	*/
        return blackCoordinates;
    }



}
