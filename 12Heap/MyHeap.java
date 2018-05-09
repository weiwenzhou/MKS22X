import java.util.Arrays;
public class MyHeap {
    private String[] box;
    private int size;
    private boolean setting;
    
    public MyHeap() {
        this(true);
    }
    
    public MyHeap(boolean mode) {
        box = new String[10];
        size = 0;
        setting = mode;
    }
    
    public void add(String s) {
        if (size == box.length) {
            resize();
        }
        box[size] = s;
        int current = size;
	size++;
        while (current != 0) {
            boolean pass = box[current].compareTo(box[(current-1)/2]) > 0;
            if (setting) {
                if (pass) {
                    swap(current, (current-1)/2 );
                    current = (current-1)/2;
                } else {
		    current = 0;
		}
            } else {
                if (!pass) {
                    swap(current, (current-1)/2 );
                    current = (current-1)/2;
                } else {
		    current = 0;
		}
            }
        }
    }
    
    public String remove() {
	box[0] = null;
	swap(0, size-1);
	return "";
    }
    
    public String peek() {
        return box[0];
    }
    
    public int size() {
        return size;
    }
    
    private void resize() {
        String[] pandora = new String[box.length*2];
        for (int x = 0; x < size; x++) {
            pandora[x] = box[x];
        }
        box = pandora;
    }
    
    private void swap(int current, int newIndex) {
        String temp = box[current];
        box[current] = box[newIndex];
        box[newIndex] = box[current];
    }

    public String toString() {
	return Arrays.toString(box);
    }
    
    public static void main (String[] args) {
	MyHeap a = new MyHeap();

	a.add("c");
	System.out.println(a);
	a.add("b");
	System.out.println(a);
	a.add("e");
	System.out.println(a);
	
    }
}
