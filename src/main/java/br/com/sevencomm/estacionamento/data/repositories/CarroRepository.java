package br.com.sevencomm.estacionamento.data.repositories;

import br.com.sevencomm.estacionamento.domain.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro,Long> {

    void deleteById(Long id);
}
