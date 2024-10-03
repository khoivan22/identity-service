package com.learn.Identity_service.configuration;

import com.learn.Identity_service.constant.UtilConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(UtilConstant.STRENGTH);
    }
}
