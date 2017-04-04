package Model;

public class Treasure {
	private String name;
	private int goldCoins;
	private int minBonus;
	private int maxBonus;
	private TreasureKind type;
	
	public Treasure(String n, int g, int min, int max, TreasureKind t) {
		name = n;
		goldCoins = g;
		minBonus = min;
		maxBonus = max;
		type = t;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGoldCoins() {
		return goldCoins;
	}
	
	public int getMinBonus() {
		return minBonus;
	}
		
	public int getMaxBonus() {
		return maxBonus;
	}
	
	public TreasureKind getType() {
		return type;
	}
	
	public String toString() {
		return name + ": " + goldCoins + " oro, Bonus: (" + minBonus + "/" + maxBonus +
				") Tipo: " + type;
	}
}
