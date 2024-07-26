package com.innowise.ryabov.cos4.annotations;
import com.innowise.ryabov.cos4.util.NotUniqueValueException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    private ApplicationContext applicationContext;
    private Class<?> repositoryClass;
    private Object repository;
    private String field;
    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.repositoryClass = constraintAnnotation.repository();
        this.repository = applicationContext.getBean(repositoryClass);
        this.field = constraintAnnotation.field();
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        try {
            String methodName = "existsBy" + capitalize(field);
            Method existsMethod = repositoryClass.getMethod(methodName, value.getClass());
            return !(boolean) existsMethod.invoke(repository, value);
        } catch (Exception e) {
            throw new NotUniqueValueException("Error invoking 'exists' method on repository");
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase()+str.substring(1);
    }
}
