package dataStructure;

public class BinaraySearchTree01 {
	static private class Tree{
		static private class Node{
			int data;
			Node left;
			Node right;
			Node (int data){
				this.data = data;
			}
		}
		
		Node root;
		public void makeTree(int[] a) {
			root = makeTreeR(a, 0, a.length - 1);
		}
		
		public Node makeTreeR(int[] a, int start, int end) {
			if(start > end) return null;
			int mid = (start + end) / 2;
			Node node = new Node(a[mid]);
			node.left = makeTreeR(a, start, mid - 1);
			node.right = makeTreeR(a, mid + 1, end);
			return node;
		}
		
		public void searchBTree (Node n, int find) {
			if(find < n.data) {
				System.out.println("data is smaller than " + n.data);
				searchBTree(n.left, find);
			}else if(find > n.data) {
				System.out.println("data is bigger than " + n.data);				
				searchBTree(n.right, find);
			}else {
				System.out.println("found");
			}
		}	
	}
	
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i  = 0 ; i < a.length; i++) {
			a[i] = i;
		}
		Tree t  = new Tree();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
		
	}
}
