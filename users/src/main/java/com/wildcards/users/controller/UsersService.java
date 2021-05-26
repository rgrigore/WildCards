package com.wildcards.users.controller;

import com.wildcards.users.controller.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersService {
    private final AccountRepository repository;
}
