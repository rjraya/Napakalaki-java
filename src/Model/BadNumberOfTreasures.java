package Model;

import java.util.ArrayList;

public class BadNumberOfTreasures extends BadConsequence {

  private int levels;
  private int nVisibleTreasures;
  private int nHiddenTreasures;

  public BadNumberOfTreasures(String text, int levels, int nVisible, int nHidden) {
    super(text);
    this.levels = levels;
    this.nVisibleTreasures = nVisible;
    this.nHiddenTreasures = nHidden;
  }

  public int getNVisibleTreasures() {
    return nVisibleTreasures;
  }

  public int getNHiddenTreasures() {
    return nHiddenTreasures;
  }

  @Override
  public boolean isEmpty() {
    return nVisibleTreasures == 0 && nHiddenTreasures == 0;
  }

  @Override
  public int getLevels() {
    return levels;
  }

  @Override
  public boolean kills() {
    return false;
  }

  @Override
  public void substractVisibleTreasure(Treasure t) {
    if (nVisibleTreasures > 0) {
      nVisibleTreasures--;
    }
  }

  @Override
  public void substractHiddenTreasure(Treasure t) {
    if (nHiddenTreasures > 0) {
      nHiddenTreasures--;
    }
  }

  @Override
  public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
    int minVisible = nVisibleTreasures > visible.size() ? visible.size() : nVisibleTreasures;
    int minHidden = nHiddenTreasures > hidden.size() ? hidden.size() : nHiddenTreasures;
    return new BadNumberOfTreasures(text, levels, minVisible, minHidden);
  }

  @Override
  public String toString() {
    return super.toString()
            + "Texto: " + this.getText()
            + "\nNiveles: " + Integer.toString(this.getLevels())
            + "\nDebes descartarte de " + Integer.toString(this.getNVisibleTreasures()) + " visibles y de "
            + Integer.toString(this.getNHiddenTreasures()) + " ocultos\n";
  }
}
