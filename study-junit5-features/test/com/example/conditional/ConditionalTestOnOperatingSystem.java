package com.example.conditional;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(OperatingSystemCondition.class)
public @interface ConditionalTestOnOperatingSystem {
    OperatingSystem[] value();
}
