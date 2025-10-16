package com.tay.springSecurityWithJWT2.service;

import com.tay.springSecurityWithJWT2.exception.UserNotFoundException;
import com.tay.springSecurityWithJWT2.model.UserModel;
import com.tay.springSecurityWithJWT2.repository.UserRepository;
import com.tay.springSecurityWithJWT2.security.UserAuthenticated;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticatedService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserAuthenticatedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user =userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Usuário não cadastrado"));

        return new UserAuthenticated(user);
    }
}
