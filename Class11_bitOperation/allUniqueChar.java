
public class Solution {
  public boolean allUnique(String word) {
    // write your solution here
    /*
    int[] array = new int[255];
    for(int i=0; i<word.length(); i++){
      // convert char to ASCII number
      int index = (int)word.charAt(i);
      if(array[index] >=1)
        return false;
      else
        array[index] = 1;
    } 
    return true;
    */
    // 256 = 8*32
    int[] array = new int[8];
    for(int i=0; i<word.length(); i++){
      char currC = word.charAt(i);
      // check if that digit filled by 1
      if( (array[currC/32] >>> (currC%32) & 1) != 0)
        return false;
      // update digit
      array[currC/32] |= 1<<(currC%32);
    }
    return true;
  }
}
