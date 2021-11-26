package com.tao.project.secondary;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author YangTao
 * @date 2021-11-13 21:27
 */
@Data
@NoArgsConstructor
public class UserSecondary {
    private Long id;
    private String username;
    private String password;
    private Integer sex;
    private Integer age;
    private LocalDateTime birthDay;

    public UserSecondary(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
