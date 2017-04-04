package Model;

public class Prize {

  private int treasures;
  private int levels;

  Prize(int treasures, int levels) {
    this.treasures = treasures;
    if (levels > 1) {
      this.levels = levels;
    } else {
      this.levels = 1;
    }
  }

  public int getTreasures() {
    return treasures;
  }

  public int getLevels() {
    return levels;
  }

  public String toString() {
    return "Tesoros: " + Integer.toString(treasures) + ", Niveles: "
            + Integer.toString(levels);
  }
}
