package com.tao.project.primary;

import com.tao.project.secondary.UserSecondary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author YangTao
 * @date 2021-11-13 22:12
 */
@Mapper
public interface UserMapperPrimary {
    UserSecondary findByUsername(@Param("username") String username);

    int insert(@Param("username") String username, @Param("age") Integer age);

    int deleteAll();
}
