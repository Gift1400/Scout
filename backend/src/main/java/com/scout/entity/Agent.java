package com.scout.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID agentId;

    @OneToOne
    private User user;
    private String fullName;
    private String agencyName;
    private boolean licenced;
    private String specialization;
    private String licenceNumber;
    private int yearsExperience;

    protected Agent(){}
    public Agent(Builder builder){
        this.agentId = builder.agentId;
        this.user = builder.user;
        this.fullName = builder.fullName;
        this.agencyName = builder.agencyName;
        this.licenced = builder.licenced;
        this.specialization = builder.specialization;
        this.licenceNumber = builder.licenceNumber;
        this.yearsExperience = builder.yearsExperience;
    }

    public UUID getAgentId() {
        return agentId;
    }

    public User getUser() {
        return user;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public boolean isLicenced() {
        return licenced;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", user=" + user +
                ", fullName='" + fullName + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", licenced=" + licenced +
                ", specialization='" + specialization + '\'' +
                ", licenceNumber='" + licenceNumber + '\'' +
                ", yearsExperience=" + yearsExperience +
                '}';
    }

    public static class Builder{
        private UUID agentId;
        private User user;
        private String fullName;
        private String agencyName;
        private boolean licenced;
        private String specialization;
        private String licenceNumber;
        private int yearsExperience;

        public Builder copy(Agent agent){
            this.agentId = agent.agentId;
            this.user = agent.user;
            this.fullName = agent.fullName;
            this.agencyName = agent.agencyName;
            this.licenced = agent.licenced;
            this.specialization = agent.specialization;
            this.licenceNumber = agent.licenceNumber;
            this.yearsExperience = agent.yearsExperience;
            return this;
        }

        public Builder setAgentId(UUID agentId){
            this.agentId = agentId;
            return this;
        }
        public Builder setUser(User user){
            this.user = user;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setAgencyName(String agencyName) {
            this.agencyName = agencyName;
            return this;
        }

        public Builder setLicenced(boolean licenced) {
            this.licenced = licenced;
            return this;
        }

        public Builder setSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder setLicenceNumber(String licenceNumber) {
            this.licenceNumber = licenceNumber;
            return this;
        }

        public Builder setYearsExperience(int yearsExperience) {
            this.yearsExperience = yearsExperience;
            return this;
        }

        public Agent build(){
            return new Agent(this);
        }
    }
}
