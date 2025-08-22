package com.querywithapi.querywithapiexercice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.querywithapi.querywithapiexercice.model.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {


  Boolean existsByEmail (String email);

  Optional<UserAccount> findByUserName (String userName);
  Optional<UserAccount> findByEmail (String email);









  

}
