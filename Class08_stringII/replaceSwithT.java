public class Solution {
  public static String replace(String input, String s, String t) {
    // Write your solution here.
    StringBuilder sbd = new StringBuilder();
    int i=0;
    while (i<input.length()){
        boolean replace = false;
        if (input.charAt(i) == s.charAt(0)){
            int index = i;
            int j=0;
            while(j<s.length() && index<input.length()){
                if (input.charAt(index) != s.charAt(j)){
                    replace = false;
                    break;
                }
                index++;
                j++;
            }
            // if while complete then j at the end of s
            if (j == s.length()){
                replace = true;
                i=index;
            }
        }
        if(replace){
            sbd.append(t);
            continue;
        }
        sbd.append(input.charAt(i));
        i++;
    }
    return sbd.toString();

    // with SBD
    /*
    StringBuilder sbd = new StringBuilder();
    int index = input.indexOf(s);
    while(index != -1){
      sbd.append(input.substring(0, index));
      sbd.append(t);
      input = input.substring(index+s.length());
      index = input.indexOf(s);
    }
    sbd.append(input);
    return sbd.toString();
    */
    }
}
