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


}

