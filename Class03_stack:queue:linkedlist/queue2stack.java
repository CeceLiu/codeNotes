public class Solution {
  
  private Deque<Integer> stack1;
  private Deque<Integer> stack2;
  
  public Solution() {
    // Write your solution here.
    stack1 = new LinkedList<Integer>();
    stack2 = new LinkedList<Integer>();
    /*
    bloonean offerFirst(E e): Inserts the specified element at the front of this list.
    E peakFirst(): Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
    E pollFirst(): Retrieves and removes the first element of this list, or returns null if this list is empty.
    */
  }
  
  public Integer poll() {
    move();
    return stack2.size()==0?null:stack2.pollFirst();
  }
  
  public void offer(int element) {
    stack1.offerFirst(element);
  }
  
  public Integer peek() {
    move();
    return stack2.size() == 0? null:stack2.peekFirst();
  }
  
  public int size() {
    return stack1.size() + stack2.size();
  }
  
  public boolean isEmpty() {
    return stack1.size()==0 && stack2.size()==0;
  }
  
  public void move(){
    if(stack2.isEmpty()){
      while(stack1.size() != 0){
        int element = stack1.pollFirst();
        stack2.offerFirst(element);
      }
    }
  }
  
}