package JavaLearnings;

class OuterClass2
{
	  int x = 10;

	  class InnerClass 
	  {
	    int y = 5;
	  }
}

public class Outerclass 
{
	 public static void main(String[] args)
	 {
	    OuterClass2 myOuter = new OuterClass2();
	    OuterClass2.InnerClass myInner = myOuter.new InnerClass();
	    System.out.println(myInner.y + myOuter.x);
     }
}