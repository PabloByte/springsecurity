package com.querywithapi.querywithapiexercice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querywithapi.querywithapiexercice.dto.UserAccountDtoInsert;
import com.querywithapi.querywithapiexercice.dto.UserAccountDtoReturn;
import com.querywithapi.querywithapiexercice.service.UserAccountImpl;

@RequestMapping("/apiUserAccount")
@RestController
public class UserAccountController {

  private final UserAccountImpl userAccountImpl;

  public UserAccountController(UserAccountImpl userAccountImpl) {
    this.userAccountImpl = userAccountImpl;
  }

  @PostMapping("/createUserAccount")
  public ResponseEntity<?> createUserAccount ( @RequestBody UserAccountDtoInsert userAccount ){
    UserAccountDtoReturn newUserAccount = userAccountImpl.createUserAccount(userAccount);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUserAccount); }

  @GetMapping("/showAllUserAccounts")
  public ResponseEntity<?> getAllUsersAccounts (){
    List<UserAccountDtoReturn> list = userAccountImpl.getAllUserAccounts();

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
  }























  @GetMapping("/getUserAccountById/{id}")
  public ResponseEntity<?> getUserAccountById (@PathVariable Long id){

    UserAccountDtoReturn userAccount = userAccountImpl.getUserAccountById(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(userAccount);

  }

   @DeleteMapping("/deleteUserAccountById/{id}")
  public ResponseEntity<?> deleteUserAccountById (@PathVariable Long id){

    userAccountImpl.deleteUserAccount(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("delete sucesfully");

  }

  


























  

}
