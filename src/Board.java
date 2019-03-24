/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
import java.awt.Graphics;
import  java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Board extends JPanel
{
	//how many checkers are on each pip
	//pip[0] holds white checkers
	//pip[1] hold black checker
	public int[][] pips = { {0, 0, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
							{0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0}};

	public int numInWhiteSlot = 0; //varibles to count the number of checkers in player's slots
	public int numInBlackSlot = 0;

	//declare all white checkers
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

	//declare all black checkers
	BlackChecker b1 = new BlackChecker(413, 50);
	BlackChecker b2 = new BlackChecker(413, 80);
	BlackChecker b3 = new BlackChecker(413, 110);
	BlackChecker b4 = new BlackChecker(413, 140);
	BlackChecker b5 = new BlackChecker(413, 170);
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

	//each pip is represented by an ArrayList, as is the bar and bear off
	ArrayList<Checker> bar = new ArrayList<>();
	ArrayList<Checker> s1 = new ArrayList<>();
	ArrayList<Checker> s2 = new ArrayList<>();
	ArrayList<Checker> s3 = new ArrayList<>();
	ArrayList<Checker> s4 = new ArrayList<>();
	ArrayList<Checker> s5 = new ArrayList<>();
	ArrayList<Checker> s6 = new ArrayList<>();
	ArrayList<Checker> s7 = new ArrayList<>();
	ArrayList<Checker> s8 = new ArrayList<>();
	ArrayList<Checker> s9 = new ArrayList<>();
	ArrayList<Checker> s10 = new ArrayList<>();
	ArrayList<Checker> s11 = new ArrayList<>();
	ArrayList<Checker> s12 = new ArrayList<>();
	ArrayList<Checker> s13 = new ArrayList<>();
	ArrayList<Checker> s14 = new ArrayList<>();
	ArrayList<Checker> s15 = new ArrayList<>();
	ArrayList<Checker> s16 = new ArrayList<>();
	ArrayList<Checker> s17 = new ArrayList<>();
	ArrayList<Checker> s18 = new ArrayList<>();
	ArrayList<Checker> s19 = new ArrayList<>();
	ArrayList<Checker> s20 = new ArrayList<>();
	ArrayList<Checker> s21 = new ArrayList<>();
	ArrayList<Checker> s22 = new ArrayList<>();
	ArrayList<Checker> s23 = new ArrayList<>();
	ArrayList<Checker> s24 = new ArrayList<>();
	ArrayList<Checker> bearOff = new ArrayList<>();

	//ArrayList to hold all of the pips, the bar, and the bearoff
	ArrayList<ArrayList<Checker>> board = new ArrayList<ArrayList<Checker>>();

	//constructor
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

		board.add(bearOff);
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
		board.add(bar);
	}

	int whosTurn;//vriable to switch depending on which players turn. 0 for White. 1 for black

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
		    drawSpikeNoWhite(g);

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

	private void drawSpikeNoWhite(Graphics g) //numbers from whites perspective
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
        g.drawString("21", 524, 568);
        g.drawString("23", 624, 568);
        g.drawString("11", 118, 46);
        g.drawString("9", 218, 46);
        g.drawString("7", 318, 46);
        g.drawString("5", 470, 46);
        g.drawString("3", 570, 46);
        g.drawString("1", 670, 46);

        g.setColor(slateGray);
        g.drawString("14", 118, 568);
        g.drawString("16", 222, 568);
        g.drawString("18", 322, 568);
        g.drawString("20", 474, 568);
        g.drawString("22", 574, 568);
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

	//paints the checkers onto the board
	private void placeCheckers(Graphics g)
	{
		for(int i = 0; i < board.size(); i++)
		{
			for(int j = 0; j < board.get(i).size(); j++)
			{
				board.get(i).get(j).paint(g);
			}
		}

		int[] debug = {0,0};
		acceptableMoves(0, debug);
	}

	//converts what black entered in to be switched to a common pip number
	private int blackToWhite(int pip)
	{
		int[] answer = {25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int returned = answer[pip];

		return returned;
	}

	//move method
	public void Move(String colour, int from, int to)
	{
	    if(colour == "Black")
	    {
	    	int blackFrom = blackToWhite(from);
	    	int blackTo = blackToWhite(to);
	    	int i;
	    	BlackChecker moving = new BlackChecker(0,0);

	    	if(pips[1][blackFrom] == 0)
	    		throw new NoCheckerException();

	    	for(i = 1; i <= (board.get(blackFrom).size()); i++)
	    	{
	    		if((board.get(blackFrom).get(board.get(blackFrom).size()-i)).getClass() == BlackChecker.class)
	    		{
	    			moving = (BlackChecker) board.get(blackFrom).get(board.get(blackFrom).size()-i);
	    			break;
	    		}
	    	}

	    	moving.move(blackTo, pips[1]);
		    pips[1][blackFrom]--;
		    pips[1][blackTo]++;
		    board.get(blackTo).add(board.get(blackFrom).remove((board.get(blackFrom).size()-i)));
		    
		    if(pips[0][blackTo] == 1)
		    {
		    	WhiteChecker hit = (WhiteChecker) board.get(blackTo).get(0);
		    	hit.move(25, pips[0]);
		    	pips[0][blackTo]--;
		    	pips[0][25]++;
		    	board.get(25).add(board.get(blackTo).remove(0));
		    	
		    }

		    if(blackTo == 25)	
		    	numInBlackSlot++;
	    }

	    else if(colour == "White")
	    {
	    	WhiteChecker moving = new WhiteChecker(0, 0);
	    	int i;

	    	if(pips[0][from] == 0)
	    		throw new NoCheckerException();

	    	for(i = 1; i <= (board.get(from).size()); i++)
	    	{
	    		if((board.get(from).get(board.get(from).size()-i)).getClass() == WhiteChecker.class)
	    		{
	    			moving = (WhiteChecker) board.get(from).get(board.get(from).size()-i);
	    			break;
	    		}
	    	}

	    	moving.move(to, pips[0]);
	    	pips[0][from]--;
	    	pips[0][to]++;
	    	board.get(to).add(board.get(from).remove((board.get(from).size() - i)));
	    	
	    	if(pips[1][to] == 1)
	    	{
	    		BlackChecker hit = (BlackChecker) board.get(to).get(0);
	    		hit.move(25, pips[1]);
	    		pips[1][to]--;
	    		pips[1][25]++;
	    		board.get(25).add(board.get(to).remove(0));
	    	}

			if(to == 0) //TODO and if the move is valid
				numInWhiteSlot++;
	    }

	}

	public void cheat()
	{
		for(ArrayList<Checker> a : board)
		{
			a.clear();
		}

		w1.setCoordinates(362, 260);
		w2.setCoordinates(362, 230);
		w3.setCoordinates(362, 200);
		w4.setCoordinates(663, 520);
		w5.setCoordinates(663, 490);
		w6.setCoordinates(613, 520);
		w7.setCoordinates(613, 490);
		w8.setCoordinates(563, 520);
		w9.setCoordinates(563, 490);
		w10.setCoordinates(513, 520);
		w11.setCoordinates(513, 490);
		w12.setCoordinates(463, 520);
		w13.setCoordinates(463, 490);
		w14.setCoordinates(715, 535);
		w15.setCoordinates(715, 520);

		b1.setCoordinates(362, 310);
		b2.setCoordinates(362, 340);
		b3.setCoordinates(362, 370);
		b4.setCoordinates(663, 50);
		b5.setCoordinates(663, 80);
		b6.setCoordinates(663, 110);
		b7.setCoordinates(563, 50);
		b8.setCoordinates(563, 80);
		b9.setCoordinates(563, 110);
		b10.setCoordinates(513, 50);
		b11.setCoordinates(513, 80);
		b12.setCoordinates(513, 110);
		b13.setCoordinates(715, 252);
		b14.setCoordinates(715, 237);
		b15.setCoordinates(715, 222);

		bar.add(w1);
		bar.add(w2);
		bar.add(w3);
		bar.add(b1);
		bar.add(b2);
		bar.add(b3);

		s1.add(w4);
		s1.add(w5);

		s2.add(w6);
		s2.add(w7);

		s3.add(w8);
		s3.add(w9);

		s4.add(w10);
		s4.add(w11);

		s5.add(w12);
		s5.add(w13);

		s24.add(b4);
		s24.add(b5);
		s24.add(b6);

		s22.add(b7);
		s22.add(b8);
		s22.add(b9);

		s21.add(b10);
		s21.add(b11);
		s21.add(b12);

		bearOff.add(b13);
		bearOff.add(b14);
		bearOff.add(b15);

		bearOff.add(w14);
		bearOff.add(w15);
		
		
		int[][] changed = {	{2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
							{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 3, 3}};
		pips = changed;
	}

	public Board getBoard()
    {
        return this;
    }

    public String acceptableMoves(int colour, int[] rolls)
    {

        int oppositeColour;
        int addNums;
        if(colour == 0)
            oppositeColour = 1;
        else
            oppositeColour = 0;
        String possibleMoves = "";

		if(colour == 0) {

		    if(pips[colour][25] > 0)  //code for checkers in bar. Must move checkers outside of bar before any other move can be made
		     {

		         if(!(pips[oppositeColour][25 - rolls[0]] >= 1))
		         {
		             addNums = 25 - rolls[0];
		             possibleMoves += "\n" + "Bar" + "-" + addNums;
		         }
		         else if (pips[oppositeColour][25 - rolls[0]] == 1) //if there is a possible hit
		         {
		             addNums = 25 - rolls[0];
                     possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                 }


                 if(!(pips[oppositeColour][25 - rolls[1]] >= 1))
                 {
                     addNums = 25 - rolls[1];
                     possibleMoves += "\n" + "Bar" + "-" + addNums;
                 }
                 else if (pips[oppositeColour][25 - rolls[1]] == 1) //if there is a possible hit
                 {
                     addNums = 25 - rolls[1];
                     possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                 }



                 if(!(pips[oppositeColour][25 - rolls[0] - rolls[1]] >= 1))
                 {
                     addNums = 25 - rolls[0] - rolls[1];
                     possibleMoves += "\n" + "Bar" + "-" + addNums;
                 }
                 else if (pips[oppositeColour][25 - rolls[0] - rolls[1]] == 1) //if there is a possible hit
                 {
                     addNums = 25 - rolls[0] - rolls[1];
                     possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                 }

                if(rolls[0] == rolls[1]) //for doubles
                {
					addNums = 25 - 3*rolls[0];
                	if(!(pips[oppositeColour][addNums] >= 1))
                		possibleMoves += "\n" + "Bar" + "-" + addNums;
                	else if (pips[oppositeColour][addNums] == 1)
						possibleMoves += "\n" + "Bar" + "-" + addNums + "*" ;
					addNums = 25 - 4*rolls[0];
					if(!(pips[oppositeColour][addNums] >= 1))
						possibleMoves += "\n" + "Bar" + "-" + addNums;
					else if (pips[oppositeColour][addNums] == 1)
						possibleMoves += "\n" + "Bar" + "-" + addNums + "*" ;

				}

		     }

            else {
                 for (int j = 25; j > 0; j--) {

                     if (pips[colour][j] != 0) {


                         //possibleMoves not involving hits.
                         if ((j - rolls[0] >= 0) && !(pips[oppositeColour][j - rolls[0]] >= 1)) {
                             addNums = j - rolls[0];
                             if (!(addNums == 0))
                                 possibleMoves += "\n" + j + "-" + addNums;
                             else
                                 possibleMoves += "\n" + j + "-" + "Off";
                         }


                         //possible moves involving hits
                        else if (j - rolls[0] >= 0 && (pips[oppositeColour][j - rolls[0]]) == 1) {
                             addNums = j - rolls[0];
                             if (!(addNums == 0))
                                 possibleMoves += "\n" + j + "-" + addNums + "*";
                             else
                                 possibleMoves += "\n" + j + "-" + "Off" + "*";
                         }

                         if (((j - rolls[1] >= 0) && (rolls[0] != rolls[1]) && !(pips[oppositeColour][j - rolls[1]] >= 1))) {
                             addNums = j - rolls[1];
                             if (!(addNums == 0))
                                 possibleMoves += "\n" + j + "-" + addNums;
                             else
                                 possibleMoves += "\n" + j + "-" + "Off";
                         }

                        else if (j - rolls[1] >= 0 && (pips[oppositeColour][j - rolls[1]]) == 1) {
                             addNums = j - rolls[1];
                             if (!(addNums == 0))
                                 possibleMoves += "\n" + j + "-" + addNums + "*";
                             else
                                 possibleMoves += "\n" + j + "-" + "Off" + "*";
                         }

                         if ((j - rolls[0] - rolls[1] >= 0) && !(pips[oppositeColour][j - rolls[0] - rolls[1]] >= 1)) {
                             addNums = j - rolls[0] - rolls[1];
                             if (!(addNums == 0))
                                 possibleMoves += "\n" + j + "-" + addNums;
                             else
                                 possibleMoves += "\n" + j + "-" + "Off";
                         }


                         else if ((j - rolls[0] - rolls[1] >= 0) && (pips[oppositeColour][j - rolls[0] - rolls[1]]) == 1) {
                             addNums = j - rolls[0] - rolls[1];
                             if (!(addNums == 0))
                                 possibleMoves += "\n" + j + "-" + addNums + "*";
                             else
                                 possibleMoves += "\n" + j + "-" + "Off" + "*";
                         }


                         //possible moves for doubles
                         if (rolls[0] == rolls[1]) {

                             if (j - 3 * rolls[0] >= 0 && !(pips[oppositeColour][j - 3 * rolls[0]] > 1)) {
                                 addNums = j - 3 * rolls[0];
                                 if (!(addNums == 0))
                                     possibleMoves += "\n" + j + "-" + addNums;
                                 else
                                     possibleMoves += "\n" + j + "-" + "Off";
                             }

                             else if (j - 3 * rolls[0] >= 0 && !((pips[oppositeColour][j - 3 * rolls[0]]) == 1)) {
                                 addNums = j - 3 * rolls[0];
                                 if (!(addNums == 0))
                                     possibleMoves += "\n" + j + "-" + addNums + "*";
                                 else
                                     possibleMoves += "\n" + j + "-" + "Off" + "*";
                             }

                             if (j - 4 * rolls[0] >= 0 && !(pips[oppositeColour][j - 4 * rolls[0]] > 1)) {
                                 addNums = j - 4 * rolls[0];
                                 if (!(addNums == 0))
                                     possibleMoves += "\n" + j + "-" + addNums;
                                 else
                                     possibleMoves += "\n" + j + "-" + "Off";
                             }



                            else if (j - 4 * rolls[0] >= 0 && !((pips[oppositeColour][j - 4 * rolls[0]]) == 1)) {
                                 addNums = j - 4 * rolls[0];
                                 if (!(addNums == 0))
                                     possibleMoves += "\n" + j + "-" + addNums + "*";
                                 else
                                     possibleMoves += "\n" + j + "-" + "Off" + "*";
                             }


                         }

                     }
                 }

             }
		}

		else {

			if(pips[colour][25] > 0)
			{
                if(!(pips[oppositeColour][rolls[0] + 1] >= 1))
                {
                    addNums = 25 - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums;

                }
               else if((pips[oppositeColour][rolls[0] + 1] == 1))
                {
                    addNums = 25 - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums + "*";

                }

                if(!(pips[oppositeColour][rolls[1] + 1] >= 1))
                {
                    addNums = 25 - rolls[1];
                    possibleMoves += "\n" + "Bar" + "-" + addNums;

                }
                else if((pips[oppositeColour][rolls[1] + 1] == 1))
                {
                    addNums = 25 - rolls[1];
                    possibleMoves += "\n" + "Bar" + "-" + addNums + "*";

                }

                if(!(pips[oppositeColour][rolls[0]+rolls[1] + 1] >= 1))
                {
                    addNums = 25 - rolls[1] - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums;

                }
                else if((pips[oppositeColour][rolls[0]+rolls[1] + 1] == 1))
                {
                    addNums = 25 - rolls[1] - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums + "*";

                }
			}


		else{
				for (int j = 0; j < 26; j++) {
					if ((pips[colour][j] != 0)) {


						//possible moves not involving hits
						if ((j + rolls[0] < 26) && !((pips[oppositeColour][j + rolls[0]]) > 1)) {
							addNums = ((j + rolls[0]));
							if (addNums == 25)
								possibleMoves += "\n" + (25 - j) + "-" + "Off";
							else
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}

                        //possible moves involving hits
                        else if (j + rolls[0] < 26 && (pips[oppositeColour][j + rolls[0]]) == 1) {
                            addNums = j + rolls[0];
                            if (addNums == 25)
                                possibleMoves += "\n" + (25 - j) + "-" + "Off";
                            else
                                possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                        }

						if ((j + rolls[1] < 26) && !((pips[oppositeColour][j + rolls[1]]) > 1)) {
							addNums = ((j + rolls[1]));
							if (addNums == 25)
								possibleMoves += "\n" + (25 - j) + "-" + "Off";
							else
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}

                        else if (j + rolls[1] < 26 && (pips[oppositeColour][j + rolls[1]]) == 1) {
                            addNums = j + rolls[1];
                            if (addNums == 25)
                                possibleMoves += "\n" + (25 - j) + "-" + "Off";
                            else
                                possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                        }

						if ((j + rolls[0] + rolls[1] < 26) && !((pips[oppositeColour][j + rolls[0] + rolls[1]]) > 1)) {
							addNums = ((j + rolls[0] + rolls[1]));
							if (addNums == 25)
								possibleMoves += "\n" + (25 - j) + "-" + "Off";
							else
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}

                       else if ((j + rolls[0] + rolls[1] < 26) && (pips[oppositeColour][j + rolls[0] + rolls[1]]) == 1) {
                            addNums = j + rolls[0] + rolls[1];
                            if (addNums == 25)
                                possibleMoves += "\n" + (25 - j) + "-" + "Off";
                            else
                                possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                        }

						//moves for doubles
						if (rolls[0] == rolls[1]) {

							if (j + 3 * rolls[0] < 26 && !((pips[oppositeColour][j + 3 * rolls[0]]) > 1)) {
								addNums = j + 3 * rolls[0];
								if (addNums == 25)
									possibleMoves += "\n" + (25 - j) + "-" + "Off";
								else
									possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
							}

                            else if (j + 3 * rolls[0] < 26 && !((pips[oppositeColour][j + 3 * rolls[0]]) == 1)) {
                                addNums = j + 3 * rolls[0];
                                if (addNums == 25)
                                    possibleMoves += "\n" + (25 - j) + "-" + "Off" + "*";
                                else
                                    possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                            }

                            if (j + 4 * rolls[0] < 26 && !((pips[oppositeColour][j + 4 * rolls[0]]) > 1)) {
								addNums = 4 * rolls[0];
								if (addNums == 25)
									possibleMoves += "\n" + (25 - j) + "-" + "Off";
								else
									possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
							}


							else if (j + 4 * rolls[0] < 26 && !((pips[oppositeColour][j + 4 * rolls[0]]) == 1)) {
								addNums = j + 4 * rolls[0];
								if (addNums == 25)
									possibleMoves += "\n" + (25 - j) + "-" + "Off";
								else
									possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
							}


						}
					}
				}
			}
		}
		possibleMoves = dupeRemover(possibleMoves);
        return possibleMoves;
    }

    // a function for removing duplicate moves from the possible moves list
    public String dupeRemover(String moves) {
		String[] moveArray = moves.split("\\n"); // an array for the individual strings
		String newMoves = new String();


		for (int i=0; i<moveArray.length; i++) {
			for (int j = i+1; j<moveArray.length; j++) {
				if (moveArray[i] == moveArray[j] ) {
					j++;
				}
			}
			newMoves += "\n";
			newMoves += moveArray[i];
		} // end of outer for loop

		return newMoves;
	} // end of dupe remover

    public void setWhosTurn(int turn)
    {
        whosTurn = turn;
    }

}
