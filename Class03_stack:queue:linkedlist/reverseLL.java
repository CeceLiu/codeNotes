/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode reverse(ListNode head) {
    // write your solution here
    if (head == null || head.next == null){
      return head;
    }
    /*  Iteration
    ListNode curr = head;
    ListNode next = null;
    ListNode prev = null;
    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
    */
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
