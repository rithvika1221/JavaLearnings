package StringFirstAssignments;

public class Part1 {

	public String findSimpleGene(String dna) {
		String result = "";
		int startIndex = dna.indexOf("ATG");
		int stopIndex = dna.indexOf("TAA", startIndex + 3);
		if (startIndex == -1 || stopIndex == -1) {
			return result;

		}
		if ((stopIndex+1 - startIndex) % 3 == 0) {
			result = dna.substring(startIndex, stopIndex + 3);
			return result;
		} else 
		{
			return result;
		}
	}

	public void testSimpleGene() {

		String dna = "AATGCGTAAATATGGT";
		System.out.println("DNA strand is " + dna);
		String gene = this.findSimpleGene(dna);
		System.out.println("Gene is " + gene);

	}

	public static void main(String[] args) {
		Part1 obj1 = new Part1();
		obj1.testSimpleGene();
	}
}
