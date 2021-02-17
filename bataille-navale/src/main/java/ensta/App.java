package ensta;

import java.util.*;
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
        //board.print();

        Destroyer destroy = new Destroyer(Orientation.NORTH);
        //Carrier carrier = new Carrier(Orientation.WEST);
        //board.putShip(destroy, 1, 2);
       // board.putShip(carrier, 4, 3);


        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        ships.add(new Submarine());
        ships.add(new Battleship());
        ships.add(new Carrier());
        System.out.println("Hello World!" );

        //board.setHit(false, 5, 5);

        Player play = new Player(board, board, ships);
        play.putShips();

        board.print();
    }
}
