package Model;
import java.util.ArrayList;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import Model.Napakalaki;
//import Test.GameTester;

public class Main {

  public static void main(String[] args) {
//    // Entorno texto
//    Napakalaki game = Napakalaki.getInstance();
//    GameTester test = GameTester.getInstance();
//
//    // Poner el numero de jugadores con el que se quiera probar
//    test.play(game, 2);
//    //
    ArrayList<String> names = new ArrayList();
    Napakalaki napakalakiModel = Napakalaki.getInstance();
    NapakalakiView napakalakiView = new NapakalakiView();   
    Dice.createInstance(napakalakiView);
    PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
    names = namesCapture.getNames();
    napakalakiModel.initGame(names);
    napakalakiView.setNapakalaki(napakalakiModel);
    napakalakiView.showView();

  }
}
