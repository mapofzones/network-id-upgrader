package com.mapofzones.networkidupgrader;

import com.google.common.base.Strings;
import com.mapofzones.networkidupgrader.data.entities.Zone;
import com.mapofzones.networkidupgrader.properties.NetworkIdUpgraderProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.mapofzones.networkidupgrader.data.repository.*;

import java.util.Optional;

@Slf4j
@Service
public class UpgradeService {
    private final ZoneRepository zoneRepository;
    private final NetworkIdUpgraderProperties networkIdUpgraderProperties;

    public UpgradeService(ZoneRepository zoneRepository, NetworkIdUpgraderProperties networkIdUpgraderProperties) {
        this.zoneRepository = zoneRepository;
        this.networkIdUpgraderProperties = networkIdUpgraderProperties;
    }

    public void doScript(String[] arguments) throws Exception {
        log.info("-----Service Started.");
        validateNetworkIds();
        mergeZones();
        //todo
        log.info("-----Service Finished.");

    }

    private void mergeZones() {
        Optional<Zone> zone = zoneRepository.findById(networkIdUpgraderProperties.getNetworkIdNew());
        if (zone.isPresent()) {
            log.info("Need to merge old zone with new one.");
            //todo
        }
        else {
            log.info("Need to create new zone based on the old one.");
            //todo
        }
    }

    private void validateNetworkIds() throws Exception {
        validateNetworkIdsIsNotEmptyOrNull();
        validateOldNetworkIdHasZone();
    }

    private void validateNetworkIdsIsNotEmptyOrNull() throws Exception {
        if (Strings.isNullOrEmpty(networkIdUpgraderProperties.getNetworkIdOld()) ||
        Strings.isNullOrEmpty(networkIdUpgraderProperties.getNetworkIdNew())) {
            String message = "Need to specify old network-id & new network-id!";
            log.error(message);
            throw new Exception(message);
        } else {
            String message = "Starting upgrade from \"" + networkIdUpgraderProperties.getNetworkIdOld() +
                    "\" to \"" + networkIdUpgraderProperties.getNetworkIdNew() + "\".";
            log.info(message);
        }
    }

    private void validateOldNetworkIdHasZone() throws Exception {
        Optional<Zone> zone = zoneRepository.findById(networkIdUpgraderProperties.getNetworkIdOld());
        if (zone.isEmpty()) {
            String message = "No zones were found for the specified \"" + networkIdUpgraderProperties.getNetworkIdOld() +
                    "\" network-id from which to migrate.";
            log.error(message);
            throw new Exception(message);
        }
    }
}
