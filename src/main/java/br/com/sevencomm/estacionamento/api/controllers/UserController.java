package br.com.sevencomm.estacionamento.api.controllers;

import br.com.sevencomm.estacionamento.api.DTOs.SignUpDTO;
import br.com.sevencomm.estacionamento.domain.models.User;
import br.com.sevencomm.estacionamento.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService _userService;

    public UserController(UserService userService){
        _userService = userService;
    }

    @GetMapping("/listUsers")
    public ResponseEntity listUsers(){
        List<User> users = _userService.listUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUserById")
    public ResponseEntity getUserById(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(_userService.getUserById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody SignUpDTO signUpDTO){
        try {
            _userService.signUp(signUpDTO);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }
}
