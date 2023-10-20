package com.muze.domain.map.query.domain.repository;

import com.muze.domain.map.query.application.dto.FindMapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {

    List<FindMapDTO> findAll();
}
