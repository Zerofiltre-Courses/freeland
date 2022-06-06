package tech.zerofiltre.freeland.collab.domain.servicecontract.model;

import tech.zerofiltre.freeland.collab.domain.agency.model.*;
import tech.zerofiltre.freeland.collab.domain.freelancer.model.*;
import tech.zerofiltre.freeland.collab.domain.servicecontract.*;

import java.time.*;
import java.util.*;

public class WagePortageAgreement {
    private WagePortageAgreementProvider wagePortageAgreementProvider;
    private WagePortageAgreementId wagePortageAgreementId;
    private FreelancerId freelancerId;
    private AgencyId agencyId;
    private float serviceFeesRate;
    private String terms;
    private Date startDate;
    private Date endDate;

    public WagePortageAgreementProvider getWagePortageAgreementProvider() {
        return wagePortageAgreementProvider;
    }

    public WagePortageAgreementId getWagePortageAgreementId() {
        return wagePortageAgreementId;
    }

    public FreelancerId getFreelancerId() {
        return freelancerId;
    }

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public float getServiceFeesRate() {
        return serviceFeesRate;
    }

    public String getTerms() {
        return terms;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public static WagePortageAgreementBuilder builder(){
        return new WagePortageAgreementBuilder();
    }
    private WagePortageAgreement(WagePortageAgreementBuilder builder) {
        this.wagePortageAgreementId = builder.wagePortageAgreementId;
        this.freelancerId = builder.freelancerId;
        this.agencyId = builder.agencyId;
        this.serviceFeesRate = builder.serviceFeesRate;
        this.terms = builder.terms;
        this.startDate = builder.startDate != null ? builder.startDate : new Date();
        this.endDate = builder.endDate != null ? builder.endDate : new Date(startDate.getTime() + Duration.ofDays(180).getSeconds() * 1000);
        this.wagePortageAgreementProvider = builder.wagePortageAgreementProvider;
    }

    public static class WagePortageAgreementBuilder{
        private WagePortageAgreementProvider wagePortageAgreementProvider;
        private WagePortageAgreementId wagePortageAgreementId;
        private FreelancerId freelancerId;
        private AgencyId agencyId;
        private float serviceFeesRate;
        private String terms;
        private Date startDate;
        private Date endDate;

        public WagePortageAgreementBuilder wagePortageAgreementProvider(WagePortageAgreementProvider wagePortageAgreementProvider) {
            this.wagePortageAgreementProvider = wagePortageAgreementProvider;
            return this;
        }

        public WagePortageAgreementBuilder freelancerId(FreelancerId freelancerId) {
            this.freelancerId = freelancerId;
            return this;
        }

        public WagePortageAgreementBuilder wagePortageAgreementId(WagePortageAgreementId wagePortageAgreementId) {
            this.wagePortageAgreementId = wagePortageAgreementId;
            return this;
        }

        public WagePortageAgreementBuilder agencyId(AgencyId agencyId) {
            this.agencyId = agencyId;
            return this;
        }

        public WagePortageAgreementBuilder serviceFeesRate(float serviceFeesRate) {
            this.serviceFeesRate = serviceFeesRate;
            return this;
        }

        public WagePortageAgreementBuilder terms(String terms) {
            this.terms = terms;
            return this;
        }

        public WagePortageAgreementBuilder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public WagePortageAgreementBuilder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public WagePortageAgreement build() {
            return new WagePortageAgreement(this);
        }

    }
}