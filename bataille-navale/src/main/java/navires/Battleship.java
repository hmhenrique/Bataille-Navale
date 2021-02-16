package navires;

import ensta.Orientation;

public class Battleship extends AbstractShip{

    /**
     * Constructeur
     */
    public Battleship(){
        super('B',"Battleship",4,Orientation.EAST);
    }

    /**
     * Constructeur avec orientation
     * @param theOrientation
     */
    public Battleship(Orientation theOrientation){
        super('B',"Battleship",4,theOrientation);
    }
}