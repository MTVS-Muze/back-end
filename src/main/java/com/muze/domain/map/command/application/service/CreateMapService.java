package com.muze.domain.map.command.application.service;

import com.muze.domain.map.command.application.dto.RequestMapDTO;
import com.muze.domain.map.command.application.dto.ResponseMapDTO;
import com.muze.domain.map.command.domain.aggregate.entity.Map;
import com.muze.domain.map.command.domain.aggregate.vo.MemberVO;
import com.muze.domain.map.command.domain.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMapService {

    private final MapRepository mapRepository;

    @Autowired
    public CreateMapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public ResponseMapDTO createMap(RequestMapDTO createMapDTO) {
        MemberVO memberId = MemberVO.builder().memeberId(createMapDTO.getMemberId()).build();

        Map newMap = mapRepository.save(new Map(memberId, createMapDTO.getData()));

        ResponseMapDTO map = new ResponseMapDTO(
                newMap.getId(),
                newMap.getMemberId().getId(),
                newMap.getData()
        );

        return map;
    }

}