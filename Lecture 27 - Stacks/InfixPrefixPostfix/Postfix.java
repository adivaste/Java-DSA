import java.util.Stack;

public class Postfix{

    public int evaluate(int val1, int val2, char opr){
        if (opr == '+') return val1 + val2;
        else if (opr == '-') return val1 - val2;
        else if (opr == '*') return val1 * val2;
        else return val1 / val2;
    }

    public void conversion(String expression){

        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        for(int i=0; i<expression.length(); i++){

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

                String preval2 = prefix.pop();
                String preval1 = prefix.pop();
                String preans = preval1 + preval2 + c;
                prefix.push(preans);
            }
            else{
                valueStack.push(c - '0');
                prefix.push(c + "");
                infix.push(c + "");
            }
        }

        System.out.println(prefix.pop());
        System.out.println(valueStack.pop());
        System.out.println(infix.pop());
        
    }

    public static void main(String[] args){
        Postfix p = new Postfix();
        p.conversion("123*+");
    }
}
