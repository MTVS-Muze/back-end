package com.muze.domain.map.query.application.controller;

import com.muze.domain.map.query.application.dto.FindMapDTO;
import com.muze.domain.map.query.application.dto.FindResponseDTO;
import com.muze.domain.map.query.application.service.FindMapService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/map")
public class FindMapController {

    private final FindMapService findMapService;

    @Autowired
    public FindMapController(FindMapService findMapService) {
        this.findMapService = findMapService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<FindMapDTO>> findAll(){
        List<FindMapDTO> maps =findMapService.findAll();
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindMapDTO> findById(@PathVariable Long id){
        FindMapDTO findMap = findMapService.findById(id);
        return new ResponseEntity<>(findMap,HttpStatus.OK);
    }



//    @GetMapping("/test")
//    public ResponseEntity<Resource> test() {
//
//
//        String body = "번호,이름,나이\n1,Williams,28\n2,Smith,99\n3,Brown,55";
//
//        List<List<String>> csvBody = parseCSV(body);
//
//        ByteArrayInputStream byteArrayOutputStream;
//
//        try (
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
//        ){
//            CSVPrinter csvPrinter = new CSVPrinter(new PrintStream(out), CSVFormat.DEFAULT);
//            for (List<String> record : csvBody){
//                csvPrinter.printRecord(record);
//            }
//            csvPrinter.flush();
//            byteArrayOutputStream = new ByteArrayInputStream(out.toByteArray());
//
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//
//        InputStreamResource fileInputStream = new InputStreamResource(byteArrayOutputStream);
//
//        String csvFileName = "people.csv";
//
//        //Http 헤더설정
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + csvFileName);
//
//        //Content Type 설정(text/csv)
//        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");
//
//        return new ResponseEntity<Resource>(fileInputStream,headers,HttpStatus.OK);
//    }
//
//    public static List<List<String>> parseCSV(String csvString) {
//        List<List<String>> csvBody = new ArrayList<>();
//        String[] lines = csvString.split("\n");
//        for (String line : lines) {
//            String[] fields = line.split(",");
//            List<String> row = new ArrayList<>(Arrays.asList(fields));
//            csvBody.add(row);
//        }
//        return csvBody;
//    }

}
