package com.lgh.service;

import com.lgh.model.domain.UserData;

public interface ILogonService {
    UserData verify(String token);

    UserData login(String phone, String password);
}
