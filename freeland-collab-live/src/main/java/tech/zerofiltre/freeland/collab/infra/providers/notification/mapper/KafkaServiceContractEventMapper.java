package tech.zerofiltre.freeland.collab.infra.providers.notification.mapper;

import org.mapstruct.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.notification.model.*;

@Mapper(componentModel = "spring")
public abstract class KafkaServiceContractEventMapper {

    public abstract KafkaServiceContractEvent toKafka(ServiceContractEvent serviceContractEvent);
    public abstract ServiceContractEvent fromKafka(KafkaServiceContractEvent kafkaServiceContractEvent);




}
