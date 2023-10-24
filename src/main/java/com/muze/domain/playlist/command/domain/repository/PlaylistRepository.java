package com.muze.domain.playlist.command.domain.repository;

import com.muze.domain.playlist.command.domain.aggregate.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
}
