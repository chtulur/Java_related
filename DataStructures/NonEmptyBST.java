package DataStructures;

public class NonEmptyBST<T extends Comparable<T>> implements Tree<T> {
	T data;
	Tree<T> left;
	Tree<T> right;
	
	public NonEmptyBST(T element) {
		data = element;
		left = new EmptyBST<T>();
		right = new EmptyBST<T>();
	}
	
	public NonEmptyBST(T element, Tree<T> leftTree, Tree<T> rightTree) {
		data = element;
		left = leftTree;
		right = rightTree;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public int cardinality() {
		return 1 + left.cardinality() + right.cardinality(); //clever recursion for counting the size and not use a separate variable to keep track
	}
	
	public boolean member(T element) {
		if (data == element) {
			return true;
		} else {
			if (element.compareTo(data) < 0) {
				return left.member(element);
			} else {
				return right.member(element);
			}
		}
	}
	
	public NonEmptyBST<T> add(T element) {
		if (data == element) {
			return this;
		} else {
			if (element.compareTo(data) < 0) {
				return new NonEmptyBST<T>(data, left.add(element), right);
			} else {
				return new NonEmptyBST<T>(data,  left, right.add(element));
			}
			
		}
	}
	
	public T smallestElement() {
		return left.isEmpty() ? data : left.smallestElement();
	}
	
	public T biggestElement() {
		return right.isEmpty() ? data : right.biggestElement(); 
	}
}
