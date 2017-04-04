package Model;

import java.util.ArrayList;

public class BadDeath extends BadConsequence {

  public BadDeath(String text) {
    super(text);
  }

  @Override
  public boolean isEmpty() {
    //confía la responsabilidad de haber matado al jugador al resto de la aplicación
    return true;
  }

  @Override
  public boolean kills() {
    return true;
  }

  @Override
  public int getLevels() {
    return 0;
  }

  @Override
  public void substractVisibleTreasure(Treasure t) {/*Vacio*/

  }

  @Override
  public void substractHiddenTreasure(Treasure t) {/*Vacio*/

  }

  @Override
  public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
    return new BadDeath(text);
  }

  @Override
  public String toString() {
    return super.toString() + "Texto: " + this.getText() + " Muerte\n";
  }

}
