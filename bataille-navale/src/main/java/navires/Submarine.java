package navires;

import ensta.Orientation;

public class Submarine extends AbstractShip{

    /**
     * Constructeur
     */
    public Submarine(){
        super('S',"Submarine",3,Orientation.EAST);
    }

    /**
     * Constructeur avec orientation
     * @param theOrientation
     */
    public Submarine(Orientation theOrientation){
        super('S',"Submarine",3,theOrientation);
    }
}