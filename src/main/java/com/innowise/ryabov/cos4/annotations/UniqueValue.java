package com.innowise.ryabov.cos4.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//todo elementtype.type, string[] fields, generate 'existsBy' methods
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {
    String message() default "Non-unique value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> repository();
    String field();
}
