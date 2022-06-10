package tech.zerofiltre.freeland.billing.domain.serviceContract;


import tech.zerofiltre.freeland.billing.domain.serviceContract.model.*;

import java.util.*;

public interface ServiceContractProvider {

  Optional<ServiceContract> serviceContractOfId(ServiceContractId serviceContractId);

}
