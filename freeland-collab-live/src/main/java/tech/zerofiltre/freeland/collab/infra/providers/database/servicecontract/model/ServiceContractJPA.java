package tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.model;

import lombok.*;
import tech.zerofiltre.freeland.collab.domain.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.client.model.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service_contract")
public class ServiceContractJPA {

  @Id
  @GeneratedValue
  private Long contractNumber;

  @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  @JoinColumn(name = "wage_portage_agreement_number")
  private WagePortageAgreementJPA wagePortageAgreement;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_siren")
  private ClientJPA client;

  private float rateValue;
  private Rate.Currency rateCurrency;
  private Rate.Frequency rateFrequency;

  private String terms;
  private Date startDate;
  private Date endDate;

}
