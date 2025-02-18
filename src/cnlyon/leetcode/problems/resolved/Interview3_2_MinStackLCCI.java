package cnlyon.leetcode.problems.resolved;

import cnlyon.leetcode.annotations.Microsoft;

import java.util.Stack;

/** <a href="https://leetcode.cn/problems/min-stack-lcci/">...</a> */
@Microsoft
public class Interview3_2_MinStackLCCI {
  class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
      minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
      stack.push(x);
      minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
      stack.pop();
      minStack.pop();
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return minStack.peek();
    }
  }
}
