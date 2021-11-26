package com.tao.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author YangTao
 * @date 2021-11-13 18:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Integer sex;
    private Integer age;
    private LocalDateTime birthDay;
}
