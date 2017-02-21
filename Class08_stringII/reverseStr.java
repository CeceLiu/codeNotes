public class Solution {
  public String reverse(String input) {
    // Write your solution here.
    if(input == null || input.length() <1)
      return input;
    char[] array = input.toCharArray();
    int left = 0;
    int right = array.length-1;
    // update left/right after switch
    while(left < right){
      char temp = array[left];
      array[left++] = array[right];
      array[right--] = temp;
    }
    return new String(array);
  }
}
