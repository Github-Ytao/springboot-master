package com.tao.project.repository;

import com.tao.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author YangTao
 * @date 2021-11-13 17:33
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
