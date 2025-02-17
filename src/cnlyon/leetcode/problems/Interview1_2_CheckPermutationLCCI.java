package cnlyon.leetcode.problems;

import cnlyon.leetcode.annotations.Microsoft;

/** <a href="https://leetcode.cn/problems/check-permutation-lcci/">...</a> */
@Microsoft
public class Interview1_2_CheckPermutationLCCI {
  private static final Integer MAX_LENGTH = 26;

  public boolean CheckPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int[] letterMap = new int[MAX_LENGTH];
    for (char c : s1.toCharArray()) {
      letterMap[c - 'a']++;
    }
    for (char c : s2.toCharArray()) {
      letterMap[c - 'a']--;
      if (letterMap[c - 'a'] < 0) {
        return false;
      }
    }
    for (int i = 0; i < MAX_LENGTH; i++) {
      if (letterMap[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
