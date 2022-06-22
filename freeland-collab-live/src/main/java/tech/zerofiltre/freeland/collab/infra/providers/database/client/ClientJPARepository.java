package tech.zerofiltre.freeland.collab.infra.providers.database.client;

import org.springframework.data.jpa.repository.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.client.model.*;

public interface ClientJPARepository extends JpaRepository<ClientJPA, String> {

}
