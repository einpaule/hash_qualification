package whoop.whoop;

public class Drone {
  public int payload;
  public int x;
  public int y;

  public Drone(int payload){
    this.payload = payload;
    this.x = 0;
    this.y = 0;
  }

  public int[] getPosition() {
    return new int[]{x, y};
  }

  public void setPosition(int[] position) {
    this.x = position[0];
    this.y = position[1];
  }

}
