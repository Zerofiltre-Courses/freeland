package tech.zerofiltre.freeland.collab.application.servicecontract;

import tech.zerofiltre.freeland.collab.domain.*;
import tech.zerofiltre.freeland.collab.domain.client.*;
import tech.zerofiltre.freeland.collab.domain.client.model.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;

public class ServiceContractStarter {
    private final ServiceContractProvider serviceContractProvider;
    private final ServiceContractNotificationProvider serviceContractNotificationProvider;
    ServiceContract serviceContract;
    WagePortageAgreement wagePortageAgreement;
    Client client;


    public ServiceContractStarter(ServiceContractProvider serviceContractProvider, ClientProvider clientProvider, WagePortageAgreementProvider wagePortageAgreementProvider, ServiceContractNotificationProvider serviceContractNotificationProvider) {
        this.serviceContractProvider = serviceContractProvider;
        this.serviceContractNotificationProvider = serviceContractNotificationProvider;

        wagePortageAgreement = WagePortageAgreement.builder()
                .wagePortageAgreementProvider(wagePortageAgreementProvider)
                .build();
        client = Client.builder()
                .clientProvider(clientProvider)
                .build();
    }

    public ServiceContract start(WagePortageAgreementId wagePortageAgreementId, ClientId clientId,
                                 String terms, Rate rate) throws StartServiceContractException {
        wagePortageAgreement = wagePortageAgreement
                .of(wagePortageAgreementId)
                .orElseThrow(() -> new StartServiceContractException(
                        "There is no wage portage agreement available for"
                                + wagePortageAgreementId.getAgreementNumber()));

        if (client.of(clientId).isEmpty())
            throw new StartServiceContractException("There is no client available for" + clientId.getSiren());

        serviceContract = ServiceContract.builder()
                .serviceContractProvider(serviceContractProvider)
                .serviceContractNotificationProvider(serviceContractNotificationProvider)
                .wagePortageAgreement(wagePortageAgreement)
                .clientId(clientId)
                .terms(terms)
                .rate(rate)
                .starDate(null)
                .endDate(null)
                .build()
                .start();
        serviceContract.notifyServiceContractStarted();
        return serviceContract;
    }
}
