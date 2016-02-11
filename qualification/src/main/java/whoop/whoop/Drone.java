package whoop.whoop;

public class Drone {
  private int payload;

  public Drone(int payload){
    this.payload = payload;
  }

  public void setPayload(int payload) {
    this.payload = payload;
  }

  public int getPayload() {
    return payload;
  }

}
