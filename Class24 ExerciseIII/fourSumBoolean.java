public class Solution {
  public boolean exist(int[] array, int target) {
    // Write your solution here.
    if(array==null || array.length<4)
      return false;
    Arrays.sort(array);
    for(int i=0; i<array.length-3; i++){
      for(int j=i+1;j<array.length-2;j++){
        int m=j+1;
        int n=array.length-1;
        while(m<n){
          if(array[i]+array[j]+array[m]+array[n]==target)
            return true;
          else if(array[i]+array[j]+array[m]+array[n]>target)
            n--;
          else
            m++;
        }
      }
    }
    return false;
  }
}
