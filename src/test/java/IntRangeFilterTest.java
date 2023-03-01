import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntRangeFilterTest {

  private final String name;
  private final int lowerBound;
  private final int upperBound;

  private final int value;
  private final boolean expectedResult;

  public IntRangeFilterTest(
      String name, int lowerBound, int upperBound, int value, boolean expectedResult) {
    this.name = name;
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.value = value;
    this.expectedResult = expectedResult;
  }

  @Parameters(name = "{0} - значение {3}")
  public static Object[][] getData() {
    return new Object[][] {
      {"Нижняя граница входит", 2, 5, 2, true},
      {"Нижняя граница не входит", 2, 5, 1, false},
      {"Верхняя граница входит", 2, 5, 5, true},
      {"Верхняя граница не входит", 2, 5, 6, false}
    };
  }

  @Test
  public void filter_expectNoErrors() {
    IntRangeFilter filter = new IntRangeFilter(lowerBound, upperBound);
    boolean result = filter.filter(value);
    assertEquals(expectedResult, result);
  }

  @Test
  public void filter_expectFiltered() {
    IntRangeFilter filter = new IntRangeFilter(2, 5);
    boolean result = filter.filter(2);
    assertTrue(result);
  }

  @Test
  public void filter_expectNotFiltered() {
    IntRangeFilter filter = new IntRangeFilter(2, 5);
    boolean result = filter.filter(1);
    assertFalse(result);
  }
}
