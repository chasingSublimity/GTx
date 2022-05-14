import java.util.Arrays;
public class BlueAstronaut extends Player implements Crewmate {
  int numTasks;
  int taskSpeed;

  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);    
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }

  public BlueAstronaut(String name) {
    this(name, 15, 6, 10);
  }

  public void emergencyMeeting() {
    if (isFrozen()) {
      return;
    }

    Player[] players = getPlayers();
    Arrays.sort(players);

    if (players[0] != players[1]) {
      players[0].setFrozen(true);
    }
    
    gameOver();
  }

  public void completeTask() {
    if (isFrozen()) {
      return;
    }

    if (taskSpeed > 20) {
      numTasks -= 2;
    } else {
      numTasks--;
    }

    if (numTasks < 0) {
      numTasks = 0;
    }

    if (numTasks == 0) {
      System.out.println("I have completed all my tasks");
      setSusLevel(getSusLevel() / 2);
    }
  }

  public boolean equals(Object o) {
    if (o instanceof BlueAstronaut) {
        BlueAstronaut astro = (BlueAstronaut) o;
        return this.getName().equals(astro.getName()) 
          && this.isFrozen() == astro.isFrozen()
          && this.getSusLevel() == astro.getSusLevel()
          && this.numTasks == astro.numTasks
          && this.taskSpeed == astro.taskSpeed;
    }
    return false;
  }

  public String toString() {
    String str = super.toString();
    String updated = str + " I have " + numTasks + " left over.";
    return getSusLevel() > 15 ? updated.toUpperCase() : updated;
  }
}