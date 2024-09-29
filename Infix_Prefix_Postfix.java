import java.util.*;
public class Infix_Prefix_Postfix {
    
    static boolean isOperator(char c){
        return c == '+' || c == '-' || c=='*' || c=='/'||c=='^';
    }
    
    static int precedence(char c){
         switch(c){
            case '+':
            case '-':
             return 1;
            case '*':
            case '/':
             return 2;
            case '^':
             return 3;
         }
         return -1;
    }
    public static String infixToPostfix(String infix){

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        for(int i=0;i<infix.length();i++){
             char c= infix.charAt(i);

             if(Character.isLetterOrDigit(c)){
                postfix.append(c);
             }
             else if(c=='('){
               stack.push(c);
             }
             else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                      postfix.append(stack.pop());
                }
                stack.pop();
             }
             else if(isOperator(c)){
                while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek())){
                    postfix.append(stack.pop());
             }
                stack.push(c);
             }
        }
             while(!stack.isEmpty()){
                postfix.append(stack.pop());
             }
             return postfix.toString();
    }
    public static String infixToPrefix(String infix){
        Stack<Character> stack = new Stack<>();
        StringBuilder prefix = new StringBuilder();

        String reversedInfix = new StringBuilder(infix).reverse().toString();
        for(int i=0;i<reversedInfix.length();i++){
            if(reversedInfix.charAt(i)=='('){
                reversedInfix = reversedInfix.substring(0,i) + ')' + reversedInfix.substring(i+1);
            }
            else if(reversedInfix.charAt(i)==')'){
                reversedInfix = reversedInfix.substring(0,i) + '(' + reversedInfix.substring(i+1);
            }
        }
            String reversedPostfix = infixToPostfix(reversedInfix);
            prefix.append(reversedPostfix).reverse().toString();
            return prefix.toString();
    }
    public static String postfixToInfix(String postfix){
        Stack<String> stack = new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char c= postfix.charAt(i);

            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            }
            else if(isOperator(c)){
                String Operand2 = stack.pop();
                String Operand1 = stack.pop();
                String infix = "(" + Operand1 + c + Operand2 + ")";
                stack.push(infix);
            }   
        }
        return stack.pop();
    }                  
    public static String prefixToInfix(String prefix){
        Stack<String> stack = new Stack<>();

        for(int i=prefix.length()-1; i>=0 ;i--){
            char c= prefix.charAt(i);

            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            }
            else if(isOperator(c)){
                String Operand1 = stack.pop();
                String Operand2 = stack.pop();
                String infix = "(" + Operand1 + c + Operand2 + ")";
                stack.push(infix);
            }   
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Infix String");
        String infix = sc.nextLine();
        System.out.println();
        System.out.println("Infix:"+ infix);
        
        System.out.println();
        String postfix = infixToPostfix(infix);
        System.out.println("Postfix:"+ postfix);
        
        System.out.println();
        String prefix = infixToPrefix(infix);
        System.out.println("Prefix:"+ prefix);
        
        System.out.println();
        String ConvertedInfixFromPostfix = postfixToInfix(postfix);
        System.out.println("Converted Infix from Postfix: "+ ConvertedInfixFromPostfix);
        
        System.out.println();
        String ConvertedInfixFromPrefix = prefixToInfix(prefix);
        System.out.println("Converted Infix from Prefix: "+ ConvertedInfixFromPrefix);
    }                  
}

