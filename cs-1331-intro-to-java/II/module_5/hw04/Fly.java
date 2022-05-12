public class Fly {
  private double mass;
  private double speed;

  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  public Fly(double mass) {
    this(mass, 10d);
  }

  public Fly() {
    this(5d);
  }

  public double getMass() {
    return mass;
  }

  public void setMass(int mass) {
    this.mass = mass;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public String toString() {
    return mass == 0
      ? String.format(
        "I'm dead, but I used to be a fly with a speed of %.2f.",
        speed
      )
      : String.format(
        "I'm a speedy fly with %.2f speed and %.2f mass.",
        speed, mass
      );
  }

  // This will need to be verified
  public void grow(int addedMass) {
    double speedDelta = (20 - mass) + ((mass + addedMass) % 20) * -.5;
    
    mass += addedMass;
    speed += speedDelta;
  }

  public boolean isDead() {
    return mass == 0 ? true : false;
  }
}