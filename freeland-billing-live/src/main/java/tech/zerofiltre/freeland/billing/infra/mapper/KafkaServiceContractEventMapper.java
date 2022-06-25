package tech.zerofiltre.freeland.billing.infra.mapper;

import org.mapstruct.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.model.*;
import tech.zerofiltre.freeland.billing.infra.model.*;

@Mapper(componentModel = "spring")
public abstract class KafkaServiceContractEventMapper {

    public abstract KafkaServiceContractEvent toKafka(ServiceContractEvent serviceContractEvent);
    public abstract ServiceContractEvent fromKafka(KafkaServiceContractEvent kafkaServiceContractEvent);




}
