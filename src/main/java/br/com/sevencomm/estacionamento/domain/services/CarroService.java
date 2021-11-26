package br.com.sevencomm.estacionamento.domain.services;

import br.com.sevencomm.estacionamento.api.DTOs.CarroDTO;

import java.util.List;

public interface CarroService {

    List<CarroDTO> listCarros();
    CarroDTO getCarroById(Long id);
    CarroDTO createCarro(CarroDTO carroDTO);
    CarroDTO updateCarro(CarroDTO carroDTO,Long id);
    CarroDTO deleteCarro(Long id);
}
