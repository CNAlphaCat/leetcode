package cnlyon.leetcode.problems.resolved;

import cnlyon.leetcode.annotations.Microsoft;
import cnlyon.leetcode.datastructure.ListNode;

/** <a href="https://leetcode.cn/problems/sum-lists-lcci/">...</a> */
@Microsoft
public class Interview2_5_SumListsLCCI {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode resultHead = new ListNode();
    ListNode current = resultHead;
    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      current.next = node;
      current = node;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int sum = l1.val + carry;
      l1 = l1.next;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      current.next = node;
      current = node;
    }
    while (l2 != null) {
      int sum = l2.val + carry;
      l2 = l2.next;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      current.next = node;
      current = node;
    }
    if (carry != 0) {
      ListNode node = new ListNode(carry);
      current.next = node;
    }
    return resultHead.next;
  }
}
