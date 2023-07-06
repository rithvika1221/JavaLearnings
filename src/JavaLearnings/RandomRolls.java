package JavaLearnings;
import java.util.Random;

import edu.duke.*;

public class RandomRolls {

	public void simpleSimulate(int rolls)
	{
		Random rand = new Random();
		int [] counts = new int [13];
		int twelves = 0;
		
		for (int k=0; k < rolls; k++)
		{
			int d1 = rand.nextInt(6) + 1;
			int d2 = rand.nextInt(6) + 1;
			counts[d1+d2] +=1;
			
		}
		for (int k=2; k<=12; k++)
		{
			System.out.println(k + "'s=\t" + counts[k]+ '\t' + 100.0 * counts[k]/rolls);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		RandomRolls obj1 = new RandomRolls();
		
		int rolls = 12;
		obj1.simpleSimulate(rolls);
		
		    	}

	
}
