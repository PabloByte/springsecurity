package com.querywithapi.querywithapiexercice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querywithapi.querywithapiexercice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {


  Optional<Role> findByName (String name);

}
