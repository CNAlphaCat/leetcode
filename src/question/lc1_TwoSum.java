package question;

import java.util.HashMap;

public class lc1_TwoSum {
  // https://leetcode.cn/problems/two-sum/
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numToIndexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int differ = target - nums[i];
      if (numToIndexMap.containsKey(differ)) {
        return new int[] {numToIndexMap.get(differ), i};
      } else {
        numToIndexMap.put(nums[i], i);
      }
    }
    return new int[0];
  }
}
