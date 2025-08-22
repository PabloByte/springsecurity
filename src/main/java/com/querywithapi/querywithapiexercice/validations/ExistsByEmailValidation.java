package com.querywithapi.querywithapiexercice.validations;

import org.springframework.stereotype.Component;

import com.querywithapi.querywithapiexercice.model.UserAccount;
import com.querywithapi.querywithapiexercice.service.UserAccountImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



@Component
public class ExistsByEmailValidation implements ConstraintValidator <ExistsByEmail, String>{

  private final UserAccountImpl userService;

  public ExistsByEmailValidation(UserAccountImpl userService) {
    this.userService = userService;
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {

    return  email != null && !userService.existsByEmail(email);

  }





}
