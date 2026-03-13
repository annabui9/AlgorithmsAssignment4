import java.util.LinkedList;
import java.util.Stack;

public class BalancedSymbols {

    public static String isBalanced(String s){
        Stack<Character> open = new Stack<>();
        String position;
//        int counter = 0;

        for(int i = 0; i < s.length(); i++){

//            System.out.println(counter);
//            counter++;

            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{' || c == '<' || c == '¿'){ // if opening add to stack
                open.push(c);
            }else if(c == ')' || c == ']' || c == '}' || c == '>' || c == '?'){
                if (open.isEmpty()){ //check empty
                    position = "NO";
                    return position;
                }

                char top = open.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') ||  (c == '}' && top == '{') || (c == '>' && top == '<') || (c == '?' && top == '¿')) {
                    open.pop(); // remove if valid
                } else{
                    position = "NO";
                    return position;
                }
            }
        }

        if(open.isEmpty()){
            position = "YES"; // only valid when all open symbols have a corresponding pair
        }else{
            position = "NO";
        }

        return position;
    }

    public static void main(String args[]){
        String s1 = "{[()]}";
        String s2 = "{[(])}¿";
        String s3 = "{{[[(()<>)]]}}";

        System.out.println(s1 + ": " + isBalanced(s1));
        System.out.println(s2 + ": " + isBalanced(s2));
        System.out.println(s3 + ": " + isBalanced(s3));

    }
}
