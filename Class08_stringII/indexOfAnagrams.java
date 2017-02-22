public class Solution {
  List<Integer> allAnagrams(String s, String l) {
    // Write your solution here.
    List<Integer> solu = new ArrayList<Integer>();
    int sLength = s.length();
    // looping i until l-s
    for(int i=0; i<=l.length()-sLength; i++){
      // "hello" substring(1,3) -> "el" [start, start+length]
      String str = l.substring(i, i+sLength);
      if (checkAnagrams(s, str))
        solu.add(i);
    }
    return solu;
  }
  
  public boolean checkAnagrams(String one, String two){
    //M1. sort both string --> time O(nlog)
    /*
    char[] oneArray = one.toCharArray();
    char[] twoArray = two.toCharArray();
    Arrays.sort(oneArray);
    Arrays.sort(twoArray);
    for(int i=0; i<oneArray.length; i++){
      if (oneArray[i] != twoArray[i])
        return false;
    }
    return true;
    */
    //M2. Count characters-> time O(n)
    /*
    int[] oneArray = new int[26];
    int[] twoArray = new int[26];
    for(char c: one.toCharArray()){
      int i = c - 'a';
      oneArray[i] += 1;
    }
    for(char c: two.toCharArray()){
      int i= c-'a';
      twoArray[i] += 1;
    }
    for(int i=0; i<26; i++){
      if (oneArray[i] != twoArray[i])
        return false;
    }
    return true;
    */ 
    // O(m) with less space 
    int[] count = new int[26];
    for (char c: one.toCharArray()){
      int i= c-'a';
      count[i] +=1;
    }
    for(char c:two.toCharArray()){
      int i = c-'a';
      count[i] -=1;
      if(count[i] < 0)
        return false;
    }
    return true;
  }
}
