package whoop.whoop;

public class DeliverCommand extends Command {

	public Order order;
	public ProductType productType;
	public int quantity;

	public DeliverCommand(Drone drone, Order order, ProductType productType, int quantity) {
	    this.drone = drone;
	    this.order = order;
	    this.productType = productType;
	    this.quantity = quantity;
	}

	@Override
	String output() {
		return drone.id + " D " + order.id + " " + productType.id + " " + quantity;
	}

	@Override
	int estimateSteps(Drone drone, Destination destination, ProductType productType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
