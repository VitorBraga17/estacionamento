package br.com.sevencomm.estacionamento.domain.models;

import br.com.sevencomm.estacionamento.api.DTOs.SignUpDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String senha;

    private String nome;

    private String email;

    public static User signUpToUser(SignUpDTO signupDTO) {
        User user = new User();

        user.setLogin(signupDTO.getLogin());
        user.setSenha(signupDTO.getSenha());
        user.setEmail(signupDTO.getEmail());
        user.setNome(signupDTO.getNome());

        return user;
    }
}
