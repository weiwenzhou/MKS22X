import java.util.Arrays;
public class Quick {
    public static int partition(int[] data, int start, int end) {
	int p = (int) (Math.random()*(end-start) + start);
	int pivot = data[p];
	int low = start+1;
	int high = end;
	swap(data, pivot, start);
	while (low <= high) {
	    if (data[low] > pivot) {
		swap(data, low, high);
		high--;
	    } else {
		low++;
	    }
	}
	swap(data, 0, low);
	System.out.println("p"+pivot);
	return low;
    }

    public static void swap(int[] data, int spot, int newSpot) {
	int temp = data[newSpot];
	data[newSpot] = data[spot];
	data[spot] = temp;
    }

    public static void main(String[] args) {
	int[] set = {0,0,0,1,99,3,99,2,99};
	System.out.println(Arrays.toString(set));
	System.out.println(partition(set, 0, set.length-1));
	System.out.println(Arrays.toString(set));
    }
    
}
