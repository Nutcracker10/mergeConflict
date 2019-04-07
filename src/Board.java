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
	//how many checkers are on each pip
	//pip[0] holds white checkers
	//pip[1] hold black checker
	public int[][] pips = { {0, 0, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
							{0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0}};
	public int[][] restartCopy = pips;

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
		g.fillRect(715, 60, 50, 225);
		g.fillRect(715, 315, 50, 225);
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
		int[] answer = {0, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 25};

		return answer[pip];
	}

	//move method
	void Move(String colour, int from, int to)
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

		    if(blackTo == 0)	
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

			if(to == 0)
				numInWhiteSlot++;
	    }

	}

	void cheat()
	{
		for(ArrayList<Checker> a : board)
		{
			a.clear();
		}

		w1.setCoordinates(662, 490);
		w2.setCoordinates(662, 520);
		w3.setCoordinates(715, 345);
		w4.setCoordinates(715, 360);
		w5.setCoordinates(715, 375);
		w6.setCoordinates(715, 390);
		w7.setCoordinates(715, 405);
		w8.setCoordinates(715, 420);
		w9.setCoordinates(715, 435);
		w10.setCoordinates(715, 450);
		w11.setCoordinates(715, 465);
		w12.setCoordinates(715, 480);
		w13.setCoordinates(715, 495);
		w14.setCoordinates(715, 510);
		w15.setCoordinates(715, 525);

		b1.setCoordinates(662, 80);
		b2.setCoordinates(662, 50);
		b3.setCoordinates(715, 90);
		b4.setCoordinates(715, 105);
		b5.setCoordinates(715, 120);
		b6.setCoordinates(715, 135);
		b7.setCoordinates(715, 150);
		b8.setCoordinates(715, 165);
		b9.setCoordinates(715, 180);
		b10.setCoordinates(715, 195);
		b11.setCoordinates(715, 210);
		b12.setCoordinates(715, 225);
		b13.setCoordinates(715, 240);
		b14.setCoordinates(715, 255);
		b15.setCoordinates(715, 270);

		s1.add(w1);
		s1.add(w2);
		bearOff.add(w3);
		bearOff.add(w4);
		bearOff.add(w5);
		bearOff.add(w6);
		bearOff.add(w7);
		bearOff.add(w8);
		bearOff.add(w9);
		bearOff.add(w10);
		bearOff.add(w11);
		bearOff.add(w12);
		bearOff.add(w13);
		bearOff.add(w14);
		bearOff.add(w15);
		
		s24.add(b2);
		s24.add(b1);
		bearOff.add(b3);
		bearOff.add(b4);
		bearOff.add(b5);
		bearOff.add(b6);
		bearOff.add(b7);
		bearOff.add(b8);
		bearOff.add(b9);
		bearOff.add(b10);
		bearOff.add(b11);
		bearOff.add(b12);
		bearOff.add(b13);
		bearOff.add(b14);
		bearOff.add(b15);
		
		int[][] changed = {	{13, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0}};
		pips = changed;
		numInBlackSlot = 13;
		numInWhiteSlot = 13;
	}

	public Board getBoard()
    {
        return this;
    }

    String acceptableMoves(int colour, int[] rolls)
    {

    	if(rolls[0] ==0 && rolls[1] == 0)
    		return "";
        int oppositeColour;
        int addNums;
        if(colour == 0)
            oppositeColour = 1;
        else
            oppositeColour = 0;
        String possibleMoves = "";

		if(colour == 0) 
		{

		    if(pips[colour][25] > 0)  //code for checkers in bar. Must move checkers outside of bar before any other move can be made
		     {

		         if(!((pips[oppositeColour][25 - rolls[0]]) >= 1))
		         {
		             addNums = 25 - rolls[0];
		             possibleMoves += "\n" + "Bar" + "-" + addNums;
		         }
		         else if ((pips[oppositeColour][25 - rolls[0]]) == 1) //if there is a possible hit
		         {
		             addNums = 25 - rolls[0];
                     possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                 }

                 if(!((pips[oppositeColour][25 - rolls[1]]) >= 1))
                 {
                     addNums = 25 - rolls[1];
                     possibleMoves += "\n" + "Bar" + "-" + addNums;
                 }
                 else if ((pips[oppositeColour][25 - rolls[1]]) == 1) //if there is a possible hit
                 {
                     addNums = 25 - rolls[1];
                     possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                 }

                 if(!((pips[oppositeColour][25 - rolls[0] - rolls[1]]) >= 1))
                 {
                     addNums = 25 - rolls[0] - rolls[1];
                     possibleMoves += "\n" + "Bar" + "-" + addNums;
                 }
                 else if ((pips[oppositeColour][25 - rolls[0] - rolls[1]]) == 1) //if there is a possible hit
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

		    //allows checkers into bear off if all checkers are in the home base
		    else if(pips[colour][0] + pips[colour][1] + pips[colour][2] + pips[colour][3] + pips[colour][4] + pips[colour][5] + pips[colour][6] == 15)
		    {
		    	for (int j = 25; j > 0; j--)
		    	{

                    if (pips[colour][j] != 0)
                    {
                        //possibleMoves not involving hits.
                        if (((j - rolls[0]) >= 0) && !(pips[oppositeColour][j - rolls[0]] >= 1))
                        {
                            addNums = j - rolls[0];
                            if (!(addNums <= 0))
                                possibleMoves += "\n" + j + "-" + addNums;
                            else
                                possibleMoves += "\n" + j + "-" + "Off";
                        }


                        //possible moves involving hits
                       else if (((j - rolls[0]) >= 0) && (pips[oppositeColour][j - rolls[0]]) == 1)
                       {
                            addNums = j - rolls[0];
                            if (!(addNums <= 0))
                                possibleMoves += "\n" + j + "-" + addNums + "*";
                            else
                                possibleMoves += "\n" + j + "-" + "Off" + "*";
                        }

                        if (((j - rolls[1] >= 0) && (rolls[0] != rolls[1]) && !(pips[oppositeColour][j - rolls[1]] >= 1)))
                        {
                            addNums = j - rolls[1];
                            if (!(addNums <= 0))
                                possibleMoves += "\n" + j + "-" + addNums;
                            else
                                possibleMoves += "\n" + j + "-" + "Off";
                        }

                       else if (((j - rolls[1]) >= 0) && (pips[oppositeColour][j - rolls[1]]) == 1)
                       {
                            addNums = j - rolls[1];
                            if (!(addNums <= 0))
                                possibleMoves += "\n" + j + "-" + addNums + "*";
                            else
                                possibleMoves += "\n" + j + "-" + "Off";
                        }

                        if (((j - rolls[0] - rolls[1]) >= 0) && !(pips[oppositeColour][j - rolls[0] - rolls[1]] >= 1))
                        {
                            addNums = j - rolls[0] - rolls[1];
                            if (!(addNums <= 0))
                                possibleMoves += "\n" + j + "-" + addNums;
                            else
                                possibleMoves += "\n" + j + "-" + "Off";
                        }


                        else if (((j - rolls[0] - rolls[1]) >= 0) && (pips[oppositeColour][j - rolls[0] - rolls[1]]) == 1)
                        {
                            addNums = j - rolls[0] - rolls[1];
                            if (!(addNums <= 0))
                                possibleMoves += "\n" + j + "-" + addNums + "*";
                            else
                                possibleMoves += "\n" + j + "-" + "Off";
                        }

                        //possible moves for doubles
                        if (rolls[0] == rolls[1])
                        {

                            if (((j - 3 * rolls[0]) >= 0) && !(pips[oppositeColour][j - 3 * rolls[0]] >= 1))
                            {
                                addNums = j - 3 * rolls[0];
                                if (!(addNums <= 0))
                                    possibleMoves += "\n" + j + "-" + addNums;
                                else
                                    possibleMoves += "\n" + j + "-" + "Off";
                            }

                            else if (((j - 3 * rolls[0]) >= 0) && !((pips[oppositeColour][j - 3 * rolls[0]]) == 1))
                            {
                                addNums = j - 3 * rolls[0];
                                if (!(addNums <= 0))
                                    possibleMoves += "\n" + j + "-" + addNums + "*";
                                else
                                    possibleMoves += "\n" + j + "-" + "Off";
                            }

                            if (((j - 4 * rolls[0] )>= 0) && !(pips[oppositeColour][j - 4 * rolls[0]] >= 1))
                            {
                                addNums = j - 4 * rolls[0];
                                if (!(addNums <= 0))
                                    possibleMoves += "\n" + j + "-" + addNums;
                                else
                                    possibleMoves += "\n" + j + "-" + "Off";
                            }

                           else if (((j - 4 * rolls[0]) >= 0) && !((pips[oppositeColour][j - 4 * rolls[0]]) == 1))
                           {
                                addNums = j - 4 * rolls[0];
                                if (!(addNums <= 0))
                                    possibleMoves += "\n" + j + "-" + addNums + "*";
                                else
                                    possibleMoves += "\n" + j + "-" + "Off";
                            }
                        }
                    }
		    	}

		    }
            else 
            {
                 for (int j = 25; j > 0; j--) 
                 {

                     if (pips[colour][j] != 0) 
                     {
                         //possibleMoves not involving hits.
                         if (((j - rolls[0] >= 0)) && !(pips[oppositeColour][j - rolls[0]] >= 1))
                         {
                             addNums = j - rolls[0];
                             if (!(addNums <= 0))
                                 possibleMoves += "\n" + j + "-" + addNums;
                         }

                         //possible moves involving hits
                        else if (((j - rolls[0]) >= 0) && (pips[oppositeColour][j - rolls[0]]) == 1)
                        {
                             addNums = j - rolls[0];
                             if (!(addNums <= 0))
                                 possibleMoves += "\n" + j + "-" + addNums + "*";
                         }

                         if (((j - rolls[1] >= 0) && (rolls[0] != rolls[1]) && !(pips[oppositeColour][j - rolls[1]] >= 1))) 
                         {
                             addNums = j - rolls[1];
                             if (!(addNums <= 0))
                                 possibleMoves += "\n" + j + "-" + addNums;
                         }

                        else if (((j - rolls[1]) >= 0) && (pips[oppositeColour][j - rolls[1]]) == 1)
                        {
                             addNums = j - rolls[1];
                             if (!(addNums <= 0))
                                 possibleMoves += "\n" + j + "-" + addNums + "*";
                         }

                         if (((j - rolls[0] - rolls[1]) >= 0) && !(pips[oppositeColour][j - rolls[0] - rolls[1]] >= 1))
                         {
                             addNums = j - rolls[0] - rolls[1];
                             if (!(addNums <= 0))
                                 possibleMoves += "\n" + j + "-" + addNums;
                         }

                         else if (((j - rolls[0] - rolls[1]) >= 0) && (pips[oppositeColour][j - rolls[0] - rolls[1]]) == 1)
                         {
                             addNums = j - rolls[0] - rolls[1];
                             if (!(addNums <= 0))
                                 possibleMoves += "\n" + j + "-" + addNums + "*";
                         }

                         //possible moves for doubles
                         if (rolls[0] == rolls[1]) 
                         {

                             if (((j - 3 * rolls[0] ) >= 0) && !(pips[oppositeColour][j - 3 * rolls[0]] >= 1))
                             {
                                 addNums = j - 3 * rolls[0];
                                 if (!(addNums <= 0))
                                     possibleMoves += "\n" + j + "-" + addNums;
                             }

                             else if (((j - 3 * rolls[0]) >= 0) && !((pips[oppositeColour][j - 3 * rolls[0]]) == 1))
                             {
                                 addNums = j - 3 * rolls[0];
                                 if (!(addNums <= 0))
                                     possibleMoves += "\n" + j + "-" + addNums + "*";
                             }

                             if (((j - 4 * rolls[0]) >= 0) && !(pips[oppositeColour][j - 4 * rolls[0]] >= 1))
                             {
                                 addNums = j - 4 * rolls[0];
                                 if (!(addNums <= 0))
                                     possibleMoves += "\n" + j + "-" + addNums;
                             }

                            else if (((j - 4 * rolls[0]) >= 0) && !((pips[oppositeColour][j - 4 * rolls[0]]) == 1))
                            {
                                 addNums = j - 4 * rolls[0];
                                 if (!(addNums <= 0))
                                     possibleMoves += "\n" + j + "-" + addNums + "*";
                             }
                         }
                     }
                 }
             }
		}

		else // black checkers
		{

			if(pips[colour][25] > 0)
			{
                if(!((pips[oppositeColour][rolls[0] + 1]) >= 1))
                {
                    addNums = 25 - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums;
                }
               else if(((pips[oppositeColour][rolls[0] + 1]) == 1))
                {
                    addNums = 25 - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                }

                if(!((pips[oppositeColour][rolls[1] + 1]) >= 1))
                {
                    addNums = 25 - rolls[1];
                    possibleMoves += "\n" + "Bar" + "-" + addNums;
                }
                else if(((pips[oppositeColour][rolls[1] + 1]) == 1))
                {
                    addNums = 25 - rolls[1];
                    possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                }

                if(!((pips[oppositeColour][rolls[0]+rolls[1] + 1]) >= 1))
                {
                    addNums = 25 - rolls[1] - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums;
                }
                else if(((pips[oppositeColour][rolls[0]+rolls[1] + 1]) == 1))
                {
                    addNums = 25 - rolls[1] - rolls[0];
                    possibleMoves += "\n" + "Bar" + "-" + addNums + "*";
                }
			}

		//allows checkers into bear off if all checkers are in the home base
		else if(pips[colour][0] + pips[colour][24] + pips[colour][23] + pips[colour][22] + pips[colour][21] + pips[colour][20] + pips[colour][19] == 15)
		{
			for (int j = 0; j < 26; j++) 
			{
				if ((pips[colour][j] != 0)) 
				{
					//possible moves not involving hits
					if (((j + rolls[0]) < 26) && !((pips[oppositeColour][j + rolls[0]]) >= 1))
					{
						addNums = ((j + rolls[0]));
						if (addNums == 25)
							possibleMoves += "\n" + (25 - j) + "-" + "Off";
						else
							possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
					}

                    //possible moves involving hits
                    else if (((j + rolls[0]) < 26) && (pips[oppositeColour][j + rolls[0]]) == 1)
                    {
                        addNums = j + rolls[0];
                        if (addNums == 25)
                            possibleMoves += "\n" + (25 - j) + "-" + "Off";
                        else
                            possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                    }

					if (((j + rolls[1]) < 26) && !((pips[oppositeColour][j + rolls[1]]) >= 1))
					{
						addNums = ((j + rolls[1]));
						if (addNums == 25)
							possibleMoves += "\n" + (25 - j) + "-" + "Off";
						else
							possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
					}

                    else if (((j + rolls[1]) < 26) && (pips[oppositeColour][j + rolls[1]]) == 1)
                    {
                        addNums = j + rolls[1];
                        if (addNums == 25)
                            possibleMoves += "\n" + (25 - j) + "-" + "Off";
                        else
                            possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                    }

					if (((j + rolls[0] + rolls[1]) < 26) && !((pips[oppositeColour][j + rolls[0] + rolls[1]]) >= 1))
					{
						addNums = ((j + rolls[0] + rolls[1]));
						if (addNums == 25)
							possibleMoves += "\n" + (25 - j) + "-" + "Off";
						else
							possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
					}

                   else if (((j + rolls[0] + rolls[1]) < 26) && (pips[oppositeColour][j + rolls[0] + rolls[1]]) == 1)
                   {
                        addNums = j + rolls[0] + rolls[1];
                        if (addNums == 25)
                            possibleMoves += "\n" + (25 - j) + "-" + "Off";
                        else
                            possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                    }

					//moves for doubles
					if (rolls[0] == rolls[1]) 
					{
						if (((j + 3 * rolls[0]) < 26) && !((pips[oppositeColour][j + 3 * rolls[0]]) >= 1))
						{
							addNums = j + 3 * rolls[0];
							if (addNums == 25)
								possibleMoves += "\n" + (25 - j) + "-" + "Off";
							else
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}

                        else if (((j + 3 * rolls[0]) < 26) && ((pips[oppositeColour][j + 3 * rolls[0]]) == 1))
                        {
                            addNums = j + 3 * rolls[0];
                            if (addNums == 25)
                                possibleMoves += "\n" + (25 - j) + "-" + "Off" + "*";
                            else
                                possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                        }

                        if (((j + 4 * rolls[0]) < 26) && !((pips[oppositeColour][j + 4 * rolls[0]]) >= 1))
                        {
							addNums = 4 * rolls[0];
							if (addNums == 25)
								possibleMoves += "\n" + (25 - j) + "-" + "Off";
							else
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}


						else if (((j + 4 * rolls[0]) < 26) && ((pips[oppositeColour][j + 4 * rolls[0]]) == 1))
						{
							addNums = j + 4 * rolls[0];
							if (addNums == 25)
								possibleMoves += "\n" + (25 - j) + "-" + "Off" + "*";
							else
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
						}
					}
				}
			}
		}
			
		else
		{
				for (int j = 0; j < 26; j++) 
				{
					if ((pips[colour][j] != 0)) 
					{
						//possible moves not involving hits
						if (((j + rolls[0]) < 26) && !((pips[oppositeColour][j + rolls[0]]) >= 1))
						{
							addNums = ((j + rolls[0]));
							if (addNums != 25)
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}

                        //possible moves involving hits
                        else if (((j + rolls[0]) < 26) && (pips[oppositeColour][j + rolls[0]]) == 1)
                        {
                            addNums = j + rolls[0];
                            if (addNums != 25)
                            	possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                        }

						if (((j + rolls[1]) < 26) && !((pips[oppositeColour][j + rolls[1]]) >= 1))
						{
							addNums = ((j + rolls[1]));
							if (addNums != 25)
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}

                        else if (((j + rolls[1]) < 26) && (pips[oppositeColour][j + rolls[1]]) == 1)
                        {
                            addNums = j + rolls[1];
                            if (addNums != 25)
                            	possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                        }

						if (((j + rolls[0] + rolls[1]) < 26) && !((pips[oppositeColour][j + rolls[0] + rolls[1]]) >= 1))
						{
							addNums = ((j + rolls[0] + rolls[1]));
							if (addNums != 25)
								possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
						}

                       else if (((j + rolls[0] + rolls[1]) < 26) && (pips[oppositeColour][j + rolls[0] + rolls[1]]) == 1)
                       {
                            addNums = j + rolls[0] + rolls[1];
                            if (addNums != 25)
                            	possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                        }

						//moves for doubles
						if (rolls[0] == rolls[1])
						{

							if (((j + 3 * rolls[0]) < 26) && !((pips[oppositeColour][j + 3 * rolls[0]]) >= 1))
							{
								addNums = j + 3 * rolls[0];
								if (addNums != 25)
									possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
							}

                            else if (((j + 3 * rolls[0]) < 26) && ((pips[oppositeColour][j + 3 * rolls[0]]) == 1))
                            {
                                addNums = j + 3 * rolls[0];
                                if (addNums != 25)
                                	possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
                            }

                            if (((j + 4 * rolls[0]) < 26) && !((pips[oppositeColour][j + 4 * rolls[0]]) >= 1))
                            {
								addNums = 4 * rolls[0];
								if (addNums != 25)
									possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums);
							}

							else if (((j + 4 * rolls[0]) < 26) && ((pips[oppositeColour][j + 4 * rolls[0]]) == 1))
							{
								addNums = j + 4 * rolls[0];
								if (addNums != 25)
									possibleMoves += "\n" + (25 - j) + "-" + (25 - addNums) + "*";
							}
						}
					}
				}
			}
		}
		
		possibleMoves = dupeRemover(possibleMoves);
		possibleMoves = letterAdder(possibleMoves);
        return possibleMoves;
    }

    // a function for removing duplicate moves from the possible moves list
    public String dupeRemover(String moves) {
		String[] moveArray = moves.split("\\n"); // an array for the individual strings
		String newMoves = new String();


		for (int i=1; i<moveArray.length; i++) { //starting at one to get rid of a pesky \n
		    int hitCount =0;
		    boolean dupFlag = false; //when a dup found will turn true


            for (int j = i+1; j<moveArray.length; j++) { // adds elements to a list without duplicating them

                if(moveArray[j].contains("*") && moveArray[i].equals(moveArray[j].substring(0, moveArray[j].length()-1))) {
                    hitCount++;
                    dupFlag = true;
                }

				else if (moveArray[i].equals(moveArray[j]) ) { // increment to skip listing
				     dupFlag = true;


				}
			}// end of inner for loop

            if (hitCount > 0) {
                moveArray[i] += "*";
            }

            if(!dupFlag)
                newMoves += "\n" + moveArray[i];


		} // end of outer for loop
		return newMoves;
	} // end of dupe remover

   public String letterAdder(String input) {
	   	String[] stringArray = input.split("\\n");
	   	String letteredList = new String(); // a string for the lettered moves
		int size = stringArray.length;

		for (int i=1; i<size; i++) { // adds single letters

			letteredList += "\n" + numbertoCharacter(i) +": ";
			letteredList += stringArray[i];

		}

		if (size >= 27) { // adds double letters
			for (int i=27; i<size; i++) {
				letteredList += "\nA" + numbertoCharacter(i%26) +": ";
				letteredList += stringArray[i];
			}//end of for
		} // end of if
		return letteredList;
   	}// end of letterAdder

	private String numbertoCharacter(int i) 
	{ // turns numbers to characters
		return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null; // turns number to letter
	}

	public int getScore(String colour)
	{
		if(colour.equals("White"))
		{
			if(pips[1][0] >= 1)
				return 1;
			
			else if((pips[1][0] == 0) && ((pips[1][25] >= 1)||(pips[1][1] >= 1)||(pips[1][2] >= 1)||(pips[1][3] >= 1)||(pips[1][4] >= 1)||(pips[1][5] >= 1)||(pips[1][6] >= 1)))
				return 3;
			
			else
				return 2;
		}
		
		if(colour.equals("Black"))
		{
			if(pips[0][0] >= 1)
				return 1;
			
			else if((pips[0][0] == 0) && ((pips[0][25] >= 1)||(pips[0][24] >= 1)||(pips[0][23] >= 1)||(pips[0][22] >= 1)||(pips[0][21] >= 1)||(pips[0][20] >= 1)||(pips[0][19] >= 1)))
				return 3;
			
			else
				return 2;
		}
		
		return 0;
	}
    public void setWhosTurn(int turn)
    {
        whosTurn = turn;
    }


    public void restBoard()
    {
    	for(ArrayList<Checker> a : board)
		{
			a.clear();
		}

    	w1.setCoordinates(413, 520);
    	w2.setCoordinates(413, 490);
    	w3.setCoordinates(413, 460);
    	w4.setCoordinates(413, 430);
    	w5.setCoordinates(413, 400);
    	w6.setCoordinates(261, 520);
    	w7.setCoordinates(261, 490);
    	w8.setCoordinates(261, 460);
    	w9.setCoordinates(61, 50);
    	w10.setCoordinates(61, 80);
    	w11.setCoordinates(61, 110);
    	w12.setCoordinates(61, 140);
    	w13.setCoordinates(61, 170);
    	w14.setCoordinates(663, 50);
    	w15.setCoordinates(663, 80);

    	//declare all black checkers
    	b1.setCoordinates(413, 50);
    	b2.setCoordinates(413, 80);
    	b3.setCoordinates(413, 110);
    	b4.setCoordinates(413, 140);
    	b5.setCoordinates(413, 170);
    	b6.setCoordinates(261, 50);
    	b7.setCoordinates(261, 80);
    	b8.setCoordinates(261, 110);
    	b9.setCoordinates(61, 520);
    	b10.setCoordinates(61, 490);
    	b11.setCoordinates(61, 460);
    	b12.setCoordinates(61, 430);
    	b13.setCoordinates(61, 400);
    	b14.setCoordinates(663, 520);
    	b15.setCoordinates(663, 490);
    	
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
    	
        pips = restartCopy;
        numInWhiteSlot = 0; //varibles to count the number of checkers in player's slots
        numInBlackSlot = 0;
        this.repaint();
    }


}