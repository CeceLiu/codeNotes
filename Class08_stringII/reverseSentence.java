public class Solution {
  public String reverseWords(String input) {
    // Write your solution here.
    char[] array = input.toCharArray();
    reverseString(array, 0, array.length-1);
    int start = 0;
    for(int i=0; i<array.length; i++){
        // get the index of each word start
        if(array[i] != ' ' && (i==0||array[i-1]==' '))
            start = i;
        // get the index of each word end
        if(array[i] !=' ' && (i==array.length-1||array[i+1]==' '))
            reverseString(array, start, i);
    }
    return new String(array);
    }
// reverse word by index
public void reverseString(char[] array, int left, int right){
    while(left < right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        left++;
        right--;
    }
}
}
