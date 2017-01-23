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
  public ListNode merge(ListNode one, ListNode two) {
    // write your solution here
    if (one == null){
      return two;
    }
    if (two == null){
      return one;
    }
    // create a dummy pointer to real head with value
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while(one!=null && two!=null){
      if (one.value <= two.value){
        curr.next = one;
        one = one.next;
      }
      else{
        curr.next = two;
        two = two.next;
      }
      curr = curr.next;
    }
    if(one!=null){
      curr.next = one;
    }
    else if(two != null){
      curr.next = two;
    }
    // dummy.next point to real head
    return dummy.next;
  }
}
