package tech.zerofiltre.freeland.collab.domain.servicecontract.model;


public class ServiceContractId {

  private final long contractNumber;


  public ServiceContractId(long contractNumber) {
    this.contractNumber = contractNumber;
  }

  public long getContractNumber() {
    return contractNumber;
  }
}
