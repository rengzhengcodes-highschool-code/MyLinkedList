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
			end = insert;
		}

		size++;
		return true;
	}

	private Node seek(int index) {
		if (index < 0 || index > size)  {
			throw new IndexOutOfBoundsException("Index " + index + " is out of range from 0 to " + size);
		}
		
		Node nodeAtIndex = start; //node initialized with value from node at index 0.

		for (int i = 1; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.getNext(); ///iterates through one node at a time across the index.
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
			} else if (index == size) {
				end.setNext(insert);
				end = insert;
			} else {
				Node before = seek(index - 1);
				before.setNext(insert);
			}
		}

		size++;
		return true;
	}

	public String get(int index) {
		Node nodeAtIndex = seek(index);
		return nodeAtIndex.getData();
	}

	public String set(int index, String value)  {
		Node nodeAtIndex = seek(index);
		return nodeAtIndex.setData(value);
	}

	public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
