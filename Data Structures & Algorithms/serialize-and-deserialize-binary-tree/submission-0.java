/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("n_");
            return;
        }
        sb.append(root.val+"_");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index=new int[]{0};
        String[] token=data.split("_");
        return decode(token, index);

    }
    private TreeNode decode(String[] token, int[]index){
        if(index[0]>=token.length){
            return null;
        }
        String data=token[index[0]++];
        if(data.equals("n")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(data));
        node.left=decode(token,index);
        node.right=decode(token,index);
        return node;
    }
}
