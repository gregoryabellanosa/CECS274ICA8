/**
 * Tests the methods of a RecursiveLinkedList
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com> 
 *
 */
public class RecursiveLinkedListMain {

	public static void main(String[] args) {
		RecursiveLinkedList list = new RecursiveLinkedList(); 
		list.add("A");
		list.add("B");
		list.add("D");
		list.add("C", 2);
		list.add("E", 4);
		list.add("G", 6); //this should be invalid
		System.out.println( list );
		System.out.println( list.remove(1).getValue() ); 
		System.out.println( list.remove("D").getValue() ); 
		System.out.println( list.remove("G").getValue() );
		System.out.println( list.size() );
		System.out.println( list );

	}

}
