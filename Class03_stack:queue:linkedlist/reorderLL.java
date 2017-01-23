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
  public ListNode reorder(ListNode head) {
    // Write your solution here.
    if(head == null || head.next == null){
      return head;
    }
    ListNode middle = findMidd(head);
    ListNode one = head;
    ListNode two = middle.next;
    // split the LL to two parts
    middle.next = null;
    return merge(head, reverse(two));
  }
  
  public ListNode findMidd(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
  
  public ListNode reverse(ListNode head){
    ListNode curr = head;
    ListNode prev = null;
    ListNode next = null;
    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
  
  public ListNode merge(ListNode one, ListNode two){
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while(one!=null && two!=null){
      curr.next = one;
      one = one.next;
      curr = curr.next;
      curr.next = two;
      two = two.next;
      curr = curr.next;
    }
    if(one!=null){
      curr.next = one;
    }
    else{
      curr.next = two;
    }
    return dummy.next;
  }
}
