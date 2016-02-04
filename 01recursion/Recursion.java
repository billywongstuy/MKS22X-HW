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
	System.out.println(guess);
	System.out.println(n);
	if (Math.pow(guess,2)/n < 0.01) {
	    return guess;
	}
	guess = (n/guess+guess)/2;
	//System.out.println(guess);
	return convergeOnRoot(n,guess);
    }


    public static void main(String[]args) {
	Recursion r = new Recursion();
	System.out.println(r.sqrt(100));
    }

}
