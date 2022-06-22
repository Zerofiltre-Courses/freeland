package tech.zerofiltre.freeland.collab.infra.providers.database.freelancer.mapper;

import org.mapstruct.*;
import tech.zerofiltre.freeland.collab.domain.*;
import tech.zerofiltre.freeland.collab.domain.freelancer.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.freelancer.model.*;

@Mapper(componentModel = "spring")
public abstract class FreelancerJPAMapper {

  @Mapping(target = "siren", expression = "java(freelancer.getFreelancerId().getSiren())")
  @Mapping(target = "name", expression = "java(freelancer.getFreelancerId().getName())")
  @Mapping(target = "streetNumber", expression = "java(freelancer.getAddress().getStreetNumber())")
  @Mapping(target = "streetName", expression = "java(freelancer.getAddress().getStreetName())")
  @Mapping(target = "city", expression = "java(freelancer.getAddress().getCity())")
  @Mapping(target = "postalCode", expression = "java(freelancer.getAddress().getPostalCode())")
  @Mapping(target = "country", expression = "java(freelancer.getAddress().getCountry())")
  public abstract FreelancerJPA toJPA(Freelancer freelancer);

  public abstract Freelancer fromJPA(FreelancerJPA FreelancerJPA);

  @AfterMapping
  Freelancer completeMapping(@MappingTarget Freelancer.FreelancerBuilder result, FreelancerJPA freelancerJPA) {
    FreelancerId FreelancerId = new FreelancerId(freelancerJPA.getSiren(), freelancerJPA.getName());
    result.freelancerId(FreelancerId);
    Address address = new Address(freelancerJPA.getStreetNumber(), freelancerJPA.getStreetName(), freelancerJPA.getPostalCode(),
        freelancerJPA.getCity(), freelancerJPA.getCountry());
    result.address(address);
    return result.build();
  }

}
