//package Examenes;
//
//import Model.BadConsequence;
//import Model.Player;
//import Model.Treasure;
//import Model.TreasureKind;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List; 
//import java.util.Iterator;
////Preparacion listas de tesoros y treasuresKinds
//// Treasure h = new Treasure("h",0,4,7,TreasureKind.HELMET)
//// Treasure s = new Treasure("S",0,3,4,TreasureKind.SHOE)
//// Treasure a = new Treasure("A",0,2,5,TreasureKind.ARMOR)
//// Treasure b = new Treasure("BH",0,1,1,TreasureKind.BOTHHANDS)
//// Treasure o = new Treasure("O",0,3,6,TreasureKind.ONEHAND)
//// Treasure n = new Treasure("N",0,0,0,TreasureKind.NECKLACE)
//
////tipos
////TreasureKind.HELMET    
////TreasureKind.SHOE
////TreasureKind.ARMOR
////TreasureKind.BOTHHANDS
////TreasureKind.ONEHAND
////TreasureKind.NECKLACE
//public class Examen3 {
//
//  public static void main(String[] args) {
//    Treasure h = new Treasure("h", 0, 4, 7, TreasureKind.HELMET);
//    Treasure s = new Treasure("S", 0, 3, 4, TreasureKind.SHOE);
//    Treasure a = new Treasure("A", 0, 2, 5, TreasureKind.ARMOR);
//    Treasure b = new Treasure("BH", 0, 1, 1, TreasureKind.BOTHHANDS);
//    Treasure o = new Treasure("O", 0, 3, 6, TreasureKind.ONEHAND);
//    Treasure n = new Treasure("N", 0, 0, 0, TreasureKind.NECKLACE);
//    TreasureKind th = TreasureKind.HELMET;    
//    TreasureKind ts = TreasureKind.SHOE;
//    TreasureKind ta =TreasureKind.ARMOR;
//    TreasureKind tb = TreasureKind.BOTHHANDS;
//    TreasureKind to = TreasureKind.ONEHAND;
//    TreasureKind tn = TreasureKind.NECKLACE;
//    Player p1 = new Player("1");
//    p1.setVisibleTreasureList(new ArrayList(Arrays.asList(s,h,o)));
//    p1.setHiddenTreasureList(new ArrayList(Arrays.asList(s,o,b,o,h,a)));
//    System.out.println(p1.toString());
//    for(Treasure t: p1.getVisibleTreasures()){
//      System.out.println(t.toString());
//    }
//    for(Treasure t: p1.getHiddenTreasures()){
//      System.out.println(t.toString());
//    }
//    System.out.println(p1.getCombatLevel());
//    p1.addTreasure(n);
//    System.out.println(p1.getCombatLevel());
//    ArrayList<Treasure> inv  = p1.getHiddenTreasures();
//    for(Treasure t: inv){
//      System.out.println(p1.canMakeTreasureVisible(t));
//    }
//    BadConsequence b1 = new BadConsequence("b",0,new ArrayList(Arrays.asList(to,to,tb,th)),new ArrayList(Arrays.asList(to,to,tb,tb,ts)));
//    System.out.println(b1.toString());
//    BadConsequence com = b1.adjustToFitTreasureLists(new ArrayList(Arrays.asList(s,o,h,o)), new ArrayList(Arrays.asList(h,o)));
//    System.out.println(com.toString());
//    com = b1.adjustToFitTreasureLists(new ArrayList(Arrays.asList(s,h,b)),new ArrayList(Arrays.asList(h,o,s)));
//    System.out.println(com.toString());
//    BadConsequence b2 = new BadConsequence("2",0,new ArrayList(),new ArrayList());
//    Player p2 = new Player("2");
//    p2.setPendingBadConsequence(b2);
//    System.out.println(p2.validState());
//   
//    System.out.println( b2.adjustToFitTreasureLists(new ArrayList(Arrays.asList(ta)), new ArrayList()));
//    BadConsequence b3 = new BadConsequence("3",0,0,0);
//    Player p3 = new Player("3");
//    p3.setPendingBadConsequence(b3);
//    System.out.println(p3.validState());
//    System.out.println(b3.adjustToFitTreasureLists(new ArrayList(Arrays.asList(ta)), new ArrayList()));
//  }
//}
