package tech.zerofiltre.freeland.billing.domain.serviceContract.model;


public class ServiceContractId {

  private final long contractNumber;


  public ServiceContractId(long contractNumber) {
    this.contractNumber = contractNumber;
  }

  public long getContractNumber() {
    return contractNumber;
  }
}
