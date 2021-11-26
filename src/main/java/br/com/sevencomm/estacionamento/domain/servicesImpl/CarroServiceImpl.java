package br.com.sevencomm.estacionamento.domain.servicesImpl;


import br.com.sevencomm.estacionamento.api.DTOs.CarroDTO;
import br.com.sevencomm.estacionamento.data.repositories.CarroRepository;
import br.com.sevencomm.estacionamento.domain.models.Carro;
import br.com.sevencomm.estacionamento.domain.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository _carroRepository;

    public List<CarroDTO> listCarros() {

        List<Carro> carros = _carroRepository.findAll();
        List<CarroDTO> carrosDTO = new ArrayList<>();

        for (Carro c : carros) {
            carrosDTO.add(CarroDTO.toDTO(c));
        }

        return carrosDTO;
    }

    @Override
    public CarroDTO getCarroById(Long id) {
        Optional<Carro> carro = _carroRepository.findById(id);

        return CarroDTO.toDTO(carro.orElseThrow(() -> new IllegalArgumentException("User not found!")));
    }

    @Override
    public CarroDTO createCarro(CarroDTO carroDTO) {

        Carro carro = new Carro();

        if ((carroDTO.getModelo().equals("")) || carroDTO.getModelo() == null)
            throw new IllegalArgumentException("Modelo must not be null");
        if ((carroDTO.getTipo().equals("")) || carroDTO.getTipo() == null)
            throw new IllegalArgumentException("Tipo must not be null");

        carro.setModelo(carroDTO.getModelo());
        carro.setTipo(carroDTO.getTipo());

        return CarroDTO.toDTO(_carroRepository.save(carro));
    }

    @Override
    public CarroDTO updateCarro(CarroDTO carroDTO, Long id) {

        Optional<Carro> carro = _carroRepository.findById(id);

        if (!carro.isPresent())
            throw new IllegalArgumentException("Carro not Found!");

        Carro updateCarro = carro.get();
        updateCarro.setTipo(carroDTO.getTipo());
        updateCarro.setModelo(carroDTO.getModelo());

        return CarroDTO.toDTO(_carroRepository.save(updateCarro));
    }

    @Override
    public CarroDTO deleteCarro(Long id) {

        Optional<Carro> carro = _carroRepository.findById(id);

        if (!carro.isPresent()) {
            throw new IllegalArgumentException("Carro not Found!");
        }
        _carroRepository.deleteById(id);
        return CarroDTO.toDTO(carro.get());

    }

}
