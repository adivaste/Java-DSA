import java.util.Stack;

public class PostfixToInPre{

    public int evaluate(int val1, int val2, char operator){
        if (operator == '+') return val1 + val2;
        else if (operator == '-') return val1 - val2;
        else if (operator == '*') return val1*val2;
        else return val1/val2;
    }

    public int precedence(char operator){
        if (operator == '+' || operator == '-') return 1;
        else if ( operator == '/' || operator == '*') return 2;
        else return 0;
    }

    public void conversion(String expression){
        
        Stack<String> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        for(int i=0; i<expression.length(); i++){

            // Get the character
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '/' || c == '*'){
                int v2 = valueStack.pop();
                int v1 = valueStack.pop();
                int ans = evaluate(v1, v2, c);
                valueStack.push(ans);

                String inv2 = infix.pop();
                String inv1 = infix.pop();
                String inans = "(" + inv1 + c + inv2 + ")";
                infix.push(inans);

                String prev2 = prefix.pop();
                String prev1 = prefix.pop();
                String preans = c + prev1 + prev2;
                prefix.push(preans);

            }
            else{
                valueStack.push(c - '0');
                prefix.push(c + "");
                infix.push(c + "");
            }
        }

       System.out.println(valueStack.pop());
       System.out.println(infix.pop());
       System.out.println(prefix.pop());
    }


    public static void main(String[] args){
        PostfixToInPre p = new PostfixToInPre();
        p.conversion("58*4+62/-");

    }
}
