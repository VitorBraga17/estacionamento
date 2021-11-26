package br.com.sevencomm.estacionamento.api.controllers;

import br.com.sevencomm.estacionamento.domain.models.User;
import br.com.sevencomm.estacionamento.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService _userService;

    public UserController(UserService userService){
        _userService = userService;
    }

    @GetMapping("/list-users")
    public ResponseEntity listUsers(){
        List<User> users = _userService.listUsers();
        return ResponseEntity.ok(users);
    }
}
