package ensta;

import java.util.*;
import navires.*;

public class TestPlayer 
{
    public TestPlayer()
    {
        Board board = new Board("TestBoard");

        
        Destroyer destroy = new Destroyer(Orientation.NORTH);

        
        
        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        ships.add(new Submarine());
        ships.add(new Battleship());
        ships.add(new Carrier());
        
        
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
