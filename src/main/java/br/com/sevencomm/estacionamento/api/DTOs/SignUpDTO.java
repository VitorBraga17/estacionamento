package br.com.sevencomm.estacionamento.api.DTOs;

import br.com.sevencomm.estacionamento.domain.models.User;
import lombok.Data;


@Data
public class SignUpDTO {

    private String login;

    private String senha;

    private String nome;

    private String email;

    private String confirmarSenha;

    public static SignUpDTO toDTO(User user) {

        SignUpDTO signUpDTO = new SignUpDTO();

        signUpDTO.setLogin(user.getLogin());
        signUpDTO.setSenha(user.getSenha());
        signUpDTO.setNome(user.getNome());
        signUpDTO.setEmail(user.getEmail());

        return signUpDTO;

    }

}
