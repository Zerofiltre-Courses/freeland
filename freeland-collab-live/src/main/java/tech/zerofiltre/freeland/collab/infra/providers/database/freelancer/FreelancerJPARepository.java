package tech.zerofiltre.freeland.collab.infra.providers.database.freelancer;

import org.springframework.data.jpa.repository.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.freelancer.model.*;

public interface FreelancerJPARepository extends JpaRepository<FreelancerJPA, String> {

}
