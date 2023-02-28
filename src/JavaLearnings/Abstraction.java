package JavaLearnings;

abstract class Animal
{
	public abstract void animalSound();
	
	public void sleep()
	{
		System.out.println("ZZZ");
	
	}
}

class Pig extends Animal
{
	
	public void animalSound()
	{
		System.out.println("Oink Oink");
	}

	public void sleep() {
		// TODO Auto-generated method stub
		
	}

}

public class Abstraction
{
	
	public static void main(String[] args)
	{
		Pig myPig = new Pig();
		myPig.animalSound();
		myPig.sleep();
	}
	

}
