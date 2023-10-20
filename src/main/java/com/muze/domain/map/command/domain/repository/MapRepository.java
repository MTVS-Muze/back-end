package com.muze.domain.map.command.domain.repository;

import com.muze.domain.map.command.domain.aggregate.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<Map,Long> {
}
