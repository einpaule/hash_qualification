package whoop.whoop;

public abstract class Command {
  public Drone drone;

  abstract String output();
  abstract int estimateSteps(Drone drone, Destination destination, ProductType productType);

}
