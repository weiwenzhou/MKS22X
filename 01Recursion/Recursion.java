public class Recursion {
    public int fact (int n) {
        return factHelper(n, 1);
    }
    
    private int factHelper(int n, int product) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return product;
        } 
        return factHelper(n-1, n * product);
    }
    
    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println(r.fact(0)); // 1
        System.out.println(r.fact(6)); // 720
        System.out.println(r.fact(10)); // 3628800
        //System.out.println(r.fact(-5)); // exception
    }
}