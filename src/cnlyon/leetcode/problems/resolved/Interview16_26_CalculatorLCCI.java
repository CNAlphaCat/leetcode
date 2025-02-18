package cnlyon.leetcode.problems.resolved;

import cnlyon.leetcode.annotations.Microsoft;

import java.util.Stack;

/** <a href="https://leetcode.cn/problems/calculator-lcci/description/">...</a> */
@Microsoft
public class Interview16_26_CalculatorLCCI {
  public int calculate(String s) {
    Stack<Integer> numStack = new Stack<>();

    int currentNum = 0;
    char preSign = '+';
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        continue;
      }
      if (Character.isDigit(c)) {
        currentNum = currentNum * 10 + (c - '0');
        continue;
      }
      pushNumToStack(preSign, numStack, currentNum);
      preSign = c;
      currentNum = 0;
    }
    pushNumToStack(preSign, numStack, currentNum);
    return numStack.stream().mapToInt(Integer::intValue).sum();
  }

  private static void pushNumToStack(char preSign, Stack<Integer> numStack, int currentNum) {
    switch (preSign) {
      case '+':
        numStack.push(currentNum);
        break;
      case '-':
        numStack.push(-currentNum);
        break;
      case '*':
        numStack.push(numStack.pop() * currentNum);
        break;
      case '/':
        numStack.push(numStack.pop() / currentNum);
        break;
    }
  }
}
