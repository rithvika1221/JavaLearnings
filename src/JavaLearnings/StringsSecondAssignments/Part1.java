package JavaLearnings.StringsSecondAssignments;
import „;
import edu.duke.*;

public class Part1 {

	// Takes DNA, startIndex, stopCodon
	// function find the next index of stopcodon from the startindex
	// if the distance between startIndex and stopCodon is divisible by 3 return the
	// index

	public int findStopCodon(String dna, int startIndex, String stopCodon) {
		int Index = startIndex;
		while (true) {
			Index = dna.indexOf(stopCodon, Index +1);
			if ((Index - startIndex) % 3 == 0) {
				return Index;
			} 
			if(Index == -1)
			{
				return dna.length();
			}
		}

		//return dna.length();
		
	/*	int index = 0;

		while (true) {
			int begginingIndex = startIndex;
			index = dna.indexOf(stopCodon, startIndex);
			if (index == -1) {
				return dna.length();
			} else if ((index - begginingIndex) % 3 == 0) {
				return index;
			} else {

				startIndex = index + 1;
			}
		}*/

	}

	// find index of start codon
	// get index of all three stop codons
	// compare and get the least
	// find and return gene
	public String findGene(String dna, int position) {
		//dna = dna.toUpperCase();
		int startIndex = dna.indexOf("ATG", position);
		if (startIndex == -1) {
			return "";
		}

		int TAAINDEX = findStopCodon(dna, startIndex, "TAA");
		int TAGINDEX = findStopCodon(dna, startIndex, "TAG");
		int TGAINDEX = findStopCodon(dna, startIndex, "TGA");
		
		int minIndex = Math.min(TAAINDEX, TAGINDEX);
		minIndex = Math.min(TGAINDEX, minIndex);
		
		
		if(minIndex == dna.length())
		{
			return "";
		}

		return dna.substring(startIndex, minIndex + 3);
	}

	public void printAllGenes(String dna) {
		int anscount = 0;
		int maxlength = 0;
		dna = dna.toUpperCase();
		int position = 0;
		while (true)
		{
			String ans = this.findGene(dna, position);
			if (ans == "" || ans.isEmpty()) {
				break;
			} else {
				System.out.println(ans);
				anscount++;
				maxlength = Math.max(maxlength, ans.length());
				position = dna.indexOf(ans, position) + ans.length();
			}
			

		}
		System.out.println(anscount);
		System.out.println("Max length:");
		System.out.println(maxlength);
	}

	public StorageResource getAllGenes(String dna) {
		dna = dna.toUpperCase();
		int position = 0;
		String dnaSub = dna;
		StorageResource genes = new StorageResource();
		while (true)

		{

			String ans = this.findGene(dnaSub, position);
			if (ans == "") {
				break;
			} else {
				genes.add(ans);
				
				if ((dnaSub.indexOf(ans) + ans.length()) < dnaSub.length()) {
					dnaSub = dnaSub.substring(dnaSub.indexOf(ans) + ans.length());
				}
			}

		}
		return genes;
	}

	public int countAllGenes(String dna) {
		int position = 0;
		int answer = 0;
		while (true)

		{

			String ans = this.findGene(dna, position);
			if (ans == "") {
				break;
			} else {
				answer++;
				position = (dna.indexOf(ans) + ans.length());

			}

		}
		return answer;
	}

	public float cgRatio(String dna) {

		int count = 0;

		for (char c : dna.toCharArray()) {
			if (c == 'C' || c == 'G') {
				count++;
			}

		}
		return (float) (count) / dna.length();
	}

	public void processGenes(StorageResource sr) {

		// print all the Strings in sr that are longer than 9 characters
		// print the number of Strings in sr that are longer than 9 characters
		// print the Strings in sr whose C-G-ratio is higher than 0.35
		// print the number of strings in sr whose C-G-ratio is higher than 0.35
		// print the length of the longest gene in sr

		int longCount = 0;
		int ratioCount = 0;
		for (String i : sr.data()) {
			if (i.length() > 60) {
				System.out.println(i);
				longCount++;
			}
			if (cgRatio(i) > 0.35) {
				System.out.println(i);
				ratioCount++;

			}

		}
		System.out.println(longCount);
		System.out.println(ratioCount);

	}

	public void testProcessGenes() {

		FileResource fr = new FileResource();
		String dna = fr.asString();

		this.processGenes(this.getAllGenes(dna));

		// StorageResource sr = new StorageResource();
		// sr.add("QWEATGSDVFDFVDBNJTGAGBBBB");
		// sr.add("ATGTGA");
		// sr.add("ATGCCATAG");
		// sr.add("ACG");

		// this.processGenes(sr);
	}

	public void testFindStopCodon() {
		System.out.println(this.findStopCodon("ATGATAAAATAA", 0, "TAA"));
		System.out.println(this.findStopCodon("ATGAAATAGAATAA", 0, "TAG"));
	}

	public void testfindGene() {
		System.out.println(this.findGene("ATGATAAAATAA", 0));
		System.out.println(this.findGene("ATGATAAAATAATGA", 0));
		System.out.println(this.findGene("ATGATAAAATAATGATAG", 0));
		System.out.println(this.findGene("ATGATAAAATABTGA", 0));

	}

	public void testprintAllGenes() {

		FileResource fr = new FileResource();
		String dna = fr.asString();
		System.out.println("Starting of testPrintAllGenes");
		this.printAllGenes(dna);
	}

	public void testgetAllGenes() {

		for (String s : this.getAllGenes("ATGTAABCATAGBCCATGTGA").data()) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {

		Part1 obj1 = new Part1();
		// obj1.testFindStopCodon();
		// obj1.testfindGene();
		obj1.testprintAllGenes();
		// obj1.testgetAllGenes();
		// System.out.println(obj1.countAllGenes("ATGTAAATGTGAATGTAG"));
		// System.out.println(obj1.cgRatio("ATGCCATAG"));
		 //obj1.testProcessGenes();

	}

}
