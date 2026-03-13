import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {

    public static String decode(String s){
        Stack<Integer> count = new Stack<>(); // to keep track of how many times to repeat
        Stack<String> string = new Stack<>(); // letter(s) to add / to be repeated
        String current = "";
        int k = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c >= '0' && c <= '9'){
                k = k * 10 + (c - '0'); // googled how to handle multiple digit numbers -- k * 10 handles digit place, (c - '0') handles the actual value of c
            } else if(c == '['){
                count.add(k); // add number value to count stack (so we know how much we need later)
                string.add(current); // add what we have up to / before bracket
                current = ""; //reset
                k = 0; //reset
            }else if (c == ']'){
                int repeat = count.peek(); // see how many times to repeat
                count.pop();
                String prev = string.peek(); // what is before the repeated section
                string.pop();

                String repeated = ""; // string for the repeated letters
                for(int j = 0; j < repeat; j++){ // repeat letter correct amount of times in string
                    repeated = repeated + current;
                }
                current = prev + repeated; // make current the string up to bracket + repeated section

            }else{
                current = current + c;
            }
        }
        return current;

    }

    public static void main(String args[]){
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        System.out.println(s1 + ": " + decode(s1));
        System.out.println(s2 + ": " + decode(s2));
        System.out.println(s3 + ": " + decode(s3));

    }

}
