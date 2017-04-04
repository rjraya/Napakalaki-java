package Model;

public class Prize {
	private int treasures;
	private int levels;

	public Prize(int treasures, int levels){
        this.treasures = treasures;
		this.levels = levels;
	}

	public int getTreasures(){
		return treasures;
	}
	public int getLevels(){
		return levels;
	}

	public String toString(){
		return "Tesoros: "+ Integer.toString(treasures)+", Niveles: " + 
			Integer.toString(levels);
	}  
}
