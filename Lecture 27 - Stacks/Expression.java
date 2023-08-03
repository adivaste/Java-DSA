import java.util.Stack;

public class Expression{

    public int evaluate(int val1, int val2, char operator){
        if(operator == '+') return val1 + val2;
        else if(operator == '-') return val1 - val2;
        else if(operator == '*') return val1*val2;
        else return val1/val2;
    }

    public int getPrecendence(char operator){
        if (operator == '/') return 4;
        else if (operator == '*') return 3;
        else if (operator == '+') return 3;
        else return 1;

    }
    
    public int solveInfix(String expression){
        
        // Traverse over a string
        // If operand  : Push to stack
        // If operator : Evaluate
        //            => Check the top of operators, check precedence
        //               if it has a precedence greater then evaluate it
        //               otherwise push into stack
        //            => Until : Stack is empty, opening bracket, precendence of 
        //               of top becomes less than current one
        // If opening bracket :: push 
        // if closing brakcket :: perform same operations until, stack is 
        //                        not empty and opening brackets comes in.
        

        // Prepare a stack
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Traverse
        for(int i=0; i<expression.length(); i++){
            
            // Get the character
            char c = expression.charAt(i);


            // Check for operand
            if (Character.isDigit(c)){
                operands.push(c - '0');
            }
            // Check for opening bracket
            else if ( c == '('){
                operators.push(c);
            }

            // check for closing bracket
            else if ( c == ')'){
                while(operators.peek() != '('){
                    char opr = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();

                    int ans = evaluate(val1, val2, opr);
                    operands.push(ans);
                }   
                operators.pop();
            }

            // else if check operator
            else if (c == '+' || c == '-' || c == '*' || c == '/'){
                // Evalute and process
                while(!operators.isEmpty() && getPrecendence(operators.peek()) >= getPrecendence(c) && operators.peek() != '('){
                    char opr = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    
                    int ans = evaluate(val1, val2, opr);
                    operands.push(ans);
                }
                operators.push(c);
            }

        }

        
        while(operators.size() != 0){
            char opr = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();

            int ans = evaluate(val1, val2, opr);
            operands.push(ans);
        }


        return operands.peek();
    }

    public static void main(String[] args){
        Expression e = new Expression();
        int ans = e.solveInfix("(5*2)*(5/5)+4"); // Word for single digit only
        System.out.println(ans);
    }
}
