package br.com.sevencomm.estacionamento.domain.models;

import br.com.sevencomm.estacionamento.api.DTOs.SignUpDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "login must not be empty")
    private String login;

    @NotEmpty(message = "senha must not be empty")
    private String senha;

    @NotEmpty(message = "nome must not be empty")
    private String nome;

    @Email
    @NotEmpty(message = "email must not be empty")
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
