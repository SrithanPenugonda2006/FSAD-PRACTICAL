package com.practical.jwtauth.config;

import com.practical.jwtauth.model.AppUser;
import com.practical.jwtauth.model.Role;
import com.practical.jwtauth.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedUsers(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            appUserRepository.findByUsername("admin").orElseGet(() ->
                    appUserRepository.save(new AppUser("admin", passwordEncoder.encode("admin123"), Role.ADMIN))
            );

            appUserRepository.findByUsername("employee").orElseGet(() ->
                    appUserRepository.save(new AppUser("employee", passwordEncoder.encode("employee123"), Role.EMPLOYEE))
            );
        };
    }
}
