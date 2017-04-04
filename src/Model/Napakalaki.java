package Model;

import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {
    private static Napakalaki instance = null;

    private ArrayList<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;//indice que ocupa en el array players currentplayer
    private Monster currentMonster;
    private Random rand;

    private Napakalaki() {
      players = new ArrayList();
      currentPlayer = null;
      currentMonster = null;
      currentPlayerIndex = -1;
      rand = new Random();
    }
    
    public static Napakalaki getInstance() {
      if (instance == null) {
        instance = new Napakalaki();
      }
      return instance;
    }

    private void initPlayers(ArrayList<String> names) {
      for (String name : names) {
          players.add(new Player(name));
      }
    }

    private Player nextPlayer() {
      if (currentPlayer == null) {//primer turno
        currentPlayerIndex = rand.nextInt(players.size());
      }else {//en el sentido de las agujas del reloj
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
      }

      currentPlayer = players.get(currentPlayerIndex);
      return currentPlayer;
    }

    public CombatResult combat() {
        CombatResult result = currentPlayer.combat(currentMonster);
        if (result == CombatResult.LOSEANDCONVERT) {
           CultistPlayer sectario = new CultistPlayer(currentPlayer, CardDealer.getInstance().nextCultist());
           players.set(currentPlayerIndex, sectario);
           currentPlayer = sectario;
        }
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        return result;
    }

    public void discardVisibleTreasure(Treasure t) {
        currentPlayer.discardVisibleTreasure(t);
    }

    public void discardHiddenTreasure(Treasure t) {
        currentPlayer.discardHiddenTreasure(t);
    }

    public boolean makeTreasureVisible(Treasure t) {
        return currentPlayer.makeTreasureVisible(t);
    }

    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        return currentPlayer.buyLevels(visible, hidden);
    }

    public void initGame(ArrayList<String> players) {
        CardDealer.getInstance().initCards();
        initPlayers(players);
        nextTurn();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public boolean canMakeTreasureVisible(Treasure t) {
        return currentPlayer.canMakeTreasureVisible(t);
    }

    /*Metodos misteriosos
     public ArrayList<TreasureKind> getVisibleTreasures() {
     return null;
     }

     public ArrayList<TreasureKind> getHiddenTreasures() {
     return null;
     }*/
    
    public boolean nextTurn() {
      if (nextTurnAllowed()) {//primer turno o jugador en estado valido
        currentMonster = CardDealer.getInstance().nextMonster();
        currentPlayer = nextPlayer();
        if (currentPlayer.isDead()) {
          currentPlayer.initTreasures();
        }
        return true;
      }else {
        return false;
      }
    }

    public boolean nextTurnAllowed() {
      return currentPlayer == null || currentPlayer.validState();
    }

    public boolean endOfGame(CombatResult result) {
      return result == CombatResult.WINANDWINGAME;
    }
}

