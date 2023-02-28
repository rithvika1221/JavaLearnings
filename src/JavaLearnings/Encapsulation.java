package JavaLearnings;

public class Encapsulation {

		  private String name;

		  public String getName()
		  {
		    return name;
		  }

		  public void setName(String newName)
		  {
		    this.name = newName;
		  }


		  public static void main(String[] args)
		  {
			    Encapsulation myObj = new Encapsulation();
			    myObj.setName("Rithvika"); 
			    System.out.println(myObj.getName());
		  }


}

