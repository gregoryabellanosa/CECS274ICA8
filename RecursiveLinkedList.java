/**
 * Creates a RecursiveLinkedList and provides a set of methods in which to add and remove specific
 * objects to and from the list. 
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class RecursiveLinkedList {
	
	/** the first Node */
	private Node first;
	
	/**
	 * Constructs a RecursiveLinkedList object in which the first is set to null
	 */
	public RecursiveLinkedList()
	{
		first = null;
	}
	
	/**
	 * Tests whether or not the RecursiveLinkedList is empty
	 * 
	 * @return true or false depending on if the list is empty or not
	 */
	public boolean isEmpty()
	{
		return first == null;
	}
	
	/**
	 * Returns the size of the RecursiveLinkedList using the private size() method
	 * 
	 * @return the size
	 */
	public int size()
	{
		return size(first); 
	}
	
	/**
	 * Calculates the size of a RecursiveLinkedList by keeping track of how many objects are stored in it
	 * 
	 * @param list the list containing the objects
	 * @return the size of the RecursiveLinkedList
	 */
	private int size(Node list)
	{
		if (list == null) //base case
		{
			return 0;
		}
		else
		{
			return size(list.getNext()) + 1; 
		}
	}
	
	/**
	 * Returns the Node at a specified index
	 * 
	 * @param i the index specifying which index to access
	 * @return the Node at the specified index
	 */
	public Node get(int i) 
	{
		return get(i, 0, first); 
	}
	
	/**
	 * Iterates through a RecursiveLinkedList until the Node at the specified index is 
	 * found
	 * 
	 * @param i the index specifying which Node to find
	 * @param count keeps track of which Node is currently being accessed
	 * @param list the list containing the Nodes to iterate through and find the specified Node
	 * @return the Node at the specified index
	 */
	private Node get(int i, int count, Node list) 
	{
		if (list == null) 
		{
			return null;
		}
		else if (count == i) 
		{
			return list;
		}
		else
		{
			return get(i, count + 1, list.getNext());
		}
	}
	
	/**
	 * Adds a String value into a RecursiveLinkedList given a specific index
	 * 
	 * @param s the String value to add into the RecursiveLinkedList
	 * @param i the index specifying in which index of the RecursiveLinkedList to add the String value into
	 */ 
	public void add(String s, int i)
	{
		if (i < 0 || i > size())
		{
			System.out.println("Index out of bounds.");
		}
		else
		{
			add(s, first, i);
		}
	}
	
	/**
	 * Iterates through a RecursiveLinkedList until the specified index of the RecursiveLinkedList is reached
	 * and then inserts the String object at that location
	 * 
	 * @param s the String value to add into the RecursiveLinkedList
	 * @param i the index specifying in which index of the RecursiveLinkedList to add the String value into
	 * @param cur keeps track of where the iteration is currently at within the RecursiveLinkedList
	 */
	private void add(String s, Node cur, int i)
	{
		if (i == 1)
		{
			cur.setNext(new Node(s, cur.getNext()));
		}
		else
		{
			add(s, cur.getNext(), i - 1);
		}
	}
	
	/**
	 * Adds a String value to the end of a RecursiveLinkedList
	 * 
	 * @param s the string value to add into the RecursiveLinkedList
	 */
	public void add(String s) //even though this method is void, the helper function will return first 
	{
		first = add(s, first); //pass in the string that you want to add
	}
	
	/**
	 * Given a specified list, Finds the Node in which to adds the String value to the end of 
	 * the RecursiveLinkedList
	 * 
	 * @param s the string value to add into the RecursiveLinkedList 
	 * @param list the list in which to add the String value to 
	 * @return the Node that the String value was added into
	 */
	private Node add(String s, Node list) //s never changes because it is what we are adding
	{
		if (list == null) //then we've reached the end and we want to construct new node and add
		{
			return new Node(s);
		}
		else
		{
			list.setNext(add(s, list.getNext())); 
			return list;
		}
	}
	
	/**
	 * Removes a specified string from a RecursiveLinkedList
	 * 
	 * @param s the String value to remove
	 * @return the Node that contained the String value that was removed
	 */
	public Node remove(String s)
	{
		if (first == null)
		{
			return null;
		}
		else
		{
			return remove(s, first, null);
		}
	}
	
	/**
	 * Helper function that iterates through a RecursiveLinkedList until the specified String value is found and then removes
	 * it from the RecursiveLinkedList. 
	 * 
	 * @param s the String value to search for and remove
	 * @param cur keeps track of where in the RecursiveLinkedList the iteration is currently at
	 * @param prev the Node previous to the current Node
	 * @return
	 */
	private Node remove(String s, Node cur, Node prev)
	{
		if (s.equals(cur.getValue()))
		{
			if (prev == null)
			{
				first = cur.getNext();
			}
			prev.setNext(cur.getNext());
			return cur;
		}
		else if (cur.getNext() == null)
		{
			Node n = new Node(null);
			return n;
		}
		else
		{
			return remove(s, cur.getNext(), cur);
		}
	}
	
	/**
	 * Removes a Node from a RecursiveLinkedList given a specified index
	 * 
	 * @param i the index specifying which Node to remove
	 * @return the Node that was removed
	 */
	public Node remove(int i)
	{
		return remove(i, 0, first); //have to iterate through to a position
	}
	
	/**
	 * Helper function that iterates through a RecursiveLinkedList until a specified index is reached and removes the Node at that index
	 * 
	 * @param i the index specifying which Node to remove
	 * @param count keeps track of where the iteration is currently at
	 * @param list the RecursiveLinkedList containing the contents to iterate through and search for the correct Node to remove
	 * @return the Node that was removed
	 */
	private Node remove(int i, int count, Node list)
	{
		//if index doesn't exist
		if (list == null) //if true then we've gone too far and we didn't find that index so return null
		{
			return null;
		}
		else if (i == 0) //if it's at the first position, its a special case because then you have to update first
		{
			first = list.getNext(); //updates first to whatever is in the next position
			return list; 
		}
		else if (count + 1 == i) //looking at previous
		{
			Node n = list.getNext(); //store temporarily, list is where we are we are at the previous node and we want to store the node that we are removing
			if (list.getNext() != null) //for updating connections
			{
				list.setNext(list.getNext().getNext()); //call getNext() twice because we want to update our connection to go around the one that we removed
			}
			return n; 
		}
		else
		{
			return remove(i, count + 1, list.getNext());
		}
	}
	
	/**
	 * Recursively prints the contents of a RecursiveLinkedList
	 * 
	 * @return the contents of a RecursiveLinkedList
	 */
	@Override
	public String toString()
	{
		String str = "";
		Node n = first;
		return toString(str, n);
	}
	
	/**
	 * Helper function that iterates through a RecursiveLinkedList and continually appends each next String value accessed from each
	 * next Node to create one accumulative String value that will be returned
	 * 
	 * @param str the String value that will accumulate the contents of the RecursiveLinkedList
	 * @param n the current Node
	 * @return the contents of the RecursiveLinkedList
	 */
	private String toString(String s, Node n)
	{
		if (n == null)
		{
			return s;
		}
		s += n.getValue();
		return toString(s, n.getNext());
	}

}
