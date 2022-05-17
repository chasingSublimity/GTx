public class Dog extends Pet {
  double droolRate;

  public Dog(String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);

    this.droolRate = droolRate <= 0 ? .5 : droolRate;
  }

  public Dog(String name, double health, int painLevel) {
    this(name, health, painLevel, 5.0);
  }

  public double getDroolRate() {
    return droolRate;
  }

  public int treat() {
    super.heal();

    if (droolRate < 3.5) {
      return (int) ((getPainLevel() * 2) / getHealth());
    } else if (droolRate >= 3.5 || droolRate <= 7.5) {
      return (int) (getPainLevel() / getHealth());
    } else {
      return (int) (getPainLevel() / (getHealth() * 2));
    }
  }

  public void speak() {
    super.speak();
    String toSay = "";
    for (int i = 0; i < getPainLevel(); i++) {
      toSay += "bark ";
    }

    if (getPainLevel() > 5) {
      System.out.println(toSay.toUpperCase().trim());
    } else {
      System.out.println(toSay.trim());

    }
  }

  public boolean equals(Object o) {
    if (o instanceof Dog) {
      Dog d = (Dog) o;
      return super.equals(o) && droolRate == d.droolRate;
    }
    return false;
  }
}