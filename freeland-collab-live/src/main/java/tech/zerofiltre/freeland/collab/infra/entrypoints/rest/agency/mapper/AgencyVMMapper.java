package tech.zerofiltre.freeland.collab.infra.entrypoints.rest.agency.mapper;

import org.mapstruct.*;
import tech.zerofiltre.freeland.collab.domain.*;
import tech.zerofiltre.freeland.collab.domain.agency.model.*;
import tech.zerofiltre.freeland.collab.infra.entrypoints.rest.agency.model.*;

@Mapper(componentModel = "spring")
public abstract class AgencyVMMapper {


    @Mapping(target = "siren", expression = "java(agency.getAgencyId().getSiren())")
    @Mapping(target = "name", expression = "java(agency.getAgencyId().getName())")
    @Mapping(target = "streetNumber", expression = "java(agency.getAddress().getStreetNumber())")
    @Mapping(target = "streetName", expression = "java(agency.getAddress().getStreetName())")
    @Mapping(target = "city", expression = "java(agency.getAddress().getCity())")
    @Mapping(target = "postalCode", expression = "java(agency.getAddress().getPostalCode())")
    @Mapping(target = "country", expression = "java(agency.getAddress().getCountry())")
    public abstract AgencyVM toVM(Agency agency);


    public abstract Agency fromVM(AgencyVM agencyVM);

    @AfterMapping
    Agency completeMapping(@MappingTarget Agency.AgencyBuilder result, AgencyVM agencyVM) {
        AgencyId agencyId = new AgencyId(agencyVM.getSiren(), agencyVM.getName());
        result.agencyId(agencyId);
        Address address = new Address(agencyVM.getStreetNumber(), agencyVM.getStreetName(), agencyVM.getPostalCode(),
                agencyVM.getCity(), agencyVM.getCountry());
        result.address(address);
        return result.build();
    }


}
