package com.querywithapi.querywithapiexercice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.querywithapi.querywithapiexercice.dto.UserAccountDtoInsert;
import com.querywithapi.querywithapiexercice.dto.UserAccountDtoReturn;
import com.querywithapi.querywithapiexercice.mapper.OrderMapper;
import com.querywithapi.querywithapiexercice.model.Role;
import com.querywithapi.querywithapiexercice.model.UserAccount;
import com.querywithapi.querywithapiexercice.repository.RoleRepository;
import com.querywithapi.querywithapiexercice.repository.UserAccountRepository;

import jakarta.transaction.Transactional;
@Service
public class UserAccountImpl implements IUserAccount {

  private final UserAccountRepository userAccountRepository;
  private final OrderMapper convert;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;



  public UserAccountImpl(UserAccountRepository userAccountRepository, OrderMapper convert,
      RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userAccountRepository = userAccountRepository;
    this.convert = convert;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  @Transactional
  public UserAccountDtoReturn createUserAccount(UserAccountDtoInsert user) {

    Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");

    Set<Role> roles = new HashSet<>();

    optionalRoleUser.ifPresent(roles::add);

    if(user.isAdmin()){

      Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMINISTRATOR");
      optionalRoleAdmin.ifPresent(roles::add);
    }



    UserAccount userAccount = convert.userAccountInsertToUserAccount(user);

     String passwordEncodedInsert = passwordEncoder.encode(user.getPassword());
    userAccount.setRoles(roles);
    userAccount.setPassword(passwordEncodedInsert);

   

    userAccountRepository.save(userAccount);
    return convert.userAccountToUserAccountDtoReturn(userAccount);

  }

  @Override
  public List<UserAccountDtoReturn> getAllUserAccounts() {

    List<UserAccount> listAccounts = userAccountRepository.findAll();

    return convert.listUserAccountToUserAccountDtoReturns(listAccounts);
   

  }

  @Override
  public UserAccountDtoReturn getUserAccountById(Long id) {

    UserAccount userAccount = userAccountRepository.findById(id)
      .orElseThrow(()-> new RuntimeException(" no se encontro la cuenta de usuario con el id insertado"));

    return convert.userAccountToUserAccountDtoReturn(userAccount);

  }

  @Override
  public void deleteUserAccount(Long id) {
      userAccountRepository.deleteById(id);

  }

  @Override
  public UserAccount validateUserAccount(Long id) {

     UserAccount validUserAccount = userAccountRepository.findById(id)
    .orElseThrow(()-> new RuntimeException("EL USUSARIO CON EL ID INGRESADO NO EXISTE, VALIDE LA INFORMACION") );

  return validUserAccount;
  }

  





























}
