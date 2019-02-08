import java.awt.*;
import javax.swing.*;

public class Board extends Canvas
{
	public void paint(Graphics g)
	{
		super.paint(g);
		drawBackground(g);
		drawBoard(g);
		drawBearOff(g);
		//drawTrianglesOne(g);
		//drawTrianglesTwo(g);
		
	}
	
	private void drawBackground(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 800, 600);
	}
	
	private void drawBoard(Graphics g)
	{
		//draw outline
		Color brown = new Color(139, 69, 19);
		g.setColor(brown);
		g.fillRect(25, 25, 750, 550);
		
		//draw board
		Color darkRed = new Color(139, 0, 0);
		g.setColor(darkRed);
		g.fillRect(50, 50, 655, 500);
		
		//Draw brown bar in the middle
		g.setColor(brown);
		g.fillRect(352, 50, 50, 500);
	}
	
	private void drawBearOff(Graphics g)
	{
		//Draw two bear off slots
		Color brown = new Color(0, 0, 0);
		g.setColor(brown);
		g.fillRect(715, 65, 50, 200);
		g.fillRect(715, 335, 50, 200);
	}
	
	private void drawTrianglesOne(Graphics g)
	{
		//TODO
		//Draw all black triangles
	}
	
	private void drawTrianglesTwo(Graphics g)
	{
		//TODO
		//Draw all white triangles
	}
	
}
