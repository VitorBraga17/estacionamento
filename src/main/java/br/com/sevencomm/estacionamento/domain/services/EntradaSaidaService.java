package br.com.sevencomm.estacionamento.domain.services;

import br.com.sevencomm.estacionamento.api.DTOs.EntradaSaidaDTO;

import java.util.List;

public interface EntradaSaidaService {

    List<EntradaSaidaDTO> listEntradaSaidas();
    EntradaSaidaDTO getEntradaSaidaDTO();
    EntradaSaidaDTO createEntrada(EntradaSaidaDTO entradaSaidaDTO);
}
