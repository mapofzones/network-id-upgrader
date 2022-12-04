package com.mapofzones.networkidupgrader.services;

import com.google.common.base.Strings;
import com.mapofzones.networkidupgrader.data.entities.*;
import com.mapofzones.networkidupgrader.properties.NetworkIdUpgraderProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.mapofzones.networkidupgrader.data.repository.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Slf4j
@Service
public class UpgradeService {
    private final ZoneRepository zoneRepository;
    private final BlocksLogRepository blocksLogRepository;
    private final IbcClientsRepository ibcClientsRepository;
    private final IbcConnectionsRepository ibcConnectionsRepository;
    private final IbcChannelsRepository ibcChannelsRepository;
    private final TotalTxHourlyStatRepository totalTxHourlyStatRepository;
    private final ZoneParametersRepository zoneParametersRepository;
    private final IBCTransferHourlyStatsRepository ibcTransferHourlyStatsRepository;

    private final NetworkIdUpgraderProperties networkIdUpgraderProperties;

    public UpgradeService(ZoneRepository zoneRepository, NetworkIdUpgraderProperties networkIdUpgraderProperties,
                          BlocksLogRepository blocksLogRepository, IbcClientsRepository ibcClientsRepository,
                          IbcConnectionsRepository ibcConnectionsRepository, IbcChannelsRepository ibcChannelsRepository,
                          TotalTxHourlyStatRepository totalTxHourlyStatRepository, ZoneParametersRepository zoneParametersRepository,
                          IBCTransferHourlyStatsRepository ibcTransferHourlyStatsRepository) {
        this.zoneRepository = zoneRepository;
        this.networkIdUpgraderProperties = networkIdUpgraderProperties;
        this.blocksLogRepository = blocksLogRepository;
        this.ibcClientsRepository = ibcClientsRepository;
        this.ibcConnectionsRepository = ibcConnectionsRepository;
        this.ibcChannelsRepository = ibcChannelsRepository;
        this.totalTxHourlyStatRepository = totalTxHourlyStatRepository;
        this.zoneParametersRepository = zoneParametersRepository;
        this.ibcTransferHourlyStatsRepository = ibcTransferHourlyStatsRepository;
    }

    public void doScript(String[] arguments) throws Exception {
        log.info("-----Service Started.");
        validateNetworkIds();
        upgradeZones();
        upgradeBlocksLog();
        upgradeClientsConnectionsChannels();

        upgradeZoneParameters();
        upgradeIbcTransferHourlyStats();
//        upgradeTokens();
//        upgradeDerivatives();
//        upgradeIbcTransferHourlyCashflow();
//        upgradeTokenPrices();
//        upgradeTotalTxHourlyStats();
//        upgradeActiveAddresses();
//        upgradeZoneNodes();




//        upgradeNodesAddresses();
//        upgradeNodesLCDAddresses();
//        upgradeNodesRPCAddresses();

//        cleanup();

//        temporatyCleanup();


//        upgradeTotalTxHourlyStatsWithActiveAddresses();
        //todo
        log.info("-----Service Finished.");

    }

    @Transactional
    public void upgradeZoneParameters() {
        log.info("?. Start --- Need to create new ZoneParameters based on the old one.");
        List<ZoneParameter> zoneParametersRepositoriesOld = zoneParametersRepository.findAllByZone(networkIdUpgraderProperties.getNetworkIdOld());
        List<ZoneParameter> zoneParametersRepositoriesNew = new ArrayList<>();
        for (ZoneParameter zoneParameter: zoneParametersRepositoriesOld) {
            ZoneParameter value = new ZoneParameter(networkIdUpgraderProperties.getNetworkIdNew());
            value.fillDataFields(zoneParameter);
            zoneParametersRepositoriesNew.add(value);
        }
        zoneParametersRepository.saveAll(zoneParametersRepositoriesNew);
        log.info("?. End --- New ZoneParameters based on the old one created.");
    }

    @Transactional
    public void upgradeIbcTransferHourlyStats() {
        log.info("?. Start --- Need to create new ibcTransferHourlyStats based on the old one.");
        // todo: findAllByZone need to change to findAllBy Zone or ZoneSrc or ZoneDest
        List<IBCTransferHourlyStat> ibcTransferHourlyStatsOld = ibcTransferHourlyStatsRepository.findAllByZone(networkIdUpgraderProperties.getNetworkIdOld());
        List<IBCTransferHourlyStat> ibcTransferHourlyStatsNew = new ArrayList<>();
        for (IBCTransferHourlyStat ibcTransferHourlyStat: ibcTransferHourlyStatsOld) {
            IBCTransferHourlyStat value = new IBCTransferHourlyStat(networkIdUpgraderProperties.getNetworkIdNew());
            value.fillDataFields(ibcTransferHourlyStat);
            ibcTransferHourlyStatsNew.add(value);
        }
        ibcTransferHourlyStatsRepository.saveAll(ibcTransferHourlyStatsNew);
        log.info("?. End --- New ibcTransferHourlyStats based on the old one created.");
    }

//    @Transactional
//    public void temporatyCleanup() throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.setTimeZone(TimeZone.getTimeZone("UTC"));
////        Date date = format.parse("2014-01-30 07:48:25");
//        Date date = format.parse("2022-05-25 17:00:00");
////        LocalDateTime date = format.parse("2022-05-25 17:00:00");
//        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
////        long l = totalTxHourlyStatRepository.deleteByZoneAndHourBefore(networkIdUpgraderProperties.getNetworkIdNew(), ldt);
//        TotalTxHourlyStat stat = null;
//        do {
//            stat = totalTxHourlyStatRepository.findTopByZoneAndHourBefore(networkIdUpgraderProperties.getNetworkIdNew(), ldt);
//            log.info(String.valueOf(stat));
//            totalTxHourlyStatRepository.delete(stat);
//            log.info("deleted");
//        } while (stat != null);
//
//
//
//
////        long l = totalTxHourlyStatRepository.removeByZoneAndHourBefore(networkIdUpgraderProperties.getNetworkIdNew(), ldt);
////        log.info("deleted: " + l);
//    }

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

    @Transactional
    public void validateOldNetworkIdHasZone() throws Exception {
        Optional<Zone> zone = zoneRepository.findById(networkIdUpgraderProperties.getNetworkIdOld());
        if (zone.isEmpty()) {
            String message = "No zones were found for the specified \"" + networkIdUpgraderProperties.getNetworkIdOld() +
                    "\" network-id from which to migrate.";
            log.error(message);
            throw new Exception(message);
        }
    }

    @Transactional
    public void upgradeZones() {
        Optional<Zone> zoneNewResult = zoneRepository.findById(networkIdUpgraderProperties.getNetworkIdNew());
        Optional<Zone> zoneOldResult = zoneRepository.findById(networkIdUpgraderProperties.getNetworkIdOld());
        Zone zoneOld = zoneOldResult.get(); //validated before
        if (zoneNewResult.isPresent()) {
            log.info("1. Start - Need to merge old zone with new one.");
            Zone zoneNew = zoneNewResult.get();
            zoneNew.fillDefaultFields(zoneOld);
            zoneRepository.save(zoneNew);
            log.info("1. End - Old zone successfully merged to the new one.");
        }
        else {
            log.info("1. Start - Need to create new zone based on the old one.");
            Zone zoneNew = new Zone(networkIdUpgraderProperties.getNetworkIdNew());
            zoneNew.fillDefaultFields(zoneOld);
            zoneRepository.save(zoneNew);
            log.info("1. End - New zone successfully created.");
        }
    }

    @Transactional
    public void upgradeBlocksLog() {
        Optional<BlocksLog> blocksLogNewResult = blocksLogRepository.findById(networkIdUpgraderProperties.getNetworkIdNew());
        Optional<BlocksLog> blocksLogOldResult = blocksLogRepository.findById(networkIdUpgraderProperties.getNetworkIdOld());
        if (blocksLogNewResult.isPresent())
            log.warn("2. Start + End --- Blocks log for new zone already exists! ---");
        else {
            if (blocksLogOldResult.isEmpty()) {
                log.error("2. Start + End --- The old blocks log does not exist! ---");
            } else {
                log.info("2. Start - Need to create new blocks_log based on the old one.");
                BlocksLog blocksLogNew = new BlocksLog(networkIdUpgraderProperties.getNetworkIdNew());
                blocksLogNew.fillDataFields(blocksLogOldResult.get());
                blocksLogRepository.save(blocksLogNew);
                log.info("2. End - New blocks_log successfully created.");
            }
        }
    }

    private void upgradeClientsConnectionsChannels() {
        log.info("3. Start - Need to duplicate new ibc_clients & ibc_connections & ibc_channels based on the old one.");
        upgradeClients();
        upgradeConnections();
        upgradeChannels();
        log.info("3. End - New ibc_clients & ibc_connections & ibc_channels successfully created.");
    }

    private void upgradeClients() {
        addNewZoneClients();
        upgradeAllClientsCounterparties();
    }

    @Transactional
    public void addNewZoneClients() {
        List<IbcClients> ibcClientsOld = ibcClientsRepository.findAllByZone(networkIdUpgraderProperties.getNetworkIdOld());
        if (CollectionUtils.isEmpty(ibcClientsOld)) {
            log.info("3.1. Start + End - Not found any old ibc_clients.");
            return;
        }
        log.info("3.1. Start - Need to duplicate new ibc_clients based on the old one.");
        List<IbcClients> ibcClientsNew = new ArrayList<>();
        for (IbcClients clientOld : ibcClientsOld) {
            IbcClients clientNew = new IbcClients(networkIdUpgraderProperties.getNetworkIdNew());
            clientNew.fillDataFields(clientOld);
            ibcClientsNew.add(clientNew);
        }
        ibcClientsRepository.saveAll(ibcClientsNew);
        log.info("3.1. End - New ibc_clients successfully created.");
    }

    @Transactional
    public void upgradeAllClientsCounterparties() {
        log.info("3.2. Start - Update counterparty Chain_id for ibc_clients.");
        List<IbcClients> clients = ibcClientsRepository.findAllByChainId(networkIdUpgraderProperties.getNetworkIdOld());
        for (IbcClients client : clients)
            client.setChainId(networkIdUpgraderProperties.getNetworkIdNew());
        ibcClientsRepository.saveAll(clients);
        log.info("3.2. End - Counterparty chain_id for ibc_clients successfully updated.");
    }

    @Transactional
    public void upgradeConnections() {
        List<IbcConnections> ibcConnectionsOld = ibcConnectionsRepository.findAllByZone(networkIdUpgraderProperties.getNetworkIdOld());
        if (CollectionUtils.isEmpty(ibcConnectionsOld)) {
            log.info("3.3. Start + End - Not found any old ibc_connections.");
            return;
        }
        log.info("3.3. Start - Need to duplicate new ibc_connections based on the old one.");
        List<IbcConnections> ibcConnectionsNew = new ArrayList<>();
        for (IbcConnections connectionOld : ibcConnectionsOld) {
            IbcConnections connectionNew = new IbcConnections(networkIdUpgraderProperties.getNetworkIdNew());
            connectionNew.fillDataFields(connectionOld);
            ibcConnectionsNew.add(connectionNew);
        }
        ibcConnectionsRepository.saveAll(ibcConnectionsNew);
        log.info("3.3. End - New ibc_connections successfully created.");
    }

    @Transactional
    public void upgradeChannels() {
        List<IbcChannels> ibcChannelsOld = ibcChannelsRepository.findAllByZone(networkIdUpgraderProperties.getNetworkIdOld());
        if (CollectionUtils.isEmpty(ibcChannelsOld)) {
            log.info("3.4. Start + End - Not found any old ibc_channels.");
            return;
        }
        log.info("3.4. Start - Need to duplicate new ibc_channels based on the old one.");
        List<IbcChannels> ibcChannelsNew = new ArrayList<>();
        for (IbcChannels channelOld : ibcChannelsOld) {
            IbcChannels channelNew = new IbcChannels(networkIdUpgraderProperties.getNetworkIdNew());
            channelNew.fillDataFields(channelOld);
            ibcChannelsNew.add(channelNew);
        }
        ibcChannelsRepository.saveAll(ibcChannelsNew);
        log.info("3.4. End - New ibc_channels successfully created.");
    }

    private void upgradeTotalTxHourlyStatsWithActiveAddresses() throws Exception {
        if (isTimestampCollisionExists()) {
            //todo old data = old data + new data;  remove old data with collision
            throw new Exception();
        }
        upgradeTotalTxHourlyStats();
        //active_addresses will be uptated cascadingly
        //todo
    }

    private boolean isTimestampCollisionExists() {
        long numberOfMergeCollisions = totalTxHourlyStatRepository.countMergeCollisions(
                networkIdUpgraderProperties.getNetworkIdOld(),
                networkIdUpgraderProperties.getNetworkIdNew()
        );
        log.info("4.1. The number of merge collisions " + numberOfMergeCollisions + ". Needs to be merged.");
        return numberOfMergeCollisions > 0;
    }

    /**
     * non-transactional!
     */
    private void upgradeTotalTxHourlyStats() {
        List<TotalTxHourlyStat> stats = totalTxHourlyStatRepository.findAllByZone(networkIdUpgraderProperties.getNetworkIdOld());
        log.info("4.2. Need to upgrade " + stats.size() + " total_tx_hourly_stat.");
        int i = 1;
//        for (TotalTxHourlyStat stat : stats) {
//            stat.setZone(networkIdUpgraderProperties.getNetworkIdNew());
//            log.info("4.2. Prepare to upgrade " + i + "th total_tx_hourly_stat.");
//            totalTxHourlyStatRepository.save(stat);
//            i++;
//        }
//        log.info("4.2. All " + stats.size() + " total_tx_hourly_stat successfully upgraded.");
    }
}
