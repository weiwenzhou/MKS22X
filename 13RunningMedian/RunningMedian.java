import java.util.*;
public class RunningMedian {
    private int size;
    private MyHeap<Double> left, right;
    
    public RunningMedian() {
        left = new MyHeap<Double>();
        right = new MyHeap<Double>(false);
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public void add(Double val) {
        if (size == 0) {
            left.add(val);
        } else {
            if (val < left.peek()) {
                left.add(val);
            } else {
                right.add(val);
            }
        }
        if (Math.abs(left.size() - right.size()) > 1) {
            if (left.size() > right.size() ) {
                right.add(left.remove());
            } else {
                left.add(right.remove());
            }
        }
        size++;
    }
    
    public Double getMedian() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek())/2;
            }
            if (left.size() > right.size()) {
                return left.peek();
            }
            return right.peek();
        }
    }
    
    public static void main(String[] args) {
        RunningMedian a = new RunningMedian();
        
        a.add(10.0);
        System.out.println(a.getMedian());
        a.add(4.0);
        System.out.println(a.getMedian());
        a.add(9.0);
        System.out.println(a.getMedian());
        a.add(1.0);
        System.out.println(a.getMedian());
        a.add(2.0);
        System.out.println(a.getMedian());
        a.add(7.0);
        System.out.println(a.getMedian());
    }
}