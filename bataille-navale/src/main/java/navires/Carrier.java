package navires;

import ensta.Orientation;

public class Carrier extends AbstractShip{

    /**
     * Constructeur
     */
    public Carrier(){
        super('C',"Carrier",5,Orientation.EAST);
    }

    /**
     * Constructeur avec orientation
     * @param theOrientation
     */
    public Carrier(Orientation theOrientation){
        super('C',"Carrier",5,theOrientation);
    }
}