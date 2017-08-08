public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // Write your solution here.
    List<Integer> res = new LinkedList<>();
    int i=0,j=0,k=0;
    while(i<a.length && j<b.length && k<c.length){
      if(a[i] == b[j] && b[j]==c[k]){
        res.add(a[i]);
        i++;
        j++;
        k++;
      }
      // ** comapre less than instead of equal
      else if(a[i]<=b[j] && a[i]<= c[k]){
        i++;
      }
      else if(b[j]<=a[i] && b[j]<=c[k]){
        j++;
      }
      else {
        k++;
      }
    }
    return res;
  }
}
