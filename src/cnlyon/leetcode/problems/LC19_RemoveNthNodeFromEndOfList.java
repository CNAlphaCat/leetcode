package cnlyon.leetcode.problems;

import cnlyon.leetcode.datastructure.ListNode;

public class LC19_RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode l = head;
    ListNode r = head;
    for (int i = 0; i < n; i++) {
      r = r.next;
    }
    if (r == null) {
      return head.next;
    }
    while (r.next != null) {
      l = l.next;
      r = r.next;
    }
    ListNode nextNode = l.next.next;
    l.next = nextNode;
    return head;
  }
}
