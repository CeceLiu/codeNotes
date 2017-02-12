public class Solution {
  public int missing(int[] array) {
    // Write your solution here.
    /*
    int n = array.length+1;
    HashSet<Integer> set = new HashSet<Integer>();
    for (int item: array){
      set.add(item);
    }
    // check numbers from 1 to N-1
    for (int i=1; i<n; i++){
      if (!set.contains(i)){
        return i;
      }
    }
    return n;
    */
    
    // declear the variable as long
    long sum = 0L;
    for(int num: array){
      sum += num;
    }
    int n = array.length +1;
    long target = (n+0L) * (n+1L)/2;
    return (int)(target-sum);
  }
}
