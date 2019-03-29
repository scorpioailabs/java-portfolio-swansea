/** Node in a singly linked list. */
public class Node {
  /** Pointer to the next node in the
      list. */
  private Node next = null;

  /** Data associated with the node. */
  private Object data;

  /** Get/Set the pointer to the next node
	   in the list. */
  public Node getNext(){
    return next;
  }
  public void setNext(Node newNode){
	next = newNode;
  }
	
  /** Get/Set the node's data. */
  public void setData(Object newData){
    data = newData;
  }
  public Object getData(){
    return data;
  }

  /** Constructor, initializes
      node's data. */
  public Node(Object newData){
    data = newData;
  }
  
  /** Constructor, initializes
      node's data. */
  public Node(Object newData, Node next){
    data = newData;
	this.setNext(next);
  }
}
