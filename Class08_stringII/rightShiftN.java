public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here.
    if (input == null || input.length() <1)
      return input;
    char[] array = input.toCharArray();
    // get the really size need to move
    n = n % array.length;
    reverse(array, 0, array.length-n-1);
    reverse(array, array.length-n, array.length-1);
    reverse(array, 0, array.length-1);
    return new String(array);
  }
  
  public void reverse(char[] array, int left, int right){
    while(left < right){
      char temp = array[left];
      array[left++] = array[right];
      array[right--] = temp;
    }
  }
}
