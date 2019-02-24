/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
import java.awt.Graphics;
import  java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Board extends JPanel
{
	public int[][] pips = { {0, 0, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
							{0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0}};

	WhiteChecker w1 = new WhiteChecker(413, 520);
	WhiteChecker w2 = new WhiteChecker(413, 490);
	WhiteChecker w3 = new WhiteChecker(413, 460);
	WhiteChecker w4 = new WhiteChecker(413, 430);
	WhiteChecker w5 = new WhiteChecker(413, 400);
	WhiteChecker w6 = new WhiteChecker(261, 520);
	WhiteChecker w7 = new WhiteChecker(261, 490);
	WhiteChecker w8 = new WhiteChecker(261, 460);
	WhiteChecker w9 = new WhiteChecker(61, 50);
	WhiteChecker w10 = new WhiteChecker(61, 80);
	WhiteChecker w11 = new WhiteChecker(61, 110);
	WhiteChecker w12 = new WhiteChecker(61, 140);
	WhiteChecker w13 = new WhiteChecker(61, 170);
	WhiteChecker w14 = new WhiteChecker(663, 50);
	WhiteChecker w15 = new WhiteChecker(663, 80);

	BlackChecker b1 = new BlackChecker(413, 80);
	BlackChecker b2 = new BlackChecker(413, 110);
	BlackChecker b3 = new BlackChecker(413, 140);
	BlackChecker b4 = new BlackChecker(413, 170);
	BlackChecker b5 = new BlackChecker(413, 50);
	BlackChecker b6 = new BlackChecker(261, 50);
	BlackChecker b7 = new BlackChecker(261, 80);
	BlackChecker b8 = new BlackChecker(261, 110);
	BlackChecker b9 = new BlackChecker(61, 520);
	BlackChecker b10 = new BlackChecker(61, 490);
	BlackChecker b11 = new BlackChecker(61, 460);
	BlackChecker b12 = new BlackChecker(61, 430);
	BlackChecker b13 = new BlackChecker(61, 400);
	BlackChecker b14 = new BlackChecker(663, 520);
	BlackChecker b15 = new BlackChecker(663, 490);
	
	ArrayList<Component> bar = new ArrayList<>();
	ArrayList<Component> s1 = new ArrayList<>();
	ArrayList<Component> s2 = new ArrayList<>();
	ArrayList<Component> s3 = new ArrayList<>();
	ArrayList<Component> s4 = new ArrayList<>();
	ArrayList<Component> s5 = new ArrayList<>();
	ArrayList<Component> s6 = new ArrayList<>();
	ArrayList<Component> s7 = new ArrayList<>();
	ArrayList<Component> s8 = new ArrayList<>();
	ArrayList<Component> s9 = new ArrayList<>();
	ArrayList<Component> s10 = new ArrayList<>();
	ArrayList<Component> s11 = new ArrayList<>();
	ArrayList<Component> s12 = new ArrayList<>();
	ArrayList<Component> s13 = new ArrayList<>();
	ArrayList<Component> s14 = new ArrayList<>();
	ArrayList<Component> s15 = new ArrayList<>();
	ArrayList<Component> s16 = new ArrayList<>();
	ArrayList<Component> s17 = new ArrayList<>();
	ArrayList<Component> s18 = new ArrayList<>();
	ArrayList<Component> s19 = new ArrayList<>();
	ArrayList<Component> s20 = new ArrayList<>();
	ArrayList<Component> s21 = new ArrayList<>();
	ArrayList<Component> s22 = new ArrayList<>();
	ArrayList<Component> s23 = new ArrayList<>();
	ArrayList<Component> s24 = new ArrayList<>();
	ArrayList<Component> bearOff = new ArrayList<>();
	
	ArrayList<ArrayList<Component>> board = new ArrayList<ArrayList<Component>>();
	
	public Board()
	{
		s1.add(b14);
		s1.add(b15);
		
		s6.add(w1);
		s6.add(w2);
		s6.add(w3);
		s6.add(w4);
		s6.add(w5);
		
		s8.add(w6);
		s8.add(w7);
		s8.add(w8);
		
		s12.add(b9);
		s12.add(b10);
		s12.add(b11);
		s12.add(b12);
		s12.add(b13);
		
		s13.add(w9);
		s13.add(w10);
		s13.add(w11);
		s13.add(w12);
		s13.add(w13);
		
		s17.add(b6);
		s17.add(b7);
		s17.add(b8);
		
		s19.add(b1);
		s19.add(b2);
		s19.add(b3);
		s19.add(b4);
		s19.add(b5);
		
		s24.add(w14);
		s24.add(w15);
		
		board.add(bar);
		board.add(s1);
		board.add(s2);
		board.add(s3);
		board.add(s4);
		board.add(s5);
		board.add(s6);
		board.add(s7);
		board.add(s8);
		board.add(s9);
		board.add(s10);
		board.add(s11);
		board.add(s12);
		board.add(s13);
		board.add(s14);
		board.add(s15);
		board.add(s16);
		board.add(s17);
		board.add(s18);
		board.add(s19);
		board.add(s20);
		board.add(s21);
		board.add(s22);
		board.add(s23);
		board.add(s24);
		board.add(bearOff);
	}

	int whosTurn = 0; //varible to switich depending on which players turn. 0 for White. 1 for black

	public void paintComponent(Graphics g)
	{
		this.setSize(780, 600);

		super.paintComponent(g);
		drawBackground(g);
		drawBoard(g);
		drawBearOff(g);
		drawTrianglesOne(g);
		drawTrianglesTwo(g);
		placeCheckers(g);
		if(whosTurn == 0)
		{
		    drawSpikeNoWhite(g);
        }
		else
		    drawSpikeNoBlack(g);
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
	
	private void drawSpikeNoWhite(Graphics g) //numbers from whites persective
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

    private void drawSpikeNoBlack(Graphics g)  //numbers from black's perspective
    {
        int fontSize = 20;
        Color cream = new Color(245, 222, 179);
        Color slateGray = new Color(112, 128, 144);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

        g.setColor(cream);
        g.drawString("13", 68, 568);
        g.drawString("15", 168, 568);
        g.drawString("17", 272, 568);
        g.drawString("19", 424, 568);
        g.drawString("21",  524, 568);
        g.drawString("23", 624, 568);
        g.drawString("11", 118, 46);
        g.drawString("9", 218, 46);
        g.drawString("7",  318, 46);
        g.drawString("5", 470, 46);
        g.drawString("3",  570, 46);
        g.drawString("1", 670, 46);

        g.setColor(slateGray);
        g.drawString("14", 118, 568);
        g.drawString("16", 222, 568);
        g.drawString("18", 322, 568);
        g.drawString("20",  474, 568);
        g.drawString("22",  574, 568);
        g.drawString("24", 674, 568);
        g.drawString("12", 68, 46);
        g.drawString("10", 168, 46);
        g.drawString("8", 268, 46);
        g.drawString("6", 420, 46);
        g.drawString("4", 520, 46);
        g.drawString("2", 620, 46);
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
	
	private void placeCheckers(Graphics g)
	{
		for(int i = 0; i < board.size(); i++)
		{
			for(int j = 0; j < board.get(i).size(); j++)
			{
				board.get(i).get(j).paint(g);
			}
		}	
	}
	
	private int blackToWhite(int pip)
	{
		int[] answer = {0, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 25};
		int returned = answer[pip];
		
		return returned;
	}

	public void Moving(int from, int to) //testing that I can move a black checker
	{
	    if((board.get(from).get(board.get(from).size() - 1).getClass()) == BlackChecker.class)
	    {
	    	BlackChecker moving = (BlackChecker) board.get(from).get(board.get(from).size()-1);
	    	moving.move(from, to, pips[1]);
		    pips[1][from]--;
		    pips[1][to]++;
		    board.get(to).add(board.get(from).remove((board.get(from).size()-1)));
	    }

	    int whiteFrom = blackToWhite(from);
	    int whiteTo = blackToWhite(to);
	    
	    if((board.get(whiteFrom).size() - 1) >= 0)
	    {
		    if((board.get(whiteFrom).get(board.get(whiteFrom).size() - 1).getClass()) == WhiteChecker.class)
		    {
		    	WhiteChecker moving = (WhiteChecker) board.get(whiteFrom).get(board.get(whiteFrom).size() - 1);
		    	moving.move(whiteTo, pips[0]);
		    	pips[0][whiteFrom]--;
		    	pips[0][whiteTo]++;
		    	board.get(whiteTo).add(board.get(whiteFrom).remove((board.get(whiteFrom).size() - 1)));
		    }
	    }
	}


	public Board getBoard()
    {
        return this;
    }


}
