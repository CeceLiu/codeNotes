public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here.
    List<String> solu = new ArrayList<String>();
    StringBuilder sbd = new StringBuilder();
    validParentheses(n, 0, 0, sbd, solu);
    return solu;
  }
  
  public void validParentheses(int n, int leftCount, int rightCount, StringBuilder sbd, List<String> solu){
    if (leftCount == n && rightCount == n){
      solu.add(sbd.toString());
      return;
    }
    // only two states: add left or right
    if (leftCount < n){
      sbd.append('(');
      validParentheses(n, leftCount+1, rightCount, sbd, solu);
      sbd.deleteCharAt(sbd.length()-1);
    }
    // whenever plan to add a ")" the left parenthesis added so far > right parenthesis added so far
    if (rightCount < leftCount ){
      sbd.append(')');
      validParentheses(n, leftCount, rightCount+1, sbd, solu);
      sbd.deleteCharAt(sbd.length()-1);
    }
  }
}
