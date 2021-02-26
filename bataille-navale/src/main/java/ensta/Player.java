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
            done = i == 5;

            board.print();
        } while (!done);
    }

    /**
     * Send a hit 
     * @param coords x and y of the shot
     * @return the hit
     */
    public Hit sendHit(int[] coords) throws ArrayIndexOutOfBoundsException{
        boolean done = false;
        Hit hit = null;

        do {
            System.out.println("");
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();

            coords[0] = hitInput.x + 1; //to save and return the position of the hit
            coords[1] = hitInput.y + 1; //to save and return the position of the hit


            if(coords[0] < 0 || coords[1] < 0 || coords[0] > board.getSize() || coords[1] > board.getSize())
                throw new ArrayIndexOutOfBoundsException("Invalid Position");
            else{
            if (board.getFrappes()[hitInput.x][hitInput.y] == null){
                hit = this.opponentBoard.sendHit(hitInput.x, hitInput.y);
                if (hit == Hit.MISS)
                    this.board.setHit(false, hitInput.x, hitInput.y);
                else
                    this.board.setHit(true, hitInput.x, hitInput.y);
            }
            else 
                throw new ArrayIndexOutOfBoundsException("There is a shot here!");
            }
            board.print();
            done = true;
        } while (!done);

        return hit;
    }

    /**
     * get the array of ships
     * @return the hit
     */
    public AbstractShip[] getShips() {
        return ships;
    }

    /**
     * set the array of ships
     * @param ships
     */
    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
