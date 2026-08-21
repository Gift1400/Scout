package com.scout.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "clubId", columnDefinition = "BINARY(16)")
    private UUID clubId;

    @OneToOne
    private User user;
    private String name;
    private String league;
    private String location;
    private String description;
    private boolean verified;
    private String logoUrl;
    private LocalDateTime createdAt;

    protected Club(){}
    public Club(Builder builder){
        this.clubId = builder.clubId;
        this.user = builder.user;
        this.name = builder.name;
        this.league = builder.league;
        this.location = builder.location;
        this.description = builder.description;
        this.verified = builder.verified;
        this.logoUrl = builder.logoUrl;
        this.createdAt = builder.createdAt;
    }

    public UUID getClubId() {
        return clubId;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getLeague() {
        return league;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubId=" + clubId +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", league='" + league + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", verified=" + verified +
                ", logoUrl='" + logoUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class Builder{
        private UUID clubId;
        private User user;
        private String name;
        private String league;
        private String location;
        private String description;
        private boolean verified;
        private String logoUrl;
        private LocalDateTime createdAt;

        public Builder copy(Club club){
            this.clubId = club.clubId;
            this.user = club.user;
            this.name = club.name;
            this.league = club.league;
            this.location = club.location;
            this.description = club.description;
            this.verified = club.verified;
            this.logoUrl = club.logoUrl;
            this.createdAt = club.createdAt;
            return this;
        }

        public Builder setClubId(UUID clubId) {
            this.clubId = clubId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLeague(String league) {
            this.league = league;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setVerified(boolean verified) {
            this.verified = verified;
            return this;
        }

        public Builder setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Club build(){
            return new Club(this);
        }
    }
}
