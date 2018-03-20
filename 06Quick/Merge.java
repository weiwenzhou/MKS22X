import java.util.Arrays;
public class Merge {
    public static void mergesort(int[] data) {
        int[] replacement = mergesort(data, 0, data.length);
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
        int divider = total/2;
        int[] left = mergesort(data, start, divider);
        int[] right = mergesort(data, divider+1, start);
        
        int[] newAry = new int[total];
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
                if (leftIndex < rightIndex) {
                    newAry[index] = left[leftIndex];
                    leftIndex++;
                } else {
                    newAry[index] = right[rightIndex];
                    rightIndex++;
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