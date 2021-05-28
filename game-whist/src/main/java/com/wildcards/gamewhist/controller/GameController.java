package com.wildcards.gamewhist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/whist/**")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {
    private final GameService service;

    private static final List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"); // Testing

    @GetMapping("/random")
    public String getRandomString() {
        return strings.get(ThreadLocalRandom.current().nextInt(strings.size()));
    }
}
