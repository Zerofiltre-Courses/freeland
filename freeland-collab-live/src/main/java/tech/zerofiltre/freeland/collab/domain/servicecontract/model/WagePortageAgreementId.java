package tech.zerofiltre.freeland.collab.domain.servicecontract.model;

public class WagePortageAgreementId {
    private final long agreementNumber;

    public WagePortageAgreementId(long agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public long getAgreementNumber() {
        return agreementNumber;
    }
}
