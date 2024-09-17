package cnlyon.leetcode.problems;

import java.util.ArrayList;

public class lc6_ZigzagConversion {

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    ArrayList<StringBuilder> stringList = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      stringList.add(new StringBuilder());
    }
    int currentRow = 0;
    boolean isDown = true;
    for (int i = 0; i < s.length(); i++) {
      StringBuilder currentRowString = stringList.get(currentRow);
      currentRowString.append(s.charAt(i));
      currentRow = isDown ? currentRow + 1 : currentRow - 1;
      if (currentRow < 0) {
        isDown = !isDown;
        currentRow = currentRow + 2;
      }
      if (currentRow == numRows) {
        isDown = !isDown;
        currentRow = currentRow - 2;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (StringBuilder stringBuilder : stringList) {
      sb.append(stringBuilder);
    }
    return sb.toString();
  }
}
