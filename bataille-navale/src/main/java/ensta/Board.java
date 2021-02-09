package ensta;

public class Board
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
        System.out.println("Navires:                         Frappes: ");
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
}
