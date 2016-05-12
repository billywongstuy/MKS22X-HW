public class Driver {

    public static void main(String[]args) {
	RunningMedian m = new RunningMedian();
	m.add(1);
	m.add(7);
	m.add(13);
	m.add(24);
	m.add(15);
	m.add(17);
	m.add(5);
	System.out.println(m.getMedian());
    }
    
}
