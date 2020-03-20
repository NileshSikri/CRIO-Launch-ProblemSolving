import java.io.*;
import java.util.*;

public class ValidParenthesis {
    // Implement your solution by completing the below function
    public boolean isValid(String s) {
      int n = s.length();
      Stack<Character> stk = new Stack<>(); 
      for(int i=0;i<n;i++)
      {
        if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
        stk.push(s.charAt(i));

        if(s.charAt(i)==')')
        {
          char a = stk.peek();
          if(a=='(')
          stk.pop();
        }

        if(s.charAt(i)=='}')
        {
          char a = stk.peek();
          if(a=='{')
          stk.pop();
        }

        if(s.charAt(i)==']')
        {
          char a = stk.peek();
          if(a=='[')
          stk.pop();
        }
      }

      if(stk.empty())
      return true;
      else
      return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String parenthesis = in.readLine();
        boolean result = new ValidParenthesis().isValid(parenthesis);
        System.out.print(String.valueOf(result));
    }
}
