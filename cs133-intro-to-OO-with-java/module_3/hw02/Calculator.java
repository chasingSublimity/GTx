import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    print("List of operations: add subtract multiply divide alphabetize");
    print("Enter an operation: ");
    String op = input
      .nextLine()
      .toLowerCase();

    String baseResult = "Answer: ";
    // make default the error message
    String result = "";
    switch(op) {
      case "add":
        print("Enter two integers: ");
        try {
          int sum = add(
            input.nextInt(),
            input.nextInt()
          );
          result = String.format("%s%d", baseResult, sum);
        } catch (Exception e) {
          result = "Invalid input entered. Terminating...";
        } finally {
          break;
        }
      case "subtract":
        print("Enter two integers: ");
        try {
          int diff = subtract(
            input.nextInt(),
            input.nextInt()
          );
          result = String.format("%s%d", baseResult, diff);
        } catch (Exception e) {
          result = "Invalid input entered. Terminating...";
        } finally {
          break;
        }
      case "multiply":
        print("Enter two doubles: ");
        try {
          double product = multiply(
            input.nextDouble(),
            input.nextDouble()
          );
          result = String.format("%s%.2f", baseResult, product);
        } catch(Exception e) {
          result = "Invalid input entered. Terminating...";
        } finally {
          break;
        }
      case "divide":
        print("Enter two doubles: ");
        try {
          double dividend = input.nextDouble();
          double divisor = input.nextDouble();
          if (divisor == 0) {
            result = "Invalid input entered. Terminating...";
          } else {
            double quotient = divide(
              dividend,
              divisor
            );
            result = String.format("%s%.2f", baseResult, quotient);
          }
        } catch (Exception e) {
          result = "Invalid input entered. Terminating...";
        } finally {
          break;
        }
      case "alphabetize":
        print("Enter two words: ");
        String order = alphabetize(
          input.next(),
          input.next()
        );
        result = String.format("%s%s", baseResult, order);
        break;
      default:
        result = "Invalid input entered. Terminating...";
    }

    print(result);
  }

  static int add(int x, int y) {
    return x + y;
  }

  static int subtract(int x, int y) {
    return x - y;
  }

  static double multiply(double x, double y) {
    return x * y;
  }

  static double divide(double x, double y) {
    return x / y;
  }

  static String alphabetize(String x, String y) {
    int order = x.toLowerCase().compareTo(y.toLowerCase());
    if (order == 0) {
      return "Chicken or Egg.";
    } else {
      return order < 0 
        ? String.format("%s comes before %s alphabetically.", x, y)
        : String.format("%s comes before %s alphabetically.", y, x);
    }
  }

  static void print(String prompt) {
    System.out.println(prompt);
  }
}