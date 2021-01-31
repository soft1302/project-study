
package com.lgh.mapper;

import com.lgh.util.MyMapper;
import com.lgh.model.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper extends MyMapper<Resource> {
    /**
     * 通过用户id查询用户资源
     * @param userId
     * @return
     */
    List<Resource> selectResourceByRoleId(@Param("userId") int userId);
}