package com.lgh.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgh.mapper.LogonMapper;
import com.lgh.mapper.ResourceMapper;
import com.lgh.mapper.UserMapper;
import com.lgh.model.Logon;
import com.lgh.model.Resource;
import com.lgh.model.User;
import com.lgh.model.domain.UserData;
import com.lgh.service.ILogonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LogonServiceImpl implements ILogonService {

    @Autowired
    private LogonMapper logonMapper = null;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 校验用户状态
     *
     * @param token
     * @return
     */
    @Override
    public UserData verify(String token) {
        Logon logon = logonMapper.selectByPrimaryKey(token);
        if (logon != null && StringUtils.hasText(logon.getResourceData())) {
            UserData userData = new UserData();
            try {
                List<Resource> logonList = objectMapper.readValue(logon.getResourceData(), objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Resource.class));
                userData.setUserResources(logonList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            User user = userMapper.selectByPrimaryKey(logon.getUserId());
            BeanUtils.copyProperties(user, userData);
            return userData;
        }

        return null;
    }

    /**
     * 电话号码登录
     *
     * @param phone    用户电话号码
     * @param password 加密后密码
     * @return
     */
    @Override
    public UserData login(String phone, String password) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("userPhone", phone);
        User user = userMapper.selectOneByExample(example);
        if (user != null && password.equals(user.getUserPassword())) {
            UserData userData = new UserData();
            /**
             * 查询用户资源信息
             */
            userData.setUserResources(resourceMapper.selectResourceByRoleId(user.getId()));
            BeanUtils.copyProperties(user, userData);
            Logon logon = new Logon();
            logon.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
            logon.setUserId(user.getId());
            try {
                logon.setResourceData(objectMapper.writeValueAsString(userData.getUserResources()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            Example logonExample = new Example(Logon.class);
            logonExample.createCriteria().andEqualTo("userId", user.getId());
            logonMapper.deleteByExample(logonExample);
            logonMapper.insert(logon);
            userData.setToken(logon.getToken());
            return userData;
        }
        return null;
    }

}
