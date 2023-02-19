package JavaLearnings;

public class FirstJava {
	
	public   void printday(int date)
	{
		switch(date)
		{
		case 1: 
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3: 
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5: 
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
		}

	}
	
	public static void main(String[] args)
	{
		FirstJava dayone = new FirstJava();
		dayone.printday(7);
		
	}
	

}



