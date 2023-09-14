package com.userManagementSystem.usermanagementsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class UserRepository {
    @Bean
    public List<User> userDetailsList()
    {
        System.out.println("Empty User Repository initialized & ready to accept new users !!!!!!!!!!!");
        return new ArrayList<>();
    }
}
