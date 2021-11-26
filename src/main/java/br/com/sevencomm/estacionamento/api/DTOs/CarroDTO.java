package br.com.sevencomm.estacionamento.api.DTOs;

import br.com.sevencomm.estacionamento.domain.models.Carro;
import lombok.Data;

@Data
public class CarroDTO {

    private Long id;

    private String modelo;

    private String tipo;

    public static CarroDTO toDTO(Carro carro) {

        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId(carro.getId());
        carroDTO.setModelo(carro.getModelo());
        carroDTO.setTipo(carro.getTipo());

        return carroDTO;
    }
}
