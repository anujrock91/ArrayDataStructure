package Snippet;

class wrapper{
	TreeNode node;
	int pointer;
}

public class ConsBinaryTree {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
		root = buildTree(inorder, postorder, postorder.length-1).node;
		return root;
    }
	
	private wrapper buildTree(int[] inorder, int[] postorder, int pointer){
		if(inorder.length == 0 || postorder.length == 0){ return null; }
		else{
			TreeNode newNode = new TreeNode(postorder[pointer]);
			wrapper obj = new wrapper();
			obj.node = newNode;
			int inorderBreak;
			for(inorderBreak = 0; inorderBreak<inorder.length;inorderBreak++){
				if(inorder[inorderBreak] == postorder[pointer]){ break; }
			}
			int leftArr[] = new int[inorderBreak];
			int rightArr[] = new int[inorder.length-inorderBreak-1];
			for(int i=0;i<inorderBreak;i++){ leftArr[i] = inorder[i]; }
			int rightCount = 0;
			for(int i=inorderBreak+1;i<inorder.length;i++){ rightArr[rightCount] = inorder[i]; ++rightCount; }
			wrapper objRight = new wrapper();
			wrapper objLeft = new wrapper();
			if(rightArr.length != 0){ objRight = buildTree(rightArr, postorder, pointer-1); pointer = objRight.pointer;}
			if(leftArr.length != 0){ objLeft = buildTree(leftArr, postorder, pointer-1); pointer = objLeft.pointer; }
			obj.node.left = objLeft.node;
			obj.node.right = objRight.node;
			obj.pointer = pointer;
			return obj;
		}
	}
	
	public static void main(String args[]){
		new ConsBinaryTree().buildTree(new int[]{4, 2, 5, 1}, new int[]{4, 5, 2, 1});
	}
	
}
