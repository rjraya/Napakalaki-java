package Model;

import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {

    private static Napakalaki instance = null;

    private ArrayList<Player> players;
    private Player currentPlayer;
	private int currentPlayerIndex;
	private Monster currentMonster;
	
	private Random rand;

    private Napakalaki() {
        players = new ArrayList<Player>();
		currentPlayer = null;
		currentMonster = null;
		currentPlayerIndex = -1;
		rand = new Random();
    }

    private void initPlayers(ArrayList<String> names) {
		for (String name : names) {
			players.add(new Player(name));
		}
    }

    private Player nextPlayer() {
		if (currentPlayer == null) {
			currentPlayerIndex = rand.nextInt(players.size());
		} else {
			currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
		}
		
		currentPlayer = players.get(currentPlayerIndex);
		return currentPlayer;
    }

    public static Napakalaki getInstance() {
        if (instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }

    public CombatResult combat() {
        CombatResult result = currentPlayer.combat(currentMonster);
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
        return currentPlayer.canMakeTreasureVisible(t);
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
        if (nextTurnAllowed()) {
			currentMonster = CardDealer.getInstance().nextMonster();
			currentPlayer = nextPlayer();
			if (currentPlayer.isDead()) {
				currentPlayer.initTreasures();
			}
			return true;
		} else {
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
