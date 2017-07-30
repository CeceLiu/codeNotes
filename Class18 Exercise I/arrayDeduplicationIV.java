public class Solution {
  public int[] dedup(int[] array) {

    if(array==null || array.length<1)
      return array;
    Deque<Integer> stack = new LinkedList<>();
    int i=0;
    while(i<array.length){
      // ** check size before peekFirst
      if(stack.size()>0 && array[i] == stack.peekFirst()){
        while(i<array.length && array[i] == stack.peekFirst())
          i++;
        stack.pollFirst();
      }
      // add the first element inside of loop
      else{
        stack.offerFirst(array[i]);
        i++;
      }
    }
    int j=stack.size()-1, s=stack.size();
    while(j>=0){
      array[j--]=stack.pollFirst();
    }
    return Arrays.copyOfRange(array, 0, s);
  }
}
