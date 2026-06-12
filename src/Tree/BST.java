package Tree;

public class BST {
	
	class node{
		int data;
		node left, right;
		node(int d){
			data = d;
			left=null;
			right=null;
		}
	}
	
	class BinarySearchTree{
		node root;
		node insert(node root, int data) {
			if(root==null) {
				return new node(data);
			}
			if(data<root.data) {
				root.left=insert(root.left, data);
			}
			else if(data>root.data) {
				root.right=insert(root.right, data);
			}
			return root;
		}
		
		node delete(node root, int key) {
			if(root==null) return null;
			if(key<root.data) {
				root.left=delete(root.left, key);
			}
			else if(key>root.data) {
				root.right=delete(root.right, key);
			}
			else {
				if(root.left==null&&root.right==null) {
					return null;
				}
				if(root.left==null) {
					return root.right;
				}
				if(root.right==null) {
					return root.left;
				}
				int  min = findMin(root.right);
				root.data=min;
				root.right=delete(root.right, min);
			}
			return root;
		}
			int findMin(node root) {
				while(root.left!=null) {
					root=root.left;
				}
				return root.data;
			}
			
	void inOrder(node root) {
		if(root==null)
			return; 
		inOrder(root.left); 
		System.out.print(root.data+" "); 
		inOrder(root.right);
	}
}


	public static void main(String[] args) {
		BST bst = new BST();
        BinarySearchTree tree = bst.new BinarySearchTree();
		tree.root=tree.insert(tree.root, 15);
		tree.insert(tree.root, 4);
		tree.insert(tree.root, 5);
		tree.insert(tree.root, 10);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 7);
		
		tree.inOrder(tree.root);
		System.out.println();
		
		tree.root = tree.delete(tree.root, 15);
		
		tree.inOrder(tree.root);
		System.out.println();

	}

}
