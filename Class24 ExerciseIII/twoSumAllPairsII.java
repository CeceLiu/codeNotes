public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here.
    if(array==null || array.length<1)
            return null;

    Arrays.sort(array);
    HashSet<List<Integer>> res = new HashSet<List<Integer>>();
    int i=0,j=array.length-1;
    while(i<j){
        if(array[i]+array[j]==target){
            List<Integer> curr = new LinkedList<>();
            curr.add(array[i++]);
            curr.add(array[j--]);
            res.add(curr);
        }
        else if(array[i]+array[j]<target){
            boolean flag=false;
            while(i<j && array[i+1]==array[i]){
                i++;
                flag=true;
            }
            if(flag)
                continue;
            else
                i++;

        }
        else{
            boolean flag = false;
            while(j>i && array[j-1]==array[j]){
                j--;
                flag=true;
            }
            if(flag)
                continue;
            else
                j--;
        }
    }
    return new ArrayList<List<Integer>>(res);
  }
}
