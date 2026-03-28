package com.hotel.hotelaria.controller;

import com.hotel.hotelaria.entity.Quarto;
import com.hotel.hotelaria.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    private QuartoService service;

    @PostMapping
    public Quarto salvar(@RequestBody Quarto quarto) {
        return service.salvar(quarto);
    }

    @GetMapping
    public List<Quarto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Quarto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Quarto atualizar(@PathVariable Long id, @RequestBody Quarto quarto) {
        return service.atualizar(id, quarto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}