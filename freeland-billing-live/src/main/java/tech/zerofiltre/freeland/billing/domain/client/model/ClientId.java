package tech.zerofiltre.freeland.billing.domain.client.model;


import tech.zerofiltre.freeland.billing.domain.*;

public class ClientId extends CompanyId {

  public ClientId(String siren, String name) {
    super(siren, name);
  }
}
