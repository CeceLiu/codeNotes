public class Solution {
  
  private PriorityQueue<Integer> min;
  private PriorityQueue<Integer> max;
  
  public Solution() {
    min = new PriorityQueue<Integer>(20, Collections.reverseOrder());
    max = new PriorityQueue<Integer>();
    /* declare maximum priority queue
    min = new PriorityQueue<Integer>(n,
      new Comparator<Integer>(){
        public int compare(Integer one, Integer two){
          return two-one;
        }
      });
    */
  }
  
  public void read(int value) {
    // balance min and max queues and keep min > max
    if(min.isEmpty() || value<= min.peek())
      min.offer(value);
    else
      max.offer(value);
    if((min.size() - max.size()) >=2)
      max.offer(min.poll());
    else if(max.size() > min.size())
      min.offer(max.poll());
  }
  
  public Double median() {
    // write your implementation here.
    int allSize = getSize();
    if (allSize == 0)
      return null;
    else if(allSize %2 !=0)
      return (double)min.peek();
    else
      return (min.peek()+max.peek())/2.0;
  }
  
  public int getSize(){
    return max.size() + min.size();
  }
}
