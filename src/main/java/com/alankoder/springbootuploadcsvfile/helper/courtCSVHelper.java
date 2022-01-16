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

import com.alankoder.springbootuploadcsvfile.model.courtCourt;

public class courtCSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "name", "courtCircuitNumber" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<courtCourt> csvToCourt(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<courtCourt> listCourts = new ArrayList<courtCourt>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                courtCourt court = new courtCourt(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("name"),
                        Integer.parseInt(csvRecord.get("courtCircuitNumber")));

                listCourts.add(court);
            }

            return listCourts;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
