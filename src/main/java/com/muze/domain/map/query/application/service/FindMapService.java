package com.muze.domain.map.query.application.service;

import com.muze.domain.map.query.application.dto.FindMapDTO;
import com.muze.domain.map.query.application.dto.FindResponseDTO;
import com.muze.domain.map.query.domain.repository.MapMapper;
import com.muze.domain.map.query.domain.service.CsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

import java.util.List;

@Service
public class FindMapService {

    private final MapMapper mapMapper;

    private final CsvFileService csvFileService;

    @Autowired
    public FindMapService(MapMapper mapMapper, CsvFileService csvFileService) {
        this.mapMapper = mapMapper;
        this.csvFileService = csvFileService;
    }


    public List<FindMapDTO> findAll(){
        return mapMapper.findAll();
    }

    public FindResponseDTO findById(Long id){
        FindMapDTO findMap = mapMapper.findById(id);
        InputStreamResource mapFile = csvFileService.stringToCsv(findMap.getData(), findMap.getTitle());
        return new FindResponseDTO(new FindMapDTO(findMap.getId(), findMap.getMemberId(),
                findMap.getTitle(), findMap.getSong(), findMap.getData(),findMap.getCreatedDate()),mapFile);
    }
    public FindMapDTO findByIdTest(Long id){
        return mapMapper.findById(id);
    }
}
