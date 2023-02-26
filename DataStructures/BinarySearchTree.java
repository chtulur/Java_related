package DataStructures;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T>{

	public static void main(String[] args) {
		Tree<Integer> tree = new EmptyBST<Integer>();
		EmptyBST<Integer> tree2 = new EmptyBST<>();
		
		try {
			tree.smallestElement();
		} catch(NoSuchElementException e) {
			System.out.println("Tree is still empty");
		}
		
		System.out.println("Does the empty tree have number 1? " + tree.member(1));
		
		int[] arr = {7, 3, 5, 2, 1, 4, 6 };
		
		for (int i: arr) {
			tree = tree.add(i);
		}
		
		System.out.println("Is the tree empty? " + tree.isEmpty());
		System.out.println("Is number 8 in the tree? " + tree.member(8));
		System.out.println("Is number 3 in the tree? " + tree.member(3));
		System.out.println("How many numbers are in the tree? " + tree.cardinality());
		System.out.println("The smallest element is: " + tree.smallestElement());
		System.out.println("The biggest element is: " + tree.biggestElement());
		
		//Let's use breadth-first-search to find number 5
		System.out.println("Find specific number (5) in the tree with breadthFirstSearch: " + breadthFirstSearch(tree, 5));
		//Let's use breadth-first-search to find number 5
		System.out.println("Find specific number (5) in the tree with depthFirstSearch: " + depthFirstSearch(tree, 4));
	}
	
	public static boolean breadthFirstSearch(Tree<Integer> tree, int searchValue) {
		Queue<Tree<Integer>> q = new LinkedList<>();
		q.offer(tree);
		
		while(!q.isEmpty()) {
			Tree<Integer> current = q.poll();
			
			if (!current.isEmpty()) {
				if (current instanceof NonEmptyBST) {
					NonEmptyBST<Integer> nonEmpty = (NonEmptyBST<Integer>) current;
					if (nonEmpty.data == searchValue) {
						return true;
					} else {
						q.offer(nonEmpty.left);
						q.offer(nonEmpty.right);
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean depthFirstSearch(Tree<Integer> tree, int searchValue) {
		Stack<Tree<Integer>> stack = new Stack<>();
		stack.push(tree);
		
		while(!stack.isEmpty()) {
			Tree<Integer> current = stack.pop();
			if (!current.isEmpty()) {
				if (current instanceof NonEmptyBST<Integer>) {
					NonEmptyBST<Integer> nonEmpty = (NonEmptyBST<Integer>) current;
					
					if (nonEmpty.data == searchValue) {
						return true;
					} else {
						stack.push(nonEmpty.left);
						stack.push(nonEmpty.right);
					}
				}
			}
		}
		
		return false;
	}
	
}
