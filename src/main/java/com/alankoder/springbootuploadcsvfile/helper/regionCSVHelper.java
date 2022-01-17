package com.alankoder.springbootuploadcsvfile.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.alankoder.springbootuploadcsvfile.model.regionState;

public class regionCSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "id", "state_name", /* "state_id", */ "growth" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<regionState> csvToRegion(InputStream is) {
        System.out.println("inside csvToRegion");
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<regionState> listRegions = new ArrayList<regionState>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            System.out.println("until region for-loop");

            for (CSVRecord csvRecord : csvRecords) {
                regionState region = new regionState(
                        csvRecord.get("state_name"),
                        /* csvRecord.get("state_id"), */
                        Double.parseDouble(csvRecord.get("growth")));

                listRegions.add(region);
            }

            return listRegions;
        } catch (IOException e) {
            System.out.println("had Exception");
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
