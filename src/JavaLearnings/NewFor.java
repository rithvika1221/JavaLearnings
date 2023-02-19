package JavaLearnings;

public class NewFor {
	
	
	public static void main(String[] args)
	{
		
		String[] cars = {"red tesla", "blue tesla", "white tesla"};
		for (String i : cars) 
		{
		  System.out.println(i);
		}
		
		for (int i=0; i<cars.length; i++)
		{
			 System.out.println(cars[i]);
		}
	}
	
	

}
