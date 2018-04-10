public class MyLinkedList {
    private Node first, last;
    private int length;

    public MyLinkedList() {
        first = null;
        last = null;
        length = 0;
    }

    public boolean add(Integer value) {
        Node addNode = new Node(value);
        if (length == 0) {
            first = addNode;
            last = first;
        } else {
            last.setNext(addNode);
            addNode.setPrev(last);
            last = addNode;
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
            if (x != length - 1) {
                returnStr += ", ";
            }
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

    public int indexOf(Integer value) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.getValue() == value) {
                return index; 
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }
    
    private Node getNode(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int x = 0; x < index; x++) {
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
        System.out.println();
    }
    
    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        
        // Booleans
        Boolean addSize = false;
        Boolean get = false;
        Boolean clear = false;
        Boolean index = false;
        Boolean set = false;
        Boolean add = true;
        
        Integer[] nums = {0,1,2,3,4};
        if (addSize) {
            System.out.println(a);
            for (Integer num : nums) {
                a.add(num);
                System.out.println(a);
                System.out.println(a.size());
            }
            System.out.println(a);
        }
        
        if (get) {
            for (Integer num : nums) {
                a.add(num);
            }
            System.out.println(a);
            
            for (int num : nums) {
                System.out.println(a.get(num));
            }
            System.out.println(a);
            
            try {
                a.get(-1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect Index : -1");
            }
            
            try {
                a.get(10);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect Index : 10");
            }
        }
        
        if (clear) {
            System.out.println(a);
            a.add(1);
            a.add(8);
            a.add(3);
            a.add(5);
            System.out.println(a);
            a.clear();
            System.out.println(a);
        }
        
        if (index) {
            Integer[] num1 = {7, 1, 6, 8, 0, 6, 7};
            for (Integer num : num1) {
                a.add(num);
            }
            for (int num : num1) {
                System.out.println(a.indexOf(num));
            }
        }
        
        if (set) {
            Integer[] num2 = {0, 1, 2, 3, 4, 5};
            for (Integer num : num2) {
                a.add(num);
            }
            System.out.println(a);
            
            System.out.println(a.set(2, 10));
            System.out.println(a);
            System.out.println(a.set(4, 10));
            System.out.println(a);
            try {
                a.set(-1, 10);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect Index : -1");
            }
            try {
                a.set(10, 10);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect Index : 10");
            }
        }
    }
}
