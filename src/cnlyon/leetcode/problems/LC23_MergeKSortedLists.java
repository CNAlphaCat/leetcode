package cnlyon.leetcode.problems;

import cnlyon.leetcode.annotations.Microsoft;
import cnlyon.leetcode.datastructure.ListNode;

@Microsoft
public class LC23_MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    return mergeList(lists, 0, lists.length);
  }

  private ListNode mergeList(ListNode[] lists, int l, int r) {
    if (l == lists.length) {
      return null;
    }
    if (l == r) {
      return lists[l];
    }
    int mid = (l + r) >> 1;
    return mergeTwoLists(mergeList(lists, l, mid), mergeList(lists, mid + 1, r));
  }

  private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
