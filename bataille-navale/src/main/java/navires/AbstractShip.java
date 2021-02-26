package navires;

import ensta.Orientation;

public abstract class AbstractShip{

    /**
     * Attributs
     */
    protected Character label;
    protected String nom;
    protected int taille;
    protected Orientation orientation;
    protected int strikeCount;

    /**
     * Getter of label
     * @return label
     */
    public Character getLabel(){
        return this.label;
    }

    /**
     * Getter of label
     * @param label_
     */
    public void setLabel(Character label_){
        this.label = label_;
    }

    /**
     * Getter of nom
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Getter of taille
     * @return taille
     */
    public int getTaille(){
        return this.taille;
    }

    /**
     * Getter of orientation
     * @return orientation
     */
    public Orientation getOrientation(){
        return this.orientation;
    }

    /**
     * Setter of orientation
     * @param orientation_
     */
    public void setOrientation(Orientation orientation_){
        this.orientation = orientation_;
    }

    /**
     * "Add" the num of shots int the ship
     */
    public void addStrike(){
        this.strikeCount++;
    }


    /**
     * @return 'true' if it is sunk, 'false' if not
     */
    public boolean isSunk(){
        if(this.taille == this.strikeCount)
            return true;
        else
            return false;
    }

    /**
     * Constructor
     * @param theLabel
     * @param theNom
     * @param theTaille
     * @param theOrientation
     */
    public  AbstractShip(Character theLabel, String theNom, int theTaille, Orientation theOrientation){
        this.label = theLabel;
        this.nom = theNom;
        this.taille = theTaille;
        this.orientation = theOrientation;
    }

}