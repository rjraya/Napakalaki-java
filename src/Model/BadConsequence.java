package Model;

import java.util.ArrayList;

public abstract class BadConsequence {

  protected String text;

  public BadConsequence(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public abstract boolean isEmpty();

  public abstract boolean kills();

  public abstract int getLevels();

  public abstract void substractVisibleTreasure(Treasure t);

  public abstract void substractHiddenTreasure(Treasure t);

  public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden);

  public String toString() {
    return "Este es un mal rollo con el siguiente contenido:\n";
  }
}

