/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/

//Class for the Bar. When an opponent blots your checker it gets moved here. It acts like a Stack. Both players cam
//have checkers on the bar and every player can have multiple checkers on the bar at the same time.

//Methods
/*
    NumberofWhite : returns number of white checkers on bar
    NumberOfBlack : returns number of black checkers on bar
    isBarEmpty : returns boolean true if no checkers on bar, false otherwise
 */

import java.util.Stack;

public class Bar
{
	Stack<BlackChecker> blackBar = new Stack<BlackChecker>(); 
   	Stack<WhiteChecker> whiteBar = new Stack<WhiteChecker>();
 

    public Bar ()
    { }

    public int numberOfWhite()
    {
        return whiteBar.size();
    }

    public int numberOfBlack()
    {
        return blackBar.size();
    }

    public boolean isBarEmpty()
    {
        return (whiteBar.isEmpty() && blackBar.isEmpty());
    }

}