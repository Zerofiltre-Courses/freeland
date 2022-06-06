package tech.zerofiltre.freeland.collab.domain.servicecontract;

import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;

import java.util.*;

public interface WagePortageAgreementProvider {

    Optional<WagePortageAgreement> wagePortageAgreementOfId(WagePortageAgreementId wagePortageAgreementId);

    WagePortageAgreement registerWagePortageAgreement(WagePortageAgreement wagePortageAgreement);

}
