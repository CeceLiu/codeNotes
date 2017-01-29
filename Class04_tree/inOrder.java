/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  /*
  1. Create empty stack and initialize current node as root 
  2. Push current node to stack and curr = curr->left untill curr is NULL
  3. If curr is null and stack is not empty:
    a. pop top item from stack
    b. visit poped node and curr = curr->right
    c. go to step2
  4. Done when curr == null && stack.isEmpty
  */
  // 1. Iteration with stack
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode curr = root;
    while(curr != null || !stack.isEmpty()){
      if(curr != null){
        stack.offerFirst(curr);
        curr = curr.left;
      }
      else{
        curr = stack.pollFirst();
        result.add(curr.key);
        curr = curr.right;
      }
    }
    return result;
  }
  */
  //2. Recursion 
  public List<Integer> inOrder(TreeNode root){
    List<Integer> result = new ArrayList<Integer>();
    inOrder(root, result);
    return result;
  }
  
  public void inOrder(TreeNode root, List<Integer> result){
    if (root != null){
      inOrder(root.left, result);
      result.add(root.key);
      inOrder(root.right, result);
    }
  }
}
