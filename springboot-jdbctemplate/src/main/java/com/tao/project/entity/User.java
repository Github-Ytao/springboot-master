package com.tao.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author YangTao
 * @date 2021-11-13 16:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private Integer age;
    private Integer sex;
    private String password;
    private LocalDateTime birthDay;
}
