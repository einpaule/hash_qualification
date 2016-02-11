package whoop.whoop;

import java.util.HashMap;
import java.util.Map.Entry;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ParameterParserTest extends TestCase {

  public void testInputs() {
    Parameter p = ParameterParser.parse("400 600 30 112993 200\n400\n73 40 84 107 52 36 13 74 36 94 93 46 123 24 100 93 62 49 97 102 80 37 22 25 72 48 40 74 32 31 136 64 99 37 44 36 104 74 112 40 65 67 50 143 23 26 91 20 142 128 9 77 40 26 55 104 59 112 42 69 87 89 2 11 105 43 105 23 21 88 57 40 52 63 35 141 54 27 45 37 21 37 102 38 36 117 57 93 24 52 83 133 51 102 34 52 39 54 64 146 127 100 58 50 49 40 55 123 64 30 127 63 19 59 31 22 68 37 107 68 52 61 35 38 76 44 21 144 21 40 105 48 97 70 74 95 75 28 25 40 81 72 58 99 52 5 72 84 53 21 110 97 30 43 92 109 39 89 51 30 102 94 13 45 93 94 90 104 36 55 92 12 45 126 73 132 118 127 125 26 83 69 49 39 4 63 84 47 75 43 82 43 51 28 118 110 42 2 53 74 54 57 92 23 72 95 76 35 38 100 52 34 58 74 86 25 32 61 39 55 76 68 107 82 97 108 57 38 88 71 22 40 63 37 80 51 52 52 67 101 49 46 100 52 63 36 53 45 51 56 71 50 13 29 18 36 87 86 39 11 148 74 74 121 11 28 65 79 32 85 95 26 43 123 81 78 25 100 27 90 53 60 100 25 72 80 83 40 62 53 40 97 105 56 49 100 36 46 80 8 23 58 78 58 24 78 67 62 85 80 39 34 62 33 58 130 41 34 33 62 129 79 103 104 56 33 118 96 21 18 65 140 87 91 61 54 137 71 84 35 75 32 4 68 37 80 78 91 75 52 74 96 32 85 42 78 119 58 16 44 24 98 121 76 16 56 112 67 58 46 76 45 41 94 55 44 51 136 63 34 86 87 64 54 27 69 31 64 138 56 97 81 40 132 64 114 105 41 52 60\n10");

    Assert.assertEquals(p.rows, 400);
    Assert.assertEquals(p.columns, 600);
    Assert.assertEquals(p.deadline, 112993);
    Assert.assertEquals(p.maximumLoad, 200);
    Assert.assertEquals(p.numberOfProducts, 400);

    Assert.assertEquals(p.weights.getClass(), (new HashMap<Integer, Integer>()).getClass());
    Assert.assertEquals(p.weights.size(), p.numberOfProducts);
    for (Entry<Integer, Integer> product : p.weights.entrySet()) {
      Assert.assertTrue(product.getKey() < 400);
      Assert.assertTrue(product.getValue() > 0);
    }
  }
}
