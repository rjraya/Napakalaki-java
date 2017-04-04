package Model;

import java.util.Random;

public class Dice {

    private static Dice instance = null;

    //Generador de numeros aleatorios
    private Random rand;

    private Dice() {
        rand = new Random();
    }

    public static Dice getInstance() {
        //si no se ha inicializado lo inicializa
        if (instance == null) {
            instance = new Dice();
        }
        return instance;
    }

    public int nextNumber() {
        //de 0 a 5 mas 1
        return rand.nextInt(6) + 1;
    }
}
