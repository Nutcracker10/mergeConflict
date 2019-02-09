
//Class to comtain Main function

import java.util.LinkedList;

public class MainFunction
{
    public MainFunction()
    {}


    public static void main()
    {
        //trying to make a linked list of the spikes
        LinkedList<Spike<Object>>  listOfSpikes = new LinkedList<Spike<Object>>();
        Spike<Object> s1 = new Spike<Object>();
        Spike<Object> s2 = new Spike<Object>();
        //then put the checkers in the spikes and move them about
        WhiteChecker c1 = new WhiteChecker(0, 0);
        BlackChecker c2 = new BlackChecker(50, 50);




    }
}