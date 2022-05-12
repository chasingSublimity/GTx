public class InsectClient {
  public static void main(String[] args) {
    System.out.println(Insect.produceRandomFact());
    Insect bug1 = new Insect(13, 31, 0);
    Insect bug2 = new Insect(13);
    System.out.println(bug1);
    System.out.println(Insect.getPopulation());
    System.out.println(Insect.getPopulation());
  }
}