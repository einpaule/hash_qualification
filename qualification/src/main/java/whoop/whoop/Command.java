package whoop.whoop;

public abstract class Command {
  public Drone drone;
  public String name;

  abstract String output();
}
