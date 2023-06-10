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

	public CSVRecord hottestHourInFile(CSVParser parser) {

		CSVRecord maxRecord = null;
		for (CSVRecord record : parser) {
			maxRecord = compareRecords(record, maxRecord);

		}
		return maxRecord;
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

	public void testHottestHourInFile() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();

		CSVRecord output = hottestHourInFile(parser);
		System.out
				.println("The hottest temperature was " + output.get("TemperatureF") + " at " + output.get("TimeEST"));
	}

	public void testHottestHourInDirectory() {
		DirectoryResource dr = new DirectoryResource();
		CSVRecord output = hottestHourInDirectory(dr);
		System.out
				.println("The hottest temperature was " + output.get("TemperatureF") + " on " + output.get("DateUTC"));
	}

	public static void main(String[] args) {
		csvMAX obj1 = new csvMAX();
		// obj1.testHottestHourInFile();
		obj1.testHottestHourInDirectory();

	}

}