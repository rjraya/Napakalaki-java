package Model;

import java.util.ArrayList;

public class BadConsequence {

    //Representa lo que dice un mal rollo

    private String text;
    //Representa los niveles que se pierden
    private int levels;
    //Representa el número de tesoros visibles que se pierden
    private int nVisibleTreasures;
    //Representa el número de tesoros ocultos que se pierden
    private int nHiddenTreasures;
    //Representa un mal rollo de tipo muerte;
    private boolean death;
	//inicializar en el constructor
    //o bien se usan los numéricos o bien las listas
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;

    //Constructores
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        death = false;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.levels = 0;
        nVisibleTreasures = -1;
        nHiddenTreasures = -1;
        this.death = death;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }

    public BadConsequence(String text, int levels,
            ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden) {
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = -1;
        nHiddenTreasures = -1;
        this.death = false;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }

    public boolean isEmpty() {
        return nVisibleTreasures <= 0 && nHiddenTreasures <= 0
                && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }

    public boolean kills() {
        return death;
    }

    public int getLevels() {
        return levels;
    }

    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }

    public String getText() {
        return text;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public void substractVisibleTreasure(Treasure t) {
		if (nVisibleTreasures != -1) { //BadConsecuenqe tipo numero
			if (nVisibleTreasures > 0) nVisibleTreasures--;
		} else { //BadConsequence de tipo especifico
			specificVisibleTreasures.remove(t.getType()); //Borra el primero que encuentra
		}
    }

    public void substractHiddenTreasure(Treasure t) {
		if (nHiddenTreasures != -1) { //BadConsequence tipo numero
			if (nHiddenTreasures > 0) nHiddenTreasures--;
		} else { //BadConsequence de tipo especifico
			specificHiddenTreasures.remove(t.getType());
		}
    }

    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
		if (nVisibleTreasures != -1) { //Bad Consecuenqe tipo numero
			int minVisible = nVisibleTreasures > visible.size() ? visible.size() : nVisibleTreasures;
			int minHidden = nHiddenTreasures > hidden.size() ? hidden.size() : nHiddenTreasures;
			return new BadConsequence(text, levels, minVisible, minHidden);
		} else { //Bad Consequence tpo especifico		
			ArrayList<Treasure> visibleCopy = (ArrayList <Treasure>) visible.clone();
			ArrayList<TreasureKind> nuevoVisible = new ArrayList<>();
			for (TreasureKind k : specificVisibleTreasures) {
				Treasure hecho = null;
				for (int i = 0; i < visibleCopy.size() && hecho == null; i++) {
					if (visibleCopy.get(i).getType() == k) {
						nuevoVisible.add(k);
						hecho = visibleCopy.get(i);
					}
				}
				if (hecho != null) {
					visibleCopy.remove(hecho);
				}
			} 
			
			ArrayList<Treasure> hiddenCopy = (ArrayList <Treasure>) hidden.clone();
			ArrayList<TreasureKind> nuevoHidden = new ArrayList<>();
			for (TreasureKind k : specificHiddenTreasures) {
				Treasure hecho = null;
				for (int i = 0; i < hiddenCopy.size() && hecho == null; i++) {
					if (hiddenCopy.get(i).getType() == k) {
						nuevoHidden.add(k);
						hecho = hiddenCopy.get(i);
					}
				}
				if (hecho != null) {
					hiddenCopy.remove(hecho);
				}
			}

			return new BadConsequence(text, levels, nuevoVisible, nuevoHidden);
		}
		
    }

	
	public String toString() {
		return text;
	}
}
