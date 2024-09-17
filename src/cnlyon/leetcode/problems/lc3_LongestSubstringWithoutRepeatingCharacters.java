package cnlyon.leetcode.problems;

import java.util.HashSet;

public class lc3_LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> charSet = new HashSet<>();
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i > 0) {
        charSet.remove(s.charAt(i - 1));
      }
      for (int j = i + charSet.size(); j < s.length(); j++) {
        char currentChar = s.charAt(j);
        if (charSet.contains(currentChar)) {
          break;
        } else {
          charSet.add(currentChar);
        }
        max = Math.max(max, charSet.size());
      }
    }
    return max;
  }
}
