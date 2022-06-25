package tech.zerofiltre.freeland.collab.infra.entrypoints.rest.agency;

import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tech.zerofiltre.freeland.collab.domain.agency.*;
import tech.zerofiltre.freeland.collab.domain.agency.model.*;
import tech.zerofiltre.freeland.collab.infra.entrypoints.rest.agency.mapper.*;
import tech.zerofiltre.freeland.collab.infra.entrypoints.rest.agency.model.*;

import javax.validation.*;


@RestController
@RequestMapping("agency")
@RequiredArgsConstructor
public class AgencyController {

    private final AgencyVMMapper agencyVMMapper;
    private final AgencyProvider agencyProvider;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AgencyVM registerAgency(@RequestBody @Valid AgencyVM agencyVM) {
        Agency agency = agencyProvider.registerAgency(agencyVMMapper.fromVM(agencyVM));
        return agencyVMMapper.toVM(agency);
    }
}
