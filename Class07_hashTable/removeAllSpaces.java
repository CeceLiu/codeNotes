public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here.
    int i=0;
    // set flag to check first word
    boolean flag = false;
    StringBuilder sbd = new StringBuilder();
    while(true){
      // remove all spaces
      while(i<input.length() && input.charAt(i) == ' ')
        i++;
      if (i == input.length())
        break;
      if (flag == true){
        sbd.append(' ');
      }
      while(i<input.length() && input.charAt(i) != ' '){
        sbd.append(input.charAt(i));
        i++;
      }
      // update flag after first word added
      flag = true;
    }
    return sbd.toString();
  }
}
