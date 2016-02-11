package whoop.whoop;

import java.util.Map;

public class Warehouse {

	public int id;
	protected int rowPosition;
	protected int columnPosition;
	protected Map<Product, Integer> storage;

	public Warehouse(int id) {
		this.id = id;
	}
	
	public int getRowPosition() {
		return rowPosition;
	}
	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}
	public int getColumnPosition() {
		return columnPosition;
	}
	public void setColumnPosition(int columnPosition) {
		this.columnPosition = columnPosition;
	}
	public Map<Product, Integer> getStorage() {
		return storage;
	}
	public void setStorage(Map<Product, Integer> storage) {
		this.storage = storage;
	}	

}
