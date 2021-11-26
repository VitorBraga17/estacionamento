package br.com.sevencomm.estacionamento.domain.servicesImpl;

import br.com.sevencomm.estacionamento.api.DTOs.EntradaSaidaDTO;
import br.com.sevencomm.estacionamento.data.repositories.EntradaSaidaRepository;
import br.com.sevencomm.estacionamento.domain.models.EntradaSaida;
import br.com.sevencomm.estacionamento.domain.services.EntradaSaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaSaidaImpl implements EntradaSaidaService {

    @Autowired
    private EntradaSaidaRepository _entradaSaidaRepository;

    @Override
    public List<EntradaSaidaDTO> listEntradaSaidas() {
        return _entradaSaidaRepository.findAll().stream().map(EntradaSaidaDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public EntradaSaidaDTO getEntradaSaidaDTO() {
        return null;
    }

    @Override
    public EntradaSaidaDTO createEntrada(EntradaSaidaDTO entradaSaidaDTO) {

        EntradaSaida entrada = EntradaSaida.toEntity(entradaSaidaDTO);

        return EntradaSaidaDTO.toDTO(_entradaSaidaRepository.save(entrada));

    }

}
