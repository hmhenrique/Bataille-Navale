package ensta;

import java.util.*;
import navires.*;

/**
 * Class responsable for starting the game .
 */
public class App 
{
    public static void main( String[] args )
    {
        
       //TestGame test = new TestGame();  // -> To use only the AI

       Game game = new Game();
       game.init();
       game.run();
    }
}
