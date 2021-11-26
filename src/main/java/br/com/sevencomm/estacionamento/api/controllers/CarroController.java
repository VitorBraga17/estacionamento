package br.com.sevencomm.estacionamento.api.controllers;

import br.com.sevencomm.estacionamento.api.DTOs.CarroDTO;
import br.com.sevencomm.estacionamento.domain.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService _carroService;

    @GetMapping("/listCarros")
    public ResponseEntity listCarros() {
        return ResponseEntity.ok(_carroService.listCarros());
    }

    @GetMapping("/getCarroById")
    public ResponseEntity getCarroById(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(_carroService.getCarroById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/createCarro")
    public ResponseEntity createCarro(@RequestBody CarroDTO carroDTO){

        try {
            return ResponseEntity.ok(_carroService.createCarro(carroDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/updateCarro")
    public ResponseEntity updateCarro(@RequestBody CarroDTO carroDTO,@RequestParam Long id){

        try {
            return ResponseEntity.ok(_carroService.updateCarro(carroDTO,id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteCarro")
    public ResponseEntity deleteCarro(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(_carroService.deleteCarro(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
