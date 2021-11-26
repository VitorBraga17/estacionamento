package br.com.sevencomm.estacionamento.api.DTOs;

import br.com.sevencomm.estacionamento.domain.models.EntradaSaida;
import lombok.Data;

import java.time.format.DateTimeFormatter;


@Data
public class EntradaSaidaDTO {

    private Long id;

    private String entrada;

    public static EntradaSaidaDTO toDTO(EntradaSaida entradaSaida) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        EntradaSaidaDTO entradaSaidaDTO = new EntradaSaidaDTO();

        entradaSaidaDTO.setId(entradaSaida.getId());
        String horario = entradaSaida.getEntrada().format(formatter);//entradaSaida.getEntrada().format(formatter);
        entradaSaidaDTO.setEntrada(horario);

        return entradaSaidaDTO;
    }
}
