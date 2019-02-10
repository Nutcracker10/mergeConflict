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


    private int getX()
    {
        return x;
    }

    private int getY()
    {
        return y;
    }

    private void setX(int x)
    {
        this.x = x;
    }


    private void setY(int y)
    {
        this.y = y;
    }


}
