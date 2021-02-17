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
     * Accesseur de label
     * @return label
     */
    public Character getLabel(){
        return this.label;
    }

    /**
     * Mutateur de label
     * @param label_
     */
    public void setLabel(Character label_){
        this.label = label_;
    }

    /**
     * Accesseur de nom
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Accesseur de taille
     * @return taille
     */
    public int getTaille(){
        return this.taille;
    }

    /**
     * Accesseur de orientation
     * @return orientation
     */
    public Orientation getOrientation(){
        return this.orientation;
    }

    /**
     * Mutateur de orientation
     * @param orientation_
     */
    public void setOrientation(Orientation orientation_){
        this.orientation = orientation_;
    }

    /**
     * "Add" le nombre de frappes du navire 
     */
    public void addStrike(){
        this.strikeCount++;
    }


    /**
     * @return 'true' si est "sunk", 'false' si non
     */
    public boolean isSunk(){
        if(this.taille == this.strikeCount)
            return true;
        else
            return false;
    }

    /**
     * Constructeur
     */
    public  AbstractShip(Character theLabel, String theNom, int theTaille, Orientation theOrientation){
        this.label = theLabel;
        this.nom = theNom;
        this.taille = theTaille;
        this.orientation = theOrientation;
    }

}