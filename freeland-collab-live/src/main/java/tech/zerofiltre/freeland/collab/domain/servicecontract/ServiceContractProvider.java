package tech.zerofiltre.freeland.collab.domain.servicecontract;


import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;

import java.util.*;

public interface ServiceContractProvider {

  Optional<ServiceContract> serviceContractOfId(ServiceContractId serviceContractId);

  ServiceContract registerContract(ServiceContract serviceContract);



}
