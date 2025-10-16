package com.tay.springSecurityWithJWT2.security;

import com.tay.springSecurityWithJWT2.dto.Role;
import com.tay.springSecurityWithJWT2.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserAuthenticated implements UserDetails {
    private final UserModel userModel;

    public UserAuthenticated(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       if(userModel.getRole() == Role.ADMIN){
           return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
       }else {
           return List.of(new SimpleGrantedAuthority("ROLE_USER"));
       }
    }

    @Override
    public String getPassword() {
        return userModel.getPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getUsername();
    }
}
