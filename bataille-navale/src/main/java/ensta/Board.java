package ensta;

import navires.*;

public class Board implements IBoard
{
    private String nom;

    private ShipState[][] navires;

    private Boolean[][] frappes;

    /**
     * Getter de nom
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Getter de navires
     * @return navires
     */
    public ShipState[][] getNavires(){
        return this.navires;
    }

    /**
     * Getter de frappes
     * @return frappes
     */
    public Boolean[][] getFrappes(){
        return this.frappes;
    }

    /**
     * Constructeur
     */
    public Board(String Nom, int taille){
        this.nom = Nom;
        this.navires = new ShipState[taille][taille];
        this.frappes = new Boolean[taille][taille];

        for(int i = 0; i < taille; i++){
            for (int j = 0; j< taille; j++){
                this.navires[i][j] = new ShipState(); 
                this.frappes[i][j] = null;
            }
        }
    }

    /**
     * Constructeur
     */
    public Board(String Nom){
        this.nom = Nom;
        this.navires = new ShipState[10][10];
        this.frappes = new Boolean[10][10];

        for(int i = 0; i < 10; i++){
            for (int j = 0; j< 10; j++){
                this.navires[i][j] = new ShipState(); 
                this.frappes[i][j] = null;
            }
        }
    }

    /**
     * Print out the game board
     */
    public void print(){

        System.out.println(this.nom);
        System.out.print("Navires:                         ");
        for(int i = 0; i < this.navires.length; i++ ){
            if(i <= 10)
            System.out.print("");
            else
            System.out.print("  ");
        }
        System.out.println("Frappes:");
        System.out.print("  ");
        char aux = 65;
        for(int y = 0; y <= this.navires.length; y++){
            
            if (y != 0){
                if (y >= 10){
                    System.out.print(y + " ");
                }else   
                    System.out.print(y + "  ");
            }
            for (int x = 0; x < this.navires.length; x++) {
                if (y == 0){
                    if(x == this.navires.length - 1)
                        System.out.print(" " + aux + "             ");
                    else
                        System.out.print(" " + aux);
                    aux++;
                }else {
                    if(this.navires[x][y-1].getShip() == null) 
                        System.out.print(". ");
                    else {
                    if (this.getFrappes()[x][y-1] == null)
                        System.out.print(this.navires[x][y-1].getShip().getLabel() + " ");
                    else
                        System.out.print(ColorUtil.colorize(this.navires[x][y-1].getShip().getLabel() + " ", ColorUtil.Color.RED));
                    }
                    if (x == this.navires.length - 1)
                    System.out.print("          ");
                }
            }
            
            aux = 65;
            if (y != 0){
                if (y >= 10){
                    System.out.print(y + " ");
                }else   
                    System.out.print(y + "  ");
            }
            for (int x = 0; x < this.frappes.length; x++) {
                if (y == 0){
                    System.out.print(" " + aux);
                    aux++;
                }else {
                    if (frappes[x][y-1] == null)
                        System.out.print(". ");
                    else{
                        if(frappes[x][y-1])
                            System.out.print(ColorUtil.colorize("x ", ColorUtil.Color.RED));
                        else
                            System.out.print(ColorUtil.colorize("x ", ColorUtil.Color.WHITE));
                    }
                }
            }
            System.out.println("");
        }
        
    }

    /**
     * Get the size of the grids contained in the Board
     * @return the size of the grids contained in the Board
     */
    public int getSize(){
        return this.navires.length;
    }

    /**
    * Put the given ship at the given position
    * @param ship The ship to place on the board
    * @param x
    * @param y
    */
    public void putShip(AbstractShip ship, int x, int y) throws ArrayIndexOutOfBoundsException{
        //y--;
        //x--;
        int taille = ship.getTaille();
        Boolean possible = true;
        switch (ship.getOrientation()){
            case NORTH:
                for(int i = 0; i < taille; i++){
                    if(x < 0 || y - i < 0 || x >= this.getSize() || y - i >= this.getSize() || this.hasShip(x,y-i)){
                        possible = false;
                        throw new ArrayIndexOutOfBoundsException("Invalid Position");
                    }
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x][y-i].setShip(ship);
                        //navires[x][y-i].getShip().setLabel(ship.getLabel());
                        possible = true;
                    }
            break;
            case SOUTH:
                for(int i = 0; i < taille; i++){
                    if(x < 0 || y + i < 0 || x >= this.getSize() || y + i >= this.getSize() || this.hasShip(x,y+i)){
                        possible = false;
                        throw new ArrayIndexOutOfBoundsException("Invalid Position");
                    }
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x][y+i].setShip(ship);
                        //navires[x][y+i].getShip().setLabel(ship.getLabel());
                        possible = true;
                    }
            break;
            case EAST:
                for(int i = 0; i < taille; i++){
                    if(x + i < 0 || y < 0 || x + i >= this.getSize() || y >= this.getSize() || this.hasShip(x + i ,y)){
                        possible = false;
                        throw new ArrayIndexOutOfBoundsException("Invalid Position");
                    }
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x+i][y].setShip(ship);
                        //navires[x+i][y].getShip().setLabel(ship.getLabel());
                        possible = true;
                    }
            break;
            case WEST:
                for(int i = 0; i < taille; i++){
                    if(x - i < 0 || y < 0 || x - i >= this.getSize() || y >= this.getSize() || this.hasShip(x - i ,y)){
                        possible = false;
                        throw new ArrayIndexOutOfBoundsException("Invalid Position");
                    }
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x-i][y].setShip(ship);
                        //navires[x-i][y].getShip().setLabel(ship.getLabel());
                        possible = true;
                    }
            break;
        }

    }

    /**
     * Get if a ship is placed at the given position
     * @param x
     * @param y
     * @return true if a ship is located at the given position
     */
    public boolean hasShip(int x, int y){
        if (navires[x][y].getShip() != null){
            return true;
        }else 
            return false;
    }

    /**
     * Set the state of the hit at a given position
     * @param hit true if the hit must be set to successful
     * @param x
     * @param y
     */
    public void setHit(boolean hit, int x, int y){
        this.frappes[x][y] = hit;
    }

    /**
     * Get the state of a hit at the given position
     * @param x
     * @param y
     * @return true if the hit is successful
     */
    public Boolean getHit(int x, int y){
        return this.frappes[x][y];
    }



    /**
     * Sends a hit at the given position
     * @param x
     * @param y
     * @return status for the hit (eg : strike or miss)
     */
    public Hit sendHit(int x, int y){

        if (this.navires[x][y].getShip() == null)
            return Hit.MISS;
        else{
            this.navires[x][y].addStrike();
            if(this.navires[x][y].isSunk())
                return Hit.fromInt(this.navires[x][y].getShip().getTaille());
            else if (this.navires[x][y].isStruck())
                return Hit.STRIKE;
            else 
                return Hit.MISS;
        }
    }

}
