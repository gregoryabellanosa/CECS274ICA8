/**
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class Practice {

	public static void main(String[] args) {
		RecursiveLinkedList list = new RecursiveLinkedList();
		list.add("A");
		list.add("B");
		list.add("Greg");
		Node rem = list.remove("A");
		System.out.println(list);
		System.out.println(rem);
		
		

	}

}
