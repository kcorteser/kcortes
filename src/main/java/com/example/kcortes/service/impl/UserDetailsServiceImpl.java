package com.example.kcortes.service.impl;

import com.example.kcortes.model.User;
import com.example.kcortes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usuario = userRepository.findByUsername(username);
        usuario.orElseThrow(() -> new UsernameNotFoundException("No existe el usuario " + username));
        return usuario.map(MyUserDetails::new).get();
    }
}
