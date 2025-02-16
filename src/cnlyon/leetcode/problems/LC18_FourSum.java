package cnlyon.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> sumListCollections = new ArrayList<>();
    if (nums.length < 4) {
      return sumListCollections;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
        break;
      }
      if ((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1]
          < target) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
          break;
        }
        if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
          continue;
        }
        int l = j + 1;
        int r = nums.length - 1;
        while (l < r) {
          long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
          if (sum == target) {
            List<Integer> sumResult = new ArrayList<>();
            sumResult.add(nums[i]);
            sumResult.add(nums[j]);
            sumResult.add(nums[l]);
            sumResult.add(nums[r]);
            sumListCollections.add(sumResult);
            while (l < r && nums[l] == nums[l + 1]) {
              l++;
            }
            l++;
            while (l < r && nums[r] == nums[r - 1]) {
              r--;
            }
            r--;
          } else if (sum < target) {
            l++;
          } else {
            r--;
          }
        }
      }
    }
    return sumListCollections;
  }
}
