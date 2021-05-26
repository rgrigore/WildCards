package com.wildcards.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/users/**")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {
    private final UsersService service;
}
