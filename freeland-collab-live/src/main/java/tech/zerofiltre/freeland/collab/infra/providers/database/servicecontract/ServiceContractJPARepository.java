package tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract;


import org.springframework.data.jpa.repository.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.model.*;

public interface ServiceContractJPARepository extends JpaRepository<ServiceContractJPA, Long> {

}
