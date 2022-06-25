package tech.zerofiltre.freeland.billing.infra.providers.notification;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.context.*;
import org.springframework.kafka.core.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.support.*;
import org.testcontainers.containers.*;
import org.testcontainers.junit.jupiter.*;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.*;
import tech.zerofiltre.freeland.billing.domain.*;
import tech.zerofiltre.freeland.billing.domain.agency.*;
import tech.zerofiltre.freeland.billing.domain.agency.model.*;
import tech.zerofiltre.freeland.billing.domain.bill.*;
import tech.zerofiltre.freeland.billing.domain.bill.model.*;
import tech.zerofiltre.freeland.billing.domain.payment.*;
import tech.zerofiltre.freeland.billing.domain.payment.model.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.model.*;
import tech.zerofiltre.freeland.billing.infra.mapper.*;
import tech.zerofiltre.freeland.collab.infra.providers.notification.model.*;

import java.util.*;
import java.util.concurrent.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@DirtiesContext
@Testcontainers
@ContextConfiguration(initializers = ServiceContractKafkaListenerIT.BrokerPropertiesOverrideInitializer.class)
class ServiceContractKafkaListenerIT {


    @Container
    public static KafkaContainer kafka =
            new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));

    @Autowired
    KafkaServiceContractEventMapper mapper;
    @Autowired
    KafkaTemplate<String, KafkaServiceContractEvent> kafkaTemplate;
    @MockBean
    private PaymentProvider paymentProvider;
    @MockBean
    private ServiceContractProvider serviceContractProvider;
    @MockBean
    private BillProvider billProvider;
    @MockBean
    private AgencyProvider agencyProvider;
    private ServiceContractStarted serviceContractStarted;

    @BeforeEach
    void init() {
        serviceContractStarted = new ServiceContractStarted(
                10L,
                null,
                null,
                null,
                null,
                null,
                null,
                700f,
                Rate.Frequency.DAILY,
                Rate.Currency.EUR,
                0f,
                null
        );
    }

    @Test
    @DisplayName("On message received, appropriate providers are called")
    void listener() throws InterruptedException {
        when(paymentProvider.registerPayment(any())).thenReturn(Payment.builder().build());
        when(serviceContractProvider.serviceContractOfId(any())).thenAnswer(invocationOnMock -> Optional.of(
                ServiceContract.builder()
                        .rate(new Rate(700f, Rate.Currency.EUR, Rate.Frequency.DAILY))
                        .build()
        ));
        when(agencyProvider.agencyOfId(any())).thenReturn(Optional.of(new Agency(null, null, null)));
        when(billProvider.registerBill(any())).thenReturn(Bill.builder().build());

        kafkaTemplate.send("container-test-topic", mapper.toKafka(serviceContractStarted));
        TimeUnit.MILLISECONDS.sleep(5000);

        verify(paymentProvider, times(1)).registerPayment(any());
        verify(serviceContractProvider, times(2)).serviceContractOfId(any());
        verify(agencyProvider, times(1)).agencyOfId(any());
        verify(billProvider, times(1)).registerBill(any());

    }

    static class BrokerPropertiesOverrideInitializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {


        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    configurableApplicationContext,
                    "spring.kafka.bootstrap-servers=" + kafka.getBootstrapServers());

            TestPropertySourceUtils.addPropertiesFilesToEnvironment(
                    configurableApplicationContext, "classpath:application.properties");
        }
    }
}