import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
  private String skill;
  
  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill;
  }

  public RedAstronaut(String name) {
    this(name, 15, "experienced");
  }

  public String getSkill() {
    return skill;
  }

  public void emergencyMeeting() {
    if (isFrozen()) {
      return;
    }

    Player[] players = getPlayers();
    Player toFreeze = null;
    Arrays.sort(players);

    for (int i = 0; i < players.length; i++) {
      if (players[i] != this && players[i] != players[i + 1]) {
        toFreeze = players[i];
        break;
      }
    }
    toFreeze.setFrozen(true);
    gameOver();
  }

  public void freeze(Player p) {
    if (isFrozen() || p instanceof Impostor || p.isFrozen()) {
      return;
    }

    if (getSusLevel() < p.getSusLevel()) {
      // success
      p.setFrozen(true);
    } else {
      setSusLevel(getSusLevel() * 2);
    }

    gameOver();
  }

  public void sabotage(Player p) {
    if (p instanceof Impostor || isFrozen() || p.isFrozen()) {
      return;
    }

    int currSusLevel = p.getSusLevel();
    int newSusLevel;
    if (getSusLevel() < 20) {
      newSusLevel = currSusLevel + (currSusLevel / 2);
    } else {
      newSusLevel = currSusLevel + (currSusLevel / 4);
    }
    p.setSusLevel(newSusLevel);
  }

  public boolean equals(Object o) {
    if (o instanceof RedAstronaut) {
        RedAstronaut astro = (RedAstronaut) o;
        return this.getName().equals(astro.getName()) 
          && this.isFrozen() == astro.isFrozen()
          && this.getSusLevel() == astro.getSusLevel()
          && this.skill == astro.skill;
    }
    return false;
  }

  public String toString() {
    String str = super.toString();
    String updated = str + " I am an " + skill + " player!";
    return getSusLevel() > 15 ? updated.toUpperCase() : updated;
  }
}