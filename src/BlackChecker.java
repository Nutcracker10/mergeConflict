import javax.swing.*;
import java.awt.*;

public class BlackChecker extends JComponent
{
	private int xcoordinate, ycoordinate;
	
	public BlackChecker(int x, int y)
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
		g.setColor(Color.BLACK);
		g.fillOval(xcoordinate, ycoordinate, 30, 30);
	}

}
