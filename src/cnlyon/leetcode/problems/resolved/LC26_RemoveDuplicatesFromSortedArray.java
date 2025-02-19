package cnlyon.leetcode.problems.resolved;

import cnlyon.leetcode.annotations.Microsoft;

@Microsoft
public class LC26_RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] == nums[i]) {
        continue;
      }
      nums[i + 1] = nums[j];
      i++;
    }
    return i + 1;
  }
}
