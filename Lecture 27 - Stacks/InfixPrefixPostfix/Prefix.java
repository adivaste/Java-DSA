// Prefix => Infix || Postfix  :: (5+8)*3 ==> *+583

import java.util.Stack;

public class Prefix{

    public int evaluate(int val1, int val2, char operator){
        if (operator == '+') return val1 + val2;
        else if (operator == '-') return val1 - val2;
        else if (operator == '*') return val1 * val2;
        else return val1 / val2;
    }

    public void conversion(String expression){

        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        for(int i=expression.length()-1; i>=0; i--){

            // Get each character
            char c = expression.charAt(i);
            
            if(c == '+' || c == '-' || c == '/' || c == '*'){
               int val2 = valueStack.pop(); 
               int val1 = valueStack.pop(); 
               int ans = evaluate(val1, val2, c);
               valueStack.push(ans);

                String inval2 = infix.pop();
                String inval1 = infix.pop();
                String inans = "(" + inval1 + c + inval2 + ")";
                infix.push(inans);

                String postval2 = postfix.pop();
                String postval1 = postfix.pop();
                String postans = postval1 + postval2 + c;
                postfix.push(postans);
            }
            else{
                valueStack.push(c - '0');
                postfix.push(c + "");
                infix.push(c + "");
            }
        }

        System.out.println(valueStack.pop());
        System.out.println(postfix.pop());
        System.out.println(infix.pop());
    }

    public static void main(String[] args){
        Prefix p = new Prefix();
        p.conversion("*+586");
    }   
}
