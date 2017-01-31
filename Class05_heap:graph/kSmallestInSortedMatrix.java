public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here.
    int row = matrix.length;
    int col = matrix[0].length;

    PQsort compare = new PQsort();
    PriorityQueue<Node> minHeap = new PriorityQueue<Node>(k, compare);
    boolean[][] visited = new boolean[row][col];
    minHeap.offer(new Node(0,0,matrix[0][0]));
    visited[0][0] = true;
    int ret = Integer.MIN_VALUE;
    for(int i=0; i<k; i++){
      Node curr = minHeap.poll();
      ret = curr.value;
      // expand [i][j] -> generate [i+1][j]&&[i][j+1]
      // terminate when k-th node is popped out of the queue
      if ( curr.c+1 < col && !visited[curr.r][curr.c+1]){
        minHeap.offer(new Node(curr.r, curr.c+1, matrix[curr.r][curr.c+1]));
        visited[curr.r][curr.c+1] = true;
      }
      if ( curr.r+1 < row && !visited[curr.r+1][curr.c]){
        minHeap.offer(new Node(curr.r+1, curr.c, matrix[curr.r+1][curr.c]));
        visited[curr.r+1][curr.c] = true;
      }
    }
    return ret;
  }

  static class PQsort implements Comparator<Node>{
    public int compare(Node one, Node two){
      if (one.value == two.value){
        return 0;
      }
      return one.value < two.value ? -1:1;
    }
  }
  
  static class Node {
    int r;
    int c;
    int value;
    
    Node(int r, int c, int value){
      this.r = r;
      this.c = c;
      this.value = value;
    }
  }
}
