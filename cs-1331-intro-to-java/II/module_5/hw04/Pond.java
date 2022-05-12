public class Pond {
  public static void main(String[] args) {
    // create frogs
    Frog frog1 = new Frog("Peepo");
    Frog frog2 = new Frog("Pepe", 10, 15);
    Frog frog3 = new Frog("Peepaw", 4.6, 5);
    Frog frog4 = new Frog("Yeehaw");

    // create flies
    Fly fly1 = new Fly(1,3);
    Fly fly2 = new Fly(6);
    Fly fly3 = new Fly(12);

    // pond mechanics
    Frog.setSpecies("1331 Frogs");
    System.out.println(frog1);
    frog1.eat(fly2);
    System.out.println(fly2);
    
    frog1.grow(8);
    frog1.eat(fly2);
    System.out.println(fly2);
    System.out.println(frog1);
    
    System.out.println(frog4);
    
    frog3.grow(4);
    System.out.println(frog4);
    
    System.out.println(frog2);
  }
}