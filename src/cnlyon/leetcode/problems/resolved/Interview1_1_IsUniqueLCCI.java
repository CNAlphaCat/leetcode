package cnlyon.leetcode.problems.resolved;

import cnlyon.leetcode.annotations.Microsoft;

/** <a href="https://leetcode.cn/problems/is-unique-lcci/description/">...</a> */
@Microsoft
public class Interview1_1_IsUniqueLCCI {
  private static final int MAX_LENGTH = 26;

  public boolean isUnique(String astr) {
    if (astr.length() > MAX_LENGTH) {
      return false;
    }
    int bitMap = 0;
    for (char c : astr.toCharArray()) {
      int bit = c - 'a';
      if ((bitMap & (1 << bit)) == 0) {
        bitMap |= (1 << bit);
      } else {
        return false;
      }
    }
    return true;
  }
}
