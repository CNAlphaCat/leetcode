package cnlyon.leetcode.problems;

import java.util.Arrays;

public class lc16_3SumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[2];
    for (int k = 0; k < nums.length - 2; k++) {
      if (k > 0 && nums[k] == nums[k - 1]) {
        continue;
      }
      int i = k + 1;
      int j = nums.length - 1;
      while (i < j) {
        int sum = nums[k] + nums[i] + nums[j];
        if (sum == target) {
          return sum;
        }
        if (Math.abs(result - target) > Math.abs(sum - target)) {
          result = sum;
        }
        if (sum > target) {
          --j;
          while (i < j && nums[j] == nums[j + 1]) {
            --j;
          }
        }
        if (sum < target) {
          ++i;
          while (i < j && nums[i] == nums[i - 1]) {
            ++i;
          }
        }
      }
    }
    return result;
  }
}
