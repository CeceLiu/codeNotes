/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Write your solution here.
    if(head==null)
      return head;
    // ** dummyH to point to newHead and return since after processing newHead changed
    RandomListNode newHead = new RandomListNode(head.value);
    RandomListNode dummyH = newHead;
    //** map<oldNode, newNode> to check if the node existing
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    map.put(head, newHead);
    while(head!=null){
      // ** check if next is null
      // if that node in map point to existing node
      // else create a newNode then point to it and update Map
      if(head.next !=null){
        RandomListNode next= map.get(head.next);
        if(next!=null){
          newHead.next = next;
        }
        else{
          RandomListNode newNext = new RandomListNode(head.next.value);
          newHead.next = newNext;
          map.put(head.next, newNext);
        }
      }
      
      if(head.random!=null){
        RandomListNode random = map.get(head.random);
        if(random!=null)
          newHead.random = random;
        else{
          RandomListNode newRandom = new RandomListNode(head.random.value);
          newHead.random = newRandom;
          map.put(head.random, newRandom);
        }
      }
      head = head.next;
      newHead = newHead.next;
    }
    return dummyH;
  }
}
