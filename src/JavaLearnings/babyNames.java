package JavaLearnings;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import JavaLearnings.StringsSecondAssignments.csvFirstClass;
import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.*;


import edu.duke.*;
import org.apache.commons.csv.*;

public class babyNames {
    
  
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalGirlsNames = 0;
        int totalBoysNames = 0;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            
            if (record.get(1).equals("F")) {
                totalGirlsNames++;
            } else {
                totalBoysNames++;
            }
        }
        
        System.out.println("Total births: " + totalBirths);
        System.out.println("Number of girls names: " + totalGirlsNames);
        System.out.println("Number of boys names: " + totalBoysNames);
        System.out.println("Total names: " + (totalGirlsNames + totalBoysNames));
    }
    

    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource();
        int rank = 0;
        boolean found = false;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                
                if (record.get(0).equals(name)) {
                    found = true;
                    break;
                }
            }
        }
        
        int result;
        if (found) {
            result = rank;
        } else {
            result = -1;
        }

        return result;
    }
    
    public int getDRRank(FileResource fr, String name, String gender)
    {
        
        int rank = 0;
        boolean found = false;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                
                if (record.get(0).equals(name)) {
                    found = true;
                    break;
                }
            }
        }
        
        int result;
        if (found) {
            result = rank;
        } else {
            result = -1;
        }

        return result;
    }
    
    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource();
        int currentRank = 0;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                currentRank++;
                
                if (currentRank == rank) {
                    return record.get(0);
                }
            }
        }
        
        return "NO NAME";
    }
    
  
    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        
        System.out.println(name + " born in " + year + " would be " + newName + " if born in " + newYear + ".");
    }
    
   
    public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int highestRank = Integer.MAX_VALUE;
        int highestRankYear = -1;
        
        for (File f : dr.selectedFiles()) {
        	 FileResource fr = new FileResource(f);
  
            int rank = getDRRank(fr, name, gender);
            int year= Integer.parseInt(f.getName().substring(3, 7));
            
            if (rank != -1 && rank =< highestRank) {
                highestRank = rank;
                highestRankYear = year;
            }
        }
        
        return highestRankYear;
    }
    
    
    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int totalRank = 0;
        int count = 0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            int rank = getDRRank(fr, name, gender);
            int year= Integer.parseInt(f.getName().substring(3, 7));
            
            if (rank != -1) {
              totalRank += rank;
               count++;
            }
        }
        
        if (count > 0) {
        	  return (double) totalRank / count;
        	} else {
        	  return -1;
        	}
    }

    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource();
        int totalBirthsRankedHigher = 0;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                if (record.get(0).equals(name)) {
                    break;
                }
                
                totalBirthsRankedHigher += Integer.parseInt(record.get(2));
            }
        }
        
        return totalBirthsRankedHigher;
    }
    

    public static void main(String[] args) {
        babyNames bn = new babyNames();

        
        
       // bn.totalBirths(fr);
        

       //int rank = bn.getRank(1971, "Frank", "M");
       // System.out.println("Rank of the given name in 2012: " + rank);

      // String name = bn.getName(1982, 450, "M");
       // System.out.println("Name at rank in year: " + name);
        
  
       // bn.whatIsNameInYear("Owen", 1972, 2014, "M");

       // int highestRankYear = bn.yearOfHighestRank("Genevieve", "F");
       // System.out.println("Year with highest rank for name: " + highestRankYear);
        
       // double averageRank = bn.getAverageRank("Robert", "M");
       // System.out.println("Average rank for name: " + averageRank);
       // 
     
       int totalBirthsRankedHigher = bn.getTotalBirthsRankedHigher(1990, "Drew", "M");
       System.out.println("Total births ranked higher than Ethan (M) in 2012: " + totalBirthsRankedHigher);
    }
}

