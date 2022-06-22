package tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.*;
import tech.zerofiltre.freeland.collab.domain.*;
import tech.zerofiltre.freeland.collab.domain.client.model.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.client.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.client.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.model.*;

@Mapper(componentModel = "spring", uses = WagePortageAgreementJPAMapper.class)
public abstract class ServiceContractJPAMapper {

  @Autowired
  private ClientJPARepository clientJPARepository;

  @Mappings({
      @Mapping(target = "serviceContractId", source = "contractNumber"),
      @Mapping(target = "clientId", source = "client"),
  })
  public abstract ServiceContract fromJPA(ServiceContractJPA serviceContractJPA);


  @AfterMapping
  public void addRate(@MappingTarget ServiceContract.ServiceContractBuilder result, ServiceContractJPA serviceContractJPA) {
    result.rate(new Rate(serviceContractJPA.getRateValue(), serviceContractJPA.getRateCurrency(),
        serviceContractJPA.getRateFrequency()));
  }

  @Mappings({
      @Mapping(target = "contractNumber", expression = "java(serviceContract.getServiceContractId()!=null?serviceContract.getServiceContractId().getContractNumber():null)"),
      @Mapping(target = "rateValue", expression = "java(serviceContract.getRate().getValue())"),
      @Mapping(target = "rateCurrency", expression = "java(serviceContract.getRate().getCurrency())"),
      @Mapping(target = "rateFrequency", expression = "java(serviceContract.getRate().getFrequency())"),
      @Mapping(target = "client", source = "clientId")
  })
  public abstract ServiceContractJPA toJPA(ServiceContract serviceContract);


  ServiceContractId toServiceContractId(Long contractNumber) {
    if (contractNumber == null) {
      return null;
    }
    return new ServiceContractId(contractNumber);
  }

  ClientId toClientId(ClientJPA clientJPA) {
    if (clientJPA == null) {
      return null;
    }
    return new ClientId(clientJPA.getSiren(), clientJPA.getName());
  }

  ClientJPA toClientJPA(ClientId clientId) {
    if (clientId == null) {
      return null;
    }
    return clientJPARepository.findById(clientId.getSiren()).orElse(null);
  }


}
