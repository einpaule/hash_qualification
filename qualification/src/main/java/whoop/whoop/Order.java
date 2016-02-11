package whoop.whoop;

import java.util.List;

public class Order {

	public int id;
	public int destinationRow;
	public int destinationColumn;
	public List<Product> items;

	public Order(int id) {
		this.id = id;
	}

}
