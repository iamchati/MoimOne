package com.moimone.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SimpleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnHelloWorld() throws Exception {
        String helloWorld = "helloWorld";

        mvc.perform(get("/helloWorld"))
                .andExpect(status().isOk())
                .andExpect(content().string(helloWorld));
    }

    @Test
    public void returnSimpleResponse() throws Exception {
        String name = "helloWorld";
        int amount = 1000;

        mvc.perform(get("/simple/response")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
