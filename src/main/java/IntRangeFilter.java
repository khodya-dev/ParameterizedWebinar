public class IntRangeFilter {
  private final int lowerBound; // нижняя граница
  private final int upperBound; // верхняя граница

  public IntRangeFilter(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  public boolean filter(int value) {
    return lowerBound <= value && value <= upperBound;
  }
}
