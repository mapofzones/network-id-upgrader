package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.BlocksLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface BlocksLogRepository extends JpaRepository<BlocksLog, String> {
}
