/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
//needs a randome number generator
// Doubling die will be a subclass

import java.util.Random;
public class Dice 
{
	private int die1;
	private int die2;
	private Random rand;

    public Dice()
    {
    	rand = new Random();
        die1 = roll();
        die2 = roll();
    }

    //returns a random number from 1 to 6
    public int roll()
    {
    	return rand.nextInt(6) + 1;
    }
 
    public int getDie1()
    {
    	return die1;
    }
    
    public int getDie2()
    {
    	return die2;
    }
}
