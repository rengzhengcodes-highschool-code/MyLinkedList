public class MyLinkedList{
	private int size;
	private Node start,end;
	private static boolean DEBUG = false;

	public static void debug(String message) {
		if (DEBUG) System.out.println(message);
	}

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
			insert.setPrev(end);
			end = insert;
		}

		size++;
		return true;
	}

	private Node seek(int index) {
		if (index < 0 || index >= size)  {
			throw new IndexOutOfBoundsException("Index " + index + " is out of range from 0 to " + size);
		}

		Node nodeAtIndex;

		if (index <= size / 2) {
			debug("0");
			nodeAtIndex = start;

			for (int i = 1; i <= index; i++) {
				debug(i + "");
				debug(this.toString());
				nodeAtIndex = nodeAtIndex.getNext(); ///iterates through one node at a time across the index.
			}
		} else {
			nodeAtIndex = end;

			for (int i = size - 2; i >= index; i--) {
				nodeAtIndex = nodeAtIndex.getPrev(); ///iterates through one node at a time across the index.
			}
		}

		return nodeAtIndex;
	}

	public void add(int index, String value) {
		Node insert = new Node(value);

		if (index == 0) {
			if (size == 0) {
				start = end = insert;
			} else {
				insert.setNext(start);
				start.setPrev(insert);
				start = insert;
			}
		} else {
			if (index < 0 || index > size)  {
				throw new IndexOutOfBoundsException("Index " + index + " is out of range from 0 to " + size);
			} else if (index == size) {
				end.setNext(insert);
				insert.setPrev(end);
				end = insert;
			} else {
				Node at = seek(index);
				insert.setPrev(at.setPrev(insert));
				insert.getPrev().setNext(insert);
				insert.setNext(at);
			}
		}

		size++;
	}

	public String get(int index) {
		Node nodeAtIndex = seek(index);
		return nodeAtIndex.getData();
	}

	public String set(int index, String value) {
		Node nodeAtIndex = seek(index);
		return nodeAtIndex.setData(value);
	}

	public String remove(int index) {
		Node trash = seek(index);

		if (size == 1) {
			start = end = null;
		} else if (index == 0) {
			trash.getNext().setPrev(null);
			start = trash.getNext();
		} else if (index == size - 1) {
			trash.getPrev().setNext(null);
			end = trash.getNext();
		} else {
			trash.getPrev().setNext(trash.getNext());
			trash.getNext().setPrev(trash.getPrev());
		}

		if (size == 2) { //checks if we're only down to 1 value.

		}

		size--;
		return trash.getData();
	}

	public void extend(MyLinkedList other) {
		other.start.setPrev(this.end);
		this.end.setNext(other.start);
	}

	public String toString() {
		Node currentNode = start;

		String output = "[" + currentNode.getData();

		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			output += ", " + currentNode.getData();
		}

		output += "]";
		return output;
	}

	public String toStringReversed() {
		Node currentNode = end;

		String output = "[" + currentNode.getData();

		while (currentNode.getPrev() != null) {
			currentNode = currentNode.getPrev();
			output += ", " + currentNode.getData();
		}

		output += "]";
		return output;
	}
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
