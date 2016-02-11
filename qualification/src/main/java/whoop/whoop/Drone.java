package whoop.whoop;

public class Drone {
  public int payload;
  public int pos_x;
  public int pos_y;

  public Drone(int payload){
    this.payload = payload;
    this.pos_x = 0;
    this.pos_y = 0;
  }

  public int[] getPosition() {
    return new int[]{pos_x, pos_y};
  }

  public void setPosition(int[] position) {
    this.pos_x = position[0];
    this.pos_y = position[1];
  }

}
