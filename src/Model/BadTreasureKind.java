package Model;
import java.util.Iterator;
import java.util.ArrayList;

public class BadTreasureKind extends BadConsequence {

  private int levels;
  private ArrayList<TreasureKind> specificHiddenTreasures;
  private ArrayList<TreasureKind> specificVisibleTreasures;

  public BadTreasureKind(String text, int levels, ArrayList<TreasureKind> tVisible,ArrayList<TreasureKind> tHidden) {
    super(text);
    this.levels = levels;
    specificVisibleTreasures = tVisible; //no debe ser null
    specificHiddenTreasures = tHidden;   //no debe ser null
  }

  public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
    return specificVisibleTreasures;
  }

  public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
    return specificHiddenTreasures;
  }

  @Override
  public boolean isEmpty() {
    return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
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
    specificVisibleTreasures.remove(t.getType());
  }

  @Override
  public void substractHiddenTreasure(Treasure t) {
    specificHiddenTreasures.remove(t.getType());
  }

  @Override
  public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
    ArrayList<Treasure> visibleCopy = (ArrayList<Treasure>) visible.clone();
    ArrayList<TreasureKind> nuevoVisible = new ArrayList();
    
    for (TreasureKind k : specificVisibleTreasures) {
      boolean eliminado = false;
      for(Iterator<Treasure> it = visibleCopy.iterator();it.hasNext() && !eliminado;){
        Treasure t = it.next();
        if(t.getType() == k){
          nuevoVisible.add(k);
          it.remove();
          eliminado = true;
        }
      }
    }

    ArrayList<TreasureKind> nuevoHidden = new ArrayList<>();
    for (TreasureKind k : specificHiddenTreasures) {
      boolean eliminado = false;
      for(Iterator<Treasure> it = hidden.iterator();it.hasNext();){
        Treasure t = it.next();
        if(t.getType() == k){
          nuevoHidden.add(k);
          it.remove();
          eliminado = true;
        }
      }
    }

    return new BadTreasureKind(text, levels, nuevoVisible, nuevoHidden);
  }

  @Override
  public String toString() {   
    String visibles = "", ocultos = "";
    for (TreasureKind t : specificVisibleTreasures) {
      visibles += t.toString() + " ";
    }
    if (visibles.equals("")) {
      visibles = "ningun visible";
    } else {
      visibles += "visibles";
    }
    for (TreasureKind t : specificHiddenTreasures) {
      ocultos += t.toString() + " ";
    }
    if (ocultos.equals("")) {
      ocultos = "ningun oculto";
    } else {
      ocultos += "ocultos";
    }
    return super.toString() + "\nTexto: " + this.getText() + "\nNiveles: " + Integer.toString(this.getLevels())
           + "\nDebes descartarte de " + visibles + " y " + ocultos;
  }

}
