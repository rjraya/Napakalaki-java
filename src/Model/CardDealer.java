package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardDealer {

  private static CardDealer instance = null;
  private ArrayList<Monster> usedMonsters;
  private ArrayList<Monster> unusedMonsters;
  private ArrayList<Treasure> usedTreasures;
  private ArrayList<Treasure> unusedTreasures;
  private ArrayList<Cultist> unusedCultists;

  public static CardDealer getInstance() {
    if (instance == null) {
      instance = new CardDealer();
    }
    return instance;
  }

  private CardDealer() {
    usedMonsters = new ArrayList<Monster>();
    unusedMonsters = new ArrayList<Monster>();
    usedTreasures = new ArrayList<Treasure>();
    unusedTreasures = new ArrayList<Treasure>();
    unusedCultists = new ArrayList<Cultist>();
  }

  ;
    
    private void initTreasureCardDeck() {
    unusedTreasures.add(new Treasure("¡Si mi amo!", 0, 4, 7, TreasureKind.HELMET));
    unusedTreasures.add(new Treasure("Botas de investigacion", 600, 3, 4, TreasureKind.SHOE));
    unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));
    unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));
    unusedTreasures.add(new Treasure("Botas de lluvia acida", 800, 1, 1, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));
    unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));
    unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Fez alopodo", 700, 3, 5, TreasureKind.HELMET));
    unusedTreasures.add(new Treasure("Hacha prehistorica", 500, 2, 5, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("El aprato del Pr. Tela", 900, 4, 8, TreasureKind.ARMOR));
    unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Garabato mistico", 300, 2, 2, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("La fuerza de Mr.T", 1000, 0, 0, TreasureKind.NECKLACE));
    unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
    unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Necro-playboycón", 300, 3, 5, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
    unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
    unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
    unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));
    unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
  }

  private void initMonsterCardDeck() {
    BadConsequence badConsequence;
    Prize prize;

    badConsequence = new BadTreasureKind("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));

    badConsequence = new BadTreasureKind("Embobados con el lindo primigenio te descartas de tu casco visible",
            0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));

    badConsequence = new BadTreasureKind("El primordial bostezo contagioso. Pierdes el calzado visible",
            0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

    badConsequence = new BadTreasureKind("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
            0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
    prize = new Prize(4, 1);
    unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence, prize));

    badConsequence = new BadNumberOfTreasures("Pierdes todos tus tesoros visibles", 0, 6, 0);
    prize = new Prize(3, 1);
    unusedMonsters.add(new Monster("El gorron en el umbral", 10, badConsequence, prize));

    badConsequence = new BadTreasureKind("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("H.P.Munchcraft", 6, badConsequence, prize));

    badConsequence = new BadTreasureKind("Sientes bichos bajo la ropa. Descarta la armadura visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));

    badConsequence = new BadNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
    prize = new Prize(4, 2);
    unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));

    badConsequence = new BadNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

    badConsequence = new BadDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto");
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));

    badConsequence = new BadNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("Semillas Cthulu", 4, badConsequence, prize));

    badConsequence = new BadTreasureKind("Te intentas escaquear. Pierdes una mano visible",
            0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));

    badConsequence = new BadNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));

    badConsequence = new BadDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto");
    prize = new Prize(3, 1);
    unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));

    badConsequence = new BadDeath("La famila te atrapa. Estas muerto");
    prize = new Prize(4, 1);
    unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));

    badConsequence = new BadTreasureKind("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro dos manos visible",
            2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

    badConsequence = new BadTreasureKind("Te asusta en la noche. Pierdes un casco visible.",
            0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));

    badConsequence = new BadNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));

    badConsequence = new BadTreasureKind("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",
            0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("Bicefalo", 20, badConsequence, prize));

    badConsequence = new BadTreasureKind("Pierdes 1 mano visible", 0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
    prize = new Prize(3, 1);
    unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));

    badConsequence = new BadNumberOfTreasures("Pierdes tus tesoros visibles.Jajaja.", 0, 6, 0);
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize, 2));

    badConsequence = new BadDeath("Hoy no es tu día de suerte. Mueres.");
    prize = new Prize(2, 5);
    unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));

    badConsequence = new BadNumberOfTreasures("Tu gobierno te recorta 2 niveles", 2, 0, 0);
    prize = new Prize(2, 1);
    unusedMonsters.add(new Monster("Serpiente Político", 8, badConsequence, prize, -2));

    badConsequence = new BadTreasureKind("Pierdes tu caso y tu armadura visible. Pierdes tus manos ocultas", 0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
            //hay un máximo de 4 cartas ocultas
            new ArrayList(Arrays.asList(
                            TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND,
                            TreasureKind.ONEHAND, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS,
                            TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS)));
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));

    badConsequence = new BadNumberOfTreasures("Pierdes 2 niveles", 2, 0, 0);
    prize = new Prize(4, 2);
    unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));

    badConsequence = new BadNumberOfTreasures("Pinta labios negro. Pierdes 2 niveles", 2, 0, 0);
    prize = new Prize(1, 1);
    unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
  }

  private void initCultistCardDeck() {
    unusedCultists.add(new Cultist("Sectario", 1));
    unusedCultists.add(new Cultist("Sectario", 2));
    unusedCultists.add(new Cultist("Sectario", 1));
    unusedCultists.add(new Cultist("Sectario", 2));
    unusedCultists.add(new Cultist("Sectario", 1));
    unusedCultists.add(new Cultist("Sectario", 1));
  }

  private void shuffleTreasures() {
    Collections.shuffle(this.unusedTreasures);
  }

  private void shuffleMonsters() {
    Collections.shuffle(this.unusedMonsters);
  }

  private void shuffleCultists() {
    Collections.shuffle(unusedCultists);
  }

  public Treasure nextTreasure() {
    if (this.unusedTreasures.isEmpty()) {
      this.unusedTreasures = usedTreasures;
      this.usedTreasures = new ArrayList();
      shuffleTreasures();
    }
    return this.unusedTreasures.remove(0);
  }

  public Monster nextMonster() {
    if (this.unusedMonsters.isEmpty()) {
      this.unusedMonsters = usedMonsters;
      this.usedMonsters = new ArrayList();
      shuffleMonsters();
    }
    return this.unusedMonsters.remove(0);
  }

  public Cultist nextCultist() {
    if (unusedCultists.isEmpty()) {
      //Demasiados sectarios. Nunca llegara aqui (sólo tres jugadores)
      //shouldConvert de un cultista devuelve false
      //Por eso no se proporciona usedCultists
      return null;
    } else {
      return unusedCultists.remove(0);
    }
  }

  public void giveTreasureBack(Treasure t) {
    usedTreasures.add(t);
  }

  public void giveMonsterBack(Monster m) {
    usedMonsters.add(m);
  }

  public void initCards() {
    initMonsterCardDeck();
    shuffleMonsters();
    initTreasureCardDeck();
    shuffleTreasures();
    initCultistCardDeck();
    shuffleCultists();
  }
}
