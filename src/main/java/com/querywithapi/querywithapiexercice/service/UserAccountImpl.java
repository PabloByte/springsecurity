package com.querywithapi.querywithapiexercice.service;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.querywithapi.querywithapiexercice.dto.UserAccountDtoInsert;
import com.querywithapi.querywithapiexercice.dto.UserAccountDtoReturn;
import com.querywithapi.querywithapiexercice.mapper.OrderMapper;
import com.querywithapi.querywithapiexercice.model.UserAccount;
import com.querywithapi.querywithapiexercice.repository.UserAccountRepository;
@Service
public class UserAccountImpl implements IUserAccount {

  private final UserAccountRepository userAccountRepository;
  private final OrderMapper convert;

  public UserAccountImpl(UserAccountRepository userAccountRepository, OrderMapper convert) {
    this.userAccountRepository = userAccountRepository;
    this.convert = convert;
  }

  @Override
  public UserAccountDtoReturn createUserAccount(UserAccountDtoInsert user) {

    UserAccount userAccount = convert.userAccountInsertToUserAccount(user);
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
