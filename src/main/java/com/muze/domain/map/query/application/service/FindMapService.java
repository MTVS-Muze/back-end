package com.muze.domain.map.query.application.service;

import com.muze.domain.map.query.application.dto.FindMapDTO;
import com.muze.domain.map.query.application.dto.FindResponseDTO;
import com.muze.domain.map.query.domain.repository.MapMapper;
import com.muze.domain.map.query.domain.service.CsvFileService;
import com.muze.domain.map.query.infra.service.MemberRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

import java.util.List;

@Service
public class FindMapService {

    private final MapMapper mapMapper;

    private final CsvFileService csvFileService;

    private final MemberRequestService memberRequestService;

    @Autowired
    public FindMapService(MapMapper mapMapper, CsvFileService csvFileService, MemberRequestService memberRequestService) {
        this.mapMapper = mapMapper;
        this.csvFileService = csvFileService;
        this.memberRequestService=memberRequestService;
    }


    public List<FindMapDTO> findAll(){
        return mapMapper.findAll();
    }

    public FindMapDTO findById(Long id){
        FindMapDTO map = mapMapper.findById(id);
        map.setMemberId(memberRequestService.findMemberById(Long.valueOf(map.getMemberId())).getName());
        return map;
    }
}
