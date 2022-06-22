package tech.zerofiltre.freeland.collab.infra.providers.database.agency;


import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import tech.zerofiltre.freeland.collab.domain.agency.*;
import tech.zerofiltre.freeland.collab.domain.agency.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.agency.mapper.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.agency.model.*;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class AgencyDatabaseProvider implements AgencyProvider {

    private final AgencyJPARepository repository;
    private final AgencyJPAMapper mapper;


    @Override
    public Optional<Agency> agencyOfId(AgencyId agencyId) {
        return repository.findById(agencyId.getSiren())
                .map(mapper::fromJPA);
    }

    @Override
    public Agency registerAgency(Agency agency) {
        AgencyJPA AgencyJPA = mapper.toJPA(agency);
        return mapper.fromJPA(repository.save(AgencyJPA));

    }
}
