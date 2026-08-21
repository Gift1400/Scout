package com.scout.entity;

import com.scout.entity.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "userId", columnDefinition = "BINARY(16)")
    private UUID userId;

    private String email;
    private String passwordHash;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected User(){}
    public User(Builder builder){
        this.userId = builder.userId;
        this.email  = builder.email;
        this.passwordHash = builder.passwordHash;
        this.role = builder.role;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public UUID getUserId(){ return userId;}
    public String getEmail(){ return email;}
    public String getPasswordHash(){ return passwordHash;}
    public Role getRole(){ return role;}
    public LocalDateTime getCreatedAt(){ return createdAt;}
    public LocalDateTime getUpdatedAt(){ return updatedAt;}

    public String toString(){
        return "User {" + "\n" +
                "User Id: " + userId + "\n" +
                "Email: " + email + "\n" +
                "Password: " + passwordHash + "\n" +
                "Role: " + role + "\n" +
                "Created At: " + createdAt + "\n" +
                "Updated At: " + updatedAt + "}";
    }

    public static class Builder{
        private UUID userId;
        private String email;
        private String passwordHash;
        private Role role;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder copy(User user){
            this.userId = user.userId;
            this.email = user.email;
            this.passwordHash = user.passwordHash;
            this.role = user.role;
            this.createdAt = user.createdAt;
            this.updatedAt = user.updatedAt;
            return this;
        }

        public Builder setUserId(UUID userId){
            this.userId = userId;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setPasswordHash(String passwordHash){
            this.passwordHash = passwordHash;
            return this;
        }
        public Builder setRole(Role role){
            this.role = role;
            return this;
        }
        public Builder setCreatedAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }
        public Builder setUpdatedAt(LocalDateTime updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
