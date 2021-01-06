public class Node {
	public Node(String value) {
		/*create a constructor*/
		data = value;
	}
	private String data;
	private Node next, prev;
	//write get/set methods for all three instance variables.

	public String dataGet() {
		return data;
	}

	public String dataSet(String set) {
		String dataHolder = data;
		data = set;
		return dataHolder;
	}

	public Node nextGet() {
		return next;
	}
	public Node nextSet(Node after) {
		Node nextHolder = next;
		//temporarily stores the next link to return after "after" assignment to next.
		next = after;
		return nextHolder;
	}

	public Node prevGet() {
		return prev;
	}

	public Node prevSet(Node before) {
		Node prevHolder = prev;
		//temporarily stores the previous link to return after before assignment to prev.
		prev = before;
		return prevHolder;
	}

}
