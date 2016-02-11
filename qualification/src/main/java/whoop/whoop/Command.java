package whoop.whoop;

public abstract class Command {
  public Drone drone;

  abstract String output();
}
