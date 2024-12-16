package cnlyon.leetcode.problems;

import cnlyon.leetcode.datastructure.ListNode;

public class lc21_MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode newListHead = new ListNode();
    ListNode currentNode = newListHead;
    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        currentNode.next = list2;
        list2 = list2.next;
      } else {
        currentNode.next = list1;
        list1 = list1.next;
      }
      currentNode = currentNode.next;
    }
    while (list1 != null) {
      currentNode.next = list1;
      list1 = list1.next;
      currentNode = currentNode.next;
    }
    while (list2 != null) {
      currentNode.next = list2;
      list2 = list2.next;
      currentNode = currentNode.next;
    }
    return newListHead.next;
  }
}
