package cnlyon.leetcode.problems;

public class lc10_RegularExpressionMatching {

  private static final char ASTERISK = '*';
  private static final char DOT = '.';

  public boolean isMatch(String s, String p) {
    if (s.isEmpty() || p.isEmpty()) {
      return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int j = 1; j < p.length() + 1; j++) {
      if (p.charAt(j - 1) == ASTERISK) {
        dp[0][j] = dp[0][j - 2];
      }
    }
    for (int i = 1; i < s.length() + 1; i++) {
      for (int j = 1; j < p.length() + 1; j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == DOT) {
          dp[i][j] = dp[i - 1][j - 1];
          continue;
        }
        if (p.charAt(j - 1) == ASTERISK) {
          matchAsterisk(s, p, dp, i, j);
        }
      }
    }
    return dp[s.length()][p.length()];
  }

  private void matchAsterisk(String s, String p, boolean[][] dp, int i, int j) {
    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == DOT) {
      dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i - 1][j - 2];
    } else {
      dp[i][j] = dp[i][j - 2];
    }
  }
}
