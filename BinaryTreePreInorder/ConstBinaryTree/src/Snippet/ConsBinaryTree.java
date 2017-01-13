package Snippet;

class wrapper{
	TreeNode node;
	int pointer;
}

public class ConsBinaryTree {
	 
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	     TreeNode root = null;
	     root = buildTree(preorder, inorder, 0).node;
	     return root;
	}
	
	//Integer value of the pointer for the preorder array
	private wrapper buildTree(int[] preorder, int[] inorder, int pointer){
		if(preorder.length == 0 || inorder.length == 0){ return null; }
		else{
			TreeNode newNode = new TreeNode(preorder[pointer]);
			wrapper obj = new wrapper();
			obj.node = newNode;
			int inorderBreak = 0;
			for(inorderBreak=0;inorderBreak<inorder.length;inorderBreak++){
				if(inorder[inorderBreak] == preorder[pointer]){break;}
			}
			int[] leftArr = new int[inorderBreak];
			int[] rightArr = new int[inorder.length-inorderBreak-1];
			for(int i=0;i<inorderBreak;i++){	leftArr[i] = inorder[i];	}
			int rightCount = 0;
			for(int i=inorderBreak+1;i<inorder.length;i++){ rightArr[rightCount] = inorder[i];++rightCount; }
			wrapper objLeft = new wrapper();
			wrapper objRight = new wrapper();
			if(leftArr.length !=0){ objLeft = buildTree(preorder, leftArr,  pointer+1); pointer = objLeft.pointer;}
			if(rightArr.length !=0){ objRight = buildTree(preorder, rightArr,  pointer+1 ); pointer = objRight.pointer; }
			obj.node.left = objLeft.node;
			obj.node.right = objRight.node;
			obj.pointer = pointer;
			return obj;
		}
	}
	
	
	public static void main(String [] args){
		new ConsBinaryTree().buildTree(new int[]{1,2,4,5,3,7}, new int[]{4,2,5,1,3,7});
	}
}
