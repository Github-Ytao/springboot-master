package com.tao.project;

import com.tao.project.primary.UserMapperPrimary;
import com.tao.project.secondary.UserMapperSecondary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangTao
 * @date 2021-11-13 21:35
 */
@SpringBootTest
class MybatisDBApplicationTest {

    @Autowired
    UserMapperPrimary userMapperPrimary;
    @Autowired
    UserMapperSecondary userMapperSecondary;

    @BeforeEach
    void setUp() {
        userMapperPrimary.deleteAll();
        userMapperSecondary.deleteAll();
    }

    @Test
    void contextLoads() {
        // 往Primary数据源插入一条数据
        userMapperPrimary.insert("AAA", 20);
    }
}