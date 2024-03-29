package com.example.kcortes.service.impl;



import com.example.kcortes.model.Role;
import com.example.kcortes.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private List<SimpleGrantedAuthority> authorities;

    public MyUserDetails(User usuario){
        this.authorities = new ArrayList<>();
        this.username = usuario.getUsername();
        this.password = usuario.getPassword();
        this.active = true;
        for(Role role : usuario.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}