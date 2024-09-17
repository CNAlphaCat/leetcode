package cnlyon.leetcode.problems;

public class lc8_StringToIntegerAtoi {

  public int myAtoi(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    String stringNum = s;
    int lastSpaceIndex = findLastSpaceInStringPrefix(s);
    if (lastSpaceIndex != -1) {
      stringNum = stringNum.substring(lastSpaceIndex + 1);
    }
    int signedness = 1;
    if (!stringNum.isEmpty() && stringNum.charAt(0) == '-') {
      signedness = -1;
      stringNum = stringNum.substring(1);
    } else if (!stringNum.isEmpty() && stringNum.charAt(0) == '+') {
      stringNum = stringNum.substring(1);
    }
    int atoi = 0;
    for (int i = 0; i < stringNum.length(); i++) {
      char c = stringNum.charAt(i);
      if (!Character.isDigit(c)) {
        return atoi;
      }
      if (atoi > Integer.MAX_VALUE / 10) {
        return Integer.MAX_VALUE;
      }
      if (atoi < Integer.MIN_VALUE / 10) {
        return Integer.MIN_VALUE;
      }
      int num = c - '0';
      if (atoi == Integer.MAX_VALUE / 10 && num >= Integer.MAX_VALUE % 10) {
        return Integer.MAX_VALUE;
      }
      if (atoi == Integer.MIN_VALUE / 10 && -num <= Integer.MIN_VALUE % 10) {
        return Integer.MIN_VALUE;
      }
      atoi = atoi * 10 + signedness * num;
    }
    return atoi;
  }

  private int findLastSpaceInStringPrefix(String s) {
    int index = -1;
    int i = 0;
    while (i < s.length() && s.charAt(i) == ' ') {
      index = i;
      ++i;
    }
    return index;
  }
}
