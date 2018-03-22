import java.util.Arrays;
public class Merge {
    /*
    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	mergesort(data, temp, 0, data.length-1);
    }

    public static void mergesort(int[] data, int[] temp, int start, int end) {
	if (start < end) {
	    mergesort(temp, data, start, (start+end)/2);
	    mergesort(temp, data, (start+end)/2+1, end);
	}
    }
    */
    // old merge sort.
    
    public static void mergesort(int[] data) {
	if (data.length == 0)return;
        int[] replacement = mergesort(data, 0, data.length-1);
	//System.out.println(Arrays.toString(replacement));
        for (int x = 0; x < data.length; x++) {
            data[x] = replacement[x];
        }
    }
    
    public static int[] mergesort(int[] data, int start, int end) {
        if (start >= end) {
            int[] ary = {data[start]};
            return ary;
        }
        int total = end-start;
        int divider = total/2+start;
        int[] left = mergesort(data, start, divider);
        int[] right = mergesort(data, divider+1, end);
        
        int[] newAry = new int[total+1];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (index < newAry.length) {
            try {
                if (left[leftIndex] < right[rightIndex]) {
                    newAry[index] = left[leftIndex];
                    leftIndex++;
                } else {
                    newAry[index] = right[rightIndex];
                    rightIndex++;
                }
            } catch (IndexOutOfBoundsException e) {
                if (leftIndex < left.length) {
                    newAry[index] = left[leftIndex];
                    leftIndex++;
                } else {
		    if (rightIndex < right.length) {
			newAry[index] = right[rightIndex];
			rightIndex++;
		    }
                }
            }
            index++;
        }
        return newAry;
    }

    
    
    public static void main(String[] args) {
        int[] ary = { 2, 10, 15, 23, 0,  5};
        System.out.println(Arrays.toString(ary));
        mergesort(ary);
        System.out.println(Arrays.toString(ary));
    }
}
