import java.util.*;

public class ParenDemo {
    
    public static boolean isMatching(String s) {
        MyStack <String> parens = new MyStack<String>();
	for (int i = 0; i < s.length(); i++) {
	    if (s.substring(i,i+1).equals("(") || s.substring(i,i+1).equals("[") || s.substring(i,i+1).equals("{") || s.substring(i,i+1).equals("<")) {
		parens.push(s.substring(i,i+1));
	    }
	   if (s.substring(i,i+1).equals(")") || s.substring(i,i+1).equals("]") || s.substring(i,i+1).equals("}") || s.substring(i,i+1).equals(">")) {
	       try {
		   String tmp = parens.pop();
		   if (!oppositeBracket(tmp).equals(s.substring(i,i+1))) {
		       return false;
		   }
	       }
	       catch (NoSuchElementException e)  {
		   return false;
	       }
	    }
	}
	return parens.isEmpty();
    }

    public static String oppositeBracket(String s) {
	if (s.equals("(")) {
	    //System.out.println("H");
	    return ")";
	}
	if (s.equals("[")) {
	    return "]";
	}
	if (s.equals("{")) {
	    return "}";
	}
	if (s.equals("<")) {
	    return ">";
	}
	return "";
    }


    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}


    }
}
