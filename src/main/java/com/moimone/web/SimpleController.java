package com.moimone.web;

import com.moimone.web.dto.SimpleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/helloWorld")
    public String Hello() {
        return "helloWorld";
    }

    @GetMapping("/simple/response")
    public SimpleResponse helloResponse(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new SimpleResponse(name, amount);
    }

}
