package ensta;

import navires.*;

import java.io.Serializable;
import java.util.List;

public class AIPlayer extends Player {
    /* **
     * Attribut
     */
    private BattleShipsAI ai;

    /* **
     * Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    /**
     * Uses the putShip of Player
     */
    public void putShip()
    {
        ai.putShips(ships);
    }

    /**
     * Uses the sendHit of Player
     * @return hit
     */
    public Hit sendHit(int[] coords)
    {
        return ai.sendHit(coords);
    }
}
