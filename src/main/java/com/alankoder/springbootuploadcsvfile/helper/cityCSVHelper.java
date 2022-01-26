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

import com.alankoder.springbootuploadcsvfile.model.city;

public class cityCSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "city_name", "density" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<city> csvToCity(InputStream is) {
        System.out.println("inside csvToCity");
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<city> listCitys = new ArrayList<city>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            System.out.println("until city for-loop");

            for (CSVRecord csvRecord : csvRecords) {
                city city = new city(
                        csvRecord.get("city_name"),
                        Integer.parseInt(csvRecord.get("density")));

                listCitys.add(city);
            }

            return listCitys;
        } catch (IOException e) {
            System.out.println("had Exception");
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
