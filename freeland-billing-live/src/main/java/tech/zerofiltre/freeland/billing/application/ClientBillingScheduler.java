package tech.zerofiltre.freeland.billing.application;

import tech.zerofiltre.freeland.billing.domain.*;
import tech.zerofiltre.freeland.billing.domain.agency.*;
import tech.zerofiltre.freeland.billing.domain.agency.model.*;
import tech.zerofiltre.freeland.billing.domain.bill.*;
import tech.zerofiltre.freeland.billing.domain.bill.model.*;
import tech.zerofiltre.freeland.billing.domain.client.model.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.model.*;

import java.time.*;

public class ClientBillingScheduler {

    private final BillProvider billProvider;
    private final AgencyProvider agencyProvider;
    private final ServiceContractProvider serviceContractProvider;

    public ClientBillingScheduler(BillProvider billProvider,
                                  AgencyProvider agencyProvider,
                                  ServiceContractProvider serviceContractProvider) {
        this.billProvider = billProvider;
        this.agencyProvider = agencyProvider;
        this.serviceContractProvider = serviceContractProvider;
    }

    public Bill execute(ClientId clientId, AgencyId agencyId, ServiceContractId serviceContractId)
            throws ScheduleClientBillingException {

        agencyProvider.agencyOfId(agencyId).orElseThrow(() -> new ScheduleClientBillingException("There is no agency for: " + agencyId));

        Amount amount = serviceContractProvider.serviceContractOfId(serviceContractId)
                .map(serviceContract -> calculateAmount(serviceContract.getRate()))
                .orElseThrow(() -> new ScheduleClientBillingException("There is no Service contract for: " + serviceContractId));


        return Bill.builder().clientId(clientId)
                .amount(amount)
                .agencyId(agencyId)
                .issuedDate(LocalDateTime.now())
                .executionPeriod(LocalDateTime.now())
                .billProvider(billProvider)
                .build().send();

    }

    private Amount calculateAmount(Rate rate) {
        float value;
        switch (rate.getFrequency()) {
            case DAILY:
                value = rate.getValue() * 20;
                break;
            case MONTHLY:
                value = rate.getValue();
                break;
            default:
                value = rate.getValue() / 12;
                break;
        }
        return new Amount(value, rate.getCurrency());
    }

}
