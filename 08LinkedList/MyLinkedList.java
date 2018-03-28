public class MyLinkedList {
    private Node first, last;
    private int length;

    public MyLinkedList() {

    }

    public boolean add(int value) {

    }

    public int size() {
	
    }

    public String toString() {

    }

    public int get(int index) {

    }

    public int set(int index, int newValue) {

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
