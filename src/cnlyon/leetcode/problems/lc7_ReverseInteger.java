package cnlyon.leetcode.problems;

public class lc7_ReverseInteger {

  public int reverse(int x) {
    int num = x;
    int reversedNum = 0;
    while (num != 0) {
      if (reversedNum > Integer.MAX_VALUE / 10 || reversedNum < Integer.MIN_VALUE / 10) {
        return 0;
      }
      int digit = num % 10;
      reversedNum = reversedNum * 10 + digit;
      num /= 10;
    }
    return reversedNum;
  }
}
