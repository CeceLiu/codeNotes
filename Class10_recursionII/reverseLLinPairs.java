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
  public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    /*
    if(head == null || head.next == null)
      return head;
    ListNode newHead = head.next;
    head.next = reverseInPairs(head.next.next);
    newHead.next = head;
    return newHead;
    */
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    // dummy->N1->N2->N3->N4->N5;
    while(curr.next != null && curr.next.next!=null){
      /*
      // next = N2, the node need to reverse
      ListNode next = curr.next.next;
      // disable N1.next update N1.next = N3
      curr.next.next = curr.next.next.next;
      // N2.next = N1
      next.next = curr.next;
      // dummy.next is new head N2
      curr.next = next;
      // move curr to N1
      curr = curr.next.next;*/
      
      ListNode next = curr.next.next; // next is N2
      curr.next.next = next.next; // N1 next is N3
      next.next = curr.next; // N2 next is N1
      curr.next = next; // change head to N2
      curr = next.next; // move curr to N1
      
    }
    return dummy.next;
  }
}
