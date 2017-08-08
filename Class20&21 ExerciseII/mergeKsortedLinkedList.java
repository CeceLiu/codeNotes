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
  public ListNode merge(List<ListNode> listOfLists) {
    // A list of ListNode i.e. each single node maintains next point
    if(listOfLists==null)
      return null;
    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(20, new MyComparator());
    // ** dummyH to return 
    ListNode curr = new ListNode(0);
    ListNode dummy = curr;
    for(ListNode node: listOfLists){
      // ** check if node null
      if(node != null)
        minHeap.offer(node);
      }
    
    while(!minHeap.isEmpty()){
      curr.next = minHeap.poll();
      if(curr.next.next != null)
        minHeap.offer(curr.next.next);
      curr = curr.next;
    }
    return dummy.next;
  }
  
  static class MyComparator implements Comparator<ListNode>{
    public int compare(ListNode n1, ListNode n2){
      return n1.value - n2.value;
    }
  }
}
