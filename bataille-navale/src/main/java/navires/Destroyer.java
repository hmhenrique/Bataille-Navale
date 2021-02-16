package navires;

import ensta.Orientation;

public class Destroyer extends AbstractShip{

    /**
     * Constructeur
     */
    public Destroyer(){
        super('D',"Destroyer",2,Orientation.EAST);
    }

    /**
     * Constructeur avec orientation
     * @param theOrientation
     */
    public Destroyer(Orientation theOrientation){
        super('D',"Destroyer",2,theOrientation);
    }
}