package cnlyon.leetcode.problems;

public class lc283_MoveZeroes {
  public void moveZeroes(int[] nums) {
    int notZeroCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }
      nums[notZeroCount] = nums[i];
      notZeroCount++;
    }
    for (int i = notZeroCount; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
