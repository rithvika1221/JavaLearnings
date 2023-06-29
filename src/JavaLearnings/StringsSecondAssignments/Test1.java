package JavaLearnings.StringsSecondAssignments;

public class Test1 {

	public void findAbc(String input){
	       int index = input.indexOf("abc");
	       while (true){
	           if (index == -1 || index >= input.length() - 3){
	               break;
	           }
	           //System.out.println("index before "index);
	           String found = input.substring(index+1, index+4);
	           System.out.println(found);
	           index = input.indexOf("abc",index+3);
	           System.out.println("index after updating " + index);
	       }
	   }

	   public void test(){
	       //findAbc("abcd");
	       findAbc("abcabcabcabca");
	   }

	public static void main(String[] args) {
		Test1 obj1 = new Test1();
		obj1.test();
	}

}
