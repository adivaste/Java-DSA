
import java.util.Stack;

public class InfixToPrePost{

    public int precedence(char operator){
        if (operator == '/') return 4;
        else if (operator == '*') return 3;
        else if (operator == '+') return 2;
        else return 1;

    }
    public void conversion(String expression){
        
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0; i<expression.length(); i++){

            // Get the character
            char c = expression.charAt(i);

            if (c == '('){
                operators.push(c);
            }
            else if ((c >= '0' && c <= '9') || ( c >= 'A' && c <= 'Z' ) || ( c >= 'a' && c <= 'z')){
                prefix.push(c + "");
                postfix.push(c + "");
            }
            else if ( c == ')'){
                while( operators.peek() != '('){
                    char opr = operators.pop();

                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    String preans = opr + preval1 + preval2;
                    prefix.push(preans);

                    
                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    String postans = postval1 + postval2 + opr;
                    postfix.push(postans);
                }
                operators.pop();
            }
            else if( c == '+' || c == '-' || c == '*' || c == '/'){

                while( operators.size() != 0 && precedence(operators.peek()) >= precedence(c) ){
                    char opr = operators.pop();

                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    String preans = opr + preval1 + preval2;
                    prefix.push(preans);

                    
                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    String postans = postval1 + postval2 + opr;
                    postfix.push(postans);
                }
                operators.push(c);
            }
        }

        while( operators.size() != 0 ){
            char opr = operators.pop();

            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            String preans = opr + preval1 + preval2;
            prefix.push(preans);


            String postval2 = postfix.pop();
            String postval1 = postfix.pop();
            String postans = postval1 + postval2 + opr;
            postfix.push(postans);
           }


        System.out.println(postfix.pop());
        System.out.println(prefix.pop());

    }

    public static void main(String[] args){
          InfixToPrePost x = new InfixToPrePost();
          x.conversion("(5+8)*9");
    }
}
