package tech.zerofiltre.freeland.collab.infra.providers.notification.config;

import org.apache.kafka.clients.admin.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.config.*;

@Configuration
class KafkaTopicConfig {

  @Bean
  public NewTopic serviceContractTopic() {
    return TopicBuilder.name("service-contract-topic").build();
  }
}

