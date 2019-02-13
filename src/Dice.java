/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
//needs a randome number generator
// Doubling die will be a subclass

import java.util.Random;
public class Dice {

    private  Random  roll;

    public Dice()
    {
        roll = new Random();
    }


    //returns a random number from 1 to 6
    public int roll()
    {
       return roll.nextInt(6) + 1 ;
    }


}
