import javax.swing.Painter;

public class Cat extends Pet {
  int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel);
    this.miceCaught = miceCaught < 0 ? 0 : miceCaught;
  }

  public Cat(String name, double health, int painLevel) {
    this(name, health, painLevel, 0);
  }

  public int getMiceCaught() {
    return miceCaught;
  }

  public int treat() {
    heal();
    if (miceCaught < 4) {
      return (int) ((getPainLevel() * 2) / getHealth());
    } else if (miceCaught >= 4 && miceCaught <= 7) {
      return (int) ((getPainLevel()) / getHealth());
    } else {
      return (int) (getPainLevel() / (getHealth() * 2));
    }
  }

  public void speak() {
    super.speak();
    String toSay = "";
    for (int i = 1; i <= getPainLevel(); i++) {
      toSay += "meow ";
    }

    if (getPainLevel() > 5) {
      System.out.println(toSay.toUpperCase().trim());
    } else {
      System.out.println(toSay.trim());
    }
  }

  public boolean equals(Object o) {
    if (o instanceof Cat) {
      Cat c = (Cat) o;
      return super.equals(o) && miceCaught == c.miceCaught;
    }
    return false;
  }
}