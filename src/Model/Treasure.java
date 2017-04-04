package Model;

public class Treasure implements Card {

  private String name;
  private int goldCoins;
  private int minBonus;
  private int maxBonus;
  private TreasureKind type;

  public Treasure(String name, int gold, int min, int max, TreasureKind t) {
    this.name = name;
    this.goldCoins = gold;
    this.minBonus = min;
    this.maxBonus = max;
    this.type = t;
  }

  public String getName() {
    return name;
  }

  public int getGoldCoins() {
    return goldCoins;
  }

  public TreasureKind getType() {
    return type;
  }

  @Override
  public int getBasicValue() {
    return minBonus;
  }

  @Override
  public int getSpecialValue() {
    return maxBonus;
  }

  public String toString() {
    return name + ": " + goldCoins + " oro, Bonus: (" + minBonus + "/" + maxBonus
            + ") Tipo: " + type;
  }
}
