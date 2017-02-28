public class Solution {
  public String hex(int number) {
    // Write your solution here.
    
    String prefix = "0x";
    if(number == 0)
      return prefix+"0";
      
    StringBuilder sbd = new StringBuilder();
    while(number>0){
      int count = number % 16;
      if(count<10)
        sbd.append( (char)(count+'0'));
      else
        sbd.append( (char)(count-10 + 'A'));
      // divide by 16 i.e. number/=16;
      number >>>= 4;
    }
    // reverse result
    return prefix+sbd.reverse().toString();
  }
}
