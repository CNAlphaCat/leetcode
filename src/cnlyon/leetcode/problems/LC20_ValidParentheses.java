package cnlyon.leetcode.problems;

import cnlyon.leetcode.annotations.Microsoft;

import java.util.HashMap;
import java.util.Stack;

@Microsoft
public class LC20_ValidParentheses {
  private static final HashMap<Character, Character> VALID_PARENTHESES_MAP =
      buildValidParenthesesMap();

  public boolean isValid(String s) {
    if (s.length() % 2 == 1) {
      return false;
    }
    Stack<Character> parenthesesStack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (!VALID_PARENTHESES_MAP.containsKey(c)) {
        parenthesesStack.push(c);
        continue;
      }
      if (parenthesesStack.isEmpty()) {
        return false;
      }
      Character popParenTheses = parenthesesStack.pop();
      if (!popParenTheses.equals(VALID_PARENTHESES_MAP.get(c))) {
        return false;
      }
    }
    return parenthesesStack.isEmpty();
  }

  private static HashMap<Character, Character> buildValidParenthesesMap() {
    HashMap<Character, Character> validParenthesesMap = new HashMap<>();
    validParenthesesMap.put(')', '(');
    validParenthesesMap.put(']', '[');
    validParenthesesMap.put('}', '{');
    return validParenthesesMap;
  }
}
