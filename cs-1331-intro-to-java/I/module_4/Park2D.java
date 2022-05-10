public class Park2D {
  public static void main(String[] args) {
    double[][] array2d = {{80, 70, 75},
                          {69, 72, 74}};

    final double MIN_TEMP = 75;
    final double MAX_TEMP = 90;

    for (double[] row: array2d) {
      for (double col: row) {
        if (col >= MIN_TEMP && col <= MAX_TEMP) {
          System.out.printf("Temp is %.0f, Go to the park.\n", col);
        }
      }
    }
  }
}