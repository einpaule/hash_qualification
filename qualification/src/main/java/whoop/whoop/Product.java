package whoop.whoop;

public class Product {
  public int typeId;
  public int weight;

  public Product(int typeId, int weight) {
    this.weight = weight;
    this.typeId = typeId;
  }

  @Override
  public String toString() {
    return "Product [id=" + typeId + ", weight=" + weight + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + typeId;
    result = prime * result + weight;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (typeId != other.typeId)
      return false;
    if (weight != other.weight)
      return false;
    return true;
  }
  
}
