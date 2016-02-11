package whoop.whoop;

import java.util.ArrayList;
import java.util.List;

public class FirstSolver extends Solver {

	private static int INFINITE = Integer.MAX_VALUE;

	protected List<Order> remainingOrders;
	protected List<Drone> availablesDrones;

	public FirstSolver(String input) {
		super(input);

		remainingOrders = new ArrayList<Order>(orders);
		availablesDrones = new ArrayList<Drone>();
	}

	@Override
	public List<Command> solve() {
		for (int turn = 0; turn < deadline; turn++) {
			for (Drone d : availablesDrones) {
				Order quickestOrder = null;
				int currentMin = INFINITE;

				for (Order currentOrder : remainingOrders) {
					if (quickestOrder == null)
						quickestOrder = currentOrder;
					else {
						int turnsNeeded = getNumberOfStepsNeeded(currentOrder, d);
						if (turnsNeeded < currentMin) {
							currentMin = turnsNeeded;
							quickestOrder = currentOrder;
						}
					}
				} // Got this far we now have the quickest order

				// updateQuantities();
				remainingOrders.remove(quickestOrder);
				availablesDrones.remove(d);
				//stackInstructions();
			}
		}
		return null;
	}
	
	public int getNumberOfStepsNeeded(Order o, Drone d){
		//TODO
		return 0;
	}
	
	public double computeDistance(int ra, int ca, int rb, int cb){
		int r = Math.abs(ra-rb)*Math.abs(ra-rb);
		int c = Math.abs(ca-cb)*Math.abs(ca-cb);
		return Math.ceil(Math.sqrt(r+c));
	}
}
