package navires;

import ensta.ColorUtil;
import ensta.ColorUtil.Color;

public class ShipState{
    protected AbstractShip ref = null;
    protected boolean struck = false;

    /**
     * return the value of "struck"
     * @return 'true' if its touched or 'false' if not
     */
    public boolean isStruck(){
        return this.struck;
    }

    /**
     * add a strike and struck = true
     */
    public void addStrike(){
        if(!this.struck)
            this.ref.addStrike();
        else
            System.out.println("There is a hit here!");
        this.struck = true;
    }


    /**
     * Get the 'label' of the ref
     * @return the label
     */
    public String toString(){
        return ColorUtil.colorize(this.ref.getLabel().toString(), ColorUtil.Color.RED);
    }

    /**
     * @return 'true' if ref is "sunk", 'false' if not
     */
    public Boolean isSunk(){
        return ref.isSunk();
    }

    /**
    * @return the ref
    */
    public AbstractShip getShip(){
        return this.ref;
    }


    /**
     * @param reference the reference ship
     */
    public void setShip(AbstractShip reference){
        this.ref = reference;
    }



    /**
     * Constructor
     */
    public ShipState(){
        this.struck = false;
    }
}