public class Sort{
    public static void radixsort (MyLinkedListImproved<Integer> data) {
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] set = new MyLinkedListImproved[1];
        for (int x = 0; x < set.length; x++) {
            set[x] = new MyLinkedListImproved<Integer>();
        }
        int counter = (int) ( Math.log10(data.get(data.max())) )+1;
        for (int level = 0;level < counter;level++) {
            while (data.size() != 0) {
                int index = ((int) ( (data.get(0) % Math.pow(10, level+1)) ))/ ((int)(Math.pow(10,level)));
                set[index].add(data.get(0));
                data.remove(0);
            }
            for (MyLinkedListImproved<Integer> place : set) {
                data.extend(place);
            }
        }
    }
    
    public static void main (String[] args) {
        MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
        Integer[] num = {16, 61, 12, 19, 15, 22, 32, -1};
        
        for (Integer n : num) {
            a.add(n);
        }
        
        System.out.println(a);
        radixsort(a);
        System.out.println(a);
        
    }
}