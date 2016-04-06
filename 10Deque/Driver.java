import java.util.*;
 
public class Driver {
    public static void main(String[] args) {
 
        MyDeque<Integer> d = new MyDeque<Integer>();
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
 
        // Limit the number of times addFirst and addLast is done
 
        int limit = 1000000;
 
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
 
        // Add to the head and to the tail
 
        for (int i = 0; i < limit; i++) {
            Integer r1 = (int) (Math.random() * 1000000);
 
            // Add to either the beginning or end
	    if (Math.random()*2 == 0) {
		d.addFirst(r1);
		ad.addFirst(r1);
	    }
	    else {
		d.addLast(r1);
		ad.addLast(r1);
	    }
        }
       
 
        // Test if adding worked by removing elements
 
        for (int i = 0; i < limit/2; i++) {
	    
            if (!d.getFirst().equals(ad.getFirst())) {
                System.out.println("Test #0 (addFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!d.getLast().equals(ad.getLast())) {
                System.out.println("Test #1 (addLast) failed at: " + i + "!");
                System.exit(0);
            }
	    
            if (!d.removeFirst().equals(ad.removeFirst())) {
                System.out.println("Test #2 (removeFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!d.removeLast().equals(ad.removeLast())) {
                System.out.println("Test #3 (removeLast) failed at: " + i + "!");
                System.exit(0);
            }
        }
 
        // Sizes should be equal
 
        if (d.size() != ad.size()) {
            System.out.println("Not equal sizes. Error!");
            System.exit(0);
        }
 
        System.out.println("Success!");
    }
 
}
