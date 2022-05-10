public class EqualityTest {

  public static void main(String[] args) {
    // strings created with `new String` are not put into constant pool
    String x = new String("park");
    String y = new String("park");
  
    if (x == y) {
      System.out.println("x and y are aliases");
    }

    if (x != y) {
      System.out.println("x and y are not aliases");
    }

    if (x.equals(y)) {
      System.out.println("x and y have the same contents");
      System.out.println("x: " + x);
      System.out.println("y: " + y);
    }
  }
}