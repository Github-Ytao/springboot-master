package com.tao.project;

import com.tao.project.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author YangTao
 * @date 2021-11-13 13:49
 */
@SpringBootTest
class RestfulApplicationTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    void contextLoads() throws Exception {
        //
        mockMvc.perform(get("/user/list"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        //
        mockMvc.perform(post("/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1, \"name\":\"测试大师\", \"age\":20}"))
                .andExpect(content().string(equalTo("success")));

        //
        mockMvc.perform(get("/user/list"))
                .andDo(print())
                .andExpect(status().isOk());

        //
        mockMvc.perform(put("/user/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"测试终极大师\", \"age\":30}"))
                .andExpect(content().string(equalTo("success")));

        //
        mockMvc.perform(get("/user/1"))
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        //
        mockMvc.perform(get("/user/delete/1"))
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
    }
}