import java.util.List;

public class Tree {
	
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		
		TreeNode() {}
		
		TreeNode(int val) { 
			this.val = val; 
		} 
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val; 
			this.left = left; 
			this.right = right;
		}

		
		
		public Boolean isLeaf(){
			if(left == null && right == null){
				return true;
			}
			return false;
		}

		public nodeCopy(){
			TreeNode node = new TreeNode();
			node.val = val;
			node.left = left;
			node.right = right;
			return node;
		}
	}
	
	public void printPerimeter(TreeNode root){
		List<Integer> listValue = new ArrayList<>();
		List<Treenode> listPerimeterNode = new ArrayList<>();
		listPerimeterNode.addAll(findRightPerimeter(root));
		listPerimeterNode.addAll(findLeafNodeR2L(root));
		listPerimeterNode.addAll(Collections.reverse(findLeftPerimeter(root)));

		for(Treenode node : listPerimeterNode) {
			listValue.add(node.val);
		}
		listValue = new ArrayList<Integer>(new LinkedHashSet<>(listValue));
		return listValue;
	}
	

	public List<TreeNode> findLeafNodeR2L(TreeNode node){
		List<Treenode> listLeaf() = new ArrayList<>();
		if(node.isLeaf){
			listLeaf.add(node);
		}else{
			// right node
			if(node.right != null){
				if(node.right.isLeaf){
					listLeaf.add(node.right);
				}else{
					listLeaf.addAll(findLeafNodeR2L(listLeaf.right));
				}
			}
			// left node
			if(node.left != null){
				if(node.left.isLeaf){
					listLeaf.add(node.left);
				}else{
					listLeaf.addAll(findLeafNodeR2L(listLeaf.left));
				}
			}
		}
		return listLeaf;
	}

	public List<TreeNode> findRightPerimeter(TreeNode node){
		List<Treenode> listNode() = new ArrayList<>();
		TreeNode nodeTmp = node.nodeCopy;
		while(nodeTmp.right != null){
			listNode.add(nodeTmp.right);
			nodeTmp = nodeTmp.right.nodeCopy;
		}
		if(nodeTmp.left != null){
			listNode.add(nodeTmp.left);
		}
	}

	public List<TreeNode> findLeftPerimeter(){
		List<Treenode> listNode() = new ArrayList<>();
		TreeNode nodeTmp = node.nodeCopy;
		while(nodeTmp.left != null){
			listNode.add(nodeTmp.left);
			nodeTmp = nodeTmp.left.nodeCopy;
		}
		if(nodeTmp.right != null){
			listNode.add(nodeTmp.right);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Tree tree = new Tree();
		
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		
		TreeNode node4 = new TreeNode(4, node8, node9);
		TreeNode node5 = new TreeNode(5, node10, node11);
		TreeNode node6 = new TreeNode(6, null, node13);
		TreeNode node7 = new TreeNode(7, node14, null);
		
		TreeNode node2 = new TreeNode(2, node4, node5);
		TreeNode node3 = new TreeNode(3, node6, node7);
		
		TreeNode node1 = new TreeNode(1, node2, node3);
		
		List<Integer> listValue = printPerimeter(node1);
		for(Integer val : listValue) {
			System.out.print(val);
		}
	}
}
