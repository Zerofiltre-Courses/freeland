package tech.zerofiltre.freeland.billing.infra.providers.dummy;

import org.springframework.stereotype.*;
import tech.zerofiltre.freeland.billing.domain.*;
import tech.zerofiltre.freeland.billing.domain.agency.*;
import tech.zerofiltre.freeland.billing.domain.agency.model.*;

import java.util.*;

@Component
public class DummyAgencyProvider implements AgencyProvider {
    @Override
    public Optional<Agency> agencyOfId(AgencyId agencyId) {
        BankInfo bankInfo = new BankInfo("7879787521122","ENOPXXX","Owner","BGFI");
        return Optional.of(new Agency(agencyId, bankInfo, new Address("212","Rue de tolbiac","75073","Paris","France")));
    }
}
