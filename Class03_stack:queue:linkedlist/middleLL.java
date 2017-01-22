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
  public ListNode middleNode(ListNode head) {
    // write your solution here
    if (head==null || head.next == null){
      return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
