package com.tay.springSecurityWithJWT2.service;

import com.tay.springSecurityWithJWT2.dto.UserDTO;
import com.tay.springSecurityWithJWT2.model.UserModel;
import com.tay.springSecurityWithJWT2.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    //métodos
    public UserDTO save (UserDTO userDTO){
        //não pode salvar com dados nulos e se estiver ja salvo
        if(userDTO.getUsername() == null && userDTO.getPassword() == null){
            System.out.println("Os campos estão nulos");
        }

        if (userRepository.existsByUsername(userDTO.getUsername())){
            System.out.println("Usuário ja cadastrado");
        }

        UserModel userModel = new UserModel();
        userModel.setUsername(userDTO.getUsername());
        userModel.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userModel.setRole(userDTO.getRole());

        userRepository.save(userModel);

        return new UserDTO(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getRole());
    }
}
