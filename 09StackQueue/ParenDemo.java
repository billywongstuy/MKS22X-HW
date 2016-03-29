public class ParenDemo {
    
    public static boolean isMatching(String s) {
        MyStack <String> parens = new MyStack<String>();
	for (int i = 0; i < s.length(); i++) {
	    if (s.substring(i,i+1).equals("(") || s.substring(i,i+1).equals("[") || s.substring(i,i+1).equals("{") || s.substring(i,i+1).equals("<")) {
		parens.push(s.substring(i,i+1));
	    }
	   if (s.substring(i,i+1).equals(")") || s.substring(i,i+1).equals("]") || s.substring(i,i+1).equals("}") || s.substring(i,i+1).equals(">")) {
	       if (s.substring(i,i+1).equals(oppositeBracket(parens.peek()))) {
		    parens.pop();
		}
	       else {return false;}
	    }
	}
	return true;
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
