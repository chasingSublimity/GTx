import java.util.Scanner;

public class FahrenheitToCelsius {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a F temp value: ");
    int fahrenheit = input.nextInt();
    System.out.print("Enter a day: ");
    String day = input.next();
    double cel = (5.0/9) * (fahrenheit - 32);
    System.out.printf("%s Fahrenheit: %d\n", day, fahrenheit);
    System.out.printf("%s Celsius: %.1f\n", day, cel);
  }
}