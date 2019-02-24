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
   	Stack<Object> bar = new Stack<Object>();

    public Bar ()
    { 
    	
    }

    public int numberOfCheckers()
    {
        return bar.size();
    }
    
    public boolean isBarEmpty()
    {
        return (bar.isEmpty());
    }
    
    public void addChecker(Object check)
    {
    	bar.push(check);
    }
    
    public Object removeChecker()
    {
    	return bar.pop();
    }

}