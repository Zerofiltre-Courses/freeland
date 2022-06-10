package tech.zerofiltre.freeland.billing.application;

import tech.zerofiltre.freeland.billing.domain.*;
import tech.zerofiltre.freeland.billing.domain.agency.*;
import tech.zerofiltre.freeland.billing.domain.agency.model.*;
import tech.zerofiltre.freeland.billing.domain.bill.*;
import tech.zerofiltre.freeland.billing.domain.client.model.*;
import tech.zerofiltre.freeland.billing.domain.freelancer.model.*;
import tech.zerofiltre.freeland.billing.domain.payment.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.model.*;

public class ServiceContractStartedListener {

  private FreelancerPaymentScheduler freelancerPaymentScheduler;
    private ClientBillingScheduler clientBillingScheduler;

    public ServiceContractStartedListener(PaymentProvider paymentProvider, ServiceContractProvider serviceContractProvider,
                                          BillProvider billProvider, AgencyProvider agencyProvider) {

      this.freelancerPaymentScheduler = new FreelancerPaymentScheduler(paymentProvider, serviceContractProvider);
        this.clientBillingScheduler = new ClientBillingScheduler(billProvider, agencyProvider, serviceContractProvider);
    }

    public void consume(ServiceContractEvent message)
            throws ScheduleFreelancerPaymentException, ScheduleClientBillingException {

        FreelancerId freelancerId = new FreelancerId(message.getFreelancerSiren(), message.getFreelancerName());

        ServiceContractId serviceContractId = new ServiceContractId(message.getServiceContractNumber());
        Rate serviceContractRate = new Rate(message.getRateValue(), message.getRateCurrency(), message.getRateFrequency());

        AgencyId agencyId = new AgencyId(message.getAgencySiren(), message.getAgencyName());
        ClientId clientId = new ClientId(message.getClientSiren(), message.getClientName());

        freelancerPaymentScheduler.execute(serviceContractId, freelancerId, serviceContractRate, message.getServiceFeesRate());
        clientBillingScheduler.execute(clientId, agencyId, serviceContractId);

    }
}
