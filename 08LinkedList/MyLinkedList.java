public class MyLinkedList {
    private Node first, last;
    private int length;

    public MyLinkedList() {
	first = null;
	last = null;
	length = 0;
    }

    public boolean add(int value) {
	if (length == 0) {
	    first = new Node(value);
	    last = first;
	} else {
	    last.setNext(new Node(value));
	}
	length += 1;
    }

    public int size() {
	return length;
    }

    public String toString() {
	String returnStr = "[";
	Node current = first;
	for (int x = 0; x < length; x++) {
	    returnStr += current.getValue();
	    current = current.nextNode();
	}
	return returnStr + "]";
    }

    public int get(int index) {
	return getNode(index).getValue();
    }

    public int set(int index, int newValue) {
	Node view = getNode(index);
	int value = view.getValue();
	view.setValue(newValue);
	return value;
    }

    private Node getNode(int index) {
	if (index >= length) {
	    throw new IndexOutofBoundsException();
	}
	Node current = first;
	for (int x = 0; x < length; x++) {
	    returnStr += current.getValue();
	    current = current.nextNode();
	}
	return current;
    }
    
    private class Node {
	private Node next, prev;
	int data;

	public Node(int value) {
	    next = null;
	    prev = null;
	    data = value;
	}

	public Node getNext() {
	    return next;
	}

	public Node getPrev() {
	    return prev;
	}

	public int getValue() {
	    return data;
	}

	public String toString() {
	    return ""+data;
	}

	public void setNext(Node nextNode) {
	    next = nextNode;
	}

	public void setPrev(Node prevNode) {
	    prev = prevNode;
	}

	public void setValue(int newValue) {
	    data = newValue;
	}
    }
}
