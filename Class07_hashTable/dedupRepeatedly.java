public class Solution {
  public String deDup(String input) {
    // Write your solution here.
     if (input == null || input.length() ==0){
            return input;
        }

        char[] array = input.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();
        int i=0;
        while(i<array.length){
            char curr = array[i];
            if ( stack.size() >0 && stack.peekFirst() == curr){
                while(i<array.length && array[i] == curr){
                    i++;
                }
                stack.pollFirst();
            }
            else{
              // add elements to head
                stack.offerFirst(curr);
                i++;
            }
        }
        StringBuilder sbd = new StringBuilder();
        while(!stack.isEmpty())
          sbd.append(stack.pollLast());
        return sbd.toString();
  }
}
