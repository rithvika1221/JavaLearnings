package JavaLearnings;

import edu.duke.FileResource;

public class FirstClass {
	
	// method run Hello
	public void runHello()
    {
        FileResource f;
        f = new FileResource();
        for(String line : f.lines())
        {
            System.out.println(line);
        }
    }

	// main method
	public static void main(String[] args) {
		FirstClass firstClass = new FirstClass();
		firstClass.runHello();
				
	}

}
