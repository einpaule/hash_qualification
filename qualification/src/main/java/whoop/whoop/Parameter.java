package whoop.whoop;

import java.util.HashMap;
import java.util.Map;

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
  }

  private Map<Integer, Integer> extractWeights(String weights) {
    Map<Integer, Integer> weightHash = new HashMap<>();

    String[] weightsArray = weights.split(" ");
    for (int i = 0; i < weightsArray.length; i++) {
      weightHash.put(i, Integer.parseInt(weightsArray[i]));
    }
    return weightHash;
  }

  public int rows;
  public int columns;
  public int dronesAvailable;
  public int deadline;
  public int maximumLoad;

  public int numberOfProducts;
  public Map<Integer, Integer> weights;

}
