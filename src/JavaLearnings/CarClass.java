package JavaLearnings;

public class CarClass 
{
	String name;
	String color;
	int price;
	
	public CarClass(String name, String color, int price)
	{
		this.name = name; 
		this.color = color;
		this.price = price;
	}
	
	
	public CarClass() 
	{
		this.name = "Tesla Model 3"; 
		this.color = "Red";
		this.price = 1000000;
		
	
	}


	public void Display()
	{
		System.out.println("The car's name is: " + name);
		System.out.println("The car's color is: " + color);
		System.out.println("The car's speed is: " + price);
		
	}
	
	
	public static void main(String[] args)
	{
		 CarClass tesla = new CarClass("Tesla model x", "Red", 50000000);
		 tesla.Display();
		 
		 CarClass tesla2 = new CarClass();
		 tesla2.Display();
		 
		 
		 
	}
	
	

}
