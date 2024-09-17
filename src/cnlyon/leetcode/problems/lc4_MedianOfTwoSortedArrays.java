package cnlyon.leetcode.problems;

public class lc4_MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    if (n == 0 && m % 2 == 0) {
      return (nums2[m / 2 - 1] + nums2[m / 2]) * 0.5;
    }
    if (n == 0 && m % 2 == 1) {
      return nums2[m / 2];
    }
    if (m == 0 && n % 2 == 0) {
      return (nums1[n / 2 - 1] + nums1[n / 2]) * 0.5;
    }
    if (m == 0 && n % 2 == 1) {
      return nums1[n / 2];
    }
    int sumLen = m + n;
    if (sumLen % 2 == 1) {
      return findKInArray(nums1, nums2, sumLen / 2 + 1);
    } else {
      return medianAverageOfArray(nums1, nums2);
    }
  }

  private int findKInArray(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int m = nums2.length;
    int l1 = 0;
    int l2 = 0;
    int currentK = k;
    while (l1 < n && l2 < m) {
      if (currentK == 1) {
        return Math.min(nums1[l1], nums2[l2]);
      }
      int p1 = Math.min(l1 + currentK / 2, n) - 1;
      int p2 = Math.min(l2 + currentK / 2, m) - 1;
      int num1 = nums1[p1];
      int num2 = nums2[p2];
      if (num1 <= num2) {
        currentK -= p1 - l1 + 1;
        l1 = p1 + 1;
      } else {
        currentK -= p2 - l2 + 1;
        l2 = p2 + 1;
      }
    }
    if (l1 == n) {
      return nums2[l2 + currentK - 1];
    }
    return nums1[l1 + currentK - 1];
  }

  private double medianAverageOfArray(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int l1 = 0;
    int l2 = 0;
    int currentK = (m + n) / 2;
    while (l1 < n && l2 < m) {
      if (currentK == 1) {
        return getAverage(nums1, nums2, l1, l2);
      }
      int p1 = Math.min(l1 + currentK / 2, n) - 1;
      int p2 = Math.min(l2 + currentK / 2, m) - 1;
      int num1 = nums1[p1];
      int num2 = nums2[p2];
      if (num1 <= num2) {
        currentK -= p1 - l1 + 1;
        l1 = p1 + 1;
      } else {
        currentK -= p2 - l2 + 1;
        l2 = p2 + 1;
      }
    }
    if (l1 == n) {
      return (nums2[l2 + currentK - 1] + nums2[l2 + currentK]) * 0.5;
    }
    return (nums1[l1 + currentK - 1] + nums1[l1 + currentK]) * 0.5;
  }

  private double getAverage(int[] nums1, int[] nums2, int l1, int l2) {
    int median;
    if (nums1[l1] <= nums2[l2]) {
      median = nums1[l1];
      l1++;
    } else {
      median = nums2[l2];
      l2++;
    }
    if (l1 == nums1.length) {
      return (median + nums2[l2]) * 0.5;
    }
    if (l2 == nums2.length) {
      return (median + nums1[l1]) * 0.5;
    }
    int sum = median + Math.min(nums1[l1], nums2[l2]);
    return sum * 0.5;
  }
}
