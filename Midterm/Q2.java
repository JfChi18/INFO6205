class Solution {
  //Time complexity : O(N),Space complexity : O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode node, int height) {
        if (node == null) return;
        if (height >= res.size())
            res.add(new ArrayList<>());
        res.get(height).add(node.val);
        helper(res, node.left, height + 1);
        helper(res, node.right, height + 1);
    }
}

