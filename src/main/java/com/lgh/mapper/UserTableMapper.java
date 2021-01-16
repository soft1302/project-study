package com.lgh.mapper;

import com.lgh.entity.UserTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserTableMapper {

    List<UserTable> findAll();
    int updateBatch(List<UserTable> userTableList);

    int updateByList(@Param("users") List<UserTable> userTableList);
}
