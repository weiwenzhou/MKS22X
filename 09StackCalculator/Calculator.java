import java.util.LinkedList;
public class Calculator<T> extends LinkedList<T> {
    public void push(T value) {
            add(value);
    }
        
    public T pop() {
            return removeLast();
    }
    
    public static double eval(String s) {
        String operators = "+-*/%";
        String[] values = s.split(" ");
        Calculator<Double> pancakes = new Calculator<Double>();
        for (String value : values) {
            int num = operators.indexOf(value);
            if (num == -1) {
                pancakes.add(Double.parseDouble(value));
            } else {
                double val2 = pancakes.pop();
                double val1 = pancakes.pop();
                if (num == 0) {
                    pancakes.push(val1 + val2);
                }
                if (num == 1) {
                    pancakes.push(val1 - val2);
                }
                if (num == 2) {
                    pancakes.push(val1 * val2);
                }
                if (num == 3) {
                    pancakes.push(val1 / val2);
                }
                if (num == 4) {
                    pancakes.push(val1 % val2);
                }
            }
        }
        return pancakes.pop();
    }    
    
    public static void main(String[] args) {
        System.out.println(eval("10 2.0 +")); // is 12.0
        System.out.println(eval("11 3 - 4 + 2.5 *")); // is 30.0
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); // is 893.0
    }
}