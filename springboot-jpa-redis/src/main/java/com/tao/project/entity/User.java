package com.tao.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author YangTao
 * @date 2021-11-14 17:23
 */
@Data
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Integer sex;
    private Integer age;
    @Column(name = "birth_day")
    private LocalDateTime birthDay;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
