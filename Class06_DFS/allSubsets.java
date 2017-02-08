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
    /*
    solu.add(sbd.toString());
    for(int i=index; i<array.length; i++){
      sbd.append(array[i]);
      // pass i or index is very different
      subSets(array, i+1, sbd, solu);
      sbd.deleteCharAt(sbd.length()-1);
    }
    */
    // only two sinario: add the letter OR not
    if (index == array.length){
      solu.add(sbd.toString());
      return;
    }
    sbd.append(array[index]);
    subSets(array, index+1, sbd, solu);
    sbd.deleteCharAt(sbd.length()-1);
    subSets(array, index+1, sbd, solu);
  }
}
