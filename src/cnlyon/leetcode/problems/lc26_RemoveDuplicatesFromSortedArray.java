package cnlyon.leetcode.problems;

public class lc26_RemoveDuplicatesFromSortedArray {
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
