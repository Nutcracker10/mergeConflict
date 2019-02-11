/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
//Class for co-ordinates. When creating an object it takes two numbers x and y respectivly.
//has methods getx, gety setx and sety

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }


    public void setY(int y)
    {
        this.y = y;
    }


}
