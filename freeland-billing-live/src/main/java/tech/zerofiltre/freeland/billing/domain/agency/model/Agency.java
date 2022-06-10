package tech.zerofiltre.freeland.billing.domain.agency.model;


import tech.zerofiltre.freeland.billing.domain.*;

public class Agency {

  private AgencyId agencyId;
  private BankInfo bankInfo;
  private Address address;

  public Agency(AgencyId agencyId, BankInfo bankInfo, Address address) {
    this.agencyId = agencyId;
    this.bankInfo = bankInfo;
    this.address = address;
  }

  public AgencyId getAgencyId() {
    return agencyId;
  }


  public BankInfo getBankInfo() {
    return bankInfo;
  }


  public Address getAddress() {
    return address;
  }

}
