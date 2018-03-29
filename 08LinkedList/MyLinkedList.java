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
        return true;
    }

    public int size() {
        return length;
    }

    public String toString() {
        String returnStr = "[";
        Node current = first;
        for (int x = 0; x < length; x++) {
            returnStr += current.getValue();
            current = current.getNext();
        }
        return returnStr + "]";
    }

    public void clear() {
        first = null;
        last = first;
        length = 0;
    }
    
    public Integer get(int index) {
        return getNode(index).getValue();
    }

    public Integer set(int index, Integer newValue) {
        Node view = getNode(index);
        int value = view.getValue();
        view.setValue(newValue);
        return value;
    }

    private Node getNode(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int x = 0; x < length; x++) {
            current = current.getNext();
        }
        return current;
    }
    
    private class Node {
        private Node next, prev;
        Integer data;

        public Node(Integer value) {
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

        public Integer getValue() {
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

        public void setValue(Integer newValue) {
            data = newValue;
        }
    }
    
    public void print(String line) {
        boolean animate = true;
        if (animate) {
            System.out.print(line);
        }
    }
    
    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        System.out.println(a);
    }
}
