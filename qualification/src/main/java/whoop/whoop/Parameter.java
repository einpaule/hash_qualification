package whoop.whoop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Parameter {

  public Parameter(String input) {

    String[] lines = input.split("\n");

    String[] firstElements = lines[0].split(" ");
    this.rows = Integer.parseInt(firstElements[0]);
    this.columns = Integer.parseInt(firstElements[1]);
    this.dronesAvailable = Integer.parseInt(firstElements[2]);
    this.deadline = Integer.parseInt(firstElements[3]);
    this.maximumLoad = Integer.parseInt(firstElements[4]);

    this.numberOfProducts = Integer.parseInt(lines[1]);
    this.weights = extractWeights(lines[2]);

    this.amountOfWarehouses = Integer.parseInt(lines[3]);
    // this.warehouses = extractWarehouses(4, lines);
  }

  private List<Warehouse> extractWarehouses(int start, String[] lines) {
    List<Warehouse> warehouses = new ArrayList<>();
    for (int i = start; i < amountOfWarehouses; i += 2) {
      String[] location = lines[i].split(" ");

      int locationRow = Integer.parseInt(location[0]);
      int locationColumn = Integer.parseInt(location[1]);

      Map<Integer, Integer> availability = extractAvailability(lines[i + 1]);
      Warehouse warehouse = new Warehouse();

      warehouse.setRowPosition(locationRow);
      warehouse.setColumnPosition(locationColumn);

      Map<Product, Integer> storage = getProducts(availability);
      warehouse.setStorage(storage);
      warehouses.add(warehouse);

    }
    return null;
  }

  private Map<Product, Integer> getProducts(Map<Integer, Integer> availability) {
    Map<Product, Integer> products = new HashMap<>();

    for (Entry<Integer, Integer> entry : availability.entrySet()) {
      products.put(new Product(new ProductType(entry.getKey(), weights.get(entry.getKey()))), entry.getValue());
    }

    return products;
  }

  private Map<Integer, Integer> extractAvailability(String availabilityLine) {
    Map<Integer, Integer> availability = new HashMap<>();
    String[] availabilityArray = availabilityLine.split(" ");
    for (int i = 0; i < availabilityArray.length; i++) {
      availability.put(i, Integer.parseInt(availabilityArray[i]));
    }
    return availability;
  }

  private Map<Integer, Integer> extractWeights(String weights) {
    Map<Integer, Integer> weightHash = new HashMap<>();

    String[] weightsArray = weights.split(" ");
    for (int i = 0; i < weightsArray.length; i++) {
      weightHash.put(i, Integer.parseInt(weightsArray[i]));
    }
    return weightHash;
  }

  public int amountOfWarehouses;
  public int rows;
  public int columns;
  public int dronesAvailable;
  public int deadline;
  public int maximumLoad;

  public int numberOfProducts;
  public Map<Integer, Integer> weights;

}
