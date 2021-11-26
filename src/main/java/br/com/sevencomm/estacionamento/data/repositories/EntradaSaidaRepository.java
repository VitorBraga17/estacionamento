package br.com.sevencomm.estacionamento.data.repositories;

import br.com.sevencomm.estacionamento.domain.models.EntradaSaida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida,Long> {
}
