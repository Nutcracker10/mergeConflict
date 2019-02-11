/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import java.util.*;



//This class represemts the Spikes on the board where the checkers move. They act like a stack.
// Checkers  can move from one spike to another. Store Spike objects in LinkedSist???


public class Spike<E> extends Stack<E>
{
    Stack<Object> spike;

    public Spike()
    {
        spike = new Stack<Object>();

    }

    public void addChecker(Object check)
    {
        spike.push(check);
    }

}
