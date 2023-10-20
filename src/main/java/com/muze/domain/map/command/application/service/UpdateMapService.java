package com.muze.domain.map.command.application.service;

import com.muze.domain.map.command.application.dto.RequestMapDTO;
import com.muze.domain.map.command.application.dto.ResponseMapDTO;
import com.muze.domain.map.command.domain.aggregate.entity.Map;
import com.muze.domain.map.command.domain.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateMapService {

    private final MapRepository mapRepository;

    @Autowired
    public UpdateMapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Transactional
    public boolean updateMap(RequestMapDTO updateMapDTO){
        Optional<Map> beforeMap = mapRepository.findById(updateMapDTO.getId());
        if(beforeMap.isPresent()){
            Map afterMap = beforeMap.get();

            if(!updateMapDTO.getData().isEmpty()){
                afterMap.setData(updateMapDTO.getData());
            }
            return true;
        }
        return false;
    }
}
