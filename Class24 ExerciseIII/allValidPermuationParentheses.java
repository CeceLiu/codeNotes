public class Solution {
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here.
    char[] pairs = new char[]{'(', ')', '[', ']', '{', '}'};
    int[] rem = new int[]{l,l,m,m,n,n};
    int targetLen = 2*l + 2*m + 2*n;
    StringBuilder sbd = new StringBuilder();
    List<String> res = new LinkedList<String>();
    Deque<Character> stack = new LinkedList<Character>();
    helper(pairs, rem, targetLen, sbd, res, stack);
    return res;
  }
  
  public void helper(char[] pairs, int[] rem, int targetLen, StringBuilder sbd, List<String> res, Deque<Character> stack){
    if(sbd.length() == targetLen){
      res.add(sbd.toString());
      return;
    }
    for(int i=0; i<rem.length; i++){
      // ** left parenthese
      if(i%2==0){
        if(rem[i]>0){
          sbd.append(pairs[i]);
          stack.offerFirst(pairs[i]);
          rem[i]--;
          helper(pairs, rem, targetLen, sbd, res, stack);
          sbd.deleteCharAt(sbd.length()-1);
          stack.pollFirst();
          rem[i]++;
        }
      }
      // ** right parentheses depends on elements in stack and not same as previous element
      else{
          if(!stack.isEmpty() && stack.peekFirst()==pairs[i-1]){
            sbd.append(pairs[i]);
            stack.pollFirst();
            rem[i]--;
            helper(pairs, rem, targetLen, sbd, res, stack);
            sbd.deleteCharAt(sbd.length()-1);
            stack.offerFirst(pairs[i-1]);
            rem[i]++;
          }
        }
      }
  }
}
