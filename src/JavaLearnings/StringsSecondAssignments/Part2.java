package JavaLearnings.StringsSecondAssignments;

import edu.duke.FileResource;

public class Part2 {
	public int howMany(String a, String b) {
		int answer = 0;
		int position = 0; 
		while(true)
			
		{
			int curr =  a.indexOf(b, position);
			if (curr != -1)
			{
				answer++;
			}
			else
			{
				break;
			}
			
			position = (curr + b.length());
			
		}
		return answer;
	}
	
	
	public void testhowMany() 
	{
		FileResource fr = new FileResource();
		String dna = fr.asString();
		System.out.println(this.howMany(dna,"CTG"));
	}
	public static void main(String[] args)
	{
		Part2 obj1 = new Part2();
		obj1.testhowMany();
	}

}
