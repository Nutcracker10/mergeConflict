import javax.swing.*;
import java.awt.*;

public class BlackChecker extends JComponent
{
	public BlackChecker()
	{
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(0,0, 30, 30);
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 29, 29);
	}

}
