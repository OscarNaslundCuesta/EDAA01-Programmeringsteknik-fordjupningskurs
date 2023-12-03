package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
		
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
        this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (this.root == null) {
			this.root = new BinaryNode<E>(x);
			size++;
			return true;
		} 
		
		return add_h(x, root);
	}
	
	private boolean add_h(E x, BinaryNode<E> node) {
		int cmp = comparator.compare(x, node.element);
		
		if (cmp < 0) {
			if (node.left == null) {		// x < node.elemet
				node.left = new BinaryNode<E>(x);
				size++;
				return true;
			} else {
				return add_h(x, node.left);
			}
		} else if (cmp > 0) { 				// x > node.elemet
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				size++;
				return true;		
			} else {						// x == node.elemet
				return add_h(x, node.right);
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height_help(0, root);
	}
	
	private int height_help(int current_height, BinaryNode<E> node) {
		
		if (node == null) {
			return current_height;
		}
		
		int left_h = height_help(current_height + 1, node.left);
		int right_h = height_help(current_height + 1, node.right);
		
		return Math.max(left_h, right_h);
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print_h(root);
	}
	
	private void print_h(BinaryNode<E> node) {
		if (node == null) {
			return;
		}
		
		print_h(node.left);
		System.out.println(node.element);
		print_h(node.right);
	}

	/**
	* Builds a balanced tree from the elements in the tree.
	*/
	public void rebuild() {
	    ArrayList<E> list = new ArrayList<>();
		toArray(root, list);
		
		this.clear();
		this.root = buildTree(list, 0, list.size() - 1);
	}
	
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n == null) {
	        return;  
	    }

	    toArray(n.left, sorted);  
	    sorted.add(n.element);      
	    toArray(n.right, sorted); 
	}
	
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (first > last) {
			return null;
		}
		
		int mid = first + (last - first) / 2;
		BinaryNode<E> midNode = new BinaryNode<>(sorted.get(mid));
		
		midNode.left = buildTree(sorted, first, mid - 1);
		midNode.right = buildTree(sorted, mid + 1, last);
		
		return midNode;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
