package cnlyon.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15_3Sum {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int k = 0; k < nums.length - 2; k++) {
      if (nums[k] > 0) {
        break;
      }
      if (k > 0 && nums[k] == nums[k - 1]) {
        continue;
      }
      int i = k + 1;
      int j = nums.length - 1;
      while (i < j) {
        int sum = nums[k] + nums[i] + nums[j];
        if (sum == 0) {
          List<Integer> itemList = new ArrayList<>();
          itemList.add(nums[k]);
          itemList.add(nums[i]);
          itemList.add(nums[j]);
          result.add(itemList);
          ++i;
          --j;
          while (i < j && nums[i] == nums[i - 1]) {
            ++i;
          }
          while (i < j && nums[j] == nums[j + 1]) {
            --j;
          }
        } else if (sum < 0) {
          ++i;
          while (i < j && nums[i] == nums[i - 1]) {
            ++i;
          }
        } else {
          // sum > 0
          --j;
          while (i < j && nums[j] == nums[j + 1]) {
            --j;
          }
        }
      }
    }
    return result;
  }
}
