package tech.zerofiltre.freeland.billing.domain.agency;


import tech.zerofiltre.freeland.billing.domain.agency.model.*;

import java.util.*;

public interface AgencyProvider {

    Optional<Agency> agencyOfId(AgencyId agencyId);

}
