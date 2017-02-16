public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here.
    List<String> solu = new ArrayList<String>();
    if( set == null)
      return solu;
    char[] array = set.toCharArray();
    permutations(array, 0, solu);
    return solu;
  }
  
  public void permutations(char[] array, int index, List<String> solu){
    if(index == array.length){
      solu.add(new String(array));
      return;
    }
    HashSet<Character> used = new HashSet<Character>();
    for(int i=index; i<array.length; i++){
      if (!used.contains(array[i])){
        used.add(array[i]);
        swap(array, i, index);
        permutations(array, index+1, solu);
        swap(array, i, index);
      }
    }
  }
  
  public void swap(char[] array, int i, int j){
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
