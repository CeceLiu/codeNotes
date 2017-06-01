public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    while(true){
      int res = getResult();
      if(res < 1000)
        return res;
    }
  }
  
  public int getResult(){
    int res = 0;
    int curr = 1;
    int base = 5;
    for(int i=0; i<5; i++){
      res += curr*RandomFive.random5();
      curr *= base;
    }
    return res;
  }
}
