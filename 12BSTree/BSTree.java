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


	public int compareTo(T n) {
	    return n.compareTo(data);
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
	    if (data == null) {
		data = value;
	    }
	    else if (left.getValue() != null && right.getValue() != null) {
		//decide where to put it
	    }
	    else if (compareTo(value) == 0) {
		right.setValue(value);
	    }
	    else {
		left.setValue(value);
	    }
	}
	public String toString(){
	    return "";
	}
	public boolean contains(T value){
	    return false;
	}
     
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
    }
    public String toString(){
	//check for empty before you do things with root.
	return "";
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }
}
