package cnlyon.leetcode.problems;

import cnlyon.leetcode.datastructure.ListNode;

public class lc25_ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode newHeadNode = new ListNode();
    newHeadNode.next = head;
    ListNode currentHead = newHeadNode;
    while (currentHead != null) {
      currentHead = tryReverseKListAndGetTail(currentHead, k);
    }
    return newHeadNode.next;
  }

  private ListNode tryReverseKListAndGetTail(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode currentNode = head;
    ListNode newHead = head.next;
    while (currentNode != null) {
      ListNode tail = findKTail(currentNode, k);
      if (tail == null) {
        return null;
      }
      currentNode = reverseListNodeAndGetTail(currentNode, tail);
    }
    return newHead;
  }

  private ListNode findKTail(ListNode head, int k) {
    ListNode currentNode = head;
    for (int i = 0; i < k; i++) {
      if (currentNode == null) {
        return null;
      }
      currentNode = currentNode.next;
    }
    return currentNode;
  }

  private ListNode reverseListNodeAndGetTail(ListNode head, ListNode tail) {
    ListNode newTail = head.next;
    ListNode currentNode = head.next;
    while (currentNode != tail) {
      ListNode firstNode = tail.next;
      tail.next = currentNode;
      ListNode nextNode = currentNode.next;
      currentNode.next = firstNode;
      currentNode = nextNode;
    }
    head.next = currentNode;
    return newTail;
  }
}
