package tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.mapper.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.model.*;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceContractDatabaseProvider implements ServiceContractProvider {

    private final ServiceContractJPARepository repository;
    private final ServiceContractJPAMapper mapper;

    @Override
    public Optional<ServiceContract> serviceContractOfId(ServiceContractId serviceContractId) {
        return repository.findById(serviceContractId.getContractNumber())
                .map(mapper::fromJPA);
    }

    @Override
    public ServiceContract registerContract(ServiceContract serviceContract) {
        ServiceContractJPA serviceContractJPA = mapper.toJPA(serviceContract);
        return mapper.fromJPA(repository.save(serviceContractJPA));
    }
}
