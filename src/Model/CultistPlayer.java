package Model;
import java.util.ArrayList;

public class CultistPlayer extends Player{
  
  private static int totalCultistPlayers = 0;
  private Cultist myCultistCard;
  
  public CultistPlayer(Player p, Cultist c){
   super(p);//constructor de copia
   this.myCultistCard = c;
   totalCultistPlayers++;
  }
  
  public static int getTotalCultistPlayers(){
    return totalCultistPlayers;
  }
  
  @Override
  public String getName() {
	  return "Sectario: " + super.getName();
  }
  
  @Override
  protected float computeGoldCoinsValue(ArrayList<Treasure> treasures){
    return super.computeGoldCoinsValue(treasures)*2;
  }
    
  @Override
  protected boolean shouldConvert(){
    return false;
  }
  
  @Override
  public int getCombatLevel(){
    return super.getCombatLevel() + myCultistCard.getSpecialValue();
  }
  
  @Override
  protected int getOponentLevel(Monster m){
    return m.getSpecialValue();
  }
  
  @Override
  public String toString() {
	  return "Sectario(+"+ myCultistCard.getBasicValue()+ "x): " + super.toString();
  }
  
  //propio
  public int getCardBonus(){
    return myCultistCard.getBasicValue();
  }
}

