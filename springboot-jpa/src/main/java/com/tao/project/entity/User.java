package com.tao.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author YangTao
 * @date 2021-11-13 17:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "age")
    private Integer age;
    @Column(name = "birth_day")
    private LocalDateTime birthDay;

    public User(String username, String password, Integer sex, Integer age, LocalDateTime birthDay) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.birthDay = birthDay;
    }
}
