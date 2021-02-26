package ensta;

import java.util.*;
import navires.*;

public class App 
{
    public static void main( String[] args )
    {
        
       //TestGame test = new TestGame();  // -> To use only the AI
       //TestPlayer test = new TestPlayer();  // -> To test the player

       Game game = new Game();
       game.init();
       game.run();
    }
}
