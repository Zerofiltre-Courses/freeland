package tech.zerofiltre.freeland.collab.infra.providers.database;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class CompanyJPA {

  @Id
  private String siren;
  private String name;

  private String description;
  private String phoneNumber;

  private String streetNumber;
  private String streetName;
  private String city;
  private String postalCode;
  private String country;

}
