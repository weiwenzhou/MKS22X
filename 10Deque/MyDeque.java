import java.util.*;
public class MyDeque<T> {
    private int start, end, length;
    private T[] box;
    
    public MyDeque() {
        this(10);
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        box =(T[]) new Object[initialCapacity];
        start = 0;
        end = 0;
        length = 0;
    }

    public int size() {
        return length;
    }

    public void addFirst(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (start == end) {
            resize();
        }
        start--;
        if (start < 0) {
            start+= box.length;
        }
        box[start] = value;
        length++;
    }

    public void addLast(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (start == end) {
            resize();
        }
            if (end >= box.length) {
            end-= box.length;
        }
        box[end] = value;
        end++;
        length++;
    }

    public String toString() {
        String rStr = "[";
        for (T val : box) {
            rStr += val + ",";
        }
        return rStr.substring(0, rStr.length()-1) + "]";
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newBox = (T[]) new Object[2*box.length];
        for (int x = 0; x < box.length; x++) {
            newBox[x] = box[(start+x)%box.length];
        }
        box = newBox;
        start = 0;
        end = length;
    }
    
    public T removeFirst() {
        if (start == end) {
            throw new NoSuchElementException();
        }
        T val = box[start];
        box[start] = null;
        start++;
        if (start >= box.length) {
            start -= box.length;
        }
        return val;
    }
    
    public T removeLast() {
        if (start == end) {
            throw new NoSuchElementException();
        }
        end--;
        T val = box[end];
        box[end] = null;
        if (end < 0) {
            end += box.length;
        }
        return val;
    }
    
    public T getFirst() {
        return box[start];
    }
    
    public T getLast() {
        int x = end--;
        if (x < 0) {
            x += box.length;
        }
        return box[x];
    }
    
    public static void main(String[] args) {
        MyDeque<Integer> a = new MyDeque<Integer>(2);

        int[] nums = {0,1,2,3,4};

        for (Integer num : nums) {
            a.addFirst(num);
            //a.addLast(num);
            System.out.println(a);
        }
        a.addFirst(10);
        System.out.println(a);
    }
}
