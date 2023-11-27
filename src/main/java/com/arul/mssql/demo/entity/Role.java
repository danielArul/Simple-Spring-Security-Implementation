package com.arul.mssql.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> user;

    @Override
    public String getAuthority() {
        return name;
    }
}
