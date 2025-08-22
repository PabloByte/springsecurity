package com.querywithapi.querywithapiexercice.service;

import java.util.List;

import com.querywithapi.querywithapiexercice.dto.UserAccountDtoInsert;
import com.querywithapi.querywithapiexercice.dto.UserAccountDtoReturn;
import com.querywithapi.querywithapiexercice.model.UserAccount;


public interface IUserAccount {

  UserAccountDtoReturn createUserAccount (UserAccountDtoInsert user);
 List<UserAccountDtoReturn> getAllUserAccounts ( );
 UserAccountDtoReturn getUserAccountById (Long id);
 void deleteUserAccount (Long id);
 UserAccount validateUserAccount (Long id);

 Boolean existsByEmail (String email);




  




}
