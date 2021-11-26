package br.com.sevencomm.estacionamento.domain.servicesImpl;

import br.com.sevencomm.estacionamento.api.DTOs.SignUpDTO;
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

        return userOptional.orElseThrow(() -> new IllegalArgumentException("User not Found!"));
    }

    @Override
    public void signUp(SignUpDTO userDTO) {

        if (userDTO.getLogin().equals("") || userDTO.getLogin() == null)
            throw new IllegalArgumentException("Login must not be null");
        if (userDTO.getSenha().equals("") || userDTO.getSenha() == null)
            throw new IllegalArgumentException("Senha must not be null");
        if (userDTO.getNome().equals("") || userDTO.getNome() == null)
            throw new IllegalArgumentException("Nome must not be null");
        if (userDTO.getEmail().equals("") || userDTO.getEmail() == null)
            throw new IllegalArgumentException("Email must not be null");
        if (!userDTO.getSenha().equals(userDTO.getConfirmarSenha()))
            throw new IllegalArgumentException("Senha Fields dont Match! ");

        _userRepository.save(User.signUpToUser(userDTO));
    }
}
