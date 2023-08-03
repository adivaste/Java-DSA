import java.util.Stack;

public class PrefixToInPost{

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
        
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        for(int i=expression.length()-1;  i>=0; i--){

            // Get the character
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '/' || c == '*'){
                int v1 = valueStack.pop();
                int v2 = valueStack.pop();
                int ans = evaluate(v1, v2, c);
                valueStack.push(ans);

                String inv1 = infix.pop();
                String inv2 = infix.pop();
                String inans = "(" + inv1 + c + inv2 + ")";
                infix.push(inans);

                String postv1 = postfix.pop();
                String postv2 = postfix.pop();
                String postans = postv1 + postv2 + c;
                postfix.push(postans);

            }
            else{
                valueStack.push(c - '0');
                postfix.push(c + "");
                infix.push(c + "");
            }
        }

       System.out.println(valueStack.pop());
       System.out.println(infix.pop());
       System.out.println(postfix.pop());
    }


    public static void main(String[] args){
        PrefixToInPost p = new PrefixToInPost();
        p.conversion("-+*584/62");

    }
}
