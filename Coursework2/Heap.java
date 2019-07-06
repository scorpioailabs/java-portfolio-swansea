// Heap using Binary Heap using Array Implementation
public class Heap<Object extends Comparable<Object> {
	//-----Initiliasing the indices leftChild and rightChild in heap-----
	private int size;
	private Object[] heap; // The heap array
	public int leftChild(int i) {
		return 2 * i + 1;
	}
	public int rightChild(int i) {
		return 2 * i + 2;
	}
	private int size() { return n; } // Number of elements in heap
	private AnyType[] heap;     // The heap array

}