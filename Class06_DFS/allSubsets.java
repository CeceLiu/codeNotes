public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> solu = new ArrayList<String>();
    if (set == null){
      return solu;
    }
    StringBuilder sbd = new StringBuilder();
    char[] array = set.toCharArray();
    subSets(array, 0, sbd, solu);
    return solu;
  }
  
  public void subSets(char[] array, int index, StringBuilder sbd, List<String> solu){
    solu.add(sbd.toString());
    for(int i=index; i<array.length; i++){
      sbd.append(array[i]);
      subSets(array, i+1, sbd, solu);
      sbd.deleteCharAt(sbd.length()-1);
    }
  }
}
