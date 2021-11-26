package com.tao.project.repository;

import com.tao.project.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author YangTao
 * @date 2021-11-14 17:25
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable
    @Query("from User where username = :username")
    User findByUsername(String username);
}
