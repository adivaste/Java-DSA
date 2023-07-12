import java.util.Stack;
import java.util.HashMap;

public class ExtraBracket{
    public static boolean check(String expression){
        Stack<Character> s = new Stack<>();
        HashMap<Character, Character> h = new HashMap<>();
        h.put(')', '(');
        h.put('}', '{');
        h.put(']', '[');
       
        // Inserting
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);

            if (h.containsKey(c)){
                if (s.peek() == h.get(c)) return true;
                while(s.peek() != h.get(c)){
                    s.pop();
                }
                s.pop();
            }
            else{
                s.push(c);
            }
        }
        return false;
    }
    public static void main(String[] args){

        String expression = "{((a+b) + (c+d))}";
        System.out.println(check(expression));
    }
}
