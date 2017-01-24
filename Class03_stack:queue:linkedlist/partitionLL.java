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
  public ListNode partition(ListNode head, int target) {
    // write your solution here
    if(head == null || head.next == null){
      return head;
    }
    // create dummyHead to return
    ListNode dummySmall = new ListNode(0);
    ListNode dummyLarge = new ListNode(0);
    ListNode small = dummySmall;
    ListNode large = dummyLarge;
    ListNode curr = head;
    while(curr != null){
      if (curr.value < target){
        small.next = curr;
        small = small.next;
      }
      else{
        large.next = curr;
        large = large.next;
      }
      curr = curr.next;
    }
    // terminate the list with null
    large.next = null;
    small.next = dummyLarge.next;
    return dummySmall.next;
  }
}
