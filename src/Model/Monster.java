package Model;

public class Monster implements Card {

  private String name;//nombre del monstruo
  private int combatLevel;//nivel de combate del monstruo
  private Prize prize;
  private BadConsequence bad;
  private int levelChangeAgainstCultistPlayer;//niveles que añade sectario

  Monster(String name, int level, BadConsequence bc, Prize price) {
    this.name = name;
    this.combatLevel = level;
    this.bad = bc;
    this.prize = price;
  }

  public Monster(String name, int level, BadConsequence bc, Prize prize, int levelCultist) {
    this(name, level, bc, prize);
    levelChangeAgainstCultistPlayer = levelCultist;
  }

  public String getName() {
    return this.name;
  }

  public int getLevel() {
    return this.combatLevel;
  }

  public BadConsequence getBadConsequence() {
    return bad;
  }

  public Prize getPrize() {
    return prize;
  }

  public String toString() {
    return name + ". Nivel " + Integer.toString(combatLevel) + "\nPremio: "
            + prize.toString() + "\nMal rollo: " + bad.toString();
  }

  @Override
  public int getBasicValue() {
    return getLevel();
  }

  @Override
  public int getSpecialValue() {
    return getLevel() + levelChangeAgainstCultistPlayer;
  }
}
