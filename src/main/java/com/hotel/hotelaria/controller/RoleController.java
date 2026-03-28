package com.hotel.hotelaria.controller;

import com.hotel.hotelaria.entity.Role;
import com.hotel.hotelaria.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping
    public Role salvar(@RequestBody Role role) {
        return service.salvar(role);
    }

    @GetMapping
    public List<Role> listar() {
        return service.listar();
    }
}