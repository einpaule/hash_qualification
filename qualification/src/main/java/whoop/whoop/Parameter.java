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
    this.warehouses = extractWarehouses(4, lines);

    this.amountOfOrders = Integer.parseInt(lines[4 + 2 * amountOfWarehouses]);
    this.orders = extractOrders(4 + 2 * amountOfWarehouses + 1, lines);
  }

  private List<Order> extractOrders(int start, String[] lines) {
    List<Order> orders = new ArrayList<>();
    for (int i = start; i < (amountOfOrders) * 3 + start; i += 3) {
      String[] location = lines[i].split(" ");

      int locationRow = Integer.parseInt(location[0]);
      int locationColumn = Integer.parseInt(location[1]);

      int amountOfOrderedProducts = Integer.parseInt(lines[i + 1]);

      List<Product> products = new ArrayList<>();

      String[] orderedProductsArray = lines[i + 2].split(" ");
      for (int j = 0; j < amountOfOrderedProducts; j++) {
        int productId = Integer.parseInt(orderedProductsArray[j]);
        Product p = new Product(productId, weights.get(j));
        products.add(p);
      }

      Order newOrder = new Order();
      newOrder.destinationRow = locationRow;
      newOrder.destinationColumn = locationColumn;

      newOrder.items = products;

      orders.add(newOrder);
    }

    return orders;
  }

  private List<Warehouse> extractWarehouses(int start, String[] lines) {
    List<Warehouse> warehouses = new ArrayList<>();
    for (int i = start; i <= (amountOfWarehouses + 1) * 2; i += 2) {
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
    return warehouses;
  }

  private Map<Product, Integer> getProducts(Map<Integer, Integer> availability) {
    Map<Product, Integer> products = new HashMap<>();

    for (Entry<Integer, Integer> entry : availability.entrySet()) {
      products.put(new Product(entry.getKey(), weights.get(entry.getKey())), entry.getValue());
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

  public List<Order> orders;
  public int amountOfOrders;
  public List<Warehouse> warehouses;
  public int amountOfWarehouses;
  public int rows;
  public int columns;
  public int dronesAvailable;
  public int deadline;
  public int maximumLoad;

  public int numberOfProducts;
  public Map<Integer, Integer> weights;

}
