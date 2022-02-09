// Taehyeon Lee
// CS 143
// Core Topic: Binary Search Tree


// This class stores and manipulates a binary search tree
// of objects E. E must implement the Comparable<E> interface.

public class BST <E extends Comparable <E>> {
	private TreeNode<E> overallRoot;

	public BST() {
		overallRoot = null;
	}

	// value added to tree so as to preserve the binary search tree
   // order, duplicate values allowed
	public void add(E value) {
		if (overallRoot == null) {
			overallRoot = new TreeNode<>(value);
		} else {
			add(overallRoot, value);
		}
	}

	private TreeNode<E> add(TreeNode<E> root, E value) {
		if (root == null) {
			return new TreeNode<>(value);
		} else if (root.data.compareTo(value) >= 0) {
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
		}

		return root;
	}

	// returns false if find value is not in BST, otherwise returns true
	public boolean contains(E find) {
		return contains(overallRoot, find);
	}

	private boolean contains(TreeNode<E> root, E find) {
		if (root == null) {
			return false;
		} else if (root.data.compareTo(find) == 0) {
			return true;
		} else if (root.data.compareTo(find) > 0) {
         return contains(root.left, find);
      }else {
			return contains(root.right, find);
		}
	}

   // Returns the largest value from this root + it's subtree
   public E max() {
      return findMax(overallRoot);
   }
	// this method returns largest value from the tree  
	private E findMax(TreeNode<E> root) {
   
   // this travers farthest right root of the tree(since farthest store largest value)
      while(root.right != null){
         root = root.right;
      }
      // root.right will be null
		return root.data;
	}

	// prints the data of the tree in sorted order
	public void print() {
      System.out.print("In order = ");
		printInorder(overallRoot);
      System.out.println();
	}

	private void printInorder(TreeNode<E> root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

   
   // returns tree if the tree is maintaining order (lower values on left, higher values on right)
   public boolean isBST() {
      return isBST(overallRoot);
   }
   
   private boolean isBST(TreeNode<E> root) {
   // base case that 
      if (root == null) {
         return true;
      } else {
      // if the left root is null return true otherwise check and compare root and root.left
      // if compareTo root.data and root.left is greater or equal to 0 then return true.
         boolean leftCheck = root.left == null ? true : root.data.compareTo(root.left.data) >= 0;
      // if the right root is null return true otherwise check and compare root and root.right
      // if compareTo root.data and root.right is less than 0 then return true.
         boolean rightCheck = root.right == null ? true : root.data.compareTo(root.right.data) < 0;
      // recurse all left side and right side and retrun all leftcheck, rightcheck and both side
         return leftCheck && rightCheck && isBST(root.left) && isBST(root.right);
      }
   }
   
   // Returns if the tree is full or not (each node in the tree has 0 or 2 children)
   public boolean isFull() {
      return isFull(overallRoot);
   }
   
   private boolean isFull(TreeNode<E> root) {
     if (root == null){
         return true;
     } else if(root.left == null && root.right == null){ // 0 children definitely
         return true;
     } else if (root.left == null || root.right == null){ // 1 children definitely
         return false;
     } else {
         return isFull(root.left) && isFull(root.right); // could have 2 children
     }
     
   }
   
   // ========== MAIN ==========
   public static void main(String[] args) {
      int[] numbers = {4, 2, 7, 1, 3, 6, 8}; 
      int[] numbers2 = {7, 4, 2, 3, 8, 9};
      int[] numbers3 = {5, 4, 7, 3, 9, 6};
      int[] numbers4 = {20, 5, 25, 3, 7, 22, 28, 1, 4, 6, 8, 24, 27, 30};
      int[] numbers5 = {10, 5, 8, 20, 15, 2, 9, 4};
      
      BST<Integer> bst = new BST<>();
      for(int n : numbers5) 
         bst.add(n);
      
      System.out.println("==== Tree Info ==== ");
      bst.print();
      System.out.println("The largest value in the tree is " + bst.max() + ".");
      System.out.println("isFull? " + bst.isFull());
      System.out.println("isBST? " + bst.isBST());
      System.out.println("contains 3? " + bst.contains(3));
      
   }

} //end of BST