public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // two points with time complexity O(n^2)
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    if(array==null || array.length<3)
      return null;
    Arrays.sort(array);
    // ** looping to the last 2 element
    for(int i=0; i<array.length-2; i++){
      // ** make sure i only move to a new element to avoid dups
      if(i==0 || array[i]>array[i-1]){
        int j=i+1;
        int k=array.length-1;
        while(j<k){
          if(array[i]+array[j]+array[k]==target){
            List<Integer> curr = new LinkedList<Integer>();
            curr.add(array[i]);
            curr.add(array[j]);
            curr.add(array[k]);
            res.add(curr);
            j++;
            k--;
            while(j<k && array[j]==array[j-1])
              j++;
            while(j<k && array[k]==array[k+1])
              k--;
          }
          else if(array[i]+array[j]+array[k]<target)
            j++;
          else
            k--;
        }
      }
    }
    return res;
  }
}
