package tech.zerofiltre.freeland.billing.infra.providers.dummy;

import org.springframework.stereotype.*;
import tech.zerofiltre.freeland.billing.domain.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.*;
import tech.zerofiltre.freeland.billing.domain.serviceContract.model.*;

import java.util.*;

@Component
public class DummyServiceContractProvider implements ServiceContractProvider {
    @Override
    public Optional<ServiceContract> serviceContractOfId(ServiceContractId serviceContractId) {
        return Optional.of(ServiceContract.builder().serviceContractId(serviceContractId)
                .rate(new Rate(700f, Rate.Currency.EUR, Rate.Frequency.DAILY))
                .build());
    }
}
