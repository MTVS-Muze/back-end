package com.muze.domain.mapinplaylist.command.domain.repository;

import com.muze.domain.mapinplaylist.command.domain.aggregate.entity.MapInPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapInPlaylistRepository extends JpaRepository<MapInPlaylist, Long> {
    void deleteAllByPlaylistId_Id(Long id);
}
