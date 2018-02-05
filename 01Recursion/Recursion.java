public class Recursion {
    private int precision = 5;
    
    
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
    
    public double sqrt(double n) {
        return sqrtHelper(n, 1);
    }
    
    private double sqrtHelper(double n, double guess) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (checkPrecision(Math.sqrt(n), guess)) {
            return guess;
        }
        return sqrtHelper(n, (n/guess + guess)/2);
    }
    
    
    private boolean checkPrecision(double actual, double guess) {
        // long method to check precision
        String real = "" + actual;
        String aprox = "" + guess;
        // round it off.
        
        try {
            aprox = aprox.substring(0, aprox.indexOf(".") + precision);
            real = real.substring(0, real.indexOf(".") + precision);
        }catch (Exception e) {}
        
        //return real.equals(aprox);
        // faster method to check precision, but 0 is broken because the inital guess is greater than 0 
        return Math.abs(actual - guess) < Math.pow(10, -precision);
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
        
        System.out.println("============");
        
        System.out.println(r.sqrt(0));
        System.out.println(r.sqrt(2));
        System.out.println(r.sqrt(4));
        System.out.println(r.sqrt(5));
        System.out.println(r.sqrt(10));
        System.out.println(r.sqrt(100));
        //System.out.println(r.sqrt(-5)); // exception
        
    }
}