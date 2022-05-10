public class ArraySearch {
  public static void main(String args[]) {
    String[] concepts = {"abstraction", "polymorphism", "inheritance", "encapsulation"};

    System.out.println(searchStringArray("polymorphism", concepts));
    System.out.println(searchStringArray("inheritance", concepts));
    System.out.println(searchStringArray("boobah", concepts));
  }

  public static Boolean searchStringArray(String target, String[] array) {
    Boolean result = false;
    for (String element: array) {
      if (element.equals(target)) {
        result = true;
        break;
      }
    }
    return result;
  }
}