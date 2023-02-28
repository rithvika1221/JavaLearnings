package JavaLearnings;

interface AnimalNew
{
	public void animalSound2();
	public void sleep2();
}

class pigNew implements AnimalNew
{
	public void animalSound2()
	{
		System.out.println("The pig says : wee wee");
		
	}
	
	public void sleep2()
	{
		System.out.println("ZZZ");
		
	}
}
	

public class InterfaceExample
{

	public static void main(String[] args)
	{
		
		pigNew myPig = new pigNew();
		myPig.animalSound2();
		myPig.sleep2();
	}
}
