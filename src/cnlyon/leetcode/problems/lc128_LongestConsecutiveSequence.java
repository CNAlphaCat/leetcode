package cnlyon.leetcode.problems;

import java.util.HashSet;

public class lc128_LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }
    int max = 0;
    for (int num : numSet) {
      if(numSet.contains(num - 1)){
        continue;
      }
      int longestConsecutive = getLongestConsecutive(numSet, num);
      max = Math.max(max, longestConsecutive);
    }
    return max;
  }

  private int getLongestConsecutive(HashSet<Integer> numSet, int num){
    int count = 1;
    int nextNum = num + 1;
    while(numSet.contains(nextNum)){
      count++;
      nextNum++;
    }
    return count;
  }
}
