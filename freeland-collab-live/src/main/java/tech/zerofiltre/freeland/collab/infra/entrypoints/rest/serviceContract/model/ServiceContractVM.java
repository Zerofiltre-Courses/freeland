package tech.zerofiltre.freeland.collab.infra.entrypoints.rest.serviceContract.model;

import lombok.*;
import tech.zerofiltre.freeland.collab.domain.*;

import javax.validation.constraints.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceContractVM {

    @NotNull
    private long contractNumber;

    @NotNull
    private long wagePortageAgreementNumber;

    @NotEmpty
    private String clientSiren;

    @NotNull
    private float rateValue;
    @NotNull
    private Rate.Currency rateCurrency;
    @NotNull
    private Rate.Frequency rateFrequency;

    @NotEmpty
    private String terms;
    private Date startDate;
    private Date endDate;

}
