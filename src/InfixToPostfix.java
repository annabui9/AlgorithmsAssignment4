import java.util.LinkedList;
import java.util.Stack;

public class InfixToPostfix {

    public static int precedence(char op){ // assign values based on given precedence
        if(op == '^'){
            return 3;
        }else if(op == '*' || op == '/'){
            return 2;
        }else if(op == '+' || op == '-'){
            return 1;
        }
        return 0;
    }

    public static boolean checkOperator(char c){ // checks if operator
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^'){
            return true;
        }else{
            return false;
        }
    }

    public static String toPostfix(String s){
        Stack<Character> operators = new Stack<>(); // keep track of operators
        String output = "";

        for(int i = 0; i <s.length(); i++){
            char c = s. charAt(i);

            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){ // didn't specify letters like #5 (valid)
                output = output + c; // add letters / operands first
            } else if(c == '('){
                operators.add(c); // shows when to stop for group in parentheses
            }else if(c == ')'){
                while(!operators.isEmpty() && operators.peek() != '('){ // looking at operators within parentheses
                    output = output + operators.peek(); // add operator
                    operators.pop(); // remove to go to next
                }
                operators.pop(); // pop open bracket
            }else if(checkOperator(c)){
                // must add higher precedence first
                while(!operators.isEmpty() && operators.peek() != '(' && precedence(operators.peek()) >= precedence(c)){
                    output = output + operators.peek();
                    operators.pop();
                }
                operators.add(c); // can add current now that higher operators have been accounted for
            }

        }

        while(!operators.isEmpty()){ // add the rest of the operators
            output = output + operators.peek();
            operators.pop();
        }
        return output;
    }

    public static void main(String args[]){
        String s1 = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(s1 + ": " + toPostfix(s1));

    }



}
