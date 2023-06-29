package JavaLearnings;

public class Part3 {

	public boolean twoOccurences(String a, String b) {
		return a.indexOf(b) != a.lastIndexOf(b);
	}

	public void testing() {

		System.out.println(" Two or more String Ocurrances of a in bannana; " + this.twoOccurences("banana", "a"));
		System.out.println(" Two or more String Ocurrances of a in bannana; " + this.twoOccurences("forest", "zoo"));
		System.out.println(" Two or more String Ocurrances of a in bannana; " + this.twoOccurences("ctgtatgtat", "atg"));
	}
	
	public static void main(String[] args) {
		Part3 obj1 = new Part3();
		obj1.testing();

	}
}
