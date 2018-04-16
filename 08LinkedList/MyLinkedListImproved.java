import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node first, last;
    private int length;

    public MyLinkedListImproved() {
        first = null;
        last = null;
        length = 0;
    }

    public boolean add(T value) {
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
    
    public T get(int index) {
        return getNode(index).getValue();
    }

    public T set(int index, T newValue) {
        Node view = getNode(index);
        T value = view.getValue();
        view.setValue(newValue);
        return value;
    }

    public int indexOf(T value) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return index; 
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }
    
    public void add(int index, T value) {
        Node addNode = new Node(value);
        if (index != 0) {
            if (index == length) {
                add(value);
                length--;
            } else {
                Node view = getNode(index);
                addNode.setPrev(view.getPrev());
                addNode.setNext(view);
                view.setPrev(addNode);
                addNode.getPrev().setNext(addNode);
            }
        } else {
            if (length == 0) {
                first = addNode;
                last = first;
            } else {
                addNode.setNext(first);
                first.setPrev(addNode);
                first = addNode;
            }
        }
        length++;
    }
    
    public boolean remove(T value) {
        Node current = first;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current == first) {
                    current.getNext().setPrev(null);
                    first = current.getNext();
                } else if (current == last) {
                    current.getPrev().setNext(null);
                    last = current.getPrev();
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                length--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    public T remove(int index) {
        Node current = getNode(index);
        if (index == 0) {
            if (length == 1) {
                first = null;
                last = null;
            } else {
                current.getNext().setPrev(null);
                first = current.getNext();
            }
        } else if (current == last) {
                current.getPrev().setNext(null);
                last = current.getPrev();
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        length--;
        return current.getValue();
    }
    
    public LLIterator iterator() {
        return new LLIterator(this, first);
    }
    
    private class LLIterator implements Iterator<T> {
        private Node current;
        private MyLinkedListImproved<T> list;
        
        public LLIterator(MyLinkedListImproved<T> list, Node first) {
            this.list = list;
            current = first;
        }
        
        public boolean hasNext() {
            return current != null;
        }
        
        public T next() {
            Node returnNode = current;
            if (hasNext()) {
                current = current.getNext();
            } else {
                throw new NoSuchElementException();
            }
            return returnNode.getValue();
        }
    }
    
    public int max() {
        if (length == 0) {
            return -1;
        } else {
            T max = first.getValue();
            int index = 0;
            int maxIndex = 0;
            for (T value : this) {
                if (value.compareTo(max) > 0) {
                    max = value;
                    maxIndex = index;
                }
                index++;
            }
            return maxIndex;
        }
    }
    
    public int min() {
        if (length == 0) {
            return -1;
        } else {
            T min = first.getValue();
            int index = 0;
            int minIndex = 0;
            for (T value : this) {
                if (value.compareTo(min) < 0) {
                    min = value;
                    minIndex = index;
                }
                index++;
            }
            return minIndex;
        }
    }
    
    public void extend(MyLinkedListImproved<T> other){
        if (length == 0) {
            first = other.first;
            last = other.last;
        } else {
            last.setNext(other.first);
            if (other.last != null) {
                last = other.last;
            }
        }
        if (other.length != 0) {
            other.first.setPrev(last);
        }
        length += other.length;
        other.clear();
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
        T data;

        public Node(T value) {
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

        public T getValue() {
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

        public void setValue(T newValue) {
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
        MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
        
        // Booleans
        Boolean addSize = false;
        Boolean get = false;
        Boolean clear = false;
        Boolean index = false;
        Boolean set = false;
        Boolean add = false;
        Boolean remove = false;
        Boolean iter = false;
        Boolean maxMin = true;
        Boolean extension = false;
        
        
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
        
        if (add) {
            Integer[] num3 = {0, 1, 2, 3, 4};
            for (Integer num : num3) {
                a.add(num);
            }
            
            a.add(0, new Integer(10));
            System.out.println(a);
            
            a.add(2, new Integer(10));
            System.out.println(a);
            
            a.add(6, new Integer(10));
            System.out.println(a);
        }
        
        if (remove) {
            Integer[] num4 = {0, 1, 2, 3, 4, 5};
            for (Integer num : num4) {
                a.add(num);
            }
            
            System.out.println("2"+a.remove(num4[2]));
            System.out.println(a);
            
            System.out.println("0"+a.remove(num4[0]));
            System.out.println(a);
            
            System.out.println("10"+a.remove(new Integer(10)));
            System.out.println(a);
            
            System.out.println("0"+a.remove(0));
            System.out.println(a);
            
            System.out.println("2"+a.remove(2));
            System.out.println(a);
            
            try {
                System.out.println("10"+a.remove(10));
                System.out.println(a);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect Index : 10");
            }
            
            try {
                System.out.println("-1"+a.remove(-1));
                System.out.println(a);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect Index : -1");
            }
        }
        
        if (iter) {
            Integer[] num5 = {0, 1, 2, 3, 4};
            
            for (Integer num : num5) {
                a.add(num);
            }
            
            System.out.println(a);
            
            for (Integer num : a) {
                System.out.println(num);
            }
        }
        
        if (maxMin) {
            Integer[] num6 = {0, 1, 2, 3, 3, 3, 3, 3, 8, 9, -1};
            
            System.out.println(a);
            
            System.out.println("Max:"+a.max());
            System.out.println("Min:"+a.min());
            
            for (Integer num : num6) {
                a.add(num);
            }
            
            System.out.println(a);
            
            System.out.println("Max:"+a.max());
            System.out.println("Min:"+a.min());
            
            
        }
        
        if (extension) {
            Integer[] num7 = {0, 1, 2, 3, 4};
            MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
            MyLinkedListImproved<Integer> c = new MyLinkedListImproved<>();
            
            for (Integer num : num7) {
                a.add(num);
                b.add(0, num);
            }
            
            System.out.println(a);
            System.out.println(b);
            a.extend(b);
            System.out.println("Extended:" + a);
            System.out.println(b);
            
            a.extend(c);
            System.out.println("Extend a filled list with an empty one");
            System.out.println(a);
            System.out.println(b);
            
            b.extend(a);
            System.out.println("Extend an empty list with a filled one");
            System.out.println(a);
            System.out.println(b);
            
            
        }
        
    }
}
