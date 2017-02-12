public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here.
    List<String> solu = new ArrayList<String>();
    if (set == null)
      return solu;
    char[] array = set.toCharArray();
    permutation(array, 0, solu);
    return solu;
  }
  
  public void permutation(char[] array, int index, List<String> solu){
    // new String then add to list also return
    if (index == array.length){
      solu.add(new String(array));
      return;
    }
    // for loop to control which index to check
    for(int i=index; i<array.length; i++){
      swap(array, i, index);
      permutation(array, index+1, solu);
      swap(array, i, index);
    }
  }
  
  public void swap(char[] array, int i, int j){
    if (i == j)
      return;
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
