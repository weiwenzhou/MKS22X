public class Recursion {
    public int fact(int n) {
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
    
    public int fib(int n) {
        return fibHelper(n, 0, 1);
    }
    
    private int fibHelper(int n, int a, int b) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return a;
        } 
        return fibHelper(n-1, b, a+b);
    }
    
    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println(r.fact(0)); // 1
        System.out.println(r.fact(6)); // 720
        System.out.println(r.fact(10)); // 3628800
        //System.out.println(r.fact(-5)); // exception
        
        System.out.println("============");
        
        System.out.println(r.fib(0)); // 0
        System.out.println(r.fib(1)); // 1
        System.out.println(r.fib(2)); // 1
        System.out.println(r.fib(5)); // 5
        System.out.println(r.fib(10)); // 10
        // System.out.println(r.fib(-5)); // exception
    }
}