package com.gabriel.emailmicroservice.application.core.domain.service;

import com.gabriel.emailmicroservice.application.core.domain.collection.User;
import com.gabriel.emailmicroservice.application.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getById(String id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado para o ID: " + id));

        return user;
    }
}
