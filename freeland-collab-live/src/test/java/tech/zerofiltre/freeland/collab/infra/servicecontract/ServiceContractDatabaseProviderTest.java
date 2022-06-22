package tech.zerofiltre.freeland.collab.infra.servicecontract;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.mapper.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.model.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ServiceContractDatabaseProviderTest {

  public static final Long CONTRACT_NUMBER = 12L;
  private ServiceContractDatabaseProvider serviceContractDatabaseProvider;

  @Mock
  private ServiceContractJPARepository repository;

  @Mock
  private ServiceContractJPAMapper mapper;

  @BeforeEach
  void init() {
    serviceContractDatabaseProvider = new ServiceContractDatabaseProvider(repository, mapper);
  }

  @Test
  void serviceContractFromId_mustCallTheProperMethods() {
    //arrange
    ServiceContractId serviceContractId = new ServiceContractId(CONTRACT_NUMBER);
    ServiceContractJPA serviceContractJPA = new ServiceContractJPA();
    when(repository.findById(any())).thenReturn(Optional.of(serviceContractJPA));

    //act
    serviceContractDatabaseProvider.serviceContractOfId(serviceContractId);

    //assert
    verify(repository, times(1)).findById(CONTRACT_NUMBER);
    verify(mapper, times(1)).fromJPA(serviceContractJPA);

  }

  @Test
  void registerContract_mustCallTheProperMethods() {
    //arrange
    ServiceContractJPA serviceContractJPA = new ServiceContractJPA();
    ServiceContract serviceContract = new ServiceContract.ServiceContractBuilder().build();
    when(mapper.toJPA(serviceContract)).thenReturn(serviceContractJPA);

    when(mapper.fromJPA(any())).thenReturn(serviceContract);

    when(repository.save(any())).thenReturn(serviceContractJPA);

    //act
    serviceContractDatabaseProvider.registerContract(serviceContract);

    //assert
    verify(mapper, times(1)).toJPA(any());

    verify(repository, times(1)).save(any());

    verify(mapper, times(1)).fromJPA(any());


  }
}