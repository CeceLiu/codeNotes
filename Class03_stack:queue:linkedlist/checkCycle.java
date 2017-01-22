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
  public boolean hasCycle(ListNode head) {
    // write your solution here
    if (head == null || head.next == null){
      return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    // when checkMidd fast can't point to final null
    // while( fast!=null && fast.next !=null)
    while(fast.next!=null && fast.next.next !=null){
      fast = fast.next.next;
      slow = slow.next;
      // check after update otherwise input is true
      if (fast == slow){
        return true;
      }
    }
    return false;
  }
}
