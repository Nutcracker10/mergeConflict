/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
//Class for slots at end of boards. Once a player has filled their slot with all their checkers that playre has won the
//game. Slots just need to store the checkers. Once the checkers are there they are safe

// method : isFull() returns true or false.
//method : addChecker() enters checker into slot

public class Slot
{

    //private  Checker [] slot;
    private int size;

    public Slot()
    {
       // slot = new Checker[15];
        size = 0;
    }


    //adds checkers to slot
 //   public void addChecker(Checker checker)
    {
      //  slot[size] = checker;
        size++;
    }

    //checks if slot is full of checkers
    public boolean isFull()
    {
        return size == 15;
    }


}