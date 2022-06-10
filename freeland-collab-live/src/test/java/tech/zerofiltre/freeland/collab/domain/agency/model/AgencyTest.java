package tech.zerofiltre.freeland.collab.domain.agency.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit.jupiter.*;
import tech.zerofiltre.freeland.collab.domain.agency.*;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AgencyTest {

    @Mock
    private AgencyProvider agencyProvider;

    private Agency agency;

    @BeforeEach
    void setUp() {
        agency = Agency.builder()
                .agencyProvider(agencyProvider)
                .build();
    }

    @Test
    @DisplayName("On register, call agencyProvider")
    void registerShouldCallAgencyProvider() {
        //given
        when(agencyProvider.registerAgency(any())).thenReturn(Agency.builder().build());

        //when
        agency.register();

        //then
        verify(agencyProvider,times(1)).registerAgency(any());


    }

    @Test
    void ofShouldCallAgencyProvider() {
        //given
        AgencyId agencyId = new AgencyId("siren","name");

        //when
        agency.of(agencyId);

        //then
        verify(agencyProvider,times(1)).agencyOfId(agencyId);
    }

    @Test
    void ofShouldFeedAgencyProvider() {
        //given
        AgencyId agencyId = new AgencyId("siren","name");
        when(agencyProvider.agencyOfId(any())).thenReturn(Optional.of(Agency.builder().build()));

        //when
        Optional<Agency> result = agency.of(agencyId);

        //then
        assertThat(result).isNotEmpty();
        assertThat(result.get().getAgencyProvider()).isNotNull();
    }




}