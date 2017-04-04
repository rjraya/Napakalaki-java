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

  public Player(String name) {
    this.dead = true;
    this.name = name;
    this.level = 1;
    this.visibleTreasures = new ArrayList<>();
    this.hiddenTreasures = new ArrayList<>();
    this.pendingBadConsequence = null;
  }

  public Player(Player p) {
    this.dead = p.dead;
    this.name = p.name;
    this.level = p.level;
    this.pendingBadConsequence = p.pendingBadConsequence;
    this.visibleTreasures = new ArrayList<>();
    for (Treasure t : p.visibleTreasures) {
      this.visibleTreasures.add(t);
    }
    this.hiddenTreasures = new ArrayList<>();
    for (Treasure t : p.hiddenTreasures) {
      this.hiddenTreasures.add(t);
    }
  }

  public String toString() {
    String bc = pendingBadConsequence == null ? "Ninguno" : pendingBadConsequence.toString();
    return "Nombre: " + name + " Nivel: " + Integer.toString(level) + " Combate: " + Integer.toString(getCombatLevel())
            + "\nMal Rollo: " + bc
            + "\nVisibles: " + this.visibleTreasures.toString() + "\nInvisibles: " + this.hiddenTreasures.toString();
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public BadConsequence getPendingBadConsequence() {
    return pendingBadConsequence;
  }

  private void bringToLive() {//nombre según el diagrama de clases
    this.dead = false;
  }

  private void incrementLevels(int i) {
    this.level += i;
    if (this.level > 10) {
      this.level = 10;
    }
  }

  private void decrementLevels(int i) {
    this.level -= i;
    if (this.level < 1) {
      this.level = 1;
    }
  }

  //Examen

  public void setPendingBadConsequence(BadConsequence b) {
    this.pendingBadConsequence = b;
  }

  //Fin examen

  private void die() {//morir consiste en perder los tesoros,nivel uno,dead=true
    for (Treasure v : this.visibleTreasures) {
      CardDealer.getInstance().giveTreasureBack(v);
    }
    this.visibleTreasures.clear();

    for (Treasure h : this.hiddenTreasures) {
      CardDealer.getInstance().giveTreasureBack(h);
    }
    this.hiddenTreasures.clear();
    this.level = 1;
    this.dead = true;
  }

  private void discardNecklaceIfVisible() {
    Treasure necklace = null;
    for (Treasure tes : this.visibleTreasures) {//busca necklace (solo uno equipado es posible)
      if (tes.getType() == TreasureKind.NECKLACE) {
        necklace = tes;
      }
    }
    if (necklace != null) {
      CardDealer.getInstance().giveTreasureBack(necklace);
      this.visibleTreasures.remove(necklace);
    }
  }

  private void dieIfNoTreasures() {
    if (this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty()) {
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
    return oro / 1000F;//F  indica float
  }

  public void applyPrize(Prize p) {
    incrementLevels(p.getLevels());
    for (int i = 0; i < p.getTreasures(); i++) {
      hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
    }
  }

  public CombatResult combat(Monster m) {
    CombatResult result;
    if (getCombatLevel() > getOponentLevel(m)) {
      applyPrize(m.getPrize());
      if (level < 10) {
        result = CombatResult.WIN;
      } else {
        result = CombatResult.WINANDWINGAME;
      }
    } else {//no gana
      if (Dice.getInstance().nextNumber() < 5) {
        BadConsequence bad = m.getBadConsequence();
        if (bad.kills()) {
          die();
          result = CombatResult.LOSEANDDIE;
        } else {
          if (this.shouldConvert()) {//si se convierte en cultista
            result = CombatResult.LOSEANDCONVERT;
          } else {//si no se convierte en cultista
            this.applyBadConsequence(bad);
            result = CombatResult.LOSE;
          }
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
        if (tes.getType() == TreasureKind.BOTHHANDS) {//busca un bothhands...
          presente = true;
        } else if (tes.getType() == TreasureKind.ONEHAND) {//...o cuenta los onehand que ya hay
          manos++;
        }
      }
      presente |= manos >= 2;

    } else if (t.getType() == TreasureKind.BOTHHANDS) {
      for (Treasure tes : visibleTreasures) {
        if (tes.getType() == TreasureKind.BOTHHANDS
                || tes.getType() == TreasureKind.ONEHAND) {//busca un bothhands o un onehand
          presente = true;
        }
      }

    } else {
      for (Treasure tes : visibleTreasures) {
        if (tes.getType() == t.getType()) {//en general, busco alguno del mismo tipo
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
    if (canIBuyLevels((int) levels)) { //typecasting truncates the value
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
    for (Treasure t : visibleTreasures) {//si tiene equipado collar
      if (t.getType() == TreasureKind.NECKLACE) {
        necklace = true;
      }
    }

    for (Treasure t : visibleTreasures) {
      nv += necklace ? t.getSpecialValue() : t.getBasicValue();
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
    return !this.visibleTreasures.isEmpty();
  }

  public ArrayList<Treasure> getVisibleTreasures() {
    return visibleTreasures;
  }

  public ArrayList<Treasure> getHiddenTreasures() {
    return hiddenTreasures;
  }

  protected int getOponentLevel(Monster m) {
    return m.getBasicValue();
  }

  protected boolean shouldConvert() {
    return Dice.getInstance().nextNumber() == 6; //comprueba si al tirar de nuevo el dado muere
  }

  //examen

  public void setVisibleTreasureList(ArrayList<Treasure> a) {
    this.visibleTreasures = a;
  }

  public void setHiddenTreasureList(ArrayList<Treasure> a) {
    this.hiddenTreasures = a;
  }

  public void addTreasure(Treasure t) {
    this.visibleTreasures.add(t);
  }
    //fin examen
}
