public class Insect {
  private double weight;
  private int x;
  private int y;

  public static final int DEFAULT_X = 0;
  public static final int DEFAULT_Y = 0;
  private final double DIST_WEIGHT_LOSS_FACTOR = .0001;
  private static int population = 0;
  private static final String[] FACTS = {
    "Fact one!",
    "Fact two!",
    "Fact three!",
    "Fact four!",
  };

  public Insect(double initWeight) {
    this(initWeight, DEFAULT_X, DEFAULT_Y);
  }

  public Insect(double weight, int x, int y) {
    this.weight = weight;
    this.x = x;
    this.y = y;
    population++;
  }

  // accessors
  public double getWeight() {
    return weight;
  }

  public int getX() {
    return x;
  }

  public void setX(int newX) {
    if (isLegalX(newX)) {
      y = newX;
    }
  }

  public int getY() {
    return y;
  }

  public void setY(int newY) {
    if (isLegalY(newY)) {
      y = newY;
    }
  }

  public static boolean isLegalX(int newX) {
    return ((newX >= 0) ? true : false);
  }

  public static boolean isLegalY(int newY) {
    return ((newY >= 0) ? true : false);
  }

  public static int getPopulation() {
    return population;
  }

  public void eat(double amount) {
    System.out.println("Nibble Nibble");
    weight = weight + amount;
  }

  public void move(int newX, int newY) {
    double distance = calculateDistance(x, y, newX, newY);
    if (distance > 0) {
      x = newX;
      y = newY;
      weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
      System.out.printf("Moved %.2f units\n", distance);
    } else {
      System.out.println("Staying put");
    }
  }

  private static double calculateDistance(
    double x1, double y1,
    double x2, double y2
  ) {
    return Math.sqrt(
      (y2-y1) * (y2 - y1) +
      (x2 - x1) * (x2 - x1)
    );
  } 

  public static String produceRandomFact() {
    int index = (int)(Math.random() * ((FACTS.length - 1) +1));
    return FACTS[index];
  }

  public String toString() {
    return "weight: " + weight + ", x: " + x + ", y: " + y;
  }

  public static void main(String[] args) {
    System.out.println("Insect population: " + population);
    Insect bug1 = new Insect(10, 100, 90);
    System.out.println("Insect population: " + population);
    Insect bug2 = new Insect(9.5, -300, 400);
    System.out.println("Insect population: " + population);

    bug1.move(1,10);
    bug2.move(-300,400);

    System.out.println(produceRandomFact());
  }
}

