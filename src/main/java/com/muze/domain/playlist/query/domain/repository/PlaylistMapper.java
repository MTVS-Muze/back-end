package com.muze.domain.playlist.query.domain.repository;

import com.muze.domain.playlist.query.application.dto.PlaylistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaylistMapper {
    List<PlaylistDTO> findAllPlaylist();
    List<PlaylistDTO> findPlaylistByMemberId(Long memberId);

}
