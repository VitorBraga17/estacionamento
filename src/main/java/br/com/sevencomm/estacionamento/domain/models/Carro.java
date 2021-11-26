package br.com.sevencomm.estacionamento.domain.models;

import br.com.sevencomm.estacionamento.api.DTOs.CarroDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private String tipo;

    public static Carro toEntity(CarroDTO carroDTO) {
        return null;
    }
}
