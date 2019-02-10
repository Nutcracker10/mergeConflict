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
		if((blackCoordinates.getX()) == 362 && (blackCoordinates.getY() == 310))
		{
			blackCoordinates.setX(663);
			blackCoordinates.setY(520);
		}

		else if((blackCoordinates.getY() == 520))
		{
			blackCoordinates.setX(blackCoordinates.getX() - 50);

			if(blackCoordinates.getX() < 61)
			{
				blackCoordinates.setX(61);
				blackCoordinates.setY(50);
			}

			if(blackCoordinates.getX() == 363)
			{
				blackCoordinates.setX(blackCoordinates.getX() - 50);
			}
		}

		else if((blackCoordinates.getY() == 50))
		{
			blackCoordinates.setX(blackCoordinates.getX() + 50);

			if(blackCoordinates.getX() == 361)
				blackCoordinates.setX(blackCoordinates.getX() + 50);
		}

        return blackCoordinates;
    }



}
