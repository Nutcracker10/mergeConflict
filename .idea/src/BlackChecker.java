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
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(xcoordinate, ycoordinate, 30, 30);
		g.setColor(Color.BLACK);
		g.fillOval(xcoordinate, ycoordinate, 29, 29);
	}

}
