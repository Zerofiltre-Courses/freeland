package tech.zerofiltre.freeland.collab.domain.agency.model;

import tech.zerofiltre.freeland.collab.domain.*;
import tech.zerofiltre.freeland.collab.domain.agency.*;

public class Agency {
    private AgencyId agencyId;
    private String description;
    private String phoneNumber;
    private Address address;
    private AgencyProvider agencyProvider;

    private Agency(AgencyBuilder agencyBuilder) {
        this.agencyId = agencyBuilder.agencyId;
        this.description = agencyBuilder.description;
        this.phoneNumber = agencyBuilder.phoneNumber;
        this.address = agencyBuilder.address;
        this.agencyProvider = agencyBuilder.agencyProvider;
    }

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public AgencyProvider getAgencyProvider() {
        return agencyProvider;
    }

    public static AgencyBuilder builder(){
        return new AgencyBuilder();
    }

    public static class AgencyBuilder {
        private AgencyId agencyId;
        private String description;
        private String phoneNumber;
        private Address address;

        private AgencyProvider agencyProvider;


        public AgencyBuilder agencyProvider(AgencyProvider agencyProvider){
            this.agencyProvider = agencyProvider;
            return this;
        }

        public AgencyBuilder agencyId(AgencyId agencyId) {
            this.agencyId = agencyId;
            return this;
        }
        public AgencyBuilder description(String description) {
            this.description = description;
            return this;
        }

        public AgencyBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public AgencyBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public Agency build(){
            return new Agency(this);
        }

    }
}
