public class MyDeque<T> {
    private int start, end, length;
    private T[] box;
    
    public MyDeque() {
        this(10);
    }
    
    public MyDeque(int initialCapacity) {
        @SuppressWarnings("unchecked") T[] boxtemp = new T[initialCapacity];
        start = 0;
        end = 0;
        length = 0;
    }
    
}