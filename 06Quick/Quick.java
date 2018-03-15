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
        data[0] = 100000;
        return index;
    }
    
    public static void swap(int[] data, int start, int end) {
        int temp = data[end];
        data[end] = data[start];
        data[start] = temp;
    }
    
    public static int quickselect(int[] data, int k) {
        int pivot = (int) (Math.random()*data.length);
        int temp = data[0];
        data[0] = data[pivot];
        data[pivot] = data[0];
        int smallest = 1;
        int largest = data.length-1;
        while (smallest < largest) {
            if (data[smallest] > data[0]) {
                
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] set = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
        System.out.println("@1"+Arrays.toString(set));
        System.out.println(partition(set, 0, 4));
        System.out.println("@2"+Arrays.toString(set));
        System.out.println(partition(set, 1, 6));
    }
}