public class Solution {
  
  private int count;
  private Integer sample;
  
  public Solution() {
    // Write your constructor code here if necessary.
    // initialize
    this.count = 0;
    this.sample = null;
  }
  
  public void read(int value) {
    // Write your implementation here.
    count++;
    // the current read number has prob of 1/count to be the current sample
    // update the sample value each time read new number
    int prob = (int)(Math.random() * count);
    if(prob == 0)
      sample = value;
  }
  
  public Integer sample() {
    // Write your implementation here.
    return sample;
  }
}
