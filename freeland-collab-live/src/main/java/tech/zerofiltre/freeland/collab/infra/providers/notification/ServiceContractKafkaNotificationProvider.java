package tech.zerofiltre.freeland.collab.infra.providers.notification;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.*;
import org.springframework.stereotype.*;
import org.springframework.util.concurrent.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.notification.mapper.*;
import tech.zerofiltre.freeland.collab.infra.providers.notification.model.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class ServiceContractKafkaNotificationProvider implements ServiceContractNotificationProvider {

    private final KafkaTemplate<String, KafkaServiceContractEvent> kafkaTemplate;

    @Value("${service-contract.topic}")
    private String topic;

    private final KafkaServiceContractEventMapper mapper;


    @Override
    public void notify(ServiceContractEvent serviceContractEvent) {
        KafkaServiceContractEvent payload = mapper.toKafka(serviceContractEvent);
        ListenableFuture<SendResult<String, KafkaServiceContractEvent>> future = kafkaTemplate
                .send(topic, payload);
        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, KafkaServiceContractEvent> result) {
                log.info("Message [{}] delivered with offset {}",
                        payload.toString(),
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("Unable to deliver message [{}]. {}",
                        payload.toString(),
                        ex.getMessage());
            }
        });
    }
}

