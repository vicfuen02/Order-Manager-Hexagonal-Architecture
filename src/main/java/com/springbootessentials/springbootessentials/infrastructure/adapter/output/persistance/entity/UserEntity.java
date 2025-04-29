package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity;

import jakarta.persistence.*;


@Table(name="SPE_USERS", schema="SPE_SCHEMA")
@Entity
public class UserEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_user_id_gen")
    @SequenceGenerator(name="seq_user_id_gen", sequenceName="SEQ_USER_ID", initialValue = 1000, allocationSize = 5)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
