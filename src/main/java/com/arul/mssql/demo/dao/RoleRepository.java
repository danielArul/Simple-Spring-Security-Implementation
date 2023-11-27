package com.arul.mssql.demo.dao;

import com.arul.mssql.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
