public class BSTree<T extends Comparable<T>> {   
    
    
    public BSTree() {
	root = new Node();
    }

    private class Node{
	T data;
	Node left;
	Node right;
	int height;
	// set/get: data/left/right
	

	public boolean hasChildren() {
	    if (left != null || right != null) {
		return true;
	    }
	    return false;
	}

	public void setValue(T value) {
	    data = value;
	}

	public T getValue() {
	    return data;
	}
	

	//real methods here
	public int height(){ 
	    return 0;
	}
	public void add(T value){
	    System.out.println("adding");
	    if (data == null) {
		System.out.println("adding2");
		data = value;
		System.out.println(data);
	    }
	    else if (value.compareTo(data) < 0) {
		if (left == null) {
		    left = new Node();
		    left.setValue(value);
		}
		else {
		    left.add(value);
		}
	    }
	    else {
		if (right == null) {
		    right = new Node();
		    right.setValue(value);
		}
		else {
		    right.add(value);
		}
	    }
	}


	public String stringHelper(Node n) {
	    System.out.println("start: " + data);
	    if (n.hasChildren()) {
		if (left != null && right != null) {
		    System.out.println("both of " + data);
		    return ""+data +" "+ stringHelper(left) + " " +  stringHelper(right);
		}
		else if (left != null) {
		    System.out.println("only left of " + data);
		    return ""+data+" "+stringHelper(left) + "_";
		}
		else {
		    System.out.println("only right of " + data);
		    System.out.println(right.getValue());
		    return ""+data+" _ " + stringHelper(right);
		}
	    }
	    System.out.println("here: " + data);
	    return ""+ data + " _ _";
	}

	public String toString(){
	    return stringHelper(this);
	}
	public boolean contains(T value){
	    return false;
	}
     
    }


    //remove easy for no or 1 children
    //remove when have 2 children replace node with largest of left or smallest of right (pick the taller child)
    //have the remove method for tree and node

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	if (root.getValue() == null) {
	    return 0;
	}
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
	root.add(value);
    }
    public String toString(){
	//check for empty before you do things with root.
	if (root.getValue() != null) {
	    return root.toString();
	}
	return "_";
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	if (root.getValue() == null) {
	    return false;
	}
	return false;
    }


    public static void main(String[]args) {
	BSTree<Integer> b = new BSTree<>();
	b.add(4);
	b.add(9);
	System.out.println(b);
    }

}

