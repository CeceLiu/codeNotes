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
  public ListNode insert(ListNode head, int value) {
    // write your solution here
    ListNode newNode = new ListNode(value);
    // insert before head
    if (head==null || value < head.value){
      newNode.next = head;
      return newNode;
    }
    ListNode curr = head;
    // found the positon to insert after
    while(curr.next !=null && curr.next.value < value){
      curr = curr.next;
    }
    newNode.next = curr.next;
    curr.next = newNode;
    return head;
  }
}
