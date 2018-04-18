import java.util.LinkedList;
public class Eval {
    public static double eval(String s) {
        String operators = "+-*/%";
        String[] values = s.split(" ");
        @SuppressWarnings Stack<String> pancakes = new Stack<String>();
        for (String value : values) {
            int num = operators.indexOf(value);
            if (num == -1) {
                pancakes.add(value);
            } else {
                double val2 = Double.parseDouble(pancakes.pop());
                double val1 = Double.parseDouble(pancakes.pop());
                if (num == 0) {
                    pancakes.push(""+(val1 + val2));
                }
                if (num == 1) {
                    pancakes.push(""+(val1 - val2));
                }
                if (num == 2) {
                    pancakes.push(""+(val1 * val2));
                }
                if (num == 3) {
                    pancakes.push(""+(val1 / val2));
                }
                if (num == 4) {
                    pancakes.push(""+(val1 % val2));
                }
            }
        }
        return Double.parseDouble(pancakes.pop());
    }
    
    
    public class Stack<T> extends LinkedList<T> {
        public void push(T value) {
            add(value);
        }
        
        public T pop() {
            return removeLast();
        }
    }
    
}