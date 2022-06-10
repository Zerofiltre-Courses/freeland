package tech.zerofiltre.freeland.billing.domain.agency.model;


import tech.zerofiltre.freeland.billing.domain.*;

public class AgencyId extends CompanyId {

  public AgencyId(String siren, String name) {
    super(siren, name);
  }
}
