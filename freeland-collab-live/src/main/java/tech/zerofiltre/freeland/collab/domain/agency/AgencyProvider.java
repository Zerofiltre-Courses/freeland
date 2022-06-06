package tech.zerofiltre.freeland.collab.domain.agency;

import tech.zerofiltre.freeland.collab.domain.agency.model.*;

import java.util.*;

public interface AgencyProvider {
    Optional<Agency> agencyOfId(AgencyId agencyId);

    Agency registerAgency(Agency agency);
}
