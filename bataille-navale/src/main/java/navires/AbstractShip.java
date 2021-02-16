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

    /**
     * Accesseur de label
     * @return label
     */
    public Character getLabel(){
        return this.label;
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
    public String getTaille(){
        return this.taille;
    }

    /**
     * Accesseur de orientation
     * @return orientation
     */
    public String getOrientation(){
        return this.orientation;
    }

    /**
     * Mutateur de orientation
     * @param orientation_
     */
    public void setOrientation(orientation_){
        this.orientation = orientation_;
    }

    /**
     * Constructeur
     */
    public  AbstractShip(String theNom, Character theLabel, int theTaille, Orientation theOrientation){
        this.label = theLabel;
        this.nom = theNom;
        this.taille = theTaille;
        this.orientation = theOrientation;
    }

}