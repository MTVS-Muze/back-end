package com.muze.domain.mapinplaylist.query.domain.repository;

import com.muze.domain.mapinplaylist.query.application.dto.MapInPlaylistInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapInPlaylistMapper {
    List<MapInPlaylistInfoDTO> findMapByPlaylistId(Long Id);
}
