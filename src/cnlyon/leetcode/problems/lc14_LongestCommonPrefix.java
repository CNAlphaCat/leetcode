package cnlyon.leetcode.problems;

public class lc14_LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String longestCommonPrefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      longestCommonPrefix = findLongestCommonPrefix(longestCommonPrefix, strs[i]);
      if (longestCommonPrefix.isEmpty()) {
        return "";
      }
    }
    return longestCommonPrefix;
  }

  private String findLongestCommonPrefix(String a, String b) {
    int length = 0;
    while (length < a.length() && length < b.length() && a.charAt(length) == b.charAt(length)) {
      ++length;
    }
    if (length == 0) {
      return "";
    }
    return a.substring(0, length);
  }
}
