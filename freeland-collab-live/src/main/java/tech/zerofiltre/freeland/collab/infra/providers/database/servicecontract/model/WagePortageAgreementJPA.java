package tech.zerofiltre.freeland.collab.infra.providers.database.servicecontract.model;

import lombok.*;
import tech.zerofiltre.freeland.infra.providers.database.agency.model.*;
import tech.zerofiltre.freeland.infra.providers.database.freelancer.model.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WagePortageAgreementJPA {

  @Id
  @GeneratedValue
  private Long agreementNumber;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "freelancer_siren")
  private FreelancerJPA freelancer;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "agency_siren")
  private AgencyJPA agency;

  private float serviceFeesRate;
  private String terms;
  private Date startDate;
  private Date endDate;
}
