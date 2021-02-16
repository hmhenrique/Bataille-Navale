package ensta;

import navires.*;

public class Board implements IBoard
{
    private String nom;

    private char[][] navires;

    private boolean[][] frappes;

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
    public char[][] getNavires(){
        return this.navires;
    }

    /**
     * Getter de frappes
     * @return frappes
     */
    public boolean[][] getFrappes(){
        return this.frappes;
    }

    /**
     * Constructeur
     */
    public Board(String Nom, int taille){
        this.nom = Nom;
        this.navires = new char[taille][taille];
        this.frappes = new boolean[taille][taille];

        for(int i = 0; i < taille; i++){
            for (int j = 0; j< taille; j++){
                this.navires[i][j] = '.'; 
                this.frappes[i][j] = false;
            }
        }
    }

    /**
     * Constructeur
     */
    public Board(String Nom){
        this.nom = Nom;
        this.navires = new char[10][10];
        this.frappes = new boolean[10][10];

        for(int i = 0; i < 10; i++){
            for (int j = 0; j< 10; j++){
                this.navires[i][j] = '.'; 
                this.frappes[i][j] = false;
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
                }else {if (x == this.navires.length - 1)
                        System.out.print(this.navires[x][y-1] + "           ");
                    else 
                        System.out.print(this.navires[x][y-1] + " ");
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
                    if (this.frappes[x][y-1] == false)
                    System.out.print(". ");      
                else if (this.frappes[x][y-1] == true)
                    System.out.print("x ");  
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
    public void putShip(AbstractShip ship, int x, int y){
        y--;
        x--;
        int taille = ship.getTaille();
        Boolean possible = true;
        switch (ship.getOrientation()){
            case NORTH:
                for(int i = 0; i < taille; i++){
                    if(x < 0 || y - i < 0 || x >= this.getSize() || y - i >= this.getSize() || this.hasShip(x,y-i)) possible = false;
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x][y-i] = ship.getLabel();
                        possible = true;
                    }
            break;
            case SOUTH:
                for(int i = 0; i < taille; i++){
                    if(x < 0 || y + i < 0 || x >= this.getSize() || y + i >= this.getSize() || this.hasShip(x,y+i)) possible = false;
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x][y+i] = ship.getLabel();
                        possible = true;
                    }
            break;
            case EAST:
                for(int i = 0; i < taille; i++){
                    if(x + i < 0 || y < 0 || x + i >= this.getSize() || y >= this.getSize() || this.hasShip(x + i ,y)) possible = false;
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x+i][y] = ship.getLabel();
                        possible = true;
                    }
            break;
            case WEST:
                for(int i = 0; i < taille; i++){
                    if(x - i < 0 || y < 0 || x - i >= this.getSize() || y >= this.getSize() || this.hasShip(x - i ,y)) possible = false;
                }
                for(int i = 0; i < taille; i++)
                    if (possible){
                        navires[x-i][y] = ship.getLabel();;
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
        if (navires[x][y] != '.'){
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
        this.frappes[x-1][y-1] = hit;
    }

    /**
     * Get the state of a hit at the given position
     * @param x
     * @param y
     * @return true if the hit is successful
     */
    public Boolean getHit(int x, int y){
        return this.frappes[x-1][y-1];
    }

}
