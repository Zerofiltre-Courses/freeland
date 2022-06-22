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
public class WagePortageAgreementDatabaseProvider implements WagePortageAgreementProvider {

    private final WagePortageAgreementJPARepository repository;
    private final WagePortageAgreementJPAMapper mapper;

    @Override
    public Optional<WagePortageAgreement> wagePortageAgreementOfId(WagePortageAgreementId wagePortageAgreementId) {
        return repository.findById(wagePortageAgreementId.getAgreementNumber())
                .map(mapper::fromJPA);
    }

    @Override
    public WagePortageAgreement registerWagePortageAgreement(WagePortageAgreement wagePortageAgreement) {
        WagePortageAgreementJPA wagePortageAgreementJPA = mapper.toJPA(wagePortageAgreement);
        return mapper.fromJPA(repository.save(wagePortageAgreementJPA));
    }
}
