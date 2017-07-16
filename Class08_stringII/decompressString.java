public class Solution {
  public String decompress(String input) {
    // Write your solution here.
    StringBuilder sbd = new StringBuilder();
    for(int i=0; i<input.length(); i +=2 ){
      char curr = input.charAt(i);
      int count = input.charAt(i+1) - '0';
      while(count>0){
        sbd.append(curr);
        count--;
      }
    }
    return sbd.toString();
  }
}
