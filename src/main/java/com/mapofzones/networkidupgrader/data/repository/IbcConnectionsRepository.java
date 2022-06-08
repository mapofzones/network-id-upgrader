package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.IbcConnections;
import com.mapofzones.networkidupgrader.data.entities.keys.IbcConnectionsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface IbcConnectionsRepository extends JpaRepository<IbcConnections, IbcConnectionsKey> {
    List<IbcConnections> findAllByZone(String zone);
}
