package com.hotel.hotelaria.controller;

import com.hotel.hotelaria.entity.Hospede;
import com.hotel.hotelaria.repository.HospedeRepository;
import com.hotel.hotelaria.service.HospedeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeService service;

    @PostMapping
    public Hospede salvar(@RequestBody Hospede hospede) {
        return service.salvar(hospede);
    }

    @GetMapping
    public List<Hospede> listar() {
        return service.listar();
    }

    @GetMapping({"/{id}"})
    public Hospede buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping({"/{id}"})
    public Hospede atualizar(@PathVariable Long id, @RequestBody Hospede hospede) {
        return service.atualizar(id, hospede);
    }

    @DeleteMapping({"/{id}"})
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
