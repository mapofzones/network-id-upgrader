package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.ActiveAddress;
import com.mapofzones.networkidupgrader.data.entities.keys.ActiveAddressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface ActiveAddressesRepository extends JpaRepository<ActiveAddress, ActiveAddressKey> {
    List<ActiveAddress> findAllByZone(String zone);
}
