public class Solution {
  public String remove(String input, String t) {
    // Write your solution here.
    /* O(mn)
    int i = 0;
    StringBuilder sbd = new StringBuilder();
    while(i < input.length()){
        boolean addFlag = true;
        int j = 0;
        while(j < t.length()){
            if(input.charAt(i) == t.charAt(j)){
                addFlag = false;
                break;
            }
            j++;
        }
        if(addFlag){
            sbd.append(input.charAt(i));
        }
        i++;
    }
    return sbd.toString();
    */

    // use HashSet: normal lookup time O(1), worse O(n)
    HashSet<Character> valid = new HashSet<Character>();
    for(char c: t.toCharArray()){
      valid.add(c);
    }
    StringBuilder sbd = new StringBuilder();
    for(int i=0; i<input.length(); i++){
      if(valid.contains(input.charAt(i)))
        continue;
      sbd.append(input.charAt(i));
    }
    return sbd.toString();
  }
}
