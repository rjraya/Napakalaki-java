package Model;

public class Cultist implements Card{
  private String name;
  private int gainedLevels;
  public Cultist(String name,int gainedLevels){
    this.name = name;
    this.gainedLevels = gainedLevels;
  }
  
  @Override
  public int getBasicValue(){
    return gainedLevels;
  }
  
  @Override
  public int getSpecialValue(){
    //sumando el nivel que indica su carta de sectario multiplicado por el número 
    //de sectarios en juego
    return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
  }
}
