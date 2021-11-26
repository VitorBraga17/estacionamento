package br.com.sevencomm.estacionamento.domain.services;

import br.com.sevencomm.estacionamento.api.DTOs.SignUpDTO;
import br.com.sevencomm.estacionamento.domain.models.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User getUserById(Long id);

    void signUp(SignUpDTO userDTO);

}
