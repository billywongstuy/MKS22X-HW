public class Recursion implements hw01{
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
	if (Math.abs((n-Math.pow(guess,2.0)))/n < 0.00001) {
	    return guess;
	}
	guess = (n/guess+guess)/2;
	return convergeOnRoot(n,guess);
    }


    public static void main(String[]args) {
	Recursion r = new Recursion();
	//System.out.println(r.sqrt(100));
	//System.out.println(r.sqrt(200));
	//System.out.println(r.sqrt(64));
	//System.out.println(r.sqrt(78));
	System.out.println(r.sqrt(4.0));
	System.out.println(r.sqrt(1.0E-7));
    }

}
