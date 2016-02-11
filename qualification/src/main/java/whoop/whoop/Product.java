package whoop.whoop;

public class Product {
  public ProductType type;
  protected int weight;

  public Product(ProductType type) {
    super();
    this.type = type;
  }

  public int getTypeId() {
    return this.type.id;
  }

  public int getWeight() {
    return type.weight;
  }
}
