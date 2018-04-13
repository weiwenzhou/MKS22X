public class Sorts {
    public static void radixsort (MyLinkedList<Integer> data) {
	@suppressWarnings("unchecked") MyLinkedList<Integer>[] data = new MyLinkedList[10];
        int counter = Math.log10(data.max())+1;
	for (int level = 1;level < counter;level++) {
	    while (data.size() != 0) {
		if (data.get(0) % 10) {
		    
		}
	    }
	}
    }
}
