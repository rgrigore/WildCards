package com.wildcards.users.controller;

import com.wildcards.users.model.Account;
import com.wildcards.users.model.LoginRequestDTO;
import com.wildcards.users.model.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersService {

    private static final Logger logger = Logger.getLogger(UsersService.class.getName());
    static {
        logger.setLevel(Level.WARNING);
    }

    private final AccountRepository repository;

    public boolean register(String email, String username, String password) {
        if (emailInUse(email)) {
            return false;
        }

        try {
            repository.save(Account.builder()
                    .email(email)
                    .username(username)
                    .password(password) // TODO Hash this
                    .build()
            );
        } catch (Exception ex) {
            for (var t = ex.getCause(); t != null; t = t.getCause()) {
                logger.warning("Exception: " + t);
            }
            return false;
        }
        return true;
    }

    public boolean emailInUse(String email) {
        return repository.existsByEmail(email);
    }

    public LoginResponseDTO login(String email, String password) {
        return repository.getByEmail(email).map(account ->
                LoginResponseDTO.builder()
                        .id(account.getId())
                        .email(account.getEmail())
                        .username(account.getUsername())
                        .build()
        ).orElse(null);
    }
}
