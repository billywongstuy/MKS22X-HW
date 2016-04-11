public class Node {

    private Coordinate location;
    private Node previous;

    public Node(Coordinate l, Node p) {
	location = l;
	previous = p;
    }

    
    public Node getPrevious() {
	return previous;
    }

    public Coordinate getValue() {
	return location;
    }

    //getprevious
    //getvalue

    

}
