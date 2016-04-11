public class Path {

    private Coordinate location;
    private Path previous;

    public Path(Coordinate l, Path p) {
	location = l;
	previous = p;
    }

    
    public Path getPrevious() {
	return previous;
    }

    public Coordinate getValue() {
	return location;
    }

}
