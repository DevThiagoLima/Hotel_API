package com.hotel.hotelaria.service;

import com.hotel.hotelaria.entity.Role;
import com.hotel.hotelaria.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Role salvar(Role role) {
        return repository.save(role);
    }

    public List<Role> listar() {
        return repository.findAll();
    }
}