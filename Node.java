/**
 * Creates Node objects in which to store String values providing methods useful for accessing specified 
 * Nodes and setting Nodes and Values in a RecursiveLinkedList.
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class Node {

	/** String value to be stored in the Node */
	private String value;
	
	/** Node to store into the linked list */
	private Node next;
	
	/**
	 * Constructs a Node object in which the next Node is null
	 * 
	 * @param v the String value to be stored in the Node
	 */
	public Node(String v)
	{
		value = v;
		next = null;
	}
	
	/**
	 * Constructs a Node object in which the next Node is set
	 * 
	 * @param v the String value to be stored in the Node
	 * @param n the next Node
	 */
	public Node(String v, Node n)
	{
		value = v;
		next = n;
	}
	
	/**
	 * Returns the next Node object
	 * 
	 * @return the next Node
	 */
	public Node getNext()
	{
		return next;
	}
	
	/**
	 * Sets the next Node
	 * 
	 * @param n the next Node
	 */
	public void setNext(Node n)
	{
		next = n;
	}
	
	/**
	 * returns the String value stored in the object
	 * 
	 * @return the String value in the Node
	 */
	public String getValue()
	{
		return value;
	}
	
	/**
	 * Sets the String value inside the Node
	 * 
	 * @param v the String value that will be set in the Node
	 */
	public void setValue(String v)
	{
		value = v;
	}
	
}
