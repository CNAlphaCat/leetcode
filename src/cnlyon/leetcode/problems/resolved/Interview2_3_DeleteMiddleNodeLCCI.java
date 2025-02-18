package cnlyon.leetcode.problems.resolved;

import cnlyon.leetcode.annotations.Microsoft;
import cnlyon.leetcode.datastructure.ListNode;

/** <a href="https://leetcode.cn/problems/delete-middle-node-lcci/description/">...</a> */
@Microsoft
public class Interview2_3_DeleteMiddleNodeLCCI {
  public void deleteNode(ListNode node) {
    ListNode next = node.next;
    node.val = next.val;
    node.next = next.next;
  }
}
