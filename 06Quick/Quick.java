import java.util.Arrays;
public class Quick {
    public static int partition(int[] data, int start, int end) {
        int p = (int) (Math.random()*(end-start) + start);
        int pivot = data[p];
        int low = start+1;
        int high = end;
        swap(data, p, start);
        while (low <= high) {
            if (data[low] > pivot) {
                swap(data, low, high);
                high--;
            } else {
                low++;
            }
        }
        //System.out.println(Arrays.toString(data));
        swap(data, 0, high);
        //System.out.println("Index"+p+",value"+pivot);
        return high;
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
        //int[] set = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
        int[] set = {0,0,0,1,99,3,99,2,99};
        System.out.println("@1"+Arrays.toString(set));
        swap(set, 0, 8);
        System.out.println("@1a"+Arrays.toString(set));
        System.out.println(partition(set, 0, 8));
        System.out.println("@2"+Arrays.toString(set));
        //System.out.println(partition(set, 1, 6));
    }
}