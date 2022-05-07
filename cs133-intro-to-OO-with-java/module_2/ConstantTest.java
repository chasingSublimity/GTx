package module_2;

public class ConstantTest {
  public static void main(String[] args) {
    final double PI = 3.1459265359;
    PI = 3.14;
  }
}
/*
  Does not compile due to re-assigning of constant
*/