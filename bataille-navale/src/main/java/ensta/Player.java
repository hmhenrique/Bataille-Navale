package ensta;
import java.io.Serializable;
import java.util.List;

import navires.*;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getNom(), s.getTaille());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            // TODO set ship orientation
            // TODO put ship at given position

            //System.out.println(res.orientation);

            switch(res.orientation)
            {
                case "e":
                    ships[i].setOrientation(Orientation.EAST);
                break;

                case "w":
                    ships[i].setOrientation(Orientation.WEST);
                break;

                case "n":
                    ships[i].setOrientation(Orientation.NORTH);
                break;

                case "s":
                    ships[i].setOrientation(Orientation.SOUTH);
                break;
            }

            try{
                board.putShip(ships[i], res.x, res.y);
                ++i;   
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }


            // TODO when ship placement successful
            //++i;
            done = i == 5;

            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done = false;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard

            coords[0] = hitInput.x + 1; //to save and return the position of the hit
            coords[1] = hitInput.y + 1; //to save and return the position of the hit

            if (board.getFrappes()[hitInput.x][hitInput.y] == null){
                hit = this.opponentBoard.sendHit(hitInput.x, hitInput.y);
                if (hit == Hit.MISS)
                    this.board.setHit(false, hitInput.x, hitInput.y);
                else
                    this.board.setHit(true, hitInput.x, hitInput.y);
            }
            else 
                hit = null;

            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
            board.print();
            done = true;
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
