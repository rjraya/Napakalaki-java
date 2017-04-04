//package Examenes;
//
//import Model.BadConsequence;
//import Model.Monster;
//import Model.Prize;
//import Model.TreasureKind;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class NapakalakyVeranoJava {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        ArrayList<Monster> monstruos = new ArrayList();
//        
//        BadConsequence badConsequence;
//        Prize prize;
//		
//        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
//        prize = new Prize(2, 1);
//        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",
//                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
//
//        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",
//                0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
//                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
//        prize = new Prize(4, 1);
//        monstruos.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 6, 0);
//        prize = new Prize(3, 1);
//        monstruos.add(new Monster("El gorron en el umbral", 10, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
//        prize = new Prize(2, 1);
//        monstruos.add(new Monster("H.P.Munchcraft", 6, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",
//                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
//        prize = new Prize(4, 2);
//        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",true);
//        prize = new Prize(2, 1);
//        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
//        prize = new Prize(2, 1);
//        monstruos.add(new Monster("Semillas Cthulu", 4, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible",
//                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
//        prize = new Prize(2, 1);
//        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));
//
//        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto",true);
//        prize = new Prize(3, 1);
//        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
//
//        badConsequence = new BadConsequence("La famila te atrapa. Estas muerto",true);
//        prize = new Prize(4, 1);
//        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
//
//        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro dos manos visible",
//                2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
//        prize = new Prize(2, 1);
//        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.",
//                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
//
//        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",
//                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
//        prize = new Prize(1, 1);
//        monstruos.add(new Monster("Bicefalo", 20, badConsequence, prize));
//        
//  
////        System.out.println("Monstruos con nivel de combate superior a 10");
////        for(Monster m: monstruos){
////            if(m.getCombatLevel() > 10){
////                System.out.println(m);
////                System.out.println();
////            }
////        }
//        System.out.println("Mal rollo que implique solo pérdida de niveles");
//        for(Monster m: monstruos){
//          BadConsequence bad = m.getBadConsequence();
//          boolean cond = bad.getLevels() > 0
//                  && bad.getNHiddenTreasures() == 0
//                  && bad.getNVisibleTreasures() == 0
//                  && bad.getSpecificHidden() == null
//                  && bad.getSpecificVisible() == null
//                  && bad.getDeath() == false;
//          
//          if(cond == true){
//              System.out.println(m);
//              System.out.println();
//          }
//        }
////        
////        System.out.println("Buen rollo ganancia niveles superior a 1");
////        for(Monster m: monstruos){
////            if(m.getPrize().getLevels() > 1){
////                System.out.println(m);
////                System.out.println();
////            }
////        }
//        
////        System.out.println("Mal rollo pierde al menos un hand");
////        for(Monster m: monstruos){
////            BadConsequence bad = m.getBadConsequence();
////            if(bad.getSpecificHidden() != null){
////                if(bad.getSpecificHidden().contains(TreasureKind.ONEHAND)){
////                    System.out.println(m);System.out.println();
////                }else if(bad.getSpecificVisible() != null){
////                    if(bad.getSpecificVisible().contains(TreasureKind.ONEHAND)){
////                        System.out.println(m);System.out.println();         
////                    }
////                }
////            }
////        }
//    }
//}
//    
