public class Frog {
  private String name;
  private int age;
  private double tongueSpeed;
  boolean isFroglet;
  static String species = "Rare Pepe";

  public static String getSpecies() {
    return species;
  }

  public static void setSpecies(String newSpecies) {
    species = newSpecies;
  }
  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int) ageInYears * 12, tongueSpeed);
  }

  public Frog(String name) {
    this(name, 5, 5d);
  }

  public void grow(int months) {
    while (months > 0) {
      if (age < 12) {
        tongueSpeed++;
      } else if (age >= 30 && tongueSpeed > 5) {
        tongueSpeed--;
      }
      age++;
      months--;
    }
    if (age > 1 && age < 7) {
      isFroglet = true;
    }
  }

  public void grow() {
    grow(1);
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }

    // fly is caught
    if (tongueSpeed > fly.getSpeed()) {
      if (fly.getMass() >= age * .5) {
        grow();
      }

      fly.setMass(0);
    // fly is not caught
    } else {
      fly.grow(1);
    }
  }

  public String toString() {
    String frogOrFroglet = isFroglet ? "froglet" : "frog";
    return String.format(
      "My name is %s and I'm a rare %s! I'm %.2f months old and my tongue has a speed of %.2f.",
      name, frogOrFroglet, (float) age, (float) tongueSpeed
    );
  }
}