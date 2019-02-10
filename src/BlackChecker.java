import javax.swing.*;
import java.awt.*;

public class BlackChecker extends JComponent
{
	private Coordinate blackCoordinates;
	
	public BlackChecker(int x, int y)
	{
		blackCoordinates.setX(x);
		blackCoordinates.setY(y);

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

}
