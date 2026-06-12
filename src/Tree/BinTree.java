package Tree;
import java.util.*;

class Node{ //creation of nodes and data 
	int data;
	Node left, right;
	Node(int d){
		data = d;
		left=null;
		right=null;
	}
}

class Pair {
	Node node;
	int hd;

	Pair(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}

class BinaryTree{
	Node root;
	void insert(int d) {
		Node newNode= new Node(d);
		if(root==null) { //if tree is empty 
			root=newNode;
			return;
		}
		Queue<Node> q = new LinkedList<>(); //level order traversal 
		q.add(root);
		while(!q.isEmpty()) { //until empty position is found
			Node temp = q.poll(); //node level i.e check each left for left or right vacancy
			
			if(temp.left==null) {
				temp.left=newNode; //added to left
				return;
			}
			else {
				q.add(temp.left); //added to queue for checking
			}
			
			if(temp.right==null) {
				temp.right=newNode;
				return;
			}
			else {
				q.add(temp.right);
			}
		}
	}
	
//-------------------------------------------------TRAVERSAL METHODS------------------------------------------------------------------
	
	void inOrder(Node root) {
		if(root==null)
			return; //return back to previous node
		inOrder(root.left); //go to left node
		System.out.print(root.data+" "); //print only if returned from the right
		inOrder(root.right);
	}
	
	void preOrder(Node root) {
		if(root==null)
			return; 
		System.out.print(root.data+" "); 
		preOrder(root.left); 
		preOrder(root.right);
	}
	
	void postOrder(Node root) {
		if(root==null)
			return; 
		postOrder(root.left); 
		postOrder(root.right);
		System.out.print(root.data+" "); 
	}
	
	void levelOrder(Node root) {
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
	}

//-----------------------------------------------------VIEW TYPES---------------------------------------------------------------------
	
		void leftView(Node root){
			if(root == null)
				return;
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()){
				int size = q.size();
				for(int i = 0; i < size; i++){
					Node temp = q.poll();
					if(i == 0){
						System.out.print(temp.data + " ");
					}
					if(temp.left != null){
						q.add(temp.left);
					}
					if(temp.right != null){
						q.add(temp.right);
					}
				}
			}
		}

		void rightView(Node root){
			if(root == null)
				return;
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()){
				int size = q.size();

				for(int i = 0; i < size; i++){
					Node temp = q.poll();
					if(i == size - 1){
						System.out.print(temp.data + " ");
					}
					if(temp.left != null){
						q.add(temp.left);
					}
					if(temp.right != null){
						q.add(temp.right);
					}
				}
			}
		}
			
			void horizontalView(Node root) {
				if(root==null)
					return;
				Queue<Node> q = new LinkedList<>();
				q.add(root);
				while(!q.isEmpty()) {
					Node temp = q.poll();
					System.out.print(temp.data+" ");
					if(temp.left!=null) {
						q.add(temp.left);
					}
					if(temp.right!=null) {
						q.add(temp.right);
					}
				}
			}
			
			void verticalView(Node root) {
				if(root == null) {
					return;
				}
				Queue<Pair> q = new LinkedList<>();
				TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
				q.offer(new Pair(root, 0));
				while(!q.isEmpty()) {
					Pair current = q.poll();
					Node node = current.node;
					int hd = current.hd;
					if(!map.containsKey(hd)) {
						map.put(hd, new ArrayList<>());
					}
					map.get(hd).add(node.data);
					if(node.left != null) {
						q.offer(new Pair(node.left, hd - 1));
					}
					if(node.right != null) {
						q.offer(new Pair(node.right, hd + 1));
					}
				}
				for(ArrayList<Integer> list : map.values()) {
					for(int value : list) {
						System.out.print(value + " ");
					}
				}
			}
			
			void topView(Node root) {
				if(root == null) {
					return;
				}
				Queue<Pair> q = new LinkedList<>();
				TreeMap<Integer, Integer> map = new TreeMap<>();
				q.offer(new Pair(root, 0));
				while(!q.isEmpty()) {
					Pair current = q.poll();
					Node node = current.node;
					int hd = current.hd;
					if(!map.containsKey(hd)) {
						map.put(hd, node.data);
					}
					if(node.left != null) {
						q.offer(new Pair(node.left, hd - 1));
					}
					if(node.right != null) {
						q.offer(new Pair(node.right, hd + 1));
					}
				}
				for(int value : map.values()) {
					System.out.print(value+" ");
				}
			}
			
			void bottomView(Node root) {
				if(root == null) {
					return;
				}
				Queue<Pair> q = new LinkedList<>();
				TreeMap<Integer, Integer> map = new TreeMap<>();
				q.offer(new Pair(root, 0));
				while(!q.isEmpty()) {
					Pair current = q.poll();
					Node node = current.node;
					int hd = current.hd;
					map.put(hd, node.data);
					if(node.left != null) {
						q.offer(new Pair(node.left, hd - 1));
					}
					if(node.right != null) {
						q.offer(new Pair(node.right, hd + 1));
					}
				}
				for(int value : map.values()) {
					System.out.print(value+" ");
				}
			}
}


//--------------------------------------------------MAIN FUNCTION--------------------------------------------------------------


public class BinTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(1); //apply function however cannot be viewed unless a traversal method is implemented 
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		
		System.out.println("InOrder Traversal:");
		tree.inOrder(tree.root);
		System.out.println();
		
		System.out.println("PreOrder Traversal:");
		tree.preOrder(tree.root);
		System.out.println();
		
		System.out.println("PostOrder Traversal:");
		tree.postOrder(tree.root);
		System.out.println();
		
		System.out.println("LevelOrder Traversal:");
		tree.levelOrder(tree.root);
		System.out.println();
		
		System.out.println("Left View:");
		tree.leftView(tree.root);
		System.out.println();

		System.out.println("Right View:");
		tree.rightView(tree.root);
		System.out.println();
		
		System.out.println("Horizontal View:");
		tree.horizontalView(tree.root);
		System.out.println();
		
		System.out.println("Vertical View:");
		tree.verticalView(tree.root);
		System.out.println();
		
		System.out.println("Top View:");
		tree.topView(tree.root);
		System.out.println();
		
		System.out.println("Bottom View:");
		tree.bottomView(tree.root);
	}
}
