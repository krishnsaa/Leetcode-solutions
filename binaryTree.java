import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import Leetcode.TreeNode;

public class binaryTree {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
    public TreeNode createBinaryTree(int[][] desc) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] dis : desc){
            if(map.containsKey(dis[0])){
                int[] ctemp = map.get(dis[0]);
                ctemp[dis[2]]=dis[1];
                map.put(dis[0],ctemp);
            }else{
                int[] ctemp = new int[2];
                Arrays.fill(ctemp,-1);
                ctemp[dis[2]]=dis[1];
                map.put(dis[0],ctemp);

            }
        }
        int rootval = findroot(map);
        TreeNode root = new TreeNode(rootval);
        maketree(root,map);
        return root;

    }
    public int findroot(Map<Integer, int[]> map) {
        Set<Integer> children = new HashSet<>();
        for (int[] childs : map.values()) {
            for (int child : childs) {
                if (child != 0) {
                    children.add(child);
                }
            }
        }
        for (int parent : map.keySet()) {
            if (!children.contains(parent)) {
                return parent;
            }
        }
        return -1;
    }
    public void maketree(TreeNode root,Map<Integer, int[]> map){
        if(root==null) return;
        if(!map.containsKey(root.val)) return;
        int[] child =map.get(root.val);
        root.left=child[1] == -1 ? null : new TreeNode(child[1]);
        root.right=child[0] == -1 ? null : new TreeNode(child[0]);
        maketree(root.left,map);
        maketree(root.right,map);
    }
}