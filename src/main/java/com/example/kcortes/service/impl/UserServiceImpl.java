package com.example.kcortes.service.impl;
import com.example.kcortes.dto.UserRequest;
import com.example.kcortes.mapper.UserMapper;
import com.example.kcortes.model.User;
import com.example.kcortes.repository.UserRepository;
import com.example.kcortes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void saveUser(UserRequest userRequest) {
        if (userRequest.getUsername() == null || userRequest.getUsername().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }
        if (userRequest.getPassword() == null || userRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }
        User user = UserMapper.INSTANCE.mapToUser(userRequest);
        userRepository.save(user);
    }

}
