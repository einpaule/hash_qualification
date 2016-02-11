package whoop.whoop;

public class LoadCommand extends Command {
  public Warehouse warehouse;
  public ProductType productType;
  public int quantity;

  public LoadCommand(Drone drone, Warehouse warehouse, ProductType productType, int quantity) {
    this.drone = drone;
    this.warehouse = warehouse;
    this.productType = productType;
    this.quantity = quantity;
  }

  public String output() {
    // return drone.id + ' ' + name + ' ' + wharehouse.id
	return drone.id + " L " + warehouse.id + " " + productType.id + " " + quantity;
  }

  @Override
  int estimateSteps(Drone drone, Destination destination, ProductType productType) {
	// TODO Auto-generated method stub
	return 0;
  }
}
