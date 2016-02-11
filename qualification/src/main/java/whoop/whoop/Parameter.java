package whoop.whoop;

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
  }

  public int rows;
  public int columns;
  public int dronesAvailable;
  public int deadline;
  public int maximumLoad;

  public int numberOfProducts;

}
