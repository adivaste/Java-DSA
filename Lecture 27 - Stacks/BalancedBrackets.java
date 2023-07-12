import java.util.Stack;
import java.util.HashMap;

public class BalancedBrackets{

    public static boolean checkBalancedBrackets(String expression){
        Stack<Character> s = new Stack<>();
        HashMap<Character, Character> h = new HashMap<>();
        h.put(')', '(');
        h.put(']', '[');
        h.put('}', '{');

        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if (h.containsValue(c)){
                s.push(c);
            }
            else if (h.containsKey(c) && s.size() != 0){
                if (h.get(c) == s.peek()){
                    s.pop();
                }
                else{
                    return false;
                }
            }
            else if (h.containsKey(c) && s.size() == 0){
                return false;
            }
        }
        if (s.empty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String expression  = "(a+b) + {a+ [x+y]}";
        System.out.println(checkBalancedBrackets(expression));
    }
}
