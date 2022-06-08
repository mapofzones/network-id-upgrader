package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.IbcChannels;
import com.mapofzones.networkidupgrader.data.entities.keys.IbcChannelsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface IbcChannelsRepository extends JpaRepository<IbcChannels, IbcChannelsKey> {
    List<IbcChannels> findAllByZone(String zone);
}
