package br.com.sevencomm.estacionamento.data.repositories;

import br.com.sevencomm.estacionamento.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
