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

import com.alankoder.springbootuploadcsvfile.model.court;

public class courtCSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "id", "name", "courtCircuitNumber" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<court> csvToCourt(InputStream is) {
        System.out.println("inside csvToCourt");
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<court> listCourts = new ArrayList<court>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            System.out.println("until court for-loop");

            for (CSVRecord csvRecord : csvRecords) {
                court court = new court(
                        Long.parseLong(csvRecord.get("id")),
                        csvRecord.get("name"),
                        Integer.parseInt(csvRecord.get("courtCircuitNumber")));

                listCourts.add(court);
            }

            return listCourts;
        } catch (IOException e) {
            System.out.println("had Exception");
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
