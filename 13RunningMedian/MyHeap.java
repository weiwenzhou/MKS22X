public class MyHeap<T extends Comparable<T>> {
    private T[] box;
    private int size;
    private boolean setting;
    
    public MyHeap() {
        this(true);
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean mode) {
        box = (T[]) new Comparable[10];
        size = 0;
        setting = mode;
    }
    
    public void add(T s) {
        if (size == box.length) {
            resize();
        }
        box[size] = s;
        int current = size;
        size++;
        if (setting) {
            while (current != 0 && box[(current-1)/2].compareTo(box[current]) < 0) {
                swap(current, (current-1)/2);
                current = (current-1)/2;
            }
        } else {
            while (current != 0 && box[(current-1)/2].compareTo(box[current]) > 0) {
                swap(current, (current-1)/2);
                current = (current-1)/2;
            }
        }    
    }
    
    public T remove() {
        T str = box[0];
        box[0] = null;
        swap(0, size-1);
        size--;
        int current = 0;
        while (  (2 * current + 1 < size && box[2*current+1].compareTo(box[current]) < 0) ||
        (2 * current + 2 < size && box[2*current+2].compareTo(box[current]) < 0) ) {
            if (2 * current + 2 < size) {
                if ( box[2*current+1].compareTo(box[2*current+2]) < 0) {
                    swap(current, 2*current+2);
                    current = 2*current+2;
                } else {
                    swap(current, 2*current+1);
                    current = 2*current+1;
                }
            } else {
                swap(current, 2*current+1);
                current = 2*current+1;
            }
        }
        return str;
    }
    
    public T peek() {
        return box[0];
    }
    
    public int size() {
        return size;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] pandora = (T[]) new Comparable[box.length*2];
        for (int x = 0; x < size; x++) {
            pandora[x] = box[x];
        }
        box = pandora;
    }
    
    private void swap(int current, int newIndex) {
        T temp = box[current];
        box[current] = box[newIndex];
        box[newIndex] = temp;
    }

    public String toString() {
        String str = "[";
        for (int x = 0; x < size; x++) {
            str += box[x] + ", ";
        }
        return str.substring(0, str.length()-2) + "]";
    }
    
    public static void main (String[] args) {
        MyHeap<Integer> a = new MyHeap<Integer>();

        a.add(10);
        System.out.println(a);
        a.add(4);
        System.out.println(a);
        a.add(9);
        System.out.println(a);
        a.add(1);
        System.out.println(a);
        a.add(2);
        System.out.println(a);
        a.add(7);
        System.out.println(a);
        
        System.out.println(a.remove());
        System.out.println(a);
        a.add(20);
        System.out.println(a);
        System.out.println(a.remove());
        System.out.println(a);
        
    }
}
