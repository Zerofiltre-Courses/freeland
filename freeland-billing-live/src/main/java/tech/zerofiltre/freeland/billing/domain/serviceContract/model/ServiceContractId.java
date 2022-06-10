package tech.zerofiltre.freeland.billing.domain.serviceContract.model;


public class ServiceContractId {

  private final Long contractNumber;


  public ServiceContractId(Long contractNumber) {
    this.contractNumber = contractNumber;
  }

  public Long getContractNumber() {
    return contractNumber;
  }
}
