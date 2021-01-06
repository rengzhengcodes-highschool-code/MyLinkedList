public class MyLinkedList{
	private int size;
	private Node start,end;
	public MyLinkedList() {
		/*create a constructor*/
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean add(String value) {
		Node insert = new Node(value);

		if (size == 0) {
			start = end = insert; //all point towards same node instance as head + tail.
		} else {
			end.setNext(insert);
		}

		return true;
	}

	private Node seek(int index) {
		Node nodeAtIndex = start;

		for (int i = 1; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.getNext();
		}

		return nodeAtIndex;
	}

	public boolean add(int index, String value) {
		Node insert = new Node(value);

		if (index == 0) {
			if (size == 0) {
				start = end = insert;
			} else {
				insert.setNext(start);
				start = insert;
			}
		} else {
			if (index < 0 || index > size)  {
				throw new IndexOutOfBoundsException("Index " + index + " is out of range from 0 to " + size);
			} else {

			}
		}
	}
	public String get(int index);
	public String set(int index, String value);
	public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
