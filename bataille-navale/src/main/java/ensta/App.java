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

        //board.setHit(false, 5, 5);

        Player play = new Player(board, board, ships);
        play.putShips();

        int[] coords = new int[2];

        Hit hit;

        boolean done = false;

        do {
            hit = play.sendHit(coords);


            /**
             * From Game.java to test
             */
            boolean incoming = false; 
            String msg;
            ColorUtil.Color color = ColorUtil.Color.RESET;
            if(hit == null){
                msg = "There is a hit here!";
            }else{
            switch (hit) {
            case MISS:
                msg = hit.toString();
                break;
            case STRIKE:
                msg = hit.toString();
                color = ColorUtil.Color.RED;
                break;
            default:
                msg = hit.toString() + " coulé";
                color = ColorUtil.Color.RED;
            }
            msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) ('A' + coords[0]-1)),
                    (coords[1]), msg);
            }
            System.out.println(ColorUtil.colorize(msg, color));

            

        }while (!done);

        board.print();
    }
}
