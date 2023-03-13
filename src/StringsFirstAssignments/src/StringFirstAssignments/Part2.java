package StringFirstAssignments;

public class Part2 {

	public String findSimpleGene2(String dna, String startCodon, String stopCodon) {
		
		
		String result = "";
		
		int startIndex = dna.toUpperCase().indexOf(startCodon);
		int stopIndex = dna.toUpperCase().indexOf(stopCodon, startIndex + 3);
		
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

		String dna = "aagtaataa";
		String startCodon = "AGT";
		String stopCodon = "TAA";
		System.out.println("DNA strand is " + dna);
		String gene = this.findSimpleGene2(dna, startCodon, stopCodon);
		System.out.println("Gene is " + gene);
		
	

		

	}
	
	public static void main(String[] args)
	{
	   Part2 obj1 = new Part2();
	   obj1.testSimpleGene();
	}
}
