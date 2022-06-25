package tech.zerofiltre.freeland.billing.infra;

import lombok.extern.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;
import tech.zerofiltre.freeland.billing.application.*;
import tech.zerofiltre.freeland.billing.domain.agency.*;
import tech.zerofiltre.freeland.billing.domain.bill.*;
import tech.zerofiltre.freeland.billing.domain.payment.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.*;
import tech.zerofiltre.freeland.billing.infra.mapper.*;
import tech.zerofiltre.freeland.billing.infra.model.*;

@Slf4j
@Component
public class ServiceContractKafkaListener {

    private final ServiceContractStartedListener serviceContractStartedListener;
    private final KafkaServiceContractEventMapper mapper;

    public ServiceContractKafkaListener(PaymentProvider paymentProvider, ServiceContractProvider serviceContractProvider, BillProvider billProvider, AgencyProvider agencyProvider, KafkaServiceContractEventMapper mapper) {
        this.mapper = mapper;
        this.serviceContractStartedListener = new ServiceContractStartedListener(paymentProvider, serviceContractProvider, billProvider, agencyProvider);
    }


    @KafkaListener(topics = "${service-contract.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(KafkaServiceContractEvent message)
            throws ScheduleFreelancerPaymentException, ScheduleClientBillingException {
        serviceContractStartedListener.consume(mapper.fromKafka(message));

    }
}
