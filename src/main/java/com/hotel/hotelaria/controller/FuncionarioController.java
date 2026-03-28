package com.hotel.hotelaria.controller;

import com.hotel.hotelaria.entity.Funcionario;
import com.hotel.hotelaria.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario) {
        return service.salvar(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listar();
    }
}