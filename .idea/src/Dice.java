
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
