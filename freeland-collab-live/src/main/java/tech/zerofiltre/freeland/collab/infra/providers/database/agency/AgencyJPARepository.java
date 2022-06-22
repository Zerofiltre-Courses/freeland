package tech.zerofiltre.freeland.collab.infra.providers.database.agency;

import org.springframework.data.jpa.repository.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.agency.model.*;

public interface AgencyJPARepository extends JpaRepository<AgencyJPA, String> {

}
