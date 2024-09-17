package cnlyon.leetcode.problems;

public class lc11_ContainerWithMostWater {

  public int maxArea(int[] height) {
    int l = 0;
    int r = height.length - 1;
    int max = (r - l) * Math.min(height[l], height[r]);
    while (l < r) {
      if (height[l] > height[r]) {
        r--;
      } else {
        l++;
      }
      max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
    }
    return max;
  }
}
