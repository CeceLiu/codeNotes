public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    if (input == null||input.length() == 0){
      return input;
    }
    char[] array = input.toCharArray();
    /*
    int i=0;
    int j=1;
    while(j<array.length){
      if (array[i] == array[j]){
        j++;
      }
      else{
        array[i+1] = array[j];
        i++;
        j++;
      }
    }
    // the initial offset and string length
    return new String(array, 0, i+1);
    */
    // compare with previous element
    int end=0;
    for (int i=0; i<array.length; i++){
      if (i==0|| array[end-1] != array[i]){
        array[end++] = array[i];
      }
    }
    return new String(array, 0, end);
  } 
}
