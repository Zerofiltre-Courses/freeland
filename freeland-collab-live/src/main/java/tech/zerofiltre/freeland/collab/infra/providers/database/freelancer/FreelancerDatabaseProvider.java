package tech.zerofiltre.freeland.collab.infra.providers.database.freelancer;


import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import tech.zerofiltre.freeland.collab.domain.freelancer.*;
import tech.zerofiltre.freeland.collab.domain.freelancer.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.freelancer.mapper.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.freelancer.model.*;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class FreelancerDatabaseProvider implements FreelancerProvider {

    private final FreelancerJPARepository repository;
    private final FreelancerJPAMapper mapper;

    @Override
    public Optional<Freelancer> freelancerOfId(FreelancerId freelancerId) {
        return repository.findById(freelancerId.getSiren())
                .map(mapper::fromJPA);
    }

    @Override
    public Freelancer registerFreelancer(Freelancer freelancer) {
        FreelancerJPA freelancerJPA = mapper.toJPA(freelancer);
        return mapper.fromJPA(repository.save(freelancerJPA));
    }
}
