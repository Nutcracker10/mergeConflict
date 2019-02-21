/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
import java.awt.Graphics;
import  java.awt.*;
import javax.swing.*;

public class Board extends JPanel
{
	 //making this checker global so can making moving method
	WhiteChecker w7 = new WhiteChecker(362, 260);
	BlackChecker b15 = new BlackChecker(362, 310);

	public int[][] pips = { {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0},
							{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0}};

	public void paintComponent(Graphics g)
	{
		this.setSize(780, 600);

		super.paintComponent(g);
		drawBackground(g);
		drawBoard(g);
		drawSpikeNo(g);
		drawBearOff(g);
		drawTrianglesOne(g);
		drawTrianglesTwo(g);
		placeWhiteCheckers(g);
		placeBlackCheckers(g);
	}
	
	private void drawBackground(Graphics g)
	{
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 800, 600);
	}
	
	private void drawBoard(Graphics g)
	{
		//draw outline
		Color brown = new Color(92, 44, 6);
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
	
	private void drawSpikeNo(Graphics g)
	{
		int fontSize = 20;
		Color cream = new Color(245, 222, 179);
		Color slateGray = new Color(112, 128, 144);
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		
		g.setColor(cream);
		g.drawString("13", 68, 46);
		g.drawString("15", 168, 46);
		g.drawString("17", 268, 46);
		g.drawString("19", 420, 46);
		g.drawString("21", 520, 46);
		g.drawString("23", 620, 46);
		g.drawString("11", 118, 568);
		g.drawString("9", 222, 568);
		g.drawString("7", 322, 568);
		g.drawString("5", 474, 568);
		g.drawString("3", 574, 568);
		g.drawString("1", 674, 568);
		
		g.setColor(slateGray);
		g.drawString("14", 118, 46);
		g.drawString("16", 218, 46);
		g.drawString("18", 318, 46);
		g.drawString("20", 470, 46);
		g.drawString("22", 570, 46);
		g.drawString("24", 670, 46);
		g.drawString("12", 68, 568);
		g.drawString("10", 168, 568);
		g.drawString("8", 272, 568);
		g.drawString("6", 424, 568);
		g.drawString("4", 524, 568);
		g.drawString("2", 624, 568);	
	}
	
	private void drawBearOff(Graphics g)
	{
		//Draw two bear off slots
		Color slateGray = new Color(112, 128, 144);
		g.setColor(slateGray);
		g.fillRect(715, 65, 50, 200);
		g.fillRect(715, 335, 50, 200);
	}
	
	private void drawTrianglesOne(Graphics g)
	{
		//Draw all black triangles
		Color slateGray = new Color(112, 128, 144);
		int x1[] = {51, 101, 76};
		int y1[] = {50, 50, 260};
		g.setColor(slateGray);
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
		Color cream = new Color(245, 222, 179);
		g.setColor(cream);
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
	
	private void placeWhiteCheckers(Graphics g)
	{
		//Spike 13
		WhiteChecker w1 = new WhiteChecker(61, 50);
		w1.paintComponent(g);
		WhiteChecker w2 = new WhiteChecker(61, 80);
		w2.paintComponent(g);
		WhiteChecker w3 = new WhiteChecker(61, 110);
		w3.paintComponent(g);
		WhiteChecker w4 = new WhiteChecker(61, 140);
		w4.paintComponent(g);
		WhiteChecker w5 = new WhiteChecker(61, 170);
		w5.paintComponent(g);
		
		//Spike 24
		WhiteChecker w6 = new WhiteChecker(663, 50);
		w6.paintComponent(g);
		w7.paintComponent(g);
		
		//Spike 8
		WhiteChecker w8 = new WhiteChecker(261, 520);
		w8.paintComponent(g);
		WhiteChecker w9 = new WhiteChecker(261, 490);
		w9.paintComponent(g);
		WhiteChecker w10 = new WhiteChecker(261, 460);
		w10.paintComponent(g);

		//Spike 6
		WhiteChecker w11 = new WhiteChecker(413, 520);
		w11.paintComponent(g);
		WhiteChecker w12 = new WhiteChecker(413, 490);
		w12.paintComponent(g);
		WhiteChecker w13 = new WhiteChecker(413, 460);
		w13.paintComponent(g);
		WhiteChecker w14 = new WhiteChecker(413, 430);
		w14.paintComponent(g);
		WhiteChecker w15 = new WhiteChecker(413, 400);
		w15.paintComponent(g);	
	}
	
	private void placeBlackCheckers(Graphics g)
	{
		//Spike 17
		BlackChecker b1 = new BlackChecker(261, 50);
		b1.paintComponent(g);
		BlackChecker b2 = new BlackChecker(261, 80);
		b2.paintComponent(g);
		BlackChecker b3 = new BlackChecker(261, 110);
		b3.paintComponent(g);
		
		//Spike 19
		BlackChecker b4 = new BlackChecker(413, 50);
		b4.paintComponent(g);
		BlackChecker b5 = new BlackChecker(413, 80);
		b5.paintComponent(g);
		BlackChecker b6 = new BlackChecker(413, 110);
		b6.paintComponent(g);
		BlackChecker b7 = new BlackChecker(413, 140);
		b7.paintComponent(g);
		BlackChecker b8 = new BlackChecker(413, 170);
		b8.paintComponent(g);
		
		//Spike 12
		BlackChecker b9 = new BlackChecker(61, 520);
		b9.paintComponent(g);
		BlackChecker b10 = new BlackChecker(61, 490);
		b10.paintComponent(g);
		BlackChecker b11 = new BlackChecker(61, 460);
		b11.paintComponent(g);
		BlackChecker b12 = new BlackChecker(61, 430);
		b12.paintComponent(g);
		BlackChecker b13 = new BlackChecker(61, 400);
		b13.paintComponent(g);
		
		//Spike 1
		BlackChecker b14 = new BlackChecker(663, 520);
		b14.paintComponent(g);
		b15.paintComponent(g);
	}

	public void Moving(int from, int to) //testing that I can move a black checker
	{
	    b15.move(from, to, pips[1]);
	    pips[1][from]--;
	    pips[1][to]++;
	    w7.move(from, to, pips[0]);
	    pips[0][from]--;
	    pips[0][to]++;
	}


}