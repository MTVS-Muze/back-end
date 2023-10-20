package com.muze.domain.map.query.application.service;

import com.muze.domain.map.query.application.dto.FindMapDTO;
import com.muze.domain.map.query.domain.repository.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindMapService {

    private final MapMapper mapMapper;

    @Autowired
    public FindMapService(MapMapper mapMapper) {
        this.mapMapper = mapMapper;
    }

    public List<FindMapDTO> findAll(){
        return mapMapper.findAll();
    }
}
