package com.example.kcortes.service;

import com.example.kcortes.dto.UserRequest;
import com.example.kcortes.model.User;
import java.util.List;

public interface UserService {

    List<User> getAll();
    void saveUser(UserRequest user);
}
