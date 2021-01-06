public class Node {
	public Node(String value) {
		/*create a constructor*/
		data = value;
	}
	private String data;
	private Node next, prev;
	//write get/set methods for all three instance variables.

	public String getData() {
		return data;
	}

	public String setData(String set) {
		String dataHolder = data;
		data = set;
		return dataHolder;
	}

	public Node getNext() {
		return next;
	}
	public Node setNext(Node after) {
		Node nextHolder = next;
		//temporarily stores the next link to return after "after" assignment to next.
		next = after;
		return nextHolder;
	}

	public Node getPrev() {
		return prev;
	}

	public Node setPrev(Node before) {
		Node prevHolder = prev;
		//temporarily stores the previous link to return after before assignment to prev.
		prev = before;
		return prevHolder;
	}

}
