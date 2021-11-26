package br.com.sevencomm.estacionamento.api.DTOs;

import lombok.Data;

@Data
public class SignUpDTO {

    private String login;
    private String senha;
    private String nome;
    private String email;
    private String confirmarSenha;

}
