package com.muze.domain.map.query.domain.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CsvFileService {


    public InputStreamResource stringToCsv(String text, String fileName) {

        List<List<String>> csvBody = parseCSV(text);
        ByteArrayInputStream byteArrayOutputStream;

        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            CSVPrinter csvPrinter = new CSVPrinter(new PrintStream(out), CSVFormat.DEFAULT);
            for (List<String> record : csvBody) {
                csvPrinter.printRecord(record);
            }
            csvPrinter.flush();
            byteArrayOutputStream = new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        InputStreamResource fileInputStream = new InputStreamResource(byteArrayOutputStream);

//        String csvFileName = fileName+".csv";

        return fileInputStream;
    }

    private static List<List<String>> parseCSV(String csvString) {
        List<List<String>> csvBody = new ArrayList<>();
        String[] lines = csvString.split("\r\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            csvBody.add(Arrays.asList(fields));
        }
        return csvBody;
    }
}
