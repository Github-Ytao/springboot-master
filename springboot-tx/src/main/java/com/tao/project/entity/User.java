package com.tao.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author YangTao
 * @date 2021-11-13 22:39
 */
@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Integer sex;
    @Max(50)
    private Integer age;
    private LocalDateTime birthDay;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
