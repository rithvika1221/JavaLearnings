package JavaLearnings;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import JavaLearnings.StringsSecondAssignments.csvFirstClass;
import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class csvMAX {

  public CSVRecord compareRecords(CSVRecord record, CSVRecord maxRecord) {
    if (maxRecord == null) {
      maxRecord = record;
    } else {
      double currTemp = Double.parseDouble(record.get("TemperatureF"));
      double maxTemp = Double.parseDouble(maxRecord.get("TemperatureF"));

      if (currTemp > maxTemp) {
        maxRecord = record;
      }
    }

    return maxRecord;

  }

  public CSVRecord comparelowRecords(CSVRecord record, CSVRecord lowRecord, String element) {
    if (lowRecord == null) {
      lowRecord = record;
    } else {
      if (record.get(element) != "N/A") {
        double curValue = Double.parseDouble(record.get(element));
        double minValue = Double.parseDouble(lowRecord.get(element));
        if (element == "TemperatureF")

        {
          if (curValue < minValue && minValue != -9999) {
            lowRecord = record;
          }

        }

        if (element == "Humidity")

        {
          if (curValue < minValue) {
            lowRecord = record;
          }

        }

      }
    }

    return lowRecord;

  }

  public CSVRecord hottestHourInFile(CSVParser parser) {

    CSVRecord maxRecord = null;
    for (CSVRecord record : parser) {
      maxRecord = compareRecords(record, maxRecord);

    }
    return maxRecord;
  }

  public CSVRecord LowestHumidityInFile(CSVParser parser) {

    CSVRecord minRecord = null;
    for (CSVRecord record : parser) {
      minRecord = comparelowRecords(record, minRecord, "Humidity");

    }
    return minRecord;
  }

  public CSVRecord coldestHourInFile(CSVParser parser) {

    CSVRecord minRecord = null;
    for (CSVRecord record : parser) {
      minRecord = comparelowRecords(record, minRecord, "TemperatureF");

    }
    return minRecord;
  }

  public CSVRecord hottestHourInDirectory(DirectoryResource dr) {

    CSVRecord maxRecord = null;

    for (File file : dr.selectedFiles()) {

      FileResource fr = new FileResource(file);

      CSVParser parser = fr.getCSVParser();

      CSVRecord record = hottestHourInFile(parser);

      maxRecord = compareRecords(record, maxRecord);

    }
    return maxRecord;

  }

  public String coldestFileInDirectory(DirectoryResource dr) {

    CSVRecord minRecord = null;
    String fileName = null;
    String answer = null;

    for (File file : dr.selectedFiles()) {

      FileResource fr = new FileResource(file);

      CSVParser parser = fr.getCSVParser();

      CSVRecord record = coldestHourInFile(parser);

      if (minRecord == null) {
        minRecord = record;
      } else {
        double currTemp = Double.parseDouble(record.get("TemperatureF"));
        double minTemp = Double.parseDouble(minRecord.get("TemperatureF"));

        if (currTemp < minTemp && minTemp != -9999) {
          minRecord = record;
          fileName = file.getName();
        }
      }
    answer = ("The coldest temperature was " + minRecord.get("TemperatureF") + " at " + minRecord.get("DateUTC")+ "in the file" + fileName);
  
      
    }
    
  
    return answer ;
    

  }

  public CSVRecord lowestHumidityInManyFiles() {
    CSVRecord minRecord = null;
    DirectoryResource dr = new DirectoryResource();

    for (File file : dr.selectedFiles()) {
      FileResource fr = new FileResource(file);
      CSVParser parser = fr.getCSVParser();

      for (CSVRecord record : parser) {
        if (minRecord == null) {
          minRecord = record;
        } else {
          double humidity = Double.parseDouble(record.get("Humidity"));
          double minHumidity = Double.parseDouble(minRecord.get("Humidity"));

          if (humidity < minHumidity) {
            minRecord = record;
          }
        }
      }
    }

    return minRecord;
  }

  public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
    double sum = 0.0;
    int count = 0;

    for (CSVRecord record : parser) {
      double temperature = Double.parseDouble(record.get("TemperatureF"));
      double humidity = Double.parseDouble(record.get("Humidity"));

      if (humidity >= value) {
        sum += temperature;
        count++;
      }
    }

    return sum / count;
  }

  public double averageTemperatureInFile(CSVParser parser) {
    double sum = 0.0;
    int count = 0;

    for (CSVRecord record : parser) {
      double temperature = Double.parseDouble(record.get("TemperatureF"));
      sum += temperature;
      count++;
    }

    return sum / count;
  }

  public void testAverageTemperatureWithHighHumidityInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();

    int humidityValue = 80;
    double averageTemp = averageTemperatureWithHighHumidityInFile(parser, humidityValue);

    System.out.println(
        "Average temperature when humidity is greater than or equal to " + humidityValue + ": " + averageTemp);
  }

  public void testLowestHumidityInManyFiles() {
    CSVRecord output = lowestHumidityInManyFiles();
    System.out.println("Lowest humidity was " + output.get("Humidity") + " at " + output.get("DateUTC"));
  }

  public void testHottestHourInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();

    CSVRecord output = hottestHourInFile(parser);
    System.out
        .println("The hottest temperature was " + output.get("TemperatureF") + " at " + output.get("TimeEST"));
  }

  public void testColdestHourInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();

    CSVRecord output = coldestHourInFile(parser);
    System.out.println("The coldest temperature was " + output.get("TemperatureF") + " at " + output.get("DateUTC"));
  }

  public void testAverageTemperatureInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();

    double averageTemp = averageTemperatureInFile(parser);
    System.out.println("Average temperature in the file is: " + averageTemp);
  }

  public void testLowestHumidityInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();

    CSVRecord output = LowestHumidityInFile(parser);
    System.out.println("The lowest humidity was " + output.get("Humidity") + " at " + output.get("DateUTC"));
  }

  public void testHottestHourInDirectory() {
    DirectoryResource dr = new DirectoryResource();
    CSVRecord output = hottestHourInDirectory(dr);
    System.out
        .println("The hottest temperature was " + output.get("TemperatureF") + " on " + output.get("DateUTC"));
  }

  public void testColdestFileInDirectory() {
    DirectoryResource dr = new DirectoryResource();
    String output = coldestFileInDirectory(dr);
    System.out.println("The file with the coldest temperature was called " + output);
  }

  public static void main(String[] args) {
    csvMAX obj1 = new csvMAX();
    // obj1.testHottestHourInFile();
    // obj1.testHottestHourInDirectory();
     //obj1.testColdestHourInFile();
    //obj1.testColdestFileInDirectory();
    // obj1.testLowestHumidityInFile();
    // obj1.testLowestHumidityInManyFiles();
    //obj1.testAverageTemperatureInFile();
    obj1.testAverageTemperatureWithHighHumidityInFile();
  }

}