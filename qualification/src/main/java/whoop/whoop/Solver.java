package whoop.whoop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Solver {
  protected final int rows;
  protected final int columns;
  protected final int dronesAvailable;
  protected final List<Drone> drones;
  protected final int deadline;
  protected final int maximumLoad;
  protected final int numberOfProducts;
  protected final List<Product> products;

  protected final int amountOfWarehouses;
  protected final List<Warehouse> warehouses;
  protected final int amountOfOrders;
  protected final List<Order> orders;

  public Solver(String input) {
    String[] lines = input.split("\n");

    String[] firstElements = lines[0].split(" ");
    this.rows = Integer.parseInt(firstElements[0]);
    this.columns = Integer.parseInt(firstElements[1]);
    this.dronesAvailable = Integer.parseInt(firstElements[2]);
    this.deadline = Integer.parseInt(firstElements[3]);
    this.maximumLoad = Integer.parseInt(firstElements[4]);

    this.numberOfProducts = Integer.parseInt(lines[1]);
    this.products = extractProducts(lines[2]);

    this.amountOfWarehouses = Integer.parseInt(lines[3]);
    this.warehouses = extractWarehouses(4, lines);

    this.amountOfOrders = Integer.parseInt(lines[4 + 2 * amountOfWarehouses]);
    this.orders = extractOrders(4 + 2 * amountOfWarehouses + 1, lines);

    this.drones = createDrones(dronesAvailable, maximumLoad);
  }

  private List<Drone> createDrones(int amount, int load) {
    List<Drone> drones = new ArrayList<>();

    for (int i = 0; i < amount; i++) {
      drones.add(new Drone(i, load));
    }
    return drones;
  }

  private List<Order> extractOrders(int start, String[] lines) {
    List<Order> orders = new ArrayList<>();
    int orderId = 0;
    for (int i = start; i < (amountOfOrders) * 3 + start; i += 3) {
      String[] location = lines[i].split(" ");

      int locationRow = Integer.parseInt(location[0]);
      int locationColumn = Integer.parseInt(location[1]);

      int amountOfOrderedProducts = Integer.parseInt(lines[i + 1]);

      String[] orderedProductsArray = lines[i + 2].split(" ");
      List<Product> orderedProducts = new ArrayList<>();
      for (int j = 0; j < amountOfOrderedProducts; j++) {
        int productId = Integer.parseInt(orderedProductsArray[j]);
        orderedProducts.add(products.get(productId));
      }

      Order newOrder = new Order(orderId, locationRow, locationColumn);

      newOrder.items = orderedProducts;

      orders.add(newOrder);
      orderId++;
    }

    return orders;
  }

  private List<Warehouse> extractWarehouses(int start, String[] lines) {
    List<Warehouse> warehouses = new ArrayList<>();
    int warehouseId = 0;
    for (int i = start; i <= (amountOfWarehouses + 1) * 2; i += 2) {
      String[] location = lines[i].split(" ");

      int locationRow = Integer.parseInt(location[0]);
      int locationColumn = Integer.parseInt(location[1]);

      Map<Integer, Integer> availability = extractAvailability(lines[i + 1]);
      Warehouse warehouse = new Warehouse(warehouseId, locationRow, locationColumn);

      Map<Product, Integer> storage = getProducts(availability);
      warehouse.storage = storage;
      warehouses.add(warehouse);
      warehouseId++;
    }
    return warehouses;
  }

  private Map<Product, Integer> getProducts(Map<Integer, Integer> availability) {
    Map<Product, Integer> available_products = new HashMap<>();

    for (Entry<Integer, Integer> entry : availability.entrySet()) {
      available_products.put(products.get(entry.getKey()), entry.getValue());
    }

    return available_products;
  }

  private Map<Integer, Integer> extractAvailability(String availabilityLine) {
    Map<Integer, Integer> availability = new HashMap<>();
    String[] availabilityArray = availabilityLine.split(" ");
    for (int i = 0; i < availabilityArray.length; i++) {
      availability.put(i, Integer.parseInt(availabilityArray[i]));
    }
    return availability;
  }

  private List<Product> extractProducts(String weights) {
    List<Product> products = new ArrayList<>();

    String[] weightsArray = weights.split(" ");
    for (int i = 0; i < weightsArray.length; i++) {
      int weight = Integer.parseInt(weightsArray[i]);
      products.add(new Product(i, weight));
    }
    return products;
  }

  public abstract List<Command> solve();
}
