package com.querywithapi.querywithapiexercice.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Constraint(validatedBy=ExistsByEmailValidation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByEmail {

  String message() default "{Ya existe el Email que desea registrar en nuestra base de datos}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };








}
