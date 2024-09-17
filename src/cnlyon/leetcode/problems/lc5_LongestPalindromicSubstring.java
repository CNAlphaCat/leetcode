package cnlyon.leetcode.problems;

public class lc5_LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    String longestPalindrome = "";
    for (int i = 0; i < s.length(); i++) {
      String currentString = longestPalindromeFromLToR(s, i, i);
      if (currentString.length() > longestPalindrome.length()) {
        longestPalindrome = currentString;
      }
      currentString = longestPalindromeFromLToR(s, i, i + 1);
      if (currentString.length() > longestPalindrome.length()) {
        longestPalindrome = currentString;
      }
    }
    return longestPalindrome;
  }

  private String longestPalindromeFromLToR(String s, int l, int r) {
    if (r == s.length()) {
      return "";
    }
    String longestPalindrome = "";
    int i = l;
    int j = r;
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      String currentString = s.substring(i, j + 1);
      if (currentString.length() > longestPalindrome.length()) {
        longestPalindrome = currentString;
      }
      --i;
      ++j;
    }
    return longestPalindrome;
  }
}
