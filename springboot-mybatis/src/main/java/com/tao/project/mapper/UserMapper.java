package com.tao.project.mapper;

import com.tao.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author YangTao
 * @date 2021-11-13 18:50
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();
}
