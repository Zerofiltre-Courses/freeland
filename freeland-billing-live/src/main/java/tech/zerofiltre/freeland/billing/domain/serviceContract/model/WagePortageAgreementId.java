package tech.zerofiltre.freeland.billing.domain.serviceContract.model;

public class WagePortageAgreementId {

  private final Long agreementNumber;

  public WagePortageAgreementId(Long agreementNumber) {
    this.agreementNumber = agreementNumber;
  }

  public Long getAgreementNumber() {
    return agreementNumber;
  }

}
