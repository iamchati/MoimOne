package com.moimone.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/helloWorld")
    public String Hello() {
        return "helloWorld";
    }

}
