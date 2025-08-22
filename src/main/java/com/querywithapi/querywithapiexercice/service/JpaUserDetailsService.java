package com.querywithapi.querywithapiexercice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querywithapi.querywithapiexercice.model.UserAccount;
import com.querywithapi.querywithapiexercice.repository.UserAccountRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {


  private final UserAccountRepository userAccountRepository;

  public JpaUserDetailsService(UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @Transactional(readOnly=true)
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


    UserAccount user = userAccountRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(String.format("username %s no existe en el sistema", username)));

   

 


    List<GrantedAuthority> authoritys = user.getRoles().stream()
    .map(role -> new SimpleGrantedAuthority(role.getName()))
    .collect(Collectors.toList());

    return new User(
      user.getEmail(),
       user.getPassword(),
    user.isEnabled(),
    true,
    true,
    true,
    authoritys);


    

  }

}
