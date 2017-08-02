public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    // ** can't direct return input since type not match
    if(arrayOfArrays==null || arrayOfArrays.length<1)
      return new int[]{};
    // ** PriorityQueue with own comparator
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(20, new MyComparator());
    
    // ** insert all 0 index elements to minHeap and record total length
    int length=0;
    for(int i=0; i<arrayOfArrays.length;i++){
      int[] currA = arrayOfArrays[i];
      length += currA.length;
      // ** make sure current sub-array contains elements
      if(currA!=null && currA.length>0)
        minHeap.offer(new Entry(i, 0, currA[0]));
    }
    
    int[] res = new int[length];
    int idx = 0;
    while(!minHeap.isEmpty()){
      Entry curr = minHeap.poll();
      res[idx++] = curr.value;
      // ** check next element in bound
      if(curr.y+1 < arrayOfArrays[curr.x].length){
        minHeap.offer(new Entry(curr.x, curr.y+1, arrayOfArrays[curr.x][curr.y+1]));
      }
    }
    return res;
  }
  
  static class MyComparator implements Comparator<Entry>{
    public int compare(Entry e1, Entry e2){
      return e1.value-e2.value;
    }
  }
  
  //x: index in arrayOfArrays; y: index in current array; value: element value
  static class Entry{
    int x;
    int y;
    int value;
    Entry(int x, int y, int value){
      this.x = x;
      this.y = y;
      this.value = value;
    }
  } 
}
