package JavaLearnings;

import edu.duke.*;
import java.io.*;
import java.io.File;
import java.lang.*;

public class PerimeterAssignmentRunner {
	
    public double getPerimeter (Shape s) {
        
        double totalPerim = 0.0;
      
        Point prevPt = s.getLastPoint();
     
        for (Point currPt : s.getPoints()) {
            
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
           
            prevPt = currPt;
        }
    
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
    	 int count = 0;
    	 for (Point currPt : s.getPoints()) 
    	 {
    		 count++;
             
         }
        return count;
    }

    public double getAverageLength(Shape s) {
    	double totalCount =0;
    	
    	 Point prevPt = s.getLastPoint();
         
         for (Point currPt : s.getPoints()) {
        	
          
             double currDist = prevPt.distance(currPt);
            
             totalCount = totalCount + currDist;
           
             prevPt = currPt;
         }
        return totalCount/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
    	
    	double largestSide = 0; 
    	Point prevPt = s.getLastPoint();
    	for (Point currPt : s.getPoints()) 
   	    {
    		double currDist = prevPt.distance(currPt);
            
            largestSide = Math.max(currDist, largestSide);
            
            
          
            prevPt = currPt;
   		   
        }
        return largestSide;
    }

    public double getLargestX(Shape s) 
    {
      
    	
    	double largestX = 0; 
    	Point prevPt = s.getLastPoint();
    	for (Point currPt : s.getPoints()) 
   	    {
 
            
            largestX = Math.max(currPt.getX(), largestX);
          
          
            prevPt = currPt;
   		   
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
     DirectoryResource d = new DirectoryResource();
     double largestPerimeter = 0;
     String largestPermFile;
    	for(File f : d.selectedFiles())
    	{
    		  FileResource fr = new FileResource(f);
    		  Shape s = new Shape(fr);
    		  if (getPerimeter(s)>largestPerimeter)
    		  {
    			  largestPerimeter= getPerimeter(s);
    			  largestPermFile = f.getName();
    		  }
    	 
    	}
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
    
    	 DirectoryResource d = new DirectoryResource();
         double largestPerimeter = 0;
         String largestPermFile = "";
        	for(File f : d.selectedFiles())
        	{
        		  FileResource fr = new FileResource(f);
        		  Shape s = new Shape(fr);
        		  if (getPerimeter(s)>largestPerimeter)
        		  {
        			  largestPerimeter= getPerimeter(s);
        			  largestPermFile = f.getName();
        		  }
        	 
        	}
            return largestPermFile;
    }

    public void testPerimeter () {
    	
    	FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        double avLength = getAverageLength(s);
        double lSide = getLargestSide(s);
        double lX = getLargestX(s);
        
        System.out.println("perimeter = " + length);
        System.out.println("NumPoints = " + points);
        System.out.println("AverageLength = " + avLength);
        System.out.println("LargestSide = " + lSide);
        System.out.println("LargestPoint = " + lX);
    	
    }
    
    
    public void testPerimeterMultipleFiles() {
    	double lPerimeter = getLargestPerimeterMultipleFiles();
    	System.out.println("LargestPerimeter = " + lPerimeter);
    	String lFile = getFileWithLargestPerimeter();
    	System.out.println("LargestPerimeterFile = " + lFile);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
       PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
       pr.testPerimeter();
       pr.testPerimeterMultipleFiles();
    }
}
