package br.com.sevencomm.estacionamento.api.controllers;


import br.com.sevencomm.estacionamento.api.DTOs.EntradaSaidaDTO;
import br.com.sevencomm.estacionamento.domain.services.EntradaSaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EntradaSaida")
public class EntradaSaidaController {

    @Autowired
    private EntradaSaidaService _entradaSaidaService;

    @GetMapping("/listEntradaSaidas")
    public ResponseEntity listEntradaSaidas() {
        return ResponseEntity.ok(_entradaSaidaService.listEntradaSaidas());
    }

    @PostMapping("/createEntrada")
    public ResponseEntity createEntrada(@RequestBody EntradaSaidaDTO entradaSaidaDTO) {
        return  ResponseEntity.ok(_entradaSaidaService.createEntrada(entradaSaidaDTO));
    }
}
