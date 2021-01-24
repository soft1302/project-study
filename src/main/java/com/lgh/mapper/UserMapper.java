package com.lgh.mapper;

import com.lgh.common.util.MyMapper;
import com.lgh.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    /**
     * 批次操作实例
     * @param users
     * @return
     */
    int updateBatch(@Param("users") List<User> users);
    /**
     * 批次操作实例
     * @param users
     * @return
     */
    int updateByList(@Param("users") List<User> users);
}