package com.querywithapi.querywithapiexercice.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {


  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private Long id;

   @Column(nullable = false, unique = true)
  private String name;

  @ManyToMany(mappedBy = "roles")
    private Set<UserAccount> users = new HashSet<>();

  public Role(String name, Set<UserAccount> users) {
    this.name = name;
    this.users = users;
  }

  public Role() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<UserAccount> getUsers() {
    return users;
  }

  public void setUsers(Set<UserAccount> users) {
    this.users = users;
  }


  

    


}
