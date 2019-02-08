import java.awt.*;

public class Board extends Canvas
{
	public void paint(Graphics g)
	{
		super.paint(g);
		drawBackground(g);
		drawBoard(g);
		drawBearOff(g);
		drawTrianglesOne(g);
		drawTrianglesTwo(g);
		
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
		//Draw all black triangles
		int x1[] = {51, 101, 76};
		int y1[] = {50, 50, 260};
		g.setColor(Color.BLACK);
		g.fillPolygon(x1, y1, 3);
		
		int x2[] = {151, 201, 176};
		g.fillPolygon(x2, y1, 3);
		
		int x3[] = {251, 301, 276};
		g.fillPolygon(x3, y1, 3);
		
		int x4[] = {403, 453, 428};
		g.fillPolygon(x4, y1, 3);
		
		int x5[] = {503, 553, 528};
		g.fillPolygon(x5, y1, 3);
		
		int x6[] = {603, 653, 628};
		g.fillPolygon(x6, y1, 3);
		
		int y2[] = {550, 550, 340};
		int x7[] = {101, 151, 126};
		g.fillPolygon(x7, y2, 3);
		
		int x8[] = {201, 251, 226};
		g.fillPolygon(x8, y2, 3);
		
		int x9[] = {301, 351, 326};
		g.fillPolygon(x9, y2, 3);
		
		int x10[] = {453, 503, 478};
		g.fillPolygon(x10, y2, 3);
		
		int x11[] = {553, 603, 578};
		g.fillPolygon(x11, y2, 3);
		
		int x12[] = {653, 703, 678};
		g.fillPolygon(x12, y2, 3);
	}
	
	private void drawTrianglesTwo(Graphics g)
	{
		//Draw all white triangles
		g.setColor(Color.WHITE);
		int y1[] = {50, 50, 260};
		int x1[] = {101, 151, 126};
		g.fillPolygon(x1, y1, 3);
		
		int x2[] = {201, 251, 226};
		g.fillPolygon(x2, y1, 3);
		
		int x3[] = {301, 351, 326};
		g.fillPolygon(x3, y1, 3);
		
		int x4[] = {453, 503, 478};
		g.fillPolygon(x4, y1, 3);
		
		int x5[] = {553, 603, 578};
		g.fillPolygon(x5, y1, 3);
		
		int x6[] = {653, 703, 678};
		g.fillPolygon(x6, y1, 3);
		
		int y2[] = {550, 550, 340};
		int x7[] = {51, 101, 76};
		g.fillPolygon(x7, y2, 3);
		
		int x8[] = {151, 201, 176};
		g.fillPolygon(x8, y2, 3);
		
		int x9[] = {251, 301, 276};
		g.fillPolygon(x9, y2, 3);
		
		int x10[] = {403, 453, 428};
		g.fillPolygon(x10, y2, 3);
		
		int x11[] = {503, 553, 528};
		g.fillPolygon(x11, y2, 3);
		
		int x12[] = {603, 653, 628};
		g.fillPolygon(x12, y2, 3);
	}
	
}
