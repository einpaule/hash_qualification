package whoop.whoop;

public class UnloadCommand extends Command {

	public Warehouse warehouse;
	public ProductType productType;
	public int quantity;

	public UnloadCommand(Drone drone, Warehouse warehouse, ProductType productType, int quantity) {
	    this.drone = drone;
	    this.warehouse = warehouse;
	    this.productType = productType;
	    this.quantity = quantity;
	  }

	@Override
	String output() {
		return drone.id + " U " + warehouse.id + " " + productType.id + " " + quantity;
	}

	@Override
	int estimateSteps(Drone drone, Destination destination, ProductType productType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
