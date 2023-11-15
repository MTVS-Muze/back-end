package com.muze.domain.map.query.application.controller;

import com.muze.domain.map.command.application.dto.ResponseMapDTO;
import com.muze.domain.map.query.application.dto.FindMapDTO;
import com.muze.domain.map.query.application.dto.FindResponseDTO;
import com.muze.domain.map.query.application.service.FindMapService;
import com.muze.global.security.principal.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag(name = "Map Query Controller")
@RestController
@RequestMapping("/map/find")
public class FindMapController {

    private final FindMapService findMapService;

    @Autowired
    public FindMapController(FindMapService findMapService) {
        this.findMapService = findMapService;
    }


    @Operation(summary = "Map 전체 조회", description = "모든 Media Art 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "전체 조회 성공",
                    content = {@Content(
                            array = @ArraySchema(
                                    schema = @Schema(
                                            name = "maps",
                                            oneOf = {
                                                    FindMapDTO.class,
                                                    FindMapDTO.class,
                                                    FindMapDTO.class
                                            })
                            ))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<List<FindMapDTO>> findAll() {
        List<FindMapDTO> maps = findMapService.findAll();
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

    @Operation(summary = "Map 상세 조회", description = "Id로 Media Art 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "상세 조회 성공",
                    content = @Content(
                            schema = @Schema(implementation = FindMapDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<FindMapDTO> findById(@PathVariable Long id) {
        FindMapDTO findMap = findMapService.findById(id);
        return new ResponseEntity<>(findMap, HttpStatus.OK);
    }

    @Operation(summary = "내가 만든 Map 조회", description = "토큰 정보로 내가 만든 Media Art 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "나의 Map 조회 성공",
                    content = {@Content(
                            array = @ArraySchema(
                                    schema = @Schema(
                                            name = "My maps",
                                            oneOf = {
                                                    FindMapDTO.class,
                                                    FindMapDTO.class,
                                            })
                            ))
                    })
    })
    @GetMapping("/member")
    public ResponseEntity<List<FindMapDTO>> findByMemberId(@Parameter(hidden = true) @AuthenticationPrincipal UserPrincipal userPrincipal){
        Long memberId = userPrincipal.getId();
        List<FindMapDTO> maps = findMapService.findByMemberId(memberId);
        return new ResponseEntity<>(maps, HttpStatus.OK);
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
