package com.mapofzones.networkidupgrader.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "network-id-upgrader")
public class NetworkIdUpgraderProperties {
    private String networkIdOld;
    private String networkIdNew;
}
