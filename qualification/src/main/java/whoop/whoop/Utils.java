package whoop.whoop;

public class Utils {
  static double euclideanDistance(int source_row, int source_column, int target_row, int target_column) {

    double xDiff = source_row - target_row;
    double xSqr = Math.pow(xDiff, 2);

    double yDiff = source_column - target_column;
    double ySqr = Math.pow(yDiff, 2);

    return Math.sqrt(xSqr + ySqr);
  }
}
