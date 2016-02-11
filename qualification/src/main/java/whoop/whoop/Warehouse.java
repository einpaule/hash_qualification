package whoop.whoop;

import java.util.Map;

public class Warehouse extends Destination {

	public int id;
	public Map<Product, Integer> storage;

	public Warehouse(int id, int row, int column) {
		this.row = row;
		this.column = column;
	}

}
