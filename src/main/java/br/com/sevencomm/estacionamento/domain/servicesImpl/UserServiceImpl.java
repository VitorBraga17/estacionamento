package br.com.sevencomm.estacionamento.domain.servicesImpl;

import br.com.sevencomm.estacionamento.data.repositories.UserRepository;
import br.com.sevencomm.estacionamento.domain.models.User;
import br.com.sevencomm.estacionamento.domain.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository _userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public List<User> listUsers() {
        return _userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = _userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        return userOptional.get();
    }

    @Override
    public void Signup(User user) {
    }
}
