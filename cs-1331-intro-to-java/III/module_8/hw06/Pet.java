public abstract class Pet {
  private String name;
  private double health;
  private int painLevel;

  public Pet(String name, double health, int painLevel) {
    this.name = name;
    if (health > 1.0) {
      this.health = 1.0;
    } else if (health < 0) {
      this.health = 0;
    } else {
      this.health = health;
    }

    if (painLevel > 10) {
      this.painLevel = 10;
    } else if (painLevel < 1) {
      this.painLevel = 1;
    } else {
      this.painLevel = painLevel;
    }
  }

  public String getName() {
    return name;
  }

  public double getHealth() {
    return health;
  }

  public double getPainLevel() {
    return painLevel;
  }

  public abstract int treat();

  public void speak() {
    String toSay = "Hello! My name is " + name;
    System.out.println(
      painLevel > 5 ? toSay.toUpperCase() : toSay
    );
  }

  public boolean equals(Object o) {
    if (o instanceof Pet) {
      Pet p = (Pet) o;
      return name == p.name;
    }
    return false;
  }

  protected void heal() {
    health = 1.0;
    painLevel = 1;
  }
}