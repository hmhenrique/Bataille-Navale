package ensta;

import navires.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Board board = new Board("TestBoard");
        board.print();

        Destroyer destroy = new Destroyer(Orientation.NORTH);
        Carrier carrier = new Carrier(Orientation.WEST);
        board.putShip(destroy, 0, 1);
        board.putShip(carrier, 4, 3);

        board.print();
    }
}
