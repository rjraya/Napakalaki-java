package Model;

public class Monster {
    //Representa el nombre del monstruo
    private String name;
    //Representa el nivel de combate del monstruo
    private int level;
    
    private Prize prize;
    
    private BadConsequence badConsequence;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.level = level;
        badConsequence = bc;
        this.prize = prize;
    }
    
    
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }

    public BadConsequence getBadConsequence() {
		return badConsequence;
    }

    public Prize getPrize() {
		return prize;
    }

    public String toString(){
        return name +". Nivel " + Integer.toString(level) +"\nPremio: "+
			prize.toString()+ "\nMal rollo: " + badConsequence.toString();
    }
}
