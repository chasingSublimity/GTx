import java.util.Scanner;

public class Scratch {

  public static int f(int x, int y) {
    if (x == 0) {
        return y;
    } else {
        return f(x - 1, y + 2);
    }
}
  public static void main(String[] args) {
    System.out.println(f(3,4));
  }
}