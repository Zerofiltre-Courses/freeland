package tech.zerofiltre.freeland.collab.infra.entrypoints.rest.serviceContract;

import org.springframework.web.bind.annotation.*;
import tech.zerofiltre.freeland.collab.application.servicecontract.*;
import tech.zerofiltre.freeland.collab.domain.agency.*;
import tech.zerofiltre.freeland.collab.domain.freelancer.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;
import tech.zerofiltre.freeland.collab.infra.entrypoints.rest.serviceContract.mapper.*;
import tech.zerofiltre.freeland.collab.infra.entrypoints.rest.serviceContract.model.*;

import javax.validation.*;

@RestController
@RequestMapping("wage-portage-agreement")
public class WagePortageAgreementController {

    private final WagePortageAgreementVMMapper mapper;
    private final WagePortageAgreementStarter wagePortageAgreementStarter;


    public WagePortageAgreementController(WagePortageAgreementVMMapper mapper, WagePortageAgreementProvider wagePortageAgreementProvider, AgencyProvider agencyProvider, FreelancerProvider freelancerProvider) {
        this.mapper = mapper;
        this.wagePortageAgreementStarter = new WagePortageAgreementStarter(wagePortageAgreementProvider, freelancerProvider, agencyProvider);
    }


    @PostMapping("/start")
    public WagePortageAgreementVM registerAgreement(@RequestBody @Valid WagePortageAgreementVM wagePortageAgreementVM) throws StartWagePortageAgreementException {
        WagePortageAgreement wagePortageAgreement = mapper.fromVM(wagePortageAgreementVM);

        WagePortageAgreement startedWagePortageAgreement = wagePortageAgreementStarter.start(
                wagePortageAgreement.getAgencyId(),
                wagePortageAgreement.getFreelancerId(),
                wagePortageAgreement.getTerms(),
                wagePortageAgreement.getServiceFeesRate()
        );
        return mapper.toVM(startedWagePortageAgreement);
    }
}
