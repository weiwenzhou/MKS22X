import java.util.Arrays;
public class Merge {
    
    public static void mergesort(int[] data) {
        if (data.length == 0)return;
        int[] replacement = new int[data.length];
        for (int x = 0; x < data.length; x++) {
            replacement[x] = data[x];
        }
        mergesort(data, replacement, 0, data.length-1);
        for (int x = 0; x < data.length; x++) {
            data[x] = replacement[x];
        }
        // System.out.println(Arrays.toString(replacement));
    }
    
    public static void mergesort(int[] data, int[] temp, int start, int end) {
        if (end - start <= 5) {
            // System.out.println("Insertion next"+start+","+end+Arrays.toString(data));
            insertionsort(data, start, end);
        } else {
            if (start < end) {
                // System.out.println("t"+Arrays.toString(temp));
                // System.out.println("d"+Arrays.toString(temp));
                int divider = (start+end)/2;
                // System.out.println(divider);
                mergesort(temp, data, start, divider);
                mergesort(temp, data, divider+1, end);
                merge(data, temp, start, divider, divider+1, end);
            }
        }
    }

    public static void merge (int[] data, int[] temp, int lStart, int lEnd, int rStart, int rEnd) {
        // System.out.println(""+lStart+","+lEnd+":"+rStart+","+rEnd);
        // System.out.println("t"+Arrays.toString(temp));
        // System.out.println("d"+Arrays.toString(temp));
        int leftIndex = lStart;
        int rightIndex = rStart;
        int index = lStart;
        while (index <= rEnd) {
            if (leftIndex <= lEnd && rightIndex <= rEnd) {
                if (data[leftIndex] < data[rightIndex]) {
                    temp[index] = data[leftIndex];
                    leftIndex++;
                } else {
                    temp[index] = data[rightIndex];
                    rightIndex++;
                }
            } else {
                if (leftIndex <= lEnd) {
                    temp[index] = data[leftIndex];
                    leftIndex++;
                } else {
                    if (rightIndex <= rEnd) {
                        temp[index] = data[rightIndex];
                        rightIndex++;
                    }
                }
            }
            index++;
        }
    }
    
    public static void insertionsort(int[] data, int start, int end) {
        for (int x = start; x < end+1; x++) {
            int temp = data[x];
            int correctIndex = start;
            while ( correctIndex < x && temp > data[correctIndex]) {
                correctIndex++;
            }
            for (int i = x; i > correctIndex; i--) {
                data[i] = data[i-1];
            }
            data[correctIndex] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] ary = { 2, 10, 15, 23, 0,  5};
        System.out.println(Arrays.toString(ary));
        mergesort(ary);
        System.out.println(Arrays.toString(ary));
    }
}
