package Model;

import java.util.ArrayList;

public class Player {

    private static final int MAXHIDDENTREASURE = 4;

    private boolean dead;
    private String name;
    private int level;

    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence;

    Player(String name) {
        dead = true;
        this.name = name;
        level = 1;
        visibleTreasures = new ArrayList<Treasure>();
        hiddenTreasures = new ArrayList<Treasure>();
        pendingBadConsequence = null;
    }
	
	public String toString() {
		return name + ". Nivel: " + Integer.toString(level);
	}
	
	public String getName() {
		return name;
	}

    private void bringToLive() {
        dead = false;
    }

    private void incrementLevels(int i) {
        level += i;
        if (level > 10) level = 10;
    }

    private void decrementLevels(int i) {
        level -= i;
        if (level < 1) level = 1;
    }

    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }

    private void die() {
		for (Treasure v : visibleTreasures) {
			CardDealer.getInstance().giveTreasureBack(v);
		}
		visibleTreasures.clear();
		
		for (Treasure h : hiddenTreasures) {
			CardDealer.getInstance().giveTreasureBack(h);
		}
		hiddenTreasures.clear();
		level = 1;
		dead = true;
	}

    private void discardNecklaceIfVisible() {
		
		Treasure necklace = null;
        for (Treasure tes : visibleTreasures) {
			if (tes.getType() == TreasureKind.NECKLACE) {
				necklace = tes;
			}
		}
		if (necklace != null) {
			CardDealer.getInstance().giveTreasureBack(necklace);
			visibleTreasures.remove(necklace);
		}
    }

    private void dieIfNoTreasures() {
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty()) {
            die();
        }
    }

    private boolean canIBuyLevels(int i) {
        return level + i < 10;
    }

    protected float computeGoldCoinsValue(ArrayList<Treasure> treasures) {
        int oro = 0;
		for (Treasure tes : treasures) {
			oro += tes.getGoldCoins();
		}
        return oro / 1000F;
    }

    public void applyPrize(Prize p) {
        incrementLevels(p.getLevels());
		for (int i = 0; i < p.getTreasures(); i++) {
			hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
		}
    }

    public CombatResult combat(Monster m) {
		CombatResult result;
        if (getCombatLevel() > m.getLevel()) {
			applyPrize(m.getPrize());
			if(level < 10) {
				result = CombatResult.WIN;
			} else {
				result = CombatResult.WINANDWINGAME;
			}
		} else {
			if (Dice.getInstance().nextNumber() < 5) {
				BadConsequence bad = m.getBadConsequence();
				if (bad.kills()) {
					die();
					result = CombatResult.LOSEANDDIE;
				} else {
					applyBadConsequence(bad);
					result = CombatResult.LOSE;
				}
			} else {
				result = CombatResult.LOSEANDESCAPE;
			}
		}
		discardNecklaceIfVisible();
		return result;
    }

    public void applyBadConsequence(BadConsequence bad) {
        decrementLevels(bad.getLevels());
		setPendingBadConsequence(bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures));
    }

    public boolean makeTreasureVisible(Treasure t) {
        if (canMakeTreasureVisible(t)) {
			hiddenTreasures.remove(t);
			visibleTreasures.add(t);
			return true;
		} else {
			return false;
		}
    }

    public boolean canMakeTreasureVisible(Treasure t) {
		boolean presente = false;
		
		if (t.getType() == TreasureKind.ONEHAND) {
			int manos = 0;
			for (Treasure tes : visibleTreasures) {
				if(tes.getType() == TreasureKind.BOTHHANDS) {
					presente = true;
				} else if (tes.getType() == TreasureKind.ONEHAND) {
					manos++;
				}
			}
			presente |= manos >= 2;
			
		} else if (t.getType() == TreasureKind.BOTHHANDS) {
			for (Treasure tes : visibleTreasures) {
				if(tes.getType() == TreasureKind.BOTHHANDS ||
					tes.getType() == TreasureKind.ONEHAND) {
					presente = true;
				}
			}
			
		} else {
			for (Treasure tes : visibleTreasures) {
				if (tes.getType() == t.getType()) {
					presente = true;
				}
			}
		}
		return !presente;
    }

    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
		if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
			pendingBadConsequence.substractVisibleTreasure(t);
		}
		CardDealer.getInstance().giveTreasureBack(t);
		dieIfNoTreasures();
    }

    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);
		if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
			pendingBadConsequence.substractHiddenTreasure(t);
		}
		CardDealer.getInstance().giveTreasureBack(t);
		dieIfNoTreasures();
    }

    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        float levels = computeGoldCoinsValue(visible) + computeGoldCoinsValue(hidden);
		if(canIBuyLevels((int) levels)) {
			incrementLevels((int) levels);
			
			for (Treasure v : visible) {
				discardVisibleTreasure(v);
			}
			
			for (Treasure h : hidden) {
				discardHiddenTreasure(h);
			}
			
			return true;
		} else {
			return false;
		}
    }

    public int getCombatLevel() {
		int nv = level;
		
        boolean necklace = false;
        for (Treasure t : visibleTreasures) {
			if (t.getType() == TreasureKind.NECKLACE) {
				necklace = true;
			}
		}
		
		for (Treasure t : visibleTreasures) {
			nv+= necklace ? t.getMaxBonus() : t.getMinBonus();
		}
		
        return nv;
    }

    public boolean validState() {
        return (pendingBadConsequence == null || pendingBadConsequence.isEmpty())
			&& hiddenTreasures.size() <= 4;
    }

    public void initTreasures() {
        bringToLive();
		int number = Dice.getInstance().nextNumber();
		if (number == 1) {
			hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
		} else if (number == 6) {
			hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
			hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
			hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
		} else {
			hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
			hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
		}
    }

    public boolean isDead() {
        return dead;
    }

    public boolean hasVisibleTreasures() {
        return !visibleTreasures.isEmpty();
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
	
}
