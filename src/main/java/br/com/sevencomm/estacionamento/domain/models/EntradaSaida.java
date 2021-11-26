package br.com.sevencomm.estacionamento.domain.models;


import br.com.sevencomm.estacionamento.api.DTOs.EntradaSaidaDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
public class EntradaSaida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime Entrada;

    public static EntradaSaida toEntity(EntradaSaidaDTO entradaSaidaDTO) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        EntradaSaida entradaSaida = new EntradaSaida();

        entradaSaida.setId(entradaSaidaDTO.getId());
        entradaSaida.setEntrada(LocalDateTime.parse(entradaSaidaDTO.getEntrada(),formatter));

        return entradaSaida;
    }

}
