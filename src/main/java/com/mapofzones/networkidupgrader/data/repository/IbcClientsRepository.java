package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.IbcClients;
import com.mapofzones.networkidupgrader.data.entities.keys.IbcClientsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface IbcClientsRepository extends JpaRepository<IbcClients, IbcClientsKey> {
    List<IbcClients> findAllByZone(String zone);
    List<IbcClients> findAllByChainId(String chainId);
}
