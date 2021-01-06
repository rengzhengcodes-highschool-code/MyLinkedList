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
		try {
			Node insert = new Node(value);

			if (size == 0) {
				start = end = insert; //all point towards same node instance as head + tail.
			} else {
				end.nextSet(insert);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean add(int index, String value);
	public String get(int index);
	public String set(int index, String value);
	public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
