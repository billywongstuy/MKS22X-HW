public class BSTree<T extends Comparable<T>> {


    public int compareTo(BSTree n) {
	if (this.data > n.data) {
	    return 0;
	}
	return 1;
    }

    private class Node {

	T data;
	Node left;
	Node right;

	//set/get data/left/right


	public Node() {

	}

	public Node(T value) {
	    
	}

	public void add(T value) {

	}


	public boolean contains(T value) {
	    return false;
	}


	public int getHeight() {
	    return 0;
	}
	

    }
    

    private Node root;


    //check for empty
    public void add(T value) {root.add(value);}
    public String toString() {return root.toString();}
    public boolean contains(T value) {return root.contains(value);}
    public int getHeight() {return root.getHeight();}

}
