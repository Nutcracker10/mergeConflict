/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
//Class for slots at end of boards. Once a player has filled their slot with all their checkers that playre has won the
//game. Slots just need to store the checkers. Once the checkers are there they are safe

// method : isFull() returns true or false.
//method : addChecker() enters checker into slot

import java.util.Stack;

public class Slot
{
    private Stack<Object> bearOff;

    public Slot()
    {
    	bearOff = new Stack<>();
    }


    //adds checkers to slot
    public void addChecker(Object checker)
    {
    	bearOff.push(checker);
    }

    //checks if slot is full of checkers
    public boolean isFull()
    {
        return bearOff.size() == 15;
    }


}