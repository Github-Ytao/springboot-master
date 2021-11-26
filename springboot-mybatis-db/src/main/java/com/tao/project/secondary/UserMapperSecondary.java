package com.tao.project.secondary;

import com.tao.project.secondary.UserSecondary;
import org.apache.ibatis.annotations.*;

/**
 * @author YangTao
 * @date 2021-11-13 21:31
 */
@Mapper
public interface UserMapperSecondary {

    UserSecondary findByUsername(@Param("username") String username);

    int insert(@Param("username") String username, @Param("age") Integer age);

    int deleteAll();
}
