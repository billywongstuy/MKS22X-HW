public class Recursion {
    public String name() {
	return "Wong,Billy";
    }

    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	return convergeOnRoot(n,1);
    }


    public double convergeOnRoot(double n, double guess) {
	//System.out.println("Guess: " + guess);
	//System.out.println("Number: " + n);
	//System.out.println("% Error: " + Math.abs((n-Math.pow(guess,2.0)))/n);
	//System.out.println(Math.abs((n-Math.pow(guess,2.0))/n) < 0.01);
	if (Math.abs((n-Math.pow(guess,2.0)))/n < 0.001) {
	    //System.out.println("found root");
	    return guess;
	}
	guess = (n/guess+guess)/2;
	//System.out.println(guess);
	return convergeOnRoot(n,guess);
    }


    public static void main(String[]args) {
	Recursion r = new Recursion();
	System.out.println(r.sqrt(100));
	System.out.println(r.sqrt(200));
	System.out.println(r.sqrt(64));
	System.out.println(r.sqrt(78));
    }

}
