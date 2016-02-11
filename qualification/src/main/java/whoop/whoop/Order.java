package whoop.whoop;

import java.util.List;

public class Order extends Destination {

	public int id;
	public List<Product> items;

	public Order(int id, int row, int column) {
		this.row = row;
		this.column = column;
	}

}
