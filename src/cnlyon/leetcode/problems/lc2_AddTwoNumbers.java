package cnlyon.leetcode.problems;

import cnlyon.leetcode.datastructure.ListNode;

public class lc2_AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode resultHead = null;
    ListNode resultTail = null;
    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      l1 = l1.next;
      l2 = l2.next;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      if (resultHead == null) {
        resultHead = node;
        resultTail = node;
        continue;
      }
      resultTail.next = node;
      resultTail = node;
    }
    while (l1 != null) {
      int sum = l1.val + carry;
      l1 = l1.next;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      if (resultHead == null) {
        resultHead = node;
        resultTail = node;
        continue;
      }
      resultTail.next = node;
      resultTail = node;
    }
    while (l2 != null) {
      int sum = l2.val + carry;
      l2 = l2.next;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      if (resultHead == null) {
        resultHead = node;
        resultTail = node;
        continue;
      }
      resultTail.next = node;
      resultTail = node;
    }
    if (carry > 0) {
      resultTail.next = new ListNode(carry);
    }
    return resultHead;
  }
}
