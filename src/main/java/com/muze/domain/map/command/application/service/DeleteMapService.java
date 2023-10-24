package com.muze.domain.map.command.application.service;

import com.muze.domain.map.command.application.dto.RequestMapDTO;
import com.muze.domain.map.command.domain.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMapService {

    private final MapRepository mapRepository;

    @Autowired
    public DeleteMapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public void deleteMap(RequestMapDTO deleteMapDTO){
        mapRepository.deleteById(deleteMapDTO.getId());
    }
}
