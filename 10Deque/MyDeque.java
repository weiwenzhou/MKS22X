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

    
}
