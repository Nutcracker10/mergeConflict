/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
//needs a randome number generator
// Doubling die will be a subclass

import java.util.Random;
public class Dice {

    private Random roll1;
    private Random roll2; 

    public Dice()
    {
        roll1 = new Random();
        roll2 = new Random();
    }

    //returns a random number from 1 to 6
    public int rollDieOne()
    {
       return roll1.nextInt(6) + 1 ;
    }
    
    public int rollDieTwo()
    {
    	return roll2.nextInt(6) + 1;
    }

}
