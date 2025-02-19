package cnlyon.leetcode.problems.resolved;

import cnlyon.leetcode.annotations.Microsoft;

import java.util.ArrayList;
import java.util.List;

@Microsoft
public class LC22_GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> parenthesisList = new ArrayList<>();
    generateParenthesis(n, parenthesisList, 0, 0, new StringBuilder());
    return parenthesisList;
  }

  private void generateParenthesis(
      int n, List<String> parenthesisList, int open, int close, StringBuilder sb) {
    if (sb.length() == n * 2) {
      parenthesisList.add(sb.toString());
    }
    if (open < n) {
      sb.append("(");
      generateParenthesis(n, parenthesisList, open + 1, close, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (close < open) {
      sb.append(")");
      generateParenthesis(n, parenthesisList, open, close + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
