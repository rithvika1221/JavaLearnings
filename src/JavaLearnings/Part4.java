package JavaLearnings;

import edu.duke.*;



public class Part4 {

	public void findingYoutube() {
		 URLResource ur = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
		 for (String word : ur.words())
		 {
			 System.out.println(word);
		
			 if (word.toLowerCase().indexOf("youtube.com") != -1)
			 {
				
				 int startIndex= word.indexOf("\"");
				 int endIndex= word.lastIndexOf("\"");
				 System.out.println(word.substring(startIndex, endIndex));
			 }
		 }

	}

	public void testing(){
	this.findingYoutube();

	}

	public static void main(String[] args) {
		Part4 obj1 = new Part4();
		obj1.testing();
	
		

	}
}
