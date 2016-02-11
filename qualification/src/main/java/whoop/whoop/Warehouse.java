package whoop.whoop;

import java.util.Map;

public class Warehouse extends Destination {

	public Map<Product, Integer> storage;

	public Warehouse(int row, int column) {
		this.row = row;
		this.column = column;
	}

}
