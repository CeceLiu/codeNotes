public class Solution {
  
  private Deque <Integer> stack;
  private Deque <Integer> minStack;
  // Cant use a globalMin since once the element pollout no way to update
  //private int globalMin = Integer.MAX_VALUE;
  
  public Solution() {
    // write your solution here
    stack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
  }
  
  public int pop() {
    int ret = stack.isEmpty() ? -1:stack.pollFirst();
    if ( !minStack.isEmpty() && minStack.peekFirst().equals(ret)){
      minStack.pollFirst();
    }
    return ret;
  }
  
  public void push(int element) {
    stack.offerFirst(element);
    if(minStack.isEmpty() || element <= minStack.peekFirst()){
      minStack.offerFirst(element);
    }
  }
  
  public int top() {
    return stack.isEmpty() ? -1: stack.peekFirst();
  }
  
  public int min() {
    return minStack.isEmpty() ? -1: minStack.peekFirst();
  }
}
