import java.util.Arrays;
public class Quick {
    public static int partition(int[] data, int start, int end) {
        int num = end - start + 1;
        int pivot = (int) (Math.random()*num + start);
        int index = start;
        for (int x = start; x <= end; x++) {
            if (data[pivot] > data[x]) {
                index++;
            }
        }
        System.out.println(data[pivot]);
        return index;
    }
    
    public static void main(String[] args) {
        int[] set = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
        System.out.println(Arrays.toString(set));
        System.out.println(partition(set, 0, 4));
        System.out.println(partition(set, 1, 6));
    }
}