package cnlyon.leetcode.problems;

import cnlyon.leetcode.datastructure.ListNode;

public class lc24_SwapNodesInPairs {
  public ListNode swapPairs(ListNode head) {
    ListNode newHeadNode = new ListNode();
    newHeadNode.next = head;
    ListNode currentNode = newHeadNode;
    while (currentNode != null) {
      currentNode = swapNextTwoNodeAndGetNextHead(currentNode);
    }
    return newHeadNode.next;
  }

  private ListNode swapNextTwoNodeAndGetNextHead(ListNode head) {
    ListNode firstNode = head.next;
    if (firstNode == null) {
      return null;
    }
    ListNode secondNode = firstNode.next;
    if (secondNode == null) {
      return null;
    }
    ListNode postNode = secondNode.next;
    head.next = secondNode;
    secondNode.next = firstNode;
    firstNode.next = postNode;
    return firstNode;
  }
}
