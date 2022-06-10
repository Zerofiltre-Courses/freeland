package tech.zerofiltre.freeland.collab.domain.servicecontract.model;

import tech.zerofiltre.freeland.collab.domain.*;

import java.util.*;

public class ServiceContractStarted extends ServiceContractEvent{
    public ServiceContractStarted(long serviceContractNumber, String clientName, String clientSiren, String freelancerName, String freelancerSiren, String agencyName, String agencySiren, float rateValue, Rate.Frequency rateFrequency, Rate.Currency rateCurrency, float serviceFeesRate, Date startDate) {
        super(serviceContractNumber, clientName, clientSiren, freelancerName, freelancerSiren, agencyName, agencySiren, rateValue, rateFrequency, rateCurrency, serviceFeesRate, startDate);
    }
}
