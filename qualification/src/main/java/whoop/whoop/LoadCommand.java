package whoop.whoop;

public class LoadCommand extends Command {
  public Wharehouse wharehouse;
  public ProductType productType;
  public int quantity;

  public LoadCommand(Drone drone, Wharehouse wharehouse, ProductType productType, int quantity){
    this.name = 'L';
    this.drone = drone;
    this.wharehouse = wharehouse;
    this.productType = productType;
    this.quantity = quantity;
  }

  public String output(){
    // return drone.id + ' ' + name + ' ' + wharehouse.id
    return ''
  }
}
