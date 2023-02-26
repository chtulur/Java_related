package DataStructures;

public interface Tree<T extends Comparable<T>> {
	public boolean isEmpty();
	public int cardinality(); //size of tree
	public boolean member(T element);
	public NonEmptyBST<T> add(T element);
	public T smallestElement();
	public T biggestElement();
}
