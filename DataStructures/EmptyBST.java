package DataStructures;

import java.util.NoSuchElementException;

public class EmptyBST<T extends Comparable<T>> implements Tree<T> {
	public boolean isEmpty() {
		return true;
	}
	
	public int cardinality() {
		return 0;
	}
	
	public boolean member(T element) {
		return false;
	}
	
	public NonEmptyBST<T> add(T element) {
		return new NonEmptyBST<T>(element);
	}
	
	public T smallestElement() {
		throw new NoSuchElementException("Tree is empty");
	}
	
	public T biggestElement() {
		throw new NoSuchElementException("Tree is empty");
	}
	
}
