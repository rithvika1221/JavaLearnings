package JavaLearnings.StringsSecondAssignments;

import edu.duke.*;
import org.apache.commons.csv.*;

public class csvFirstClass {
	
	public int numberOfExporters(CSVParser parser, String exportItem) {
	    int count = 0;
	    for (CSVRecord record : parser) {
	        String exports = record.get("Exports");
	        if (exports.contains(exportItem)) {
	            count++;
	        }
	    }
	    return count;
	}

	public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
	    for (CSVRecord record : parser) {
	        String exports = record.get("Exports");
	        if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
	            String country = record.get("Country");
	            System.out.println(country);
	        }
	    }
	}
	
	public String countryInfo(CSVParser parser, String country) {
		for (CSVRecord record : parser) {
			
			String export = record.get("Country");
			
			if (export.contains(country))
			{
				String exports = record.get("Exports");
	            String value = record.get("Value (dollars)");
	            String returnValue = country + ": " + exports + ": " + value;
	            return returnValue;
			}
			
			
		}
		return "Not Found";
	}
	
	public void bigExporters(CSVParser parser, String amount) {
	    for (CSVRecord record : parser) {
	        String country = record.get("Country");
	        String value = record.get("Value (dollars)");
	        if (value.length() > amount.length()) {
	            System.out.println(country + " " + value);
	        }
	    }
	}
	
	
	
	
	public void tester() {
		
		
	
		
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		//System.out.println(countryInfo(parser, "Nauru"));
		
	//String amount = "$999,999,999";
	//bigExporters(parser, amount);
		
	//parser = fr.getCSVParser();
	//listExportersTwoProducts(parser, "cotton", "flowers");
		
	//parser = fr.getCSVParser();
	//System.out.println(numberOfExporters(parser, "cocoa"));
	
	}
	
	
	
	public static void main(String[] args)
	{
		csvFirstClass obj1 = new csvFirstClass();
		obj1.tester();
	}
}


