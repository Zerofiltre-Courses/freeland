package tech.zerofiltre.freeland.collab.domain.servicecontract;


import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;

public interface ServiceContractNotificationProvider {

  void notify(ServiceContractEvent serviceContractEvent);

}
