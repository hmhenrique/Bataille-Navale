package ensta;

import java.util.*;
import navires.*;

public class TestGame 
{
    public TestGame()
    {
        Board board = new Board("TestBoard");
        board.print();

        int countShip = 0;

        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        ships.add(new Submarine());
        ships.add(new Battleship());
        ships.add(new Carrier());

        BattleShipsAI testShipsAI = new BattleShipsAI(board, board);

        testShipsAI.putShips(ships.toArray(new AbstractShip[ships.size()]));

        int[] coords = new int[2];

        Hit hit;

        do {

            hit = testShipsAI.sendHit(coords);

            if(board.getNavires()[coords[0] - 1][coords[1] - 1] != null && board.getNavires()[coords[0] - 1][coords[1] - 1].isSunk())
                countShip++;

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
            msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) ('A' + coords[0]-1)), (coords[1]), msg);
            }
            System.out.println(ColorUtil.colorize(msg, color));


            board.print();

            sleep(1000);

        }while (countShip != 5);

        //board.print();
    }


    private static void sleep(int ms) {
        try {
        Thread.sleep(ms);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }
        
}
